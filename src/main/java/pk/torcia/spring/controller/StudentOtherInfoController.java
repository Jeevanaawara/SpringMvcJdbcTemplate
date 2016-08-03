/**
 * 
 */
package pk.torcia.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import pk.torcia.spring.bo.StudentBO;
import pk.torcia.spring.bo.StudentOtherInfoBO;
import pk.torcia.spring.bo.StudentProgressReportBO;
import pk.torcia.spring.config.ReportGenerator;
import pk.torcia.spring.model.Session;
import pk.torcia.spring.model.Student;
import pk.torcia.spring.model.StudentOtherInfo;
import pk.torcia.spring.model.StudentProgressReport;

/**
 * @author inayat
 *
 */
@Controller
@RequestMapping("/studentOtherInfo")
public class StudentOtherInfoController {

	@Autowired
	private StudentOtherInfoBO studentOtherInfoBO;
	@Autowired
	private BatchClassBO batchClassBO;
	@Autowired
	private SessionBO sectionBO;
	@Autowired
	private StudentBO studentService;
	@Autowired
	private StudentProgressReportBO studentProgressReportBO;

	static Logger log = Logger.getLogger(StudentOtherInfoController.class.getName());

	/*
	 * Method Name initBinder Return Type void
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/*
	 * Method Name listlistStudentOtherInfo Return Type String
	 */
	@RequestMapping(value = "/")
	public String listlistStudentOtherInfo(ModelMap model) throws IOException {
		log.info("Inside StudentOtherInfoController listlistStudentOtherInfo......");
		model.addAttribute("listBatchClass", batchClassBO.findAll());
		model.addAttribute("listSection", sectionBO.findAll());
		Student student = new Student();
		model.addAttribute("student", student);
		return "/searchStudentDetail";
	}

	/*
	 * Method Name searchStudentList Return Type String
	 */
	@RequestMapping(value = "/searchStudentDetailList", method = RequestMethod.POST)
	public String searchStudentList(@ModelAttribute Student student, ModelMap model, BindingResult result) {
		log.info("Inside StudentController saveStudentCoaching......");
		model.addAttribute("listStudent", studentService.findAll(student));
		model.addAttribute("listBatchClass", batchClassBO.findAll());
		model.addAttribute("listSection", sectionBO.findAll());
		return "searchStudentDetail";
	}

	/*
	 * Method Name newStudentOtherInfo Return Type String
	 */
	@RequestMapping(value = "/newStudentOtherInfo", method = RequestMethod.GET)
	public String newStudentOtherInfo(ModelMap model) {
		log.info("Inside StudentOtherInfoController newStudentOtherInfo......");
		StudentOtherInfo studentOtherInfo = new StudentOtherInfo();
		model.addAttribute("studentOtherInfo", studentOtherInfo);
		return "/studentOtherInfo";
	}

