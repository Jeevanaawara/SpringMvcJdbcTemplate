/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.ClassCategoryDAO;
import pk.torcia.spring.model.ClassCategory;

/**
 * @author inayat
 *
 */
@Component
public class ClassCategoryBOImpl implements ClassCategoryBO {

	@Autowired
	ClassCategoryDAO classCategoryDAO;

	@Override
	public void save(ClassCategory classCategory) {
		classCategoryDAO.save(classCategory);

	}

	@Override
	public void upDate(ClassCategory classCategory) {
		classCategoryDAO.upDate(classCategory);

	}

	@Override
	public ClassCategory findById(int classCategoryId) {

		return classCategoryDAO.findById(classCategoryId);
	}

	@Override
	public List<ClassCategory> findAll() {

		return classCategoryDAO.findAll();
	}

	@Override
	public boolean removeById(int classCategoryId) {

		return classCategoryDAO.removeById(classCategoryId);
	}

}
