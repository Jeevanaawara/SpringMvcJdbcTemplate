/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pk.torcia.spring.model.Fees;
import pk.torcia.spring.model.Student;

/**
 * @author inayat
 *
 */
public class FeesDaoImpl implements FeesDAO {

	private JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(FeesDaoImpl.class.getName());

	public FeesDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Fees fee) {
		log.info("insdie FeesDaoImpl save method");
		if (fee.getFeesId() > 0) {
			// update
			log.info("insdie FeesDaoImpl save method update");
			String sql = "UPDATE feestbl SET addmissionFee=?, tuitionFee=?, acCharges=?,studentId=?,feeReceived=?,balanceDueDate=?,monthName=?,feesYear=?,feesCreated=? WHERE feesId=?";
			jdbcTemplate.update(sql, fee.getAddmissionFee(), fee.getTuitionFee(), fee.getAcCharges(),
					fee.getStudentId(), fee.getFeeReceived(), fee.getBalanceDueDate(), fee.getMonthName(),
					fee.getFeesYear(), fee.getFeesCreated(), fee.getFeesId());
		} else {
			// insert
			log.info("insdie FeesDaoImpl save method insert");
			String sql = "INSERT INTO feestbl (addmissionFee, tuitionFee, acCharges,studentId,feeReceived,balanceDueDate,feesMonth,feesYear, feesCreated,sessionFee)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, fee.getAddmissionFee(), fee.getTuitionFee(), fee.getAcCharges(),
					fee.getStudentId(), fee.getFeeReceived(), fee.getBalanceDueDate(), fee.getMonthName(),
					fee.getFeesYear(), new java.sql.Date(Calendar.getInstance().getTimeInMillis()),
					fee.getSessionFee());
		}

	}

	@Override
	public void upDate(Fees fees) {

	}

	@Override
	public Student findById(int feesId) {

		return null;
	}

	@Override
	public List<Fees> findAll() {

		return null;
	}

	@Override
	public boolean removeById(int feeId) {
		log.info("insdie studentImpl remove by id method");
		String sql = "DELETE FROM studenttbl WHERE studentId=?";
		jdbcTemplate.update(sql, feeId);
		return false;
	}

	@Override
	public void saveMonthlyFee(Fees fee) {

		log.info("insdie FeesDaoImpl saveMonthlyFee method insert");
		String sql = "INSERT INTO feestbl (studentId,tuitionFee,feesMonth)" + " VALUES (?,?,?)";
		jdbcTemplate.update(sql, fee.getStudentId(), fee.getTuitionFee(), fee.getMonthName());

	}

}
