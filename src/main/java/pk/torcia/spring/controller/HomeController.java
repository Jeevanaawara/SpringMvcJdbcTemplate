package pk.torcia.spring.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pk.torcia.spring.bo.AdminBO;
import pk.torcia.spring.model.Admin;
import pk.torcia.spring.model.Student;

/**
 * @author Inayat Ali
 *
 */

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	private AdminBO adminBO;

	static Logger log = Logger.getLogger(StudentController.class.getName());

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		System.out.println(" home page--------->>>>>  ");

		return "/login";
	}

	@RequestMapping(value = "/stHome", method = RequestMethod.GET)
	public String studentHomePage(ModelMap model) {
		System.out.println("---adminpage------>>>>>  ");
		model.addAttribute("user", getPrincipal());
		return "/home";
	}

	@RequestMapping(value = "/infoStudent", method = RequestMethod.GET)
	public String infoStudent(ModelMap model) {
		System.out.println("---infoStudent------>>>>>  ");
		model.addAttribute("user", getPrincipal());
		return "redirect:/student/";
	}

	@RequestMapping(value = "/sessionHome", method = RequestMethod.GET)
	public String reDirectSession(ModelMap model) {
		log.info("Inside StudentController reDirectSession......");
		model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getName());
		return "redirect:/sessionHome/";
	}

	@RequestMapping(value = "/studentOtherInfo", method = RequestMethod.GET)
	public String searchStudentDetail(ModelMap model) {
		System.out.println("-searchStudentDetail------->>>>>  ");
		model.addAttribute("student", new Student());
		model.addAttribute("user", getPrincipal());
		return "redirect:/studentOtherInfo/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		System.out.println("-login------->>>>>  ");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		System.out.println("--------->>>>>  " + userName);
		return userName;
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/reDirectShift", method = RequestMethod.GET)
	public String reDirectShift(ModelMap model) {
		log.info("Inside StudentController reDirectShift......");
		model.addAttribute("user", getPrincipal());
		return "redirect:/shift/";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/reDirectClass", method = RequestMethod.GET)
	public String reDirectClass(ModelMap model) {
		log.info("Inside StudentController reDirectClass......");
		model.addAttribute("user", getPrincipal());
		return "redirect:/batchClass/";
	}

	@RequestMapping(value = "/reDirectAdmin", method = RequestMethod.GET)
	public String reDirectAdmin(ModelMap model) {
		log.info("Inside StudentController reDirectClass......");
		model.addAttribute("user", getPrincipal());
		return "redirect:/admin/";
	}

	/*
	 * Method reDirectStudent Return String
	 */
	@RequestMapping(value = "/reDirectStudent", method = RequestMethod.GET)
	public String reDirectStudent(ModelMap model) {
		log.info("Inside SessionController reDirectStudent......");
		model.addAttribute("user", getPrincipal());
		return "redirect:/student/";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		System.out.println("-accessdenied-------->>>>>  ");
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String forgetPassword(ModelMap model, Admin admin) {
		System.out.println("-forgetPassword-------->>>>>  ");
		model.addAttribute("admin", new Admin() );
		return "forgetPasswordForm";
	}

	/**
	 * Method saveAdmin Return String
	 */
	@RequestMapping(value = "/saveforgetPassword", method = RequestMethod.POST)
	public String saveforgetPassword(@Valid @ModelAttribute Admin admin, ModelMap model, BindingResult result,
			RedirectAttributes redirectAttributes) {
		log.info("Inside AdminController saveforgetPassword......"+admin.getAdminName());
		
			Admin newAdmin = adminBO.findById(admin.getAdminName());
			if(newAdmin != null){
			System.out.println(newAdmin.getAdminName());
			adminBO.upDate(admin);
			redirectAttributes.addFlashAttribute("message", " Password Changed Successfully");
			return "/login";
		}else{
			redirectAttributes.addFlashAttribute("message", " User name not Found");
			return "redirect:/login";	
		}
	}
	/**
	 * Method cancel Return String
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(ModelMap model)throws JsonGenerationException, JsonMappingException, IOException {
		log.info("Inside AdminController cancel......");
		return "login";
	}

}
