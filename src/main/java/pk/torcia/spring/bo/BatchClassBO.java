/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import pk.torcia.spring.model.BatchClass;

/**
 * @author inayat
 *
 */
public interface BatchClassBO {
	
	public void save(BatchClass batchClass );
	public void upDate(BatchClass batchClass );
	public BatchClass findById(int batchClassId);
	public List<BatchClass> findAll();
	public boolean removeById(int batchClassId );
	public List<BatchClass> findAllByType(String type);
	public List<BatchClass> findAllByCategory(int groupId);
}
