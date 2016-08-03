/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import pk.torcia.spring.model.Admin;
import pk.torcia.spring.model.Fees;

/**
 * @author inayat
 *
 */
public interface FeesBO {

	public void save(Fees fees );
	public void saveMonthlyFee(Fees fees );
	public void upDate(Fees fees );
	public Admin findById(int feesId);
	public List<Admin> findAll();
	public boolean removeById(int feesId );

}
