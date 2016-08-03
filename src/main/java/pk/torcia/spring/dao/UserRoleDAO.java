package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.UserRole;

public interface UserRoleDAO {

	public void save(UserRole userRole );
	public void upDate(UserRole userRole );
	public UserRole findById(int userRoleId);
	public List<UserRole> findAll();
	public boolean removeById(int userRoleId );

}
