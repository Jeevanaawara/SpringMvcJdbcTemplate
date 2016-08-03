package pk.torcia.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pk.torcia.spring.dao.ContactDAO;
import pk.torcia.spring.model.Contact;

//@Controller
@RequestMapping("/feesController")
public class FeesController {

	@Autowired
	private ContactDAO contactDAO;
	static Logger log = Logger.getLogger(FeesController.class.getName());

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		log.info("Inside FeesController listContact......");
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		model.setViewName("home");

		return model;
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		log.info("Inside FeesController newContact......");
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("ContactForm");
		return model;
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@Valid @ModelAttribute Contact contact, BindingResult result) {
		log.info("Inside FeesController saveContact......");
		if (result.hasErrors()) {
			return new ModelAndView("ContactForm");
		} else {
			contactDAO.saveOrUpdate(contact);
			return new ModelAndView("redirect:/");
		}
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		log.info("Inside FeesController deleteContact......");
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/");
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		log.info("Inside FeesController editContact......");
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(contactId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);

		return model;
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ModelAndView cancel(ModelAndView model) {
		log.info("Inside FeesController cancel......");
		return new ModelAndView("redirect:/");
	}
}
