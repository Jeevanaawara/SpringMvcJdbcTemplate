/**
 * 
 */
package pk.torcia.spring.dao;

import java.util.List;

import pk.torcia.spring.model.Session;

/**
 * @author inayat
 * 
 */
public interface SessionDAO {

	public void save(Session section);

	public void upDate(Session section);

	public Session findById(int sectionId);

	public List<Session> findByClassId(int classId);

	public List<Session> findAll();

	public boolean removeById(int sectionId);

	public List<Session> findAllByType(String type);

}
