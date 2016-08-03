/**
 * 
 */
package pk.torcia.spring.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import pk.torcia.spring.utils.TorciaUtils;

/**
 * @author inayat
 *
 */
public class ReportGenerator {

	static String pdfFileName = "C:/ReportPdf/";
	
	public static String generateReport(int studentid, int studentRoll, String className, String classType,
			String sessionName) {
		HashMap hm = null;
		
		System.out.println("Usage: ReportGenerator ....");
		try {

			System.out.println("Start ....");
			// Get jasper report
			String jrxmlentryTestReport = "C:/reports/entryTestReport.jrxml";
			String jasperentryTestReport = "C:/reports/entryTestReport.jasper";
			String jrxmlFileName = "C:/reports/studentreport.jrxml";
			String jasperFileName = "C:/reports/studentreport.jasper";

			// String dbUrl = props.getProperty("jdbc.url");
			String dbUrl = "jdbc:mysql://localhost:3306/contactdb";
			// String dbDriver = props.getProperty("jdbc.driver");
			String dbDriver = "com.mysql.jdbc.Driver";
			// String dbUname = props.getProperty("db.username");
			String dbUname = "root";
			// String dbPwd = props.getProperty("db.password");
			String dbPwd = "";
			// Load the JDBC driver
			Class.forName(dbDriver);
			// Get the connection
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);

			// Create arguments
			// Map params = new HashMap();
			hm = new HashMap();
			hm.put("STUDENTID", studentid);
			// hm.put("DATENAME", "April 2006");
			// Generate jasper print
			System.out.println(classType + " < === >" + studentRoll);
			if (classType.contentEquals("Entry Test")) {
				System.out.println("Inside  Entry Test ---");
				JasperCompileManager.compileReportToFile(jrxmlentryTestReport, jasperentryTestReport);
				pdfFileName = pdfFileName + sessionName + "_" + className + "_" + studentRoll + ".pdf";
				JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperentryTestReport, hm, conn);
				JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);

			} else if (!classType.contentEquals("Entry Test")) {
				System.out.println("Inside  Coaching ---");
				JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
				pdfFileName = pdfFileName + sessionName + "_" + className + "_" + studentRoll + ".pdf";
				JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);
				JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);

			}
			// JasperPrint jprint = (JasperPrint)
			// JasperFillManager.fillReport(jasperFileName, hm, conn);

			// Export pdf file
			// JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
			System.out.println("Done exporting reports to pdf");

		} catch (Exception e) {
			System.out.print("Exceptiion" + e);
		}
		return pdfFileName;
	}

	public static String generateReportDaily(java.util.Date date, java.util.Date date2,String classType) {
		HashMap hm = null;
		// System.out.println("Usage: ReportGenerator ....");
	///	String pdfFileName = null;
		try {
			System.out.println("Start ....");
			// Get jasper report
			String jrxmlFileName = "C:/reports/reportSummary.jrxml";
			String jasperFileName = "C:/reports/reportSummary.jasper";
			pdfFileName = pdfFileName+"reportSummary_" + TorciaUtils.getCurrentDate() + ".pdf";

			JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
			// String dbUrl = props.getProperty("jdbc.url");
			String dbUrl = "jdbc:mysql://localhost:3306/contactdb";
			// String dbDriver = props.getProperty("jdbc.driver");
			String dbDriver = "com.mysql.jdbc.Driver";
			// String dbUname = props.getProperty("db.username");
			String dbUname = "root";
			// String dbPwd = props.getProperty("db.password");
			String dbPwd = "";
			// Load the JDBC driver
			Class.forName(dbDriver);
			// Get the connection
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);

			// Create arguments
			// Map params = new HashMap();
			hm = new HashMap();
			hm.put("STARTDATE", date);
			hm.put("ENDDATE", date2);
			hm.put("CLASSTYPE", classType);
			// Generate jasper print
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);

			// Export pdf file
			JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);

			System.out.println("Done exporting reports to pdf");

		} catch (Exception e) {
			System.out.print("Exceptiion" + e);
		}
		return pdfFileName;
	}
	public static String generateProgressReport(int studentId) {
		HashMap hm = null;
		try {
			String jrxmlFileName = "C:/reports/studentProgressRpt.jrxml";
			String jasperFileName = "C:/reports/studentProgressRpt.jasper";
			pdfFileName = pdfFileName+"progressReport_" + TorciaUtils.getCurrentDate() + ".pdf";
			JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
			String dbUrl = "jdbc:mysql://localhost:3306/contactdb";
			String dbDriver = "com.mysql.jdbc.Driver";
			String dbUname = "root";
			String dbPwd = "";
			Class.forName(dbDriver);
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			hm = new HashMap();
			hm.put("STUDENTID", String.valueOf(studentId));
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);
			JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
			System.out.println("Done exporting reports to pdf");
		} catch (Exception e) {
			System.out.print("Exceptiion" + e);
		}
		return pdfFileName;
	}
}
