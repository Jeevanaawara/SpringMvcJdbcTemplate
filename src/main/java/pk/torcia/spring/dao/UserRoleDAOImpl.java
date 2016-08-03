/**
 * 
 */
package pk.torcia.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import pk.torcia.spring.model.UserRole;

/**
 * @author inayat
 *
 */
public class UserRoleDAOImpl implements UserRoleDAO {
	private JdbcTemplate jdbcTemplate;

	static Logger log = Logger.getLogger(UserRoleDAOImpl.class.getName());

	public UserRoleDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(UserRole userRole) {
		// TODO Auto-generated method stub

	}

	@Override
	public void upDate(UserRole userRole) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserRole findById(int userRoleId) {

		log.info("insdie UserRoleDAOImpl findById method");
		String sql = "SELECT * FROM userRoleTbl WHERE roleId=" + userRoleId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<UserRole>() {

			@Override
			public UserRole extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserRole userRole = new UserRole();
					userRole.setRoleId(rs.getInt("roleId"));
					userRole.setRoleName(rs.getString("roleName"));
					userRole.setRoleDesc(rs.getString("roleDesc"));
					userRole.setAdminId(rs.getInt("adminId"));
					return userRole;
				}
				return null;
			}
		});
	}

	@Override
	public List<UserRole> findAll() {
		log.info("insdie UserRoleDAOImpl findAll method");
		String sql = "SELECT * FROM userroletbl ";
		List<UserRole> listAdmin = jdbcTemplate.query(sql, new RowMapper<UserRole>() {

			@Override
			public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserRole userRole = new UserRole();

				userRole.setRoleId(rs.getInt("roleId"));
				userRole.setRoleName(rs.getString("roleName"));
				return userRole;
			}
		});
		return listAdmin;
	}

	@Override
	public boolean removeById(int userRoleId) {
		// TODO Auto-generated method stub
		return false;
	}

}
