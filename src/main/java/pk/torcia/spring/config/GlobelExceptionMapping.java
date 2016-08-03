/**
 * 
 */
package pk.torcia.spring.config;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author inayat
 *
 */
//@ControllerAdvice
public class GlobelExceptionMapping {
	static Logger log = Logger.getLogger(GlobelExceptionMapping.class.getName());
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		log.info(e.toString());
		return "torciaException";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String logOut(){
		return "redirect:/";
	}
}
