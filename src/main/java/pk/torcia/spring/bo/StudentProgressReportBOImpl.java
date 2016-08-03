/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.StudentProgressDAO;
import pk.torcia.spring.model.StudentProgressReport;

/**
 * @author inayat
 *
 */
@Component
public class StudentProgressReportBOImpl implements StudentProgressReportBO {

	@Autowired
	private StudentProgressDAO studentProgressDAO;
	
	@Override
	public void save(StudentProgressReport studentProgressReport) {
		studentProgressDAO.save(studentProgressReport);
		
	}

	@Override
	public void upDate(StudentProgressReport studentProgressReport) {
		studentProgressDAO.upDate(studentProgressReport);
		
	}

	@Override
	public StudentProgressReport findById(int studentProgressReportId) {
		studentProgressDAO.findById(studentProgressReportId);
		return null;
	}

	@Override
	public List<StudentProgressReport> findAll() {
		studentProgressDAO.findAll();
		return null;
	}

	@Override
	public boolean removeById(int studentProgressReportId) {
		studentProgressDAO.removeById(studentProgressReportId);
		return false;
	}

}
