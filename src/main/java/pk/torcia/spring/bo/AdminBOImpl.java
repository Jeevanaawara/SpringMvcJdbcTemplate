/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.AdminDAO;
import pk.torcia.spring.model.Admin;

/**
 * @author inayat
 *
 */
@Component
public class AdminBOImpl implements AdminBO {

	@Autowired
	private AdminDAO adminDAO;

	public void save(Admin admin) {
		adminDAO.save(admin);

	}

	public void upDate(Admin admin) {
		adminDAO.upDate(admin);
	}

	public Admin findById(String adminId) {

		return adminDAO.findById(adminId);
	}

	public List<Admin> findAll() {
		return adminDAO.findAll();
	}

	public boolean removeById(String adminId) {
		return adminDAO.removeById(adminId);
	}

	@Override
	public String isValidUser(String userName, String password) {
	
		return adminDAO.isValidUser(userName, password);
	}

}
