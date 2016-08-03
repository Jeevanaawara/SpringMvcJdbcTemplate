/**
 * 
 */
package pk.torcia.spring.model;

import java.util.Date;

/**
 * @author inayat
 *
 */
public class StudentOtherInfo {

	private int studentInfoId;
	private int studentId;
	private String fatherName;
	private String nationality;
	private String perminentAddress;
	private String tempAddress;
	private String phoneNo;
	private String mobileNo;
	private String studentEmail;
	private String boarderDayScholar;
	private String guardian;
	private String guardianRelation;
	private String guardianName;
	private String guardianCNIC;
	private String guardianContact;
	private String guardianCell;
	private String guardianEmail;
	private String studentDob;
	private Date studentOtherInfoCreated;
	private int classId;
	private int sectionId;
	private StudentEduInfo studentEduInfo;
	private BatchClass batchClass;
	private Shift shift;
	private Session session;
	private Student student;

	public StudentOtherInfo() {

	}

	public int getStudentInfoId() {
		return studentInfoId;
	}

	public void setStudentInfoId(int studentInfoId) {
		this.studentInfoId = studentInfoId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPerminentAddress() {
		return perminentAddress;
	}

	public void setPerminentAddress(String perminentAddress) {
		this.perminentAddress = perminentAddress;
	}

	public String getTempAddress() {
		return tempAddress;
	}

	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getBoarderDayScholar() {
		return boarderDayScholar;
	}

	public void setBoarderDayScholar(String boarderDayScholar) {
		this.boarderDayScholar = boarderDayScholar;
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public String getGuardianRelation() {
		return guardianRelation;
	}

	public void setGuardianRelation(String guardianRelation) {
		this.guardianRelation = guardianRelation;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getGuardianCNIC() {
		return guardianCNIC;
	}

	public void setGuardianCNIC(String guardianCNIC) {
		this.guardianCNIC = guardianCNIC;
	}

	public String getGuardianContact() {
		return guardianContact;
	}

	public void setGuardianContact(String guardianContact) {
		this.guardianContact = guardianContact;
	}

	public String getGuardianEmail() {
		return guardianEmail;
	}

	public void setGuardianEmail(String guardianEmail) {
		this.guardianEmail = guardianEmail;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public Date getStudentOtherInfoCreated() {
		return studentOtherInfoCreated;
	}

	public void setStudentOtherInfoCreated(Date studentOtherInfoCreated) {
		this.studentOtherInfoCreated = studentOtherInfoCreated;
	}

	public String getGuardianCell() {
		return guardianCell;
	}

	public void setGuardianCell(String guardianCell) {
		this.guardianCell = guardianCell;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public StudentEduInfo getStudentEduInfo() {
		return studentEduInfo;
	}

	public void setStudentEduInfo(StudentEduInfo studentEduInfo) {
		this.studentEduInfo = studentEduInfo;
	}

	public BatchClass getBatchClass() {
		return batchClass;
	}

	public void setBatchClass(BatchClass batchClass) {
		this.batchClass = batchClass;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
}
