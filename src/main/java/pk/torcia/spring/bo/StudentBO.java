/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import pk.torcia.spring.model.Student;

/**
 * @author inayat
 * 
 */
public interface StudentBO {

	public String save(Student student);

	public void upDate(Student student);

	public Student findById(int studentId);

	public List<Student> findAll();
	public List<Student> findAll(Student student);

	public boolean removeById(int studentId);
	public int maxRoleNo(int classId);
	public String transferStudent(Student student);
}
