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

import pk.torcia.spring.bo.BatchClassBO;
import pk.torcia.spring.bo.ClassCategoryBO;
import pk.torcia.spring.model.BatchClass;
import pk.torcia.spring.model.ClassCategory;

@Controller
@RequestMapping("/batchClass")
public class BatchClassController {

	@Autowired
	private BatchClassBO batchClassBO;
	@Autowired
	ClassCategoryBO classCategoryBO;
	static Logger log = Logger.getLogger(BatchClassController.class.getName());

	/**
	 * Method listBatchClass Return String
	 */
	@RequestMapping(value = "/")
	public String listBatchClass(ModelMap model) throws IOException {
		log.info("Inside BatchClassController listBatchClass......");
		ObjectMapper mapper = new ObjectMapper();
		List<BatchClass> listBatchClass = batchClassBO.findAll();
		model.addAttribute("listBatchClass", mapper.writeValueAsString(listBatchClass));

		return "/batchHome";
	}

	/**
	 * Method newBatchClass Return String
	 */
	@RequestMapping(value = "/newBatchClass", method = RequestMethod.GET)
	public String newBatchClass(ModelMap model) {
		log.info("Inside BatchClassController newBatchClass......");
		BatchClass batchClass = new BatchClass();
		model.addAttribute("batchClass", batchClass);
		List<ClassCategory> listClassCategory = classCategoryBO.findAll();
		model.addAttribute("listClassCategory", listClassCategory);
		return "/batchForm";
	}

	/**
	 * Method saveBatchClass Return String
	 */
	@RequestMapping(value = "/saveBatchClass", method = RequestMethod.POST)
	public String saveBatchClass(@Valid @ModelAttribute BatchClass batchClass, BindingResult result,
			RedirectAttributes redirectAttributes) {
		log.info("Inside BatchClassController saveBatchClass......");
		if (result.hasErrors()) {
			return "/batchForm";
		} else {
			batchClassBO.save(batchClass);
			redirectAttributes.addFlashAttribute("message", " Class Save Successfully");
			return "redirect:/batchClass/";
		}
	}

	/**
	 * Method deleteBatchClass Return String
	 */
	@RequestMapping(value = "/deleteBatchClass", method = RequestMethod.GET)
	public String deleteBatchClass(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		log.info("Inside BatchClassController deleteBatchClass......");
		int batchClassId = Integer.parseInt(request.getParameter("classId"));
		batchClassBO.removeById(batchClassId);
		redirectAttributes.addFlashAttribute("message", " Class Delete Successfully");
		return "redirect:/batchClass/";
	}

	/**
	 * Method editBatchClass Return String
	 */
	@RequestMapping(value = "/editBatchClass", method = RequestMethod.GET)
	public String editBatchClass(HttpServletRequest request, ModelMap model) {
		log.info("Inside BatchClassController editBatchClass......");
		int batchClassId = Integer.parseInt(request.getParameter("classId"));
		BatchClass batchClass = batchClassBO.findById(batchClassId);
		List<ClassCategory> listClassCategory = classCategoryBO.findAll();
		model.addAttribute("listClassCategory", listClassCategory);
		model.addAttribute("batchClass", batchClass);

		return "/batchForm";
	}

	/**
	 * Method cancel Return String
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(ModelMap model) {
		log.info("Inside BatchClassController cancel......");
		return "redirect:/batchClass/";
	}
}
