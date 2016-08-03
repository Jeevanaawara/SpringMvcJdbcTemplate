/**
 * 
 */
package pk.torcia.spring.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author inayat
 * 
 */
public class Admin {

	/**
	 * 
	 */
	private int adminId;
	@NotNull
	@Size(min = 3, max=10)
	private String adminName;
	private String email;
	@Size(min = 3, max=10)
	private String password;
	private Date dateCreated;
	private String roleName;
	private int enabled =1;
	private UserRole userRole;
	private boolean adminDeleted;

	public Admin() {

	}

	public Admin(int adminId, String adminName, String email, String password, Date dateCreated) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.email = email;
		this.password = password;
		this.dateCreated = dateCreated;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public boolean isAdminDeleted() {
		return adminDeleted;
	}

	public void setAdminDeleted(boolean adminDeleted) {
		this.adminDeleted = adminDeleted;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
