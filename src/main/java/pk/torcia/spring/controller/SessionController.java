package pk.torcia.spring.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pk.torcia.spring.bo.BatchClassBO;
import pk.torcia.spring.bo.SessionBO;
import pk.torcia.spring.model.BatchClass;
import pk.torcia.spring.model.Session;

@Controller
@RequestMapping("/sessionHome")
public class SessionController {

	@Autowired
	private SessionBO sectionBO;
	@Autowired
	private BatchClassBO batchClassBO;
	static Logger log = Logger.getLogger(SessionController.class.getName());

	/*
	 * Method initBinder Return void
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/*
	 * Method listSection Return String
	 */
	@RequestMapping(value = "/")
	public String listSection(ModelMap model) throws IOException {
		log.info("Inside SessionController listSection......");
//		ObjectMapper mapper = new ObjectMapper();
		List<Session> listSection = sectionBO.findAll();
		model.addAttribute("listSection",listSection);
		return "/sessionHome";
	}

	/*
	 * Method newSession Return String
	 */
	@RequestMapping(value = "/newSection", method = RequestMethod.GET)
	public String newSession(ModelMap model) {
		log.info("Inside SessionController newSession......");
		Session newSection = new Session();
		List<BatchClass> list = batchClassBO.findAll();
		model.addAttribute("session", newSection);
		model.addAttribute("listBatchClass", list);
		return "/sessionForm";
	}

	/*
	 * Method saveSection Return String
	 */
	@RequestMapping(value = "/saveSection", method = RequestMethod.POST)
	public String saveSection(@Valid @ModelAttribute Session session, BindingResult result,
			RedirectAttributes redirectAttributes) {
		log.info("Inside SessionController saveSection......");
		if (result.hasErrors()) {
			log.info("Inside SessionController saveSection  error......" + result.toString());
			return "/sessionForm";
		} else {
			log.info("Inside SessionController saveSection save......");
			sectionBO.save(session);
			redirectAttributes.addFlashAttribute("message", " Session Save Successfully");
			return "redirect:/sessionHome/";
		}
	}

	/*
	 * Method deleteSection Return String
	 */
	@RequestMapping(value = "/deleteSection", method = RequestMethod.GET)
	public String deleteSection(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		log.info("Inside SessionController deleteSection......");
		int sectionId = Integer.parseInt(request.getParameter("sectionId"));
		sectionBO.removeById(sectionId);
		redirectAttributes.addFlashAttribute("message", " Session Delete Successfully");
		return "redirect:/sessionHome/";
	}

	/*
	 * Method editSection Return String
	 */
	@RequestMapping(value = "/editSection", method = RequestMethod.GET)
	public String editSection(HttpServletRequest request, ModelMap model) {
		log.info("Inside SessionController editSection......");
		int sectionId = Integer.parseInt(request.getParameter("sectionId"));
		Session session = sectionBO.findById(sectionId);
		model.addAttribute("session", session);
		List<BatchClass> list = batchClassBO.findAll();
		model.addAttribute("listBatchClass", list);
		return "/sessionForm";
	}

	/*
	 * Method cancel Return String
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(ModelMap model) {
		log.info("Inside SessionController cancel......");
		return "redirect:/sessionHome/";
	}

	/*
	 * Method selectSessionByClass Return List<BatchClass>
	 */
	@RequestMapping(value = "/listClassByClassType", method = RequestMethod.GET)
	public @ResponseBody List<BatchClass> selectSessionByClass(@RequestParam String classType, ModelMap model) {
		System.out.println("classType is ---- " + classType);
		List<BatchClass> sesionObje = batchClassBO.findAllByType(classType);
		return sesionObje;
	}
}
