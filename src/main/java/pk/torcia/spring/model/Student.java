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
public class Student {

	private int studentId;
	@NotNull
	@Size(min = 3, max = 55)
	private String studentFirstName;
	private String imageName;
	private int studentRollNo;
	private String board;
	private int classId;
	private int shiftId;
	private int sectionId;
	private Date dateCreated;
	private Date enddateCreated;
	private Fees fees;
	private BatchClass batchClass;
	private Session sessionClass;
	private Shift shift;
	private String remarks;
	private String program;
	private boolean studentDeleted;
	private String studentCreatedby;

	public Student() {

	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public Date getEnddateCreated() {
		return enddateCreated;
	}

	public void setEnddateCreated(Date enddateCreated) {
		this.enddateCreated = enddateCreated;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Fees getFees() {
		return fees;
	}

	public void setFees(Fees fees) {
		this.fees = fees;
	}

	public BatchClass getBatchClass() {
		return batchClass;
	}

	public void setBatchClass(BatchClass batchClass) {
		this.batchClass = batchClass;
	}

	public Session getSessionClass() {
		return sessionClass;
	}

	public void setSessionClass(Session sessionClass) {
		this.sessionClass = sessionClass;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public boolean isStudentDeleted() {
		return studentDeleted;
	}

	public void setStudentDeleted(boolean studentDeleted) {
		this.studentDeleted = studentDeleted;
	}

	public String getStudentCreatedby() {
		return studentCreatedby;
	}

	public void setStudentCreatedby(String studentCreatedby) {
		this.studentCreatedby = studentCreatedby;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}
	
	

}
