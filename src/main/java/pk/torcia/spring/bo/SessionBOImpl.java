/**
 * 
 */
package pk.torcia.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pk.torcia.spring.dao.SessionDAO;
import pk.torcia.spring.model.Session;

/**
 * @author inayat
 *
 */
@Component
public class SessionBOImpl implements SessionBO {

	@Autowired
	private SessionDAO sectionDAO;

	public void save(Session section) {
		sectionDAO.save(section);

	}

	public void upDate(Session section) {
		sectionDAO.upDate(section);

	}

	public Session findById(int sectionId) {

		return sectionDAO.findById(sectionId);
	}

	public List<Session> findAll() {

		return sectionDAO.findAll();
	}

	public boolean removeById(int sectionId) {

		return sectionDAO.removeById(sectionId);
	}

	@Override
	public List<Session> findAllByType(String type) {

		return sectionDAO.findAllByType(type);
	}

	@Override
	public List<Session> findByClassId(int classId) {

		return sectionDAO.findByClassId(classId);
	}
}
