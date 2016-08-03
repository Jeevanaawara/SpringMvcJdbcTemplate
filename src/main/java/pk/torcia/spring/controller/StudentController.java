package pk.torcia.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pk.torcia.spring.bo.BatchClassBO;
import pk.torcia.spring.bo.FeesBO;
import pk.torcia.spring.bo.SessionBO;
import pk.torcia.spring.bo.ShiftBO;
import pk.torcia.spring.bo.StudentBO;
import pk.torcia.spring.config.ReportGenerator;
import pk.torcia.spring.model.BatchClass;
import pk.torcia.spring.model.Fees;
import pk.torcia.spring.model.Session;
import pk.torcia.spring.model.Student;
import pk.torcia.spring.utils.TorciaUtils;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentBO studentBO;
	@Autowired
	private BatchClassBO batchClassBO;
	@Autowired
	private ShiftBO shiftBO;
	@Autowired
	private SessionBO sectionBO;
	@Autowired
	private FeesBO feesBO;

	static Logger log = Logger.getLogger(StudentController.class.getName());

	/*
	 * Method Name Return Type
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/")
	public String studentHome(ModelMap model) throws IOException {
		log.info("Inside StudentController listStudent......");
		return "studentHome";
	}
	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/listStudent")
	public String listStudent(ModelMap model) throws IOException {
		log.info("Inside StudentController listStudent......");
		List<Student> listStudent = studentBO.findAll();
		model.addAttribute("listStudent", listStudent);
		return "studentHome";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/newEntryTest", method = RequestMethod.GET)
	public String newEntryTest(ModelMap model) {
		log.info("Inside StudentController newEntryTest......");
		Student newStudent = new Student();
		// newStudent.setStudentRollNo(studentService.maxRoleNo());
		model.addAttribute("student", newStudent);
		model.addAttribute("listBatchClass", batchClassBO.findAllByType("Entry Test"));
		model.addAttribute("listShift", shiftBO.findAll());
		return "studentEntryTest";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/newCoaching", method = RequestMethod.GET)
	public String newCoaching(ModelMap model) {
		log.info("Inside StudentController newCoaching......");
		Student newStudent = new Student();
		model.addAttribute("student", newStudent);
		model.addAttribute("listBatchClass", batchClassBO.findAllByType("Coaching"));
		model.addAttribute("listShift", shiftBO.findAll());
		return "studentCoaching";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(@Valid @ModelAttribute Student student, BindingResult result,
			@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		log.info("Inside StudentController saveStudent......");
		if (result.hasErrors()) {
			return "studentEntryTest";
		} else {
			String imageName = TorciaUtils.uploadFile(file, student.getStudentFirstName(),request);
			student.setImageName(imageName);
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			System.out.println("login user name is ---" + userName);
			student.setStudentCreatedby(userName);
			String reportName = studentBO.save(student);
			redirectAttributes.addFlashAttribute("reportName", reportName);
			redirectAttributes.addFlashAttribute("message", " Student Save Successfully");
			return "redirect:/student/";
		}
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/saveStudentCoaching", method = RequestMethod.POST)
	public String saveStudentCoaching(@Valid @ModelAttribute Student student, BindingResult result,
			@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
			HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		log.info("Inside StudentController saveStudentCoaching......");

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", result.getObjectName());
			return "studentCoaching";
		} else {
			String imageName =  TorciaUtils.uploadFile(file, student.getStudentFirstName(),request);
			student.setImageName(imageName);
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			System.out.println("login user name is ---" + userName);
			student.setStudentCreatedby(userName);
			String reportName = studentBO.save(student);
			redirectAttributes.addFlashAttribute("reportName", reportName);
			redirectAttributes.addFlashAttribute("message", " Student Save Successfully");
			return "redirect:/student/";
		}
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public String deleteStudent(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		log.info("Inside StudentController deleteStudent......");
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		studentBO.removeById(studentId);
		redirectAttributes.addFlashAttribute("message", " Student Delete Successfully");
		return "redirect:/searchStudentForm";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public String editStudent(HttpServletRequest request, ModelMap model) {
		log.info("Inside StudentController editStudent......");
		String formName = "";
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentBO.findById(studentId);

		model.addAttribute("listBatchClass", batchClassBO.findAll());
		model.addAttribute("listShift", shiftBO.findAll());
		model.addAttribute("listSection", sectionBO.findAll());
		model.addAttribute("student", student);
		System.out.println("edit name " + student.getStudentFirstName());
		if (student.getBatchClass().getClassType().equals("Coaching")) {
			formName = "studentCoaching";
		} else if (student.getBatchClass().getClassType().equals("Entry Test")) {
			formName = "studentEntryTest";
		}
		return formName;
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(ModelMap model) {
		log.info("Inside StudentController cancel......");
		return "redirect:/student/";
	}



	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/printReport", method = RequestMethod.GET)
	public String printReport(ModelMap model) {
		log.info("Inside StudentController printReport......");
		Student newStudent = new Student();
		model.addAttribute("student", newStudent);
		File f = new File(".." + File.separator + "resources/");
		System.out.println("------- " + f.getAbsolutePath());
		model.addAttribute("printReport");
		return "printReport";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	public String generateReport(@Valid @ModelAttribute Student student, BindingResult result,
			RedirectAttributes redirectAttributes, HttpServletResponse response, HttpServletRequest request) {
		log.info("Inside StudentController generateReport......");
		System.out.println("startDate--->>> > " + student.getDateCreated());
		System.out.println("endDate--->>> > " + student.getEnddateCreated());
		System.out.println("student class type--->>> > " + student.getBatchClass().getClassType());
		System.out.println("Report Generation startssssss");
		String reportName = ReportGenerator.generateReportDaily(student.getDateCreated(), student.getEnddateCreated(),
				student.getBatchClass().getClassType());
		System.out.println("Report Generation end");
		redirectAttributes.addFlashAttribute("message", " Report Print Successfully");
		TorciaUtils.setResponseHeaderTlocrtPDF(response, reportName);
		File f = new File(reportName);
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
		return "/printReport";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/searchStudent", method = RequestMethod.GET)
	public String searchStudent(ModelMap model) {
		log.info("Inside StudentController searchStudent......");
		Student newStudent = new Student();
		model.addAttribute("student", newStudent);
		model.addAttribute("listClass", batchClassBO.findAll());
		model.addAttribute("listSection", sectionBO.findAll());
		return "searchStudentForm";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/searchStudentList", method = RequestMethod.POST)
	public String searchStudentList(@ModelAttribute Student student, ModelMap model, BindingResult result) {
		log.info("Inside StudentController saveStudentCoaching......");
		model.addAttribute("listStudent", studentBO.findAll(student));
		model.addAttribute("listClass", batchClassBO.findAll());
		model.addAttribute("listSection", sectionBO.findAll());
		return "searchStudentForm";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public @ResponseBody Integer getTime(@RequestParam int classId, ModelMap model) {
		System.out.println("classID is ---- " + classId);

		int result = studentBO.maxRoleNo(classId);
		return result;
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/sessionFee", method = RequestMethod.GET)
	public @ResponseBody Session getsSssionFee(@RequestParam int sectionId, ModelMap model) {
		System.out.println("sectionId is ---- " + sectionId);
		Session sesionObje = sectionBO.findById(sectionId);
		// int result = sesionObje.getRegistrationFee();
		// int result = studentService.maxRoleNo(classId);
		return sesionObje;
	}


	 
	@RequestMapping(value = "/exportReport", method = RequestMethod.GET)
	public String exportTlocrt(Model model, HttpServletResponse response, HttpServletRequest request) {
		String reportName = request.getParameter("report");
		TorciaUtils.setResponseHeaderTlocrtPDF(response, reportName);
		File f = new File(reportName);
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
		return "/student/";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/studentTransferForm", method = RequestMethod.GET)
	public String studentTransferForm(HttpServletRequest request, Student student, ModelMap model) {
		log.info("Inside StudentController editStudent......");
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		student = studentBO.findById(studentId);
		model.addAttribute("listClass", batchClassBO.findAll());
		model.addAttribute("listSection", sectionBO.findAll());
		model.addAttribute("student", student);
		return "studentTransfer";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/studentTransfer", method = RequestMethod.POST)
	public String studentTransfer(HttpServletRequest request, Student student, ModelMap model,
			RedirectAttributes redirectAttributes) {
		log.info("Inside StudentController studentTransfer......");
		String reportName = studentBO.transferStudent(student);
		redirectAttributes.addFlashAttribute("reportName", reportName);
		redirectAttributes.addFlashAttribute("message", " Student Transfer Successfully");
		return "redirect:/student/";
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
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/listClassByClassCategory", method = RequestMethod.GET)
	public @ResponseBody List<BatchClass> listClassByClassCategory(@RequestParam int classCategory, ModelMap model) {
		System.out.println("classCategory is ---- " + classCategory);
		List<BatchClass> sesionObje = batchClassBO.findAllByCategory(classCategory);
		return sesionObje;
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/getTotalSeats", method = RequestMethod.GET)
	public @ResponseBody int getTotalSeats(@RequestParam int sectionId, ModelMap model) {
		System.out.println("sectionId is ---- " + sectionId);
		Session sesionObj = new Session();
		sesionObj = sectionBO.findById(sectionId);
		return sesionObj.getTotalSeats();
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/studentMonthlyFee", method = RequestMethod.GET)
	public String studentMonthlyFee(HttpServletRequest request, Fees fees, ModelMap model) {
		log.info("Inside StudentController studentMonthlyFee......");
		model.addAttribute("fees", fees);
		return "studentMonthlyFee";
	}

	/*
	 * Method Name Return Type
	 */
	@RequestMapping(value = "/saveStudentMonthlyFee", method = RequestMethod.POST)
	public String saveStudentMonthlyFee(HttpServletRequest request, Fees fees, ModelMap model,
			RedirectAttributes redirectAttributes) {
		log.info("Inside StudentController saveStudentMonthlyFee......");
		feesBO.saveMonthlyFee(fees);
		redirectAttributes.addFlashAttribute("message", " Student Monthly Fee Paid");
		return "redirect:/student/";
	}
}
