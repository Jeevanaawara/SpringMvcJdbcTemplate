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

import pk.torcia.spring.model.Shift;

/**
 * @author inayat
 *
 */
public class ShiftDAOImpl implements ShiftDAO {

	private JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(ShiftDAOImpl.class.getName());
	public ShiftDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Shift shift) {
		log.info("insdie ShiftImpl save method");
		if (shift.getShiftId() > 0) {
			System.out.println("insdie ShiftImpl save method Update");
			// update
			String sql = "UPDATE shifttbl SET shiftName=?, shiftDesc=?, dateCreated=? WHERE shiftId=?";
			jdbcTemplate.update(sql, shift.getShiftName(), shift.getShiftDesc(), shift.getDateCreated(),
					shift.getShiftId());
		} else {
			// insert
			log.info("insdie ShiftImpl save method insert");
			String sql = "INSERT INTO shifttbl (shiftName, shiftDesc, dateCreated,shiftDeleted)" + " VALUES (?, ?,?, ?)";
			jdbcTemplate.update(sql, shift.getShiftName(), shift.getShiftDesc(), new java.sql.Date(Calendar.getInstance().getTimeInMillis()),false);
		}
	}

	public void upDate(Shift shift) {
		log.info("insdie ShiftImpl update method");
		if (shift.getShiftId() > 0) {
			// update
			String sql = "UPDATE shifttbl SET shiftName=?, shiftDesc=?, dateCreated=?, WHERE shiftId=?";
			jdbcTemplate.update(sql, shift.getShiftName(), shift.getShiftDesc(), shift.getShiftId());
		}

	}

	public Shift findById(int shiftId) {
		log.info("insdie ShiftImpl findById method");

		String sql = "SELECT * FROM shifttbl WHERE shiftId=" + shiftId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Shift>() {

			@Override
			public Shift extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Shift shift = new Shift();
					shift.setShiftId(rs.getInt("shiftId"));
					shift.setShiftName(rs.getString("shiftName"));
					shift.setShiftDesc(rs.getString("shiftDesc"));
					return shift;
				}
				return null;
			}
		});
	}

	public List<Shift> findAll() {
		log.info("insdie ShiftImpl findAll method");

		String sql = " SELECT * FROM shifttbl where shiftDeleted ='0'  order by shiftid desc ";
		List<Shift> listShift = jdbcTemplate.query(sql, new RowMapper<Shift>() {

			@Override
			public Shift mapRow(ResultSet rs, int rowNum) throws SQLException {
				Shift shift = new Shift();

				shift.setShiftId(rs.getInt("shiftId"));
				shift.setShiftName(rs.getString("shiftName"));
				shift.setShiftDesc(rs.getString("shiftDesc"));
				return shift;
			}
		});
		return listShift;
	}

	public boolean removeById(int shiftId) {
		log.info("insdie ShiftImpl removeById method");

		String sql = "Update  shifttbl set shiftDeleted='1' WHERE shiftId=?";
		jdbcTemplate.update(sql, shiftId);
		return false;
	}

}
