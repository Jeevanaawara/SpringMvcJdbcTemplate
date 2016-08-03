package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.FeesDAO;
import pk.torcia.spring.model.Admin;
import pk.torcia.spring.model.Fees;

/**
 * @author inayat
 *
 */
@Component
public class FeesBOImpl implements FeesBO {

	@Autowired
	private FeesDAO feesDAO;

	@Override
	public void save(Fees fees) {

	}

	@Override
	public void upDate(Fees fees) {

	}

	@Override
	public Admin findById(int feesId) {
		return null;
	}

	@Override
	public List<Admin> findAll() {
		return null;
	}

	@Override
	public boolean removeById(int feesId) {
		return false;
	}

	@Override
	public void saveMonthlyFee(Fees fees) {
		feesDAO.saveMonthlyFee(fees);

	}

}
