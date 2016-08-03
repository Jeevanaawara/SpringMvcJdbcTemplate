/**
 * 
 */
package pk.torcia.spring.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author inayat
 * 
 */
public class Shift {

	private int shiftId;
	@NotNull
	@Size(min = 3,max=20)
	private String shiftName;
	private String shiftDesc;
	private Date dateCreated;
	private boolean shiftDeleted;

	public Shift() {

	}

	public Shift(int shiftid, String shiftName, String shiftDesc, Date dateCreated) {
		this.shiftId = shiftid;
		this.shiftName = shiftName;
		this.shiftDesc = shiftDesc;
		this.dateCreated = dateCreated;
	}

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getShiftDesc() {
		return shiftDesc;
	}

	public void setShiftDesc(String shiftDesc) {
		this.shiftDesc = shiftDesc;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isShiftDeleted() {
		return shiftDeleted;
	}

	public void setShiftDeleted(boolean shiftDeleted) {
		this.shiftDeleted = shiftDeleted;
	}
	

}
