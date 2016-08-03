/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import pk.torcia.spring.model.Session;

/**
 * @author inayat
 * 
 */
public interface SessionBO {

	public void save(Session section);

	public void upDate(Session section);

	public Session findById(int sectionId);

	public List<Session> findAll();

	public boolean removeById(int sectionId);

	public List<Session> findAllByType(String type);

	public List<Session> findByClassId(int classId);
}
