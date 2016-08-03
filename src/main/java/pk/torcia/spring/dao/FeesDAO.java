/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.Fees;
import pk.torcia.spring.model.Student;

/**
 * @author inayat
 *
 */
public interface FeesDAO {

	public void save(Fees fees);

	public void saveMonthlyFee(Fees fees);

	public void upDate(Fees fees);

	public Student findById(int feesId);

	public List<Fees> findAll();

	public boolean removeById(int feesId);
}
