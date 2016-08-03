/**
 * 
 */
package pk.torcia.spring.model;

import java.sql.Date;

/**
 * @author inayat
 *
 */
public class UserRole {
	private int roleId;
	private String roleName;
	private String roleDesc;
	private int adminId;
	private Date roleCreated;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Date getRoleCreated() {
		return roleCreated;
	}

	public void setRoleCreated(Date roleCreated) {
		this.roleCreated = roleCreated;
	}

}
