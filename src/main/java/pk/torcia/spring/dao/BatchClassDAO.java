/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.BatchClass;

/**
 * @author inayat
 *
 */
public interface BatchClassDAO {

	public void save(BatchClass batchClass);

	public void upDate(BatchClass batchClass);

	public BatchClass findById(int batchClassId);

	public List<BatchClass> findAll();

	public List<BatchClass> findAllByType(String type);

	public boolean removeById(int batchClassId);

	public List<BatchClass> findAllByCategory(int groupId);
}
