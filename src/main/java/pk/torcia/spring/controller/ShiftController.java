package pk.torcia.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pk.torcia.spring.bo.ShiftBO;
import pk.torcia.spring.model.Shift;

@Controller
@RequestMapping("/shift")
public class ShiftController {

	@Autowired
	private ShiftBO shiftBO;
	static Logger log = Logger.getLogger(ShiftController.class.getName());
	
	/*
	 * Method Name listShift Return list of Shift(s)
	 */
	@RequestMapping(value = "/")
	public String listShift(ModelMap model) throws IOException {
		log.info("Inside ShiftController listShift......");
		ObjectMapper mapper = new ObjectMapper();
		List<Shift> listShift = shiftBO.findAll();
		model.addAttribute("listShift", mapper.writeValueAsString(listShift));
		return "/shiftHome";
	}

	/*
	 * Method Name newShift Return Type String
	 */
	@RequestMapping(value = "/newShift", method = RequestMethod.GET)
	public String newShift(ModelMap model) {
		log.info("Inside ShiftController newShift......");
		Shift newShift = new Shift();
		model.addAttribute("shift", newShift);
		return "/shiftForm";
	}

	/*
	 * Method Name saveShift Return Type String
	 */
	@RequestMapping(value = "/saveShift", method = RequestMethod.POST)
	public String saveShift(@Valid @ModelAttribute Shift shift, BindingResult result,
			RedirectAttributes redirectAttributes) {
		log.info("Inside ShiftController saveShift......");
		if (result.hasErrors()) {
			return "/shift/shiftForm";
		} else {
			shiftBO.save(shift);
			redirectAttributes.addFlashAttribute("message", " Shift Save Successfully");
			return "redirect:/shift/";
		}
	}

	/*
	 * Method Name deleteShift Return Type String
	 */
	@RequestMapping(value = "/deleteShift", method = RequestMethod.GET)
	public String deleteShift(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		log.info("Inside ShiftController deleteShift......");
		int shiftId = Integer.parseInt(request.getParameter("shiftId"));
		shiftBO.removeById(shiftId);
		redirectAttributes.addFlashAttribute("message", " Shift Delete Successfully");
		return "redirect:/shift/";
	}

	/*
	 * Method Name editShift Return Type String
	 */
	@RequestMapping(value = "/editShift", method = RequestMethod.GET)
	public String editShift(HttpServletRequest request, ModelMap model) {
		log.info("Inside ShiftController editShift......");
		int shiftId = Integer.parseInt(request.getParameter("shiftId"));
		Shift shift = shiftBO.findById(shiftId);

		model.addAttribute("shift", shift);

		return "/shiftForm";
	}

	/*
	 * Method Name cancel Return Type String
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(ModelMap model) {
		log.info("Inside ShiftController cancel......");
		return "redirect:/shift/";
	}
}
