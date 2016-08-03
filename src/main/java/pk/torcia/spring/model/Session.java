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
public class Session {
	private int sectionId;
	@NotNull
	@Size(min = 3, max = 20)
	private String sectionName;
	private String sectionDesc;
	private Date dateCreated;
	private BatchClass batchClass;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date sessionStartDate;
	private int monthlyFee;
	private int registrationFee;
	private int acChargres;
	private int sectionFee;
	private boolean sectionDeleted;
	private int totalSeats;

	public Session() {
	}

	public Session(int sectionId, String sectionName, String sectionDesc, Date dateCreated) {
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.sectionDesc = sectionDesc;
		this.dateCreated = dateCreated;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionDesc() {
		return sectionDesc;
	}

	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public BatchClass getBatchClass() {
		return batchClass;
	}

	public void setBatchClass(BatchClass batchClass) {
		this.batchClass = batchClass;
	}

	public Date getSessionStartDate() {
		return sessionStartDate;
	}

	public void setSessionStartDate(Date sessionStartDate) {
		this.sessionStartDate = sessionStartDate;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public int getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(int registrationFee) {
		this.registrationFee = registrationFee;
	}

	public int getAcChargres() {
		return acChargres;
	}

	public void setAcChargres(int acChargres) {
		this.acChargres = acChargres;
	}

	public int getSectionFee() {
		return sectionFee;
	}

	public void setSectionFee(int sectionFee) {
		this.sectionFee = sectionFee;
	}

	public boolean isSectionDeleted() {
		return sectionDeleted;
	}

	public void setSectionDeleted(boolean sectionDeleted) {
		this.sectionDeleted = sectionDeleted;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	

}
