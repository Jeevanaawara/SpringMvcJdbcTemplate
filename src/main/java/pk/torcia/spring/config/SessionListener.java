/**
 * 
 */
package pk.torcia.spring.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author inayat
 *
 */
public class SessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent event) {
	System.out.println("==== Session is created ====");
	event.getSession().setMaxInactiveInterval(5*60);
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
	System.out.println("==== Session is destroyed ====");
	}

}
