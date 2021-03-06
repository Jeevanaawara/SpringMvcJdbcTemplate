/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import pk.torcia.spring.model.Shift;

/**
 * @author inayat
 * 
 */
public interface ShiftBO {

	public void save(Shift shift);

	public void upDate(Shift shift);

	public Shift findById(int shiftId);

	public List<Shift> findAll();

	public boolean removeById(int shiftId);

}
