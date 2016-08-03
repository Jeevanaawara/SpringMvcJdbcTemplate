/**
 * 
 */
package pk.torcia.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pk.torcia.spring.config.ReportGenerator;
import pk.torcia.spring.model.BatchClass;
import pk.torcia.spring.model.Fees;
import pk.torcia.spring.model.Session;
import pk.torcia.spring.model.Shift;
import pk.torcia.spring.model.Student;

/**
 * @author inayat
 *
 */
public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;
	@Autowired
	private FeesDAO feesDAO;
	@Autowired
	private BatchClassDAO batchClassDAO;
	@Autowired
	private SessionDAO sessionDAO;

	static Logger log = Logger.getLogger(StudentDAOImpl.class.getName());

	public StudentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String save(final Student student) {

		log.info("insdie StudentImpl save DAO");
		if (student.getStudentId() > 0) {
			log.info("insdie studentImpl save method update");
			// update
			String sql = "UPDATE studenttbl SET studentFirstName=? , classId=?, shiftId=? , sectionId=? , dateCreated=?  WHERE studentId=?";
			jdbcTemplate.update(sql, student.getStudentFirstName(),
					student.getClassId(), student.getShiftId(), student.getSectionId(), student.getDateCreated(),
					student.getStudentId());
		} else {
			log.info("insdie studentImpl save method  insert");
			// insert
			KeyHolder keyHolder = new GeneratedKeyHolder();
			final String sql = "INSERT INTO studenttbl (studentFirstName,board,imageName,studentRollNo,classId, shiftId,sectionId, dateCreated,studentRemarks,studentDeleted,studentCreatedby,program)"
					+ " VALUES   (?,?,?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(sql, new String[] { "studentId" });
					pst.setString(1, student.getStudentFirstName());
					pst.setString(2, student.getBoard());
					pst.setString(3, student.getImageName());
					pst.setInt(4, student.getStudentRollNo());
					pst.setInt(5, student.getClassId());
					pst.setInt(6, student.getShiftId());
					pst.setInt(7, student.getSectionId());
					pst.setDate(8, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
					pst.setString(9, student.getRemarks());
					pst.setBoolean(10, false);
					pst.setString(11, student.getStudentCreatedby());
					pst.setString(12, student.getProgram());
					return pst;
				}
			}, keyHolder);

			long studentid = (long) keyHolder.getKey();
			System.out.println("student is new " + studentid);
			Fees fee = student.getFees();
			fee.setStudentId((int) studentid);
			feesDAO.save(fee);
			Student studentNew = findById((int) studentid);
			BatchClass batchClass = batchClassDAO.findById(student.getClassId());
			Session sessObj = sessionDAO.findById(studentNew.getSectionId());
			sessObj.getSectionName();
			System.out.println(sessObj.getSectionName() + " <<<=Section= >>" + studentNew.getStudentRollNo()
					+ " ----class Name is --type--- " + batchClass.getClassType());
			String pdfFile = ReportGenerator.generateReport((int) studentid, studentNew.getStudentRollNo(),
					batchClass.getClassName(), batchClass.getClassType(), sessObj.getSectionName());
			return pdfFile;
		}
		return null;
	}

	public void upDate(Student student) {
		log.info("insdie studentImpl update method");
		if (student.getStudentId() > 0) {
			// update
			String sql = "UPDATE studenttbl SET studentFirstName=?  , classId=?, shiftId=? , sectionId=? , dateCreated=?  WHERE studentId=?";
			jdbcTemplate.update(sql, student.getStudentFirstName(),
					student.getClassId(), student.getShiftId(), student.getSectionId());
		}

	}

	public Student findById(int studentId) {
		log.info("insdie studentImpl findbyid method");
		String sql = "SELECT * FROM studenttbl student inner join classtbl class on student.classId = class.classId  WHERE student.studentId = " + studentId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Student student = new Student();
					student.setStudentId(rs.getInt("studentId"));
					student.setStudentFirstName(rs.getString("studentFirstName"));
					student.setStudentRollNo(rs.getInt("studentRollNo"));
					BatchClass bclass = new BatchClass();
					student.setClassId(rs.getInt("classId"));
					bclass.setClassId(rs.getInt("classId"));
					bclass.setClassType(rs.getString("classType"));
					student.setBatchClass(bclass);
					student.setShiftId(rs.getInt("shiftId"));
					student.setSectionId(rs.getInt("sectionId"));

					return student;
				}
				return null;
			}
		});
	}

	public List<Student> findAll() {
		log.info("insdie studentImpl find all method");
		String sql = " SELECT * FROM studenttbl where studentDeleted ='0'  ";

		List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentFirstName(rs.getString("studentFirstName"));
				student.setStudentRollNo(rs.getInt("studentRollNo"));
				student.setClassId(rs.getInt("classId"));
				student.setShiftId(rs.getInt("shiftId"));
				student.setSectionId(rs.getInt("sectionId"));
				return student;
			}
		});
		return listStudent;
	}

	public boolean removeById(int studentId) {
		log.info("insdie studentImpl remove by id method");
		String sql = "Update  studenttbl set studentDeleted='1' WHERE studentId=?";
		jdbcTemplate.update(sql, studentId);
		return false;
	}

	@Override
	public int maxRoleNo(int classId) {
		log.info("insdie AdminImpl maxRoleNo method");

		String sql = "select COALESCE(MAX(studentRollNo+1),1) as studentRollNo from studenttbl where classId=?";

		int exist = jdbcTemplate.queryForObject(sql, new Object[] { classId }, Integer.class);

		if (exist != 0) {
			return exist;
		} else {
			return 0;
		}

	}

	@Override
	public List<Student> findAll(Student student) {
		log.info("insdie studentImpl find all method student");
		String sql = null;
		String studentName = null;
		String studentRollNo = null;
		String classId = null;
		String sectionId = null;
		// String whereClause = " where ";
		String andClause = " And ";
		String finalQuery = null;

		sql = " SELECT * FROM studenttbl st inner join classtbl cls on cls.classId = st.classId "
				+ " inner join sectiontbl section on section.sectionId = st.sectionId "
				+ " inner join shifttbl shift on shift.shiftId =st.shiftId where  st.studentDeleted ='0' ";

		if (student.getStudentFirstName() != null && student.getStudentFirstName().length() > 0) {
			studentName = " st.studentFirstName = '" + student.getStudentFirstName() + "' ";
			System.out.println("studentName " + student.getStudentFirstName());
		}
		if (student.getStudentRollNo() > 0) {
			studentRollNo = "  st.studentRollNo = '" + student.getStudentRollNo() + "'";
			System.out.println("studentRollNo " + student.getStudentRollNo());
		}
		if (student.getClassId() > 0) {
			classId = " cls.classId = '" + student.getClassId() + "'";
			System.out.println("classId " + student.getClassId());

		}
		if (student.getSectionId() > 0) {
			sectionId = " section.sectionId = '" + student.getSectionId() + "'";
			System.out.println("sectionId " + student.getSectionId());
		}
		if (studentName != null && studentName.length() > 0) {// 10
			finalQuery = sql + " " + andClause + studentName;
			System.out.println("level 10");
		}

		if (studentRollNo != null && studentRollNo.length() > 0) {// 11
			finalQuery = sql + " " + andClause + studentRollNo;
			System.out.println("level 11");
		}

		if (classId != null && classId.length() > 0) {// 12
			finalQuery = sql + " " + andClause + classId;
			System.out.println("level 12");
		}

		if (sectionId != null && sectionId.length() > 0) {// 13
			finalQuery = sql + " " + andClause + sectionId;
			System.out.println("level 13");
		}

		if (sectionId != null && sectionId.length() > 0 && classId != null && classId.length() > 0) {// 13
			finalQuery = sql + " " + andClause + sectionId + andClause + classId;
			System.out.println("level 14");
		}

		if (studentName != null && studentName.length() > 0 && studentRollNo != null && studentRollNo.length() > 0
				&& classId != null && classId.length() > 0 && sectionId != null && sectionId.length() > 0) { // 1
			finalQuery = sql + andClause + studentName + andClause + studentRollNo + andClause + classId + andClause
					+ sectionId;
			System.out.println("level 1");
		}

		if (studentName != null && studentName.length() > 0 && studentRollNo != null && studentRollNo.length() > 0
				&& classId != null && classId.length() > 0) { // 2
			finalQuery = sql + andClause + studentName + andClause + studentRollNo + andClause + classId;
			System.out.println("level 2");
		}

		if (studentName != null && studentName.length() > 0 && studentRollNo != null && studentRollNo.length() > 0
				&& sectionId != null && sectionId.length() > 0) { // 3
			finalQuery = sql + andClause + studentName + andClause + studentRollNo + andClause + sectionId;
			System.out.println("level 3");
		}

		if (studentName != null && studentName.length() > 0 && studentRollNo != null && studentRollNo.length() > 0) { // 4
			finalQuery = sql + " " + andClause + studentName + andClause + studentRollNo;
			System.out.println("level 4");
		}

		if (studentName != null && studentName.length() > 0 && classId != null && classId.length() > 0) { // 5
			finalQuery = sql + " " + andClause + studentName + andClause + classId;
			System.out.println("level 5");
		}

		if (studentName != null && studentName.length() > 0 && sectionId != null && sectionId.length() > 0) {// 6
			finalQuery = sql + " " + andClause + studentName + andClause + sectionId;
			System.out.println("level 6");
		}

		if (studentRollNo != null && studentRollNo.length() > 0 && classId != null && classId.length() > 0
				&& sectionId != null && sectionId.length() > 0) {// 7
			finalQuery = sql + " " + andClause + studentRollNo + andClause + classId + andClause + sectionId;
			System.out.println("level 7");
		}

		if (studentRollNo != null && studentRollNo.length() > 0 && classId != null && classId.length() > 0) {// 8
			finalQuery = sql + " " + andClause + studentRollNo + andClause + classId;
			System.out.println("level 8");
		}

		if (studentRollNo != null && studentRollNo.length() > 0 && sectionId != null && sectionId.length() > 0) {// 9
			finalQuery = sql + " " + andClause + studentRollNo + andClause + sectionId;
			System.out.println("level 9");
		}

		System.out.println("finalQuery" + finalQuery);
		System.out.println("level 15");
		List<Student> listStudent = jdbcTemplate.query(finalQuery, new Object[] {}, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentFirstName(rs.getString("studentFirstName"));
				student.setStudentRollNo(rs.getInt("studentRollNo"));
				BatchClass batchClass = new BatchClass();
				batchClass.setClassId(rs.getInt("classId"));
				batchClass.setClassName(rs.getString("className"));
				Shift shift = new Shift();
				shift.setShiftId(rs.getInt("shiftId"));
				shift.setShiftName(rs.getString("shiftName"));
				Session sessionObje = new Session();
				sessionObje.setSectionId(rs.getInt("sectionId"));
				sessionObje.setSectionName(rs.getString("sectionName"));
				student.setBatchClass(batchClass);
				student.setSessionClass(sessionObje);
				student.setShift(shift);

				return student;
			}
		});
		System.out.println("list---------" + listStudent.size());
		System.out.println("level 16");
		return listStudent;
	}
	/*
	 * //possible search conditions name +roll+class+ section name +roll+class
	 * name +roll+section name +roll name +class name +section roll +section
	 * +class roll +class roll +section class section roll name
	 */

	@Override
	public String transferStudent(Student student) {
		if (student.getStudentId() > 0) {
			log.info("insdie studentImpl TransferById method ");

			String sql = "UPDATE studenttbl SET  classId=?,  sectionId=?  WHERE studentId=?";
			jdbcTemplate.update(sql, student.getClassId(), student.getSectionId(), student.getStudentId());
			System.out.println("student is new " + student.getStudentId());
			Student studentNew = findById(student.getStudentId());
			BatchClass batchClass = batchClassDAO.findById(student.getClassId());
			Session sessObj = sessionDAO.findById(studentNew.getSectionId());
			sessObj.getSectionName();
			System.out.println(sessObj.getSectionName() + " <<<=TransferById= >>" + studentNew.getStudentRollNo()
					+ " ----class Name is --type--- " + batchClass.getClassType());
			String pdfFile = ReportGenerator.generateReport(student.getStudentId(), studentNew.getStudentRollNo(),
					batchClass.getClassName(), batchClass.getClassType(), sessObj.getSectionName());
			return pdfFile;
		}
		return null;
	}
}