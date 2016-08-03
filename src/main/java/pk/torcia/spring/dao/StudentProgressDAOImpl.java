/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pk.torcia.spring.model.StudentProgressReport;

/**
 * @author inayat
 *
 */
public class StudentProgressDAOImpl implements StudentProgressDAO {

	private JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(StudentProgressDAOImpl.class.getName());

	public StudentProgressDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(StudentProgressReport studentProgressReport) {
		log.info("insdie StudentProgressDAOImpl save method");
		if (studentProgressReport.getStdntProgressRptId() > 0) {
			// update
			log.info("insdie StudentProgressDAOImpl save method update");
			/*
			 * String sql =
			 * "UPDATE admintbl SET name=?, email=?, password=?, roleId=? WHERE adminId=?"
			 * ; jdbcTemplate.update(sql, studentProgressReport.getAdminName(),
			 * admin.getEmail(), admin.getPassword(), admin.getRoleId(),
			 * admin.getAdminId());
			 */
		} else {
			// insert
			log.info("insdie StudentProgressDAOImpl save method insert");
			String sql = "INSERT INTO studentprogresstbl (studentId, subjectId,totalMarks, obtainedMarks,testName)"
					+ " VALUES (?,?,?,?,?)";
			jdbcTemplate.update(sql, studentProgressReport.getStudentId(), studentProgressReport.getSubjectId(),
					studentProgressReport.getTotalMarks(), studentProgressReport.getObtainedMarks(),
					studentProgressReport.getTestName());
		}
	}

	@Override
	public void upDate(StudentProgressReport studentProgressReport) {

	}

	@Override
	public StudentProgressReport findById(int studentProgressReportId) {
		return null;
	}

	@Override
	public List<StudentProgressReport> findAll() {
		return null;
	}

	@Override
	public boolean removeById(int studentProgressReportId) {
		return false;
	}

}
