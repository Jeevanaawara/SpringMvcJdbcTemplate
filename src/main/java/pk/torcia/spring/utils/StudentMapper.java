/**
 * 
 */
package pk.torcia.spring.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pk.torcia.spring.model.Student;

/**
 * @author inayat
 *
 */
public class StudentMapper implements RowMapper<Student> {
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getInt("id"));
		student.setStudentFirstName(rs.getString("name"));
		//student.setAge(rs.getInt("age"));
		return student;
	}
}