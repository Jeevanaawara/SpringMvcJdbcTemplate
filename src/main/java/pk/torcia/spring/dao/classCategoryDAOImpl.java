/**
 * 
 */
package pk.torcia.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import pk.torcia.spring.model.ClassCategory;

/**
 * @author inayat
 *
 */
public class classCategoryDAOImpl implements ClassCategoryDAO {

	private JdbcTemplate jdbcTemplate;

	static Logger log = Logger.getLogger(classCategoryDAOImpl.class.getName());

	public classCategoryDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(ClassCategory classCategory) {

	}

	@Override
	public void upDate(ClassCategory classCategory) {

	}

	@Override
	public ClassCategory findById(int classCategoryId) {

		return null;
	}

	@Override
	public List<ClassCategory> findAll() {

		log.info("insdie classCategoryDAOImpl findAll method");

		String sql = "select * from grouptbl ";
		List<ClassCategory> listClassCategory = jdbcTemplate.query(sql, new RowMapper<ClassCategory>() {

			@Override
			public ClassCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				ClassCategory classCategory = new ClassCategory();

				classCategory.setClassCateogryid(rs.getInt("groupId"));
				classCategory.setClassCategoryName(rs.getString("groupName"));
				return classCategory;
			}
		});
		return listClassCategory;
	}

	@Override
	public boolean removeById(int classCategoryId) {

		return false;
	}

}
