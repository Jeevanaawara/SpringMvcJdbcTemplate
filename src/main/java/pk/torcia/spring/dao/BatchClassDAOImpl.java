/**
 * 
 */
package pk.torcia.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import pk.torcia.spring.model.BatchClass;

/**
 * @author inayat
 *
 */
public class BatchClassDAOImpl implements BatchClassDAO {

	private JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(BatchClassDAOImpl.class.getName());
	public BatchClassDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(BatchClass batchClass) {
		log.info("insdie BatchClassImpl save method");
		if (batchClass.getClassId() > 0) {
			// update
			log.info("insdie BatchClassImpl save method update ");
			String sql = "UPDATE classtbl SET className=?, classDesc=?,classType=?, dateCreated=? ,groupId=? WHERE classId=?";
			jdbcTemplate.update(sql, batchClass.getClassName(), batchClass.getClassDesc(),batchClass.getClassType(), batchClass.getDateCreated(),
					batchClass.getGroupId(),batchClass.getClassId());
		} else {
			// insert
			log.info("insdie BatchClassImpl save method insert ");
			String sql = "INSERT INTO classtbl (className, classDesc,classType, dateCreated,classDeleted,groupId)" + " VALUES (?,?, ?,?, ?,?)";
			jdbcTemplate.update(sql, batchClass.getClassName(), batchClass.getClassDesc(),batchClass.getClassType(), new java.sql.Date(Calendar.getInstance().getTimeInMillis()),false,batchClass.getGroupId());
		}
	}

	@Override
	public void upDate(BatchClass batchClass) {
		log.info("insdie BatchClassImpl upDate method");
		if (batchClass.getClassId() > 0) {
			// update
			String sql = "UPDATE classtbl SET className=?, classDesc=?, dateCreated=?  WHERE classId=?";
			jdbcTemplate.update(sql, batchClass.getClassName(), batchClass.getClassDesc(), batchClass.getDateCreated());
		}
	}

	@Override
	public BatchClass findById(int batchClassId) {
		log.info("insdie BatchClassImpl findById method");

		String sql = "SELECT * FROM classtbl WHERE classId=" + batchClassId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<BatchClass>() {

			@Override
			public BatchClass extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					BatchClass batchClass = new BatchClass();
					batchClass.setClassId(rs.getInt("classId"));
					batchClass.setClassName(rs.getString("className"));
					batchClass.setClassDesc(rs.getString("classDesc"));
					batchClass.setClassType(rs.getString("classType"));
					return batchClass;
				}
				return null;
			}
		});
	}

	@Override
	public List<BatchClass> findAll() {
		log.info("insdie BatchClassImpl findAll method");

		String sql = " SELECT * FROM classtbl where classDeleted='0'  order by classid desc  ";
		List<BatchClass> listBatchClass = jdbcTemplate.query(sql, new RowMapper<BatchClass>() {

			@Override
			public BatchClass mapRow(ResultSet rs, int rowNum) throws SQLException {
				BatchClass batchClass = new BatchClass();
				batchClass.setClassId(rs.getInt("classId"));
				batchClass.setClassName(rs.getString("className"));
				batchClass.setClassDesc(rs.getString("classDesc"));
				batchClass.setClassType(rs.getString("classType"));
				return batchClass;
			}
		});
		return listBatchClass;
	}

	@Override
	public boolean removeById(int batchClassId) {
		log.info("insdie BatchClassImpl removeById method");

		String sql = "Update  classtbl set classDeleted='1' WHERE classId=?";
		jdbcTemplate.update(sql, batchClassId);
		return false;
	}

	@Override
	public List<BatchClass> findAllByType(String type) {
		log.info("insdie BatchClassImpl findById method");

		String sql = "SELECT * FROM classtbl WHERE classDeleted='0' and classType like ('%"+type+"%') ";
		List<BatchClass> listBatchClass = jdbcTemplate.query(sql, new RowMapper<BatchClass>() {

			@Override
			public BatchClass mapRow(ResultSet rs, int rowNum) throws SQLException {
				BatchClass batchClass = new BatchClass();
				batchClass.setClassId(rs.getInt("classId"));
				batchClass.setClassName(rs.getString("className"));
				batchClass.setClassDesc(rs.getString("classDesc"));
				batchClass.setClassType(rs.getString("classType"));
				return batchClass;
			}
		});
		return listBatchClass;
	}

	@Override
	public List<BatchClass> findAllByCategory(int groupId) {
		log.info("insdie BatchClassImpl findAllByCategory method");

		String sql = "SELECT * FROM classtbl WHERE classDeleted='0' and groupId= '"+groupId+"' ";
		List<BatchClass> listBatchClass = jdbcTemplate.query(sql, new RowMapper<BatchClass>() {

			@Override
			public BatchClass mapRow(ResultSet rs, int rowNum) throws SQLException {
				BatchClass batchClass = new BatchClass();
				batchClass.setClassId(rs.getInt("classId"));
				batchClass.setClassName(rs.getString("className"));
				batchClass.setClassDesc(rs.getString("classDesc"));
				batchClass.setClassType(rs.getString("classType"));
				return batchClass;
			}
		});
		return listBatchClass;
	}

}
