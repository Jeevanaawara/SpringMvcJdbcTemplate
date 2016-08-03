/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.ShiftDAO;
import pk.torcia.spring.model.Shift;

/**
 * @author inayat
 *
 */
@Component
public class ShiftBOImpl implements ShiftBO {

	@Autowired
	private ShiftDAO shiftDAO;

	public void save(Shift shift) {
		shiftDAO.save(shift);

	}

	public void upDate(Shift shift) {
		shiftDAO.upDate(shift);

	}

	public Shift findById(int shiftId) {
		// TODO Auto-generated method stub
		return shiftDAO.findById(shiftId);
	}

	public List<Shift> findAll() {
		// TODO Auto-generated method stub
		return shiftDAO.findAll();
	}

	public boolean removeById(int shiftId) {
		// TODO Auto-generated method stub
		return shiftDAO.removeById(shiftId);
	}

}
