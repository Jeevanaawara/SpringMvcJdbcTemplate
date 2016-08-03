/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import pk.torcia.spring.model.ClassCategory;

/**
 * @author inayat
 *
 */
public interface ClassCategoryBO {

	public void save(ClassCategory classCategory);

	public void upDate(ClassCategory classCategory);

	public ClassCategory findById(int classCategoryId);

	public List<ClassCategory> findAll();

	public boolean removeById(int classCategoryId);
}
