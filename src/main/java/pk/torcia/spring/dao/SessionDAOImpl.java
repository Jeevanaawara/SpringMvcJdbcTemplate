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
import pk.torcia.spring.model.Session;

/**
 * @author inayat
 *
 */

public class SessionDAOImpl implements SessionDAO {

	private JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(SessionDAOImpl.class.getName());

	public SessionDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Session section) {

		log.info("insdie SectionImpl save method");
		if (section.getSectionId() > 0) {
			log.info("insdie SectionImpl save method update");
			String sql = "UPDATE SectionTbl SET sectionName=?, sectionDesc=?,classId=?,sectionStartDate=?,acChargres=?,registrationFee=?,monthlyFee=?,sectionFee=?,totalSeats=?  WHERE sectionId=?";
			jdbcTemplate.update(sql, section.getSectionName(), section.getSectionDesc(),
					section.getBatchClass().getClassId(), section.getSessionStartDate(), section.getAcChargres(),
					section.getRegistrationFee(), section.getMonthlyFee(), section.getSectionFee(),
					section.getTotalSeats(), section.getSectionId());
		} else {
			// insert
			log.info("insdie SectionImpl save method insert");
			String sql = "INSERT INTO SectionTbl (sectionName, sectionDesc,classId,sectionStartDate, dateCreated,acChargres,registrationFee,monthlyFee,sectionFee,sectionDeleted,totalSeats)"
					+ " VALUES (?,?,?,?,?, ?, ?,?,?,?,?)";
			jdbcTemplate.update(sql, section.getSectionName(), section.getSectionDesc(),
					section.getBatchClass().getClassId(), section.getSessionStartDate(),
					new java.sql.Date(Calendar.getInstance().getTimeInMillis()), section.getAcChargres(),
					section.getRegistrationFee(), section.getMonthlyFee(), section.getSectionFee(), false,
					section.getTotalSeats());
		}
	}

	public void upDate(Session section) {
		log.info("insdie SectionImpl upDate method");

		if (section.getSectionId() > 0) {
			// update
			String sql = "UPDATE SectionTbl SET sectionName=?, sectionDesc=?, dateCreated=?  WHERE sectionId=?";
			jdbcTemplate.update(sql, section.getSectionName(), section.getSectionDesc(), section.getDateCreated());
		}
	}

	public Session findById(int sectionId) {
		log.info("insdie SectionImpl findById method");

		String sql = "select * from sectiontbl st inner join classtbl cls on st.classId = cls.classId WHERE st.sectionId="
				+ sectionId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Session>() {

			@Override
			public Session extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Session section = new Session();
					section.setSectionId(rs.getInt("st.sectionId"));
					section.setSectionName(rs.getString("st.sectionName"));
					section.setSessionStartDate(rs.getDate("st.sectionStartDate"));
					section.setRegistrationFee(rs.getInt("st.registrationFee"));
					section.setMonthlyFee(rs.getInt("st.monthlyFee"));
					section.setSectionFee(rs.getInt("st.sectionFee"));
					section.setTotalSeats(rs.getInt("st.totalSeats"));
					BatchClass bc = new BatchClass();
					bc.setClassId(rs.getInt("cls.classId"));
					bc.setClassName(rs.getString("cls.className"));
					bc.setClassType(rs.getString("cls.classType"));
					section.setBatchClass(bc);
					return section;
				}
				return null;
			}
		});
	}

	public List<Session> findAll() {
		log.info("insdie SectionImpl findAll method");

		String sql = " select * from sectiontbl st inner join classtbl cls on st.classId = cls.classId  where st.sectionDeleted='0'   order by st.sectionid desc  ";
		List<Session> listSection = jdbcTemplate.query(sql, new RowMapper<Session>() {

			@Override
			public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
				Session section = new Session();
				section.setSectionId(rs.getInt("st.sectionId"));
				section.setSectionName(rs.getString("st.sectionName") != null ? rs.getString("st.sectionName") : "");
				section.setSessionStartDate(
						rs.getDate("st.sectionStartDate") != null ? rs.getDate("st.sectionStartDate") : null);
				section.setRegistrationFee(rs.getInt("st.registrationFee") != 0 ? rs.getInt("st.registrationFee") : 0);
				section.setMonthlyFee(rs.getInt("st.monthlyFee") != 0 ? rs.getInt("st.monthlyFee") : 0);
				section.setSectionFee(rs.getInt("st.sectionFee") != 0 ? rs.getInt("st.sectionFee") : 0);
				BatchClass bc = new BatchClass();
				bc.setClassId(rs.getInt("cls.classId"));
				bc.setClassName(rs.getString("cls.className"));
				section.setBatchClass(bc);
				return section;
			}
		});
		return listSection;
	}

	public boolean removeById(int sectionId) {
		log.info("insdie SectionImpl removeById method");

		String sql = "Update  SectionTbl set sectionDeleted='1' WHERE sectionId=?";
		jdbcTemplate.update(sql, sectionId);
		return false;
	}

	@Override
	public List<Session> findAllByType(String type) {
		log.info("insdie SectionImpl findAllByType method");

		String sql = "select * from sectiontbl st inner join classtbl cls on st.classId = cls.classId  where st.sectionDeleted='0' and cls.classtype ='"
				+ type + "'  ";
		List<Session> listSection = jdbcTemplate.query(sql, new RowMapper<Session>() {

			@Override
			public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
				Session section = new Session();
				section.setSectionId(rs.getInt("st.sectionId"));
				section.setSectionName(rs.getString("st.sectionName") != null ? rs.getString("st.sectionName") : "");
				section.setSessionStartDate(
						rs.getDate("st.sectionStartDate") != null ? rs.getDate("st.sectionStartDate") : null);
				section.setRegistrationFee(rs.getInt("st.registrationFee") != 0 ? rs.getInt("st.registrationFee") : 0);
				section.setMonthlyFee(rs.getInt("st.monthlyFee") != 0 ? rs.getInt("st.monthlyFee") : 0);
				section.setSectionFee(rs.getInt("st.sectionFee") != 0 ? rs.getInt("st.sectionFee") : 0);
				BatchClass bc = new BatchClass();
				bc.setClassId(rs.getInt("cls.classId"));
				bc.setClassName(rs.getString("cls.className"));
				section.setBatchClass(bc);
				return section;
			}
		});
		return listSection;
	}

	@Override
	public List<Session> findByClassId(int classId) {

		log.info("insdie SectionImpl findByClassId method");

		String sql = "select st.sectionId, st.sectionName  from sectiontbl st where st.sectionDeleted='0' and st.classId ='"
				+ classId + "'  ";
		List<Session> listSection = jdbcTemplate.query(sql, new RowMapper<Session>() {

			@Override
			public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
				Session section = new Session();
				section.setSectionId(rs.getInt("st.sectionId"));
				section.setSectionName(rs.getString("st.sectionName") != null ? rs.getString("st.sectionName") : "");
				return section;
			}
		});
		return listSection;
	}

}
