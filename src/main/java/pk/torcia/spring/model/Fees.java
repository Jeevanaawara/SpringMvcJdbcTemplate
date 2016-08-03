/**
 * 
 */
package pk.torcia.spring.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author inayat
 *
 */
public class Fees {

	private int feesId;
	private int studentId;
	@NotNull
	@Size(min = 3, max = 20)
	private int addmissionFee;
	private int tuitionFee;
	private int acCharges;
	private int sessionFee;
	private int feeReceived;
	private int feeBalance;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date balanceDueDate;
	private String monthName;
	private String feesYear;
	private Date feesCreated;

	public Fees() {

	}

	public Fees(int feesId, int feesAmount, int feesMonth, String feesYear, Date dateCreated) {
		this.feesId = feesId;
		this.addmissionFee = feesAmount;
		this.tuitionFee = feesMonth;
		this.feesYear = feesYear;
		this.feesCreated = dateCreated;
	}

	public int getFeesId() {
		return feesId;
	}

	public void setFeesId(int feesId) {
		this.feesId = feesId;
	}

	public int getAddmissionFee() {
		return addmissionFee;
	}

	public void setAddmissionFee(int addmissionFee) {
		this.addmissionFee = addmissionFee;
	}

	public int getTuitionFee() {
		return tuitionFee;
	}

	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public int getAcCharges() {
		return acCharges;
	}

	public void setAcCharges(int acCharges) {
		this.acCharges = acCharges;
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getFeeReceived() {
		return feeReceived;
	}

	public void setFeeReceived(int feeReceived) {
		this.feeReceived = feeReceived;
	}

	public int getFeeBalance() {
		return feeBalance;
	}

	public void setFeeBalance(int feeBalance) {
		this.feeBalance = feeBalance;
	}

	public Date getBalanceDueDate() {
		return balanceDueDate;
	}

	public void setBalanceDueDate(Date balanceDueDate) {
		this.balanceDueDate = balanceDueDate;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public String getFeesYear() {
		return feesYear;
	}

	public void setFeesYear(String feesYear) {
		this.feesYear = feesYear;
	}

	public Date getFeesCreated() {
		return feesCreated;
	}

	public void setFeesCreated(Date feesCreated) {
		this.feesCreated = feesCreated;
	}

	public int getSessionFee() {
		return sessionFee;
	}

	public void setSessionFee(int sessionFee) {
		this.sessionFee = sessionFee;
	}


}
