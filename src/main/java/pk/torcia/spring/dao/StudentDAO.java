/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.Student;

/**
 * @author inayat
 * 
 */
public interface StudentDAO {

	public String save(Student student);

	public void upDate(Student student);

	public Student findById(int studentId);

	public List<Student> findAll();

	public boolean removeById(int studentId);
	public int maxRoleNo(int classId);
	public List<Student> findAll(Student student);
	public String transferStudent(Student student);
	
}
