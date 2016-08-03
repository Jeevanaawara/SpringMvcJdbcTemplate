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
public class ClassCategory {

	private int classCateogryid;
	@NotNull
	@Size(min = 3,max=20)
	private String classCategoryName;
	private Date classCategorydate;
	
	public ClassCategory(){
		
	}
	
	
	public int getClassCateogryid() {
		return classCateogryid;
	}
	public void setClassCateogryid(int classCateogryid) {
		this.classCateogryid = classCateogryid;
	}
	public String getClassCategoryName() {
		return classCategoryName;
	}
	public void setClassCategoryName(String classCategoryName) {
		this.classCategoryName = classCategoryName;
	}
	public Date getClassCategorydate() {
		return classCategorydate;
	}
	public void setClassCategorydate(Date classCategorydate) {
		this.classCategorydate = classCategorydate;
	}
	
	
}
