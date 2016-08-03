/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.StudentProgressReport;

/**
 * @author inayat
 *
 */
public interface StudentProgressDAO {

	public void save(StudentProgressReport studentProgressReport );
	public void upDate(StudentProgressReport studentProgressReport );
	public StudentProgressReport findById(int studentProgressReportId);
	public List<StudentProgressReport> findAll();
	public boolean removeById(int studentProgressReportId );

}
