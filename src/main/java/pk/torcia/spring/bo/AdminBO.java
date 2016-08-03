/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import pk.torcia.spring.model.Admin;

/**
 * @author inayat
 *
 */
public interface AdminBO {

	public void save(Admin admin);

	public void upDate(Admin admin);

	public Admin findById(String adminId);

	public List<Admin> findAll();

	public String isValidUser(String userName, String password);

	public boolean removeById(String adminId);

}
