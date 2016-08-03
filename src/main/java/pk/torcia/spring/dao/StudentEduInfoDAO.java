package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.StudentEduInfo;

public interface StudentEduInfoDAO {

	void save(StudentEduInfo studentEduInfo);

	void upDate(StudentEduInfo studentEduInfo);

	StudentEduInfo findById(int studentEduInfoId);

	List<StudentEduInfo> findAll();

	boolean removeById(int studentEduInfoId);

}