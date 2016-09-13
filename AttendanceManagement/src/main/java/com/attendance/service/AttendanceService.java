package com.attendance.service;

import java.util.List;

import com.attendance.bean.AttendanceDetails;
import com.attendance.bean.Employee;
import com.attendance.exception.DAOException;

public interface AttendanceService {
	

	
	public void ExportToExcel()  ;
	
	public void insertSwipeHours(List<AttendanceDetails> attendance) ;

}
