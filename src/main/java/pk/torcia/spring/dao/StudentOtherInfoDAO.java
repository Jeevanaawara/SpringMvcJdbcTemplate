/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.StudentOtherInfo;

/**
 * @author inayat
 *
 */
public interface StudentOtherInfoDAO {
	public void save(StudentOtherInfo studentOtherInfo );
	public void upDate(StudentOtherInfo studentOtherInfo );
	public StudentOtherInfo findById(int studentOtherInfoId);
	public List<StudentOtherInfo> findAll();
	public boolean removeById(int studentOtherInfoId );
	
}
