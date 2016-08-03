package pk.torcia.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pk.torcia.spring.bo.AdminBO;
import pk.torcia.spring.dao.UserRoleDAO;
import pk.torcia.spring.model.Admin;
import pk.torcia.spring.model.UserRole;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminBO adminBO;
	@Autowired
	private UserRoleDAO userRoleDAO;
	static Logger log = Logger.getLogger(AdminController.class.getName());

	/**
	 * Method newAdmin Return String
	 */
	@RequestMapping(value = "/newAdmin", method = RequestMethod.GET)
	public String newAdmin(ModelMap model) {
		log.info("Inside AdminController newAdmin......");
		Admin newAdmin = new Admin();
		List<Admin> listAdmin = adminBO.findAll();
		List<UserRole> listRole = userRoleDAO.findAll();
		model.addAttribute("admin", newAdmin);
		model.addAttribute("listRole", listRole);
		model.addAttribute("listAdmin", listAdmin);
		return "adminForm";
	}

	/**
	 * Method saveAdmin Return String
	 */
	@RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute Admin admin, ModelMap model, BindingResult result,
			RedirectAttributes redirectAttributes) {
		log.info("Inside AdminController saveAdmin......");
		if (result.hasErrors()) {
			return "adminForm";
		} else {
			adminBO.save(admin);
			List<Admin> listAdmin = adminBO.findAll();
			model.addAttribute("listAdmin", listAdmin);
			redirectAttributes.addFlashAttribute("message", " user Saved Successfully");
			return "/adminList";
		}
	}

	/**
	 * Method deleteAdmin Return String
	 */
	@RequestMapping(value = "/deleteAdmin", method = RequestMethod.GET)
	public String deleteAdmin(HttpServletRequest request, ModelMap model, RedirectAttributes redirectAttributes)throws JsonGenerationException, JsonMappingException, IOException {
		log.info("Inside AdminController deleteAdmin......");
		String adminId = request.getParameter("adminName");
		adminBO.removeById(adminId);
		List<Admin> listAdmin = adminBO.findAll();
		ObjectMapper mapper = new ObjectMapper();
		model.addAttribute("listAdmin", mapper.writeValueAsString(listAdmin));
		redirectAttributes.addFlashAttribute("message", " User has been Deleted");
		return "adminList";
	}

	/**
	 * Method editAdmin Return String
	 */
	@RequestMapping(value = "/editAdmin", method = RequestMethod.GET)
	public String editAdmin(HttpServletRequest request, ModelMap model) {
		log.info("Inside AdminController editAdmin......");
		String adminId = request.getParameter("adminName");
		List<UserRole> listRole = userRoleDAO.findAll();
		model.addAttribute("listRole", listRole);
		Admin admin = adminBO.findById(adminId);
		model.addAttribute("admin", admin);

		return "adminForm";
	}

	/**
	 * Method cancel Return String
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(ModelMap model)throws JsonGenerationException, JsonMappingException, IOException {
		log.info("Inside AdminController cancel......");
		List<Admin> listAdmin = adminBO.findAll();
		ObjectMapper mapper = new ObjectMapper();
		model.addAttribute("listAdmin", mapper.writeValueAsString(listAdmin));
		return "adminList";
	}

	/**
	 * Method listAdmin Return String
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listAdmin(ModelMap model, RedirectAttributes redirectAttributes) throws JsonGenerationException, JsonMappingException, IOException {
		log.info("Inside AdminController  listAdmin......");
		List<Admin> listAdmin = adminBO.findAll();
		if(listAdmin.size() == 0){
			redirectAttributes.addFlashAttribute("message", " Record not Found");
		}
		ObjectMapper mapper = new ObjectMapper();
		model.addAttribute("listAdmin", mapper.writeValueAsString(listAdmin));
		return "adminList";
	}
	

}