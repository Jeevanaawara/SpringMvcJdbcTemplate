/**
 * 
 */
package pk.torcia.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pk.torcia.spring.model.Session;
import pk.torcia.spring.model.Shift;
import pk.torcia.spring.model.Student;
import pk.torcia.spring.model.StudentOtherInfo;

/**
 * @author inayat
 *
 */
public class StudentOtherInfoDAOImpl implements StudentOtherInfoDAO {

	private JdbcTemplate jdbcTemplate;
	@Autowired
	StudentEduInfoDAO studentEduInfoDAO;
	
	static Logger log = Logger.getLogger(StudentOtherInfoDAOImpl.class.getName());

	public StudentOtherInfoDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(final StudentOtherInfo studentOtherInfo) {
		log.info("insdie StudentOtherInfoDAOImpl save method");
		if (studentOtherInfo.getStudentInfoId() > 0) {
			// update
			log.info("insdie StudentOtherInfoDAOImpl save method update");
			String sql = "UPDATE studentotherinfotbl SET name=?, email=?, password=?, "
					+ "dateCreated=? WHERE adminId=?";
			System.out.println(sql);
			/*
			 * jdbcTemplate.update(sql, admin.getAdminName(), admin.getEmail(),
			 * admin.getPassword(), admin.getDateCreated(), admin.getAdminId());
			 */
		} else {
			// insert
			KeyHolder keyHolder = new GeneratedKeyHolder();
			log.info("insdie StudentOtherInfoDAOImpl save method insert");
			final String sql = "INSERT INTO studentotherinfotbl (studentId, fatherName, nationality, perminentAddress,tempAddress,phoneNo,mobileNo,"
					+ "studentEmail,boarderDayScholar,guardian,guardianRelation,guardianName,guardianCNIC,guardianContact,guardianCell,guardianEmail,studentDob,studentOtherInfoCreated)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(sql, new String[] { "studentInfoId" });
					pst.setInt(1, studentOtherInfo.getStudentId());
					pst.setString(2, studentOtherInfo.getFatherName());
					pst.setString(3, studentOtherInfo.getNationality());
					pst.setString(4, studentOtherInfo.getPerminentAddress());
					pst.setString(5, studentOtherInfo.getTempAddress());
					pst.setString(6, studentOtherInfo.getPhoneNo());
					pst.setString(7, studentOtherInfo.getMobileNo());
					pst.setString(8, studentOtherInfo.getStudentEmail());
					pst.setString(9, studentOtherInfo.getBoarderDayScholar());
					pst.setString(10, studentOtherInfo.getGuardian());
					pst.setString(11, studentOtherInfo.getGuardianRelation());
					pst.setString(12, studentOtherInfo.getGuardianName());
					pst.setString(13, studentOtherInfo.getGuardianCNIC());
					pst.setString(14, studentOtherInfo.getGuardianContact());
					pst.setString(15, studentOtherInfo.getGuardianCell());
					pst.setString(16, studentOtherInfo.getGuardianEmail());
					SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
					java.util.Date d =null;
					try {
						d = f.parse(studentOtherInfo.getStudentDob());
					} catch (ParseException e) {
						System.out.println(e);
					}
					long milliseconds = d.getTime();
					pst.setDate(17, new java.sql.Date(milliseconds));
					pst.setDate(18, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
					return pst;
				}
			}, keyHolder);
			long studentotherInfoid = (long) keyHolder.getKey();
			studentOtherInfo.getStudentEduInfo().setStudentId((int)studentotherInfoid);
			studentEduInfoDAO.save(studentOtherInfo.getStudentEduInfo());
		}

	}

	@Override
	public void upDate(StudentOtherInfo studentOtherInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public StudentOtherInfo findById(int studentOtherInfoId) {
		log.info("insdie StudentOtherInfoDAOImpl findbyid method");
		String sql = " select section.sectionname,shft.shiftname,clas.classname,clas.classtype,st.studentfirstname,st.studentrollno,st.imagename, "
				+ " stedu.institutename,stedu.eduborad, stinfo.* from studentotherinfotbl stinfo inner join studenteduinfotbl stedu on stinfo.studentinfoid = stedu.studentid  "
				+ " inner join studenttbl st on stinfo.studentid =st.studentid inner join classtbl clas on st.classid = clas.classid "
				+ " inner join shifttbl shft on st.shiftid =shft.shiftid inner join sectiontbl section on st.sectionid = section.sectionid "
				+ " where stinfo.studentid = " + studentOtherInfoId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<StudentOtherInfo>() {

			@Override
			public StudentOtherInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					StudentOtherInfo studentOtherInfo = new StudentOtherInfo();
					studentOtherInfo.setStudentId(rs.getInt("studentId"));
					studentOtherInfo.setFatherName(rs.getString("fatherName"));
					studentOtherInfo.setNationality(rs.getString("nationality"));
					studentOtherInfo.setTempAddress(rs.getString("tempAddress"));
					studentOtherInfo.setMobileNo(rs.getString("mobileNo"));
					studentOtherInfo.setStudentEmail(rs.getString("studentEmail"));
					studentOtherInfo.setBoarderDayScholar(rs.getString("boarderDayScholar"));
					studentOtherInfo.setGuardian(rs.getString("guardian"));
					studentOtherInfo.setGuardianRelation(rs.getString("guardianRelation"));
					studentOtherInfo.setGuardianName(rs.getString("guardianName"));
					Student student = new Student();
					student.setImageName(rs.getString("imagename"));
					student.setStudentFirstName(rs.getString("studentfirstname"));
					student.setStudentRollNo(rs.getInt("studentrollno"));
					studentOtherInfo.setStudent(student);
					Shift shft = new Shift();
					shft.setShiftName(rs.getString("shiftname"));
					studentOtherInfo.setShift(shft);
					Session session = new Session();
					session.setSectionName(rs.getString("sectionname"));
					studentOtherInfo.setSession(session);
				//	StudentEduInfo studentEduInfo = new StudentEduInfo();
					return studentOtherInfo;
				}
				return null;
			}
		});
	}

	@Override
	public List<StudentOtherInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(int studentOtherInfoId) {
		// TODO Auto-generated method stub
		return false;
	}

}
