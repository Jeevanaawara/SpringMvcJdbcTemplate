/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.StudentOtherInfoDAO;
import pk.torcia.spring.model.StudentOtherInfo;

/**
 * @author inayat
 *
 */
@Component
public class StudentOtherInfoBOImpl implements StudentOtherInfoBO {

	@Autowired
	private StudentOtherInfoDAO studentOtherInfoDAO;
	
	@Override
	public void save(StudentOtherInfo studentOtherInfo) {
		studentOtherInfoDAO.save(studentOtherInfo);
		
	}

	@Override
	public void upDate(StudentOtherInfo studentOtherInfo) {
		studentOtherInfoDAO.upDate(studentOtherInfo);
		
	}

	@Override
	public StudentOtherInfo findById(int studentOtherInfoId) {

		return studentOtherInfoDAO.findById(studentOtherInfoId);
	}

	@Override
	public List<StudentOtherInfo> findAll() {
		// TODO Auto-generated method stub
		return studentOtherInfoDAO.findAll();
	}

	@Override
	public boolean removeById(int studentOtherInfoId) {
		// TODO Auto-generated method stub
		return studentOtherInfoDAO.removeById(studentOtherInfoId);
	}

}
