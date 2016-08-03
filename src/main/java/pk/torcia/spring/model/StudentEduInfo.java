package pk.torcia.spring.model;

import java.sql.Date;

public class StudentEduInfo {

	private int stEduinfoId;
	private int studentId;
	private String instituteName;
	private int classId;
	private String passyear;
	private String eduBorad;
	private String eduRollNo;
	private String totalMarks;
	private String obtainedmarks;
	private Date studentEduInfoDate;
	
	public StudentEduInfo (){
		
	}
	public int getStEduinfoId() {
		return stEduinfoId;
	}
	public void setStEduinfoId(int stEduinfoId) {
		this.stEduinfoId = stEduinfoId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getPassyear() {
		return passyear;
	}
	public void setPassyear(String passyear) {
		this.passyear = passyear;
	}
	public String getEduBorad() {
		return eduBorad;
	}
	public void setEduBorad(String eduBorad) {
		this.eduBorad = eduBorad;
	}
	public String getEduRollNo() {
		return eduRollNo;
	}
	public void setEduRollNo(String eduRollNo) {
		this.eduRollNo = eduRollNo;
	}
	public String getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getObtainedmarks() {
		return obtainedmarks;
	}
	public void setObtainedmarks(String obtainedmarks) {
		this.obtainedmarks = obtainedmarks;
	}
	public Date getStudentEduInfoDate() {
		return studentEduInfoDate;
	}
	public void setStudentEduInfoDate(Date studentEduInfoDate) {
		this.studentEduInfoDate = studentEduInfoDate;
	}
	
	
	
}
