/**
 * 
 */
package pk.torcia.spring.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import pk.torcia.spring.controller.StudentController;

/**
 * @author inayat
 *
 */
public class TorciaUtils {
	
	static Logger log = Logger.getLogger(TorciaUtils.class.getName());
	
	public static String getCurrentDate(){
		  DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
		  Date dateobj = new Date();
		  System.out.println("current date is ..... "+df.format(dateobj));
		  String currentDate = df.format(dateobj);
		  return currentDate;
	}
	/*
	 * Method Name Return Type
	 */
	public static String uploadFile(MultipartFile file, String name,HttpServletRequest request) {
		log.info("Inside StudentController uploadFile......");
		String fileUrl = null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				System.out.println("file uploaded on path " + dir.getPath());
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name + ".png");
				System.out.println("file uploaded on  server path " + serverFile.getPath());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				fileUrl = serverFile.getPath().toString();
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("file is emplty");
		}
		return fileUrl;
	}
	/*
	 * Method Name Return Type
	 */
	public static void setResponseHeaderTlocrtPDF(HttpServletResponse response, String reportName) {
		response.setContentType("application/pdf");
		response.setHeader("content-disposition", "attachment; filename=torciaAcademy.pdf");
	}


}
