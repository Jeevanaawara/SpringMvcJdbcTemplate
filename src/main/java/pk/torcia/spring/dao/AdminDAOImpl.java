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

import pk.torcia.spring.model.Admin;
import pk.torcia.spring.model.UserRole;

/**
 * @author inayat
 *
 */
public class AdminDAOImpl implements AdminDAO {

	private JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(AdminDAOImpl.class.getName());

	public AdminDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Admin admin) {
		log.info("insdie AdminImpl save method");
		if (admin.getAdminId() > 0) {
			// update
			log.info("insdie AdminImpl save method update");
			String sql = "UPDATE users usr inner join  user_roles usRole on usr.username = usRole.username SET usr.username=?,  usr.password=?, usr.email=?, usRole.role=? WHERE usr.username=?";
			jdbcTemplate.update(sql, admin.getAdminName(),  admin.getPassword(),admin.getEmail(),admin.getRoleName(),admin.getAdminName());
		} else {
			// insert
			log.info("insdie AdminImpl save method insert");
			String sql = "INSERT INTO users (username, password, enabled, email)"
					+ " VALUES (?,?,?,?)";
			jdbcTemplate.update(sql, admin.getAdminName(), admin.getPassword(),admin.getEnabled() ,admin.getEmail());
			String sql2 = "INSERT INTO user_roles (username, role)"
					+ " VALUES (?,?)";
			jdbcTemplate.update(sql2, admin.getAdminName(), admin.getRoleName());
			
		}
	}

	@Override
	public void upDate(Admin admin) {
		log.info("insdie AdminImpl upDate method");
			String sql = "UPDATE users usr SET usr.password=?  WHERE usr.username=?";
			jdbcTemplate.update(sql,  admin.getPassword(),admin.getAdminName());
	}

	@Override
	public Admin findById(String adminId) {
		
		log.info("insdie AdminImpl findById method");
		String sql = "SELECT * FROM users usr inner join  user_roles usRole on usr.username = usRole.username WHERE usr.username='"+adminId+"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Admin>() {

			@Override
			public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Admin admin = new Admin();
					admin.setAdminName(rs.getString("username"));
					admin.setEmail(rs.getString("email"));
					admin.setPassword(rs.getString("password"));
					admin.setEnabled(rs.getInt("enabled"));
					admin.setRoleName(rs.getString("usRole.role"));
					return admin;
				}
				return null;
			}
		});
	}

	@Override
	public List<Admin> findAll() {
		log.info("insdie AdminImpl findAll method");
		String sql = " SELECT * FROM users usr inner join  user_roles usRole on usr.username = usRole.username where usr.enabled='1' ";
		List<Admin> listAdmin = jdbcTemplate.query(sql, new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				admin.setAdminName(rs.getString("username"));
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				UserRole userRole = new UserRole();
				userRole.setRoleName(rs.getString("usRole.role"));
				admin.setUserRole(userRole);
				return admin;
			}
		});
		return listAdmin;
	}

	@Override
	public boolean removeById(String adminId) {
		log.info("insdie AdminImpl removeById method");
		String sql = "Update  users set enabled='0' WHERE username=?";
		jdbcTemplate.update(sql, adminId);
		return false;
	}

	@Override
	public String isValidUser(String userName, String password) {
		log.info("insdie AdminImpl isValidUser method");
		return password;
	}
	
	
	
	
	@Override
	public Admin findByUserName(String adminUser) {
		log.info("insdie AdminImpl findById method");
		String sql = "SELECT * FROM admintbl ad inner join userroletbl urt on ad.roleId = urt.roleId WHERE ad.adminId="
				+ adminUser;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Admin>() {

			@Override
			public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Admin admin = new Admin();
					admin.setAdminId(rs.getInt("adminId"));
					admin.setAdminName(rs.getString("name"));
					admin.setEmail(rs.getString("email"));
					admin.setPassword(rs.getString("password"));
					UserRole userRole = new UserRole();
					userRole.setRoleId(rs.getInt("urt.roleId"));
					userRole.setRoleName(rs.getString("urt.roleName"));
					admin.setUserRole(userRole);
					return admin;
				}
				return null;
			}
		});
	}
	
}
