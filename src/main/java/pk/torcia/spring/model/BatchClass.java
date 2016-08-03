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
public class BatchClass {

	private int classId;
	@NotNull
	@Size(min = 3,max=20)
	private String className;
	private String classDesc;
	private String classType;
	private Date dateCreated;
	private boolean classDeleted;
	private int groupId;
	private ClassCategory classCategory;

	public BatchClass() {

	}

	public BatchClass(int classid, String className, String classDesc, Date dateCreated) {
		this.classId = classid;
		this.className = className;
		this.classDesc = classDesc;
		this.dateCreated = dateCreated;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public boolean isClassDeleted() {
		return classDeleted;
	}

	public void setClassDeleted(boolean classDeleted) {
		this.classDeleted = classDeleted;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public ClassCategory getClassCategory() {
		return classCategory;
	}

	public void setClassCategory(ClassCategory classCategory) {
		this.classCategory = classCategory;
	}

	
}
