/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.StudentDAO;
import pk.torcia.spring.model.Student;

/**
 * @author inayat
 *
 */
@Component
public class StudentBOImpl implements StudentBO {

	@Autowired
	private StudentDAO studentDAO;

	public String save(Student student) {
		return studentDAO.save(student);

	}

	public void upDate(Student student) {
		studentDAO.upDate(student);

	}

	public Student findById(int studentId) {

		return studentDAO.findById(studentId);
	}

	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	public boolean removeById(int studentId) {
		return studentDAO.removeById(studentId);
	}

	@Override
	public int maxRoleNo(int classId) {
		return studentDAO.maxRoleNo(classId);
	}

	@Override
	public List<Student> findAll(Student student) {
		return studentDAO.findAll(student);
	}

	@Override
	public String transferStudent(Student student) {

		return studentDAO.transferStudent(student);
	}

}
