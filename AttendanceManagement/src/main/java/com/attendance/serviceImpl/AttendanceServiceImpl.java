package com.attendance.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.attendance.DAOServiceImpl.AttendanceDAOImpl;
import com.attendance.bean.Employee;
import com.attendance.bean.AttendanceDetails;
import com.attendance.exception.DAOException;
import com.attendance.service.AttendanceService;


public class AttendanceServiceImpl implements AttendanceService {

	AttendanceDAOImpl empDAO = new AttendanceDAOImpl();
	
	final static Logger logger = Logger.getLogger(AttendanceService.class);

	@Override
	public void ExportToExcel()  {
		// TODO Auto-generated method stub
		
		List<AttendanceDetails> attendanceList = new ArrayList<AttendanceDetails>();
		
		try {
			attendanceList = empDAO.getAttendanceDetails();
		
		
		//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Attendance Data");
        
      //Iterate over data and write to sheet
        int rownum = 0;
        
      
        int cellnum = 0;
        Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("Employee Id");
	    header.createCell(1).setCellValue("Card No");
	    header.createCell(2).setCellValue("Swipe in time");
	    header.createCell(3).setCellValue("Swipe out time");
	    header.createCell(4).setCellValue("Hours logged");

        
        for (AttendanceDetails obj : attendanceList) {
        	

        	Row dataRow = sheet.createRow(1);
        	dataRow.createCell(0).setCellValue(obj.getEmployee_id());
            dataRow.createCell(1).setCellValue(obj.getAccess_cardno());
            dataRow.createCell(2).setCellValue(obj.getSwipe_in());
            dataRow.createCell(3).setCellValue(obj.getSwipe_out());
            dataRow.createCell(4).setCellValue(obj.getTotal_hours());
        
          

		}
        
        FileOutputStream out = new FileOutputStream(new File("D:\\AttendanceDetails.xlsx"));
        workbook.write(out);
        out.close();
        logger.info("AttendanceDetails.xlsx written successfully on disk.");

        
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			logger.error("Encountered exception:"+ e.getMessage());
		   

		}


		

		
	}

	@Override
	public void insertSwipeHours(List<AttendanceDetails> attendance) {
		// TODO Auto-generated method stub
		
		try {
			empDAO.insertSwipeHours(attendance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Encountered exception:"+e.getMessage());
		}
		
	}

}
