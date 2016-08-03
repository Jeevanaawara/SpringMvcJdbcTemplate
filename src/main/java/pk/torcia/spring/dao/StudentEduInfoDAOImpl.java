/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pk.torcia.spring.model.StudentEduInfo;

/**
 * @author inayat
 *
 */
public class StudentEduInfoDAOImpl implements StudentEduInfoDAO {

	private JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(StudentEduInfoDAOImpl.class.getName());

	public StudentEduInfoDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(StudentEduInfo studentEduInfo) {
		log.info("insdie StudentEduInfoDAOImpl save method");
		if (studentEduInfo.getStEduinfoId() > 0) {
			// update
			log.info("insdie StudentEduInfoDAOImpl save method update");
			//String sql = "UPDATE studenteduinfotbl SET name=?, email=?, password=?, " + "dateCreated=? WHERE adminId=?";
			/*
			 * jdbcTemplate.update(sql, admin.getAdminName(), admin.getEmail(),
			 * admin.getPassword(), admin.getDateCreated(), admin.getAdminId());
			 */
		} else {
			// insert
			log.info("insdie StudentEduInfoDAOImpl save method insert");
			String sql = "INSERT INTO studenteduinfotbl (studentId, instituteName, classId, passyear,eduBorad,eduRollNo,totalMarks,obtainedmarks,studentEduInfoDate)"
					+ " VALUES (?, ?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, studentEduInfo.getStudentId(), studentEduInfo.getInstituteName(),
					studentEduInfo.getClassId(), studentEduInfo.getPassyear(), studentEduInfo.getEduBorad(),
					studentEduInfo.getEduRollNo(), studentEduInfo.getTotalMarks(), studentEduInfo.getObtainedmarks(),
					new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		}

	}

	@Override
	public void upDate(StudentEduInfo studentEduInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public StudentEduInfo findById(int studentEduInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentEduInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(int studentEduInfoId) {
		// TODO Auto-generated method stub
		return false;
	}

}
