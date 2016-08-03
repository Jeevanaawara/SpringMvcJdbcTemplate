/**
 * 
 */
package pk.torcia.spring.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author inayat
 *
 */
public class StudentProgressReport {

	private int stdntProgressRptId;
	@NotNull
	@Size(min = 3,max=20)
	private String testName;
	private String obtainedMarks;
	private String totalMarks;
	private int studentId;
	private int subjectId;
	private Date createDate;
	
	public StudentProgressReport(){
		
	}
	public int getStdntProgressRptId() {
		return stdntProgressRptId;
	}
	public void setStdntProgressRptId(int stdntProgressRptId) {
		this.stdntProgressRptId = stdntProgressRptId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(String obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public String getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
