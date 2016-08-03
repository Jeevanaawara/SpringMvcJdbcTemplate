/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.BatchClassDAO;
import pk.torcia.spring.model.BatchClass;

/**
 * @author inayat
 *
 */
@Component
public class BatchClassBOImpl implements BatchClassBO {

	@Autowired
	private BatchClassDAO batchClassDAO;
	
	public void save(BatchClass batchClass) {
		batchClassDAO.save(batchClass);
		
	}

	public void upDate(BatchClass batchClass) {
		batchClassDAO.upDate(batchClass);
	}

	public BatchClass findById(int batchClassId) {

		return 	batchClassDAO.findById(batchClassId);
	}

	public List<BatchClass> findAll() {
		
		return 	batchClassDAO.findAll()	;
	}

	public boolean removeById(int batchClassId) {
		return batchClassDAO.removeById(batchClassId);
	}

	@Override
	public List<BatchClass> findAllByType(String type) {
		return 	batchClassDAO.findAllByType(type);
	}

	@Override
	public List<BatchClass> findAllByCategory(int groupId) {
		// TODO Auto-generated method stub
		return batchClassDAO.findAllByCategory(groupId);
	}

}