	/*
	 * Method Name saveStudentOtherInfo Return Type String
	 */
	@RequestMapping(value = "/saveStudentOtherInfo", method = RequestMethod.POST)
	public String saveStudentOtherInfo(@Valid @ModelAttribute StudentOtherInfo studentOtherInfo, BindingResult result,
			RedirectAttributes redirectAttributes, ModelMap model) {
		log.info("Inside StudentOtherInfoController saveStudentOtherInfos......");
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "/studentOtherInfo";
		} else {

			studentOtherInfoBO.save(studentOtherInfo);
			model.addAttribute("student", new Student());
			redirectAttributes.addFlashAttribute("message", " StudentOtherInfo Save Successfully");
			return "searchStudentDetail";
		}
	}

	/*
	 * Method Name deleteStudentOtherInfo Return Type String
	 */
	@RequestMapping(value = "/deleteStudentOtherInfo", method = RequestMethod.GET)
	public String deleteStudentOtherInfo(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		log.info("Inside StudentOtherInfoController deleteStudentOtherInfo......");
		int studentInfoId = Integer.parseInt(request.getParameter("studentInfoId"));
		studentOtherInfoBO.removeById(studentInfoId);
		redirectAttributes.addFlashAttribute("message", " StudentOtherInfo Delete Successfully");
		return "redirect:/batchClass/";
	}

	/*
	 * Method Name addStudentOtherInfo Return Type String
	 */
	@RequestMapping(value = "/addStudentOtherInfo", method = RequestMethod.GET)
	public String addStudentOtherInfo(HttpServletRequest request, ModelMap model, StudentOtherInfo studentOtherInfo) {
		log.info("Inside StudentOtherInfoController addStudentOtherInfo......");
		// int studentInfoId =
		// Integer.parseInt(request.getParameter("studentInfoId"));
		// StudentOtherInfo studentOtherInfo =
		// studentOtherInfoBO.findById(studentInfoId);
		// StudentOtherInfo studentOtherInfo =new StudentOtherInfo();
		model.addAttribute("listBatchClass", batchClassBO.findAll());
		model.addAttribute("studentOtherInfo", studentOtherInfo);

		return "/studentOtherInfo";
	}

	/*
	 * Method Name addProgressReport Return Type String
	 */
	@RequestMapping(value = "/addProgressReport", method = RequestMethod.GET)
	public String addProgressReport(HttpServletRequest request, ModelMap model,
			StudentProgressReport studentProgressReport) {
		log.info("Inside StudentOtherInfoController addProgressReport......");
		model.addAttribute("studentProgressReport", studentProgressReport);

		return "/studentProgressReport";
	}

	/*
	 * Method Name cancel Return Type String
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(ModelMap model) {
		log.info("Inside StudentOtherInfoController cancel......");
		return "redirect:/studentOtherInfo/";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/selectSessionByClass", method = RequestMethod.GET)
	public @ResponseBody List<Session> selectSessionByClass(@RequestParam int classId, ModelMap model) {
		System.out.println("classId is ---- " + classId);
		List<Session> sesionObje = sectionBO.findByClassId(classId);
		return sesionObje;
	}

	/*
	 * Method Name saveStudentProgressReport Return Type String
	 */
	@RequestMapping(value = "/saveStudentProgressReport", method = RequestMethod.POST)
	public String saveStudentProgressReport(@Valid @ModelAttribute StudentProgressReport studentProgressReport,
			BindingResult result, RedirectAttributes redirectAttributes, ModelMap model) {
		log.info("Inside StudentOtherInfoController saveStudentProgressReport......");
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "/studentProgressReport";
		} else {
			studentProgressReportBO.save(studentProgressReport);
			model.addAttribute("studentProgressReport", new StudentProgressReport());
			redirectAttributes.addFlashAttribute("message", " StudentProgress Report Save Successfully");
			return "studentProgressReport";
		}
	}

	@RequestMapping(value = "/viewStudentOtherInfo", method = RequestMethod.GET)
	public String viewStudentOtherInfo(HttpServletRequest request, ModelMap model,
			RedirectAttributes redirectAttributes) {
		log.info("Inside StudentOtherInfoController viewStudentOtherInfo......");
		int studentId = Integer.parseInt(request.getParameter("studentId"));

		log.info("student id " + studentId);
		StudentOtherInfo studentOtherInfo = studentOtherInfoBO.findById(studentId);
		if (studentOtherInfo != null) {
			model.addAttribute("studentOtherInfo", studentOtherInfo);
			return "studentOtherInfoView";
		} else {
			redirectAttributes.addFlashAttribute("message", " Student Detail Does not Exist");
			return "redirect:/studentOtherInfo/";
		}

	}

	@RequestMapping(value = "/printProgressReport", method = RequestMethod.GET)
	public String printProgressReport(ModelMap model, RedirectAttributes redirectAttributes,
			HttpServletResponse response, HttpServletRequest request) {
		log.info("Inside StudentOtherInfoController printProgressReport......");
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String reportName = ReportGenerator.generateProgressReport(studentId);
		File f = new File(reportName);
		setResponseHeaderTlocrtPDF(response, reportName);
		try {
			OutputStream os = response.getOutputStream();
			byte[] buf = new byte[8192];
			InputStream is = new FileInputStream(f);
			int c = 0;
			while ((c = is.read(buf, 0, buf.length)) > 0) {
				os.write(buf, 0, c);
				os.flush();
			}
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/searchStudentDetail";
	}
	/*
	 * Method Name Return Type
	 */
	private void setResponseHeaderTlocrtPDF(HttpServletResponse response, String reportName) {
		response.setContentType("application/pdf");
		response.setHeader("content-disposition", "attachment; filename=progressReport.pdf");
	}
}
