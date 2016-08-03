package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.ClassCategory;

public interface ClassCategoryDAO {

	public void save(ClassCategory classCategory);

	public void upDate(ClassCategory classCategory);

	public ClassCategory findById(int classCategoryId);

	public List<ClassCategory> findAll();

	public boolean removeById(int classCategoryId);

}
