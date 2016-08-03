/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.Admin;


/**
 * @author inayat
 *
 */
public interface AdminDAO {

	public void save(Admin admin );
	public void upDate(Admin admin );
	public Admin findById(String adminId);
	public List<Admin> findAll();
	public boolean removeById(String adminId );
	public String isValidUser(String userName, String password);
	public Admin findByUserName(String username);
	
}
