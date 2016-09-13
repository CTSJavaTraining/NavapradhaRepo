package com.attendance.DAOService;

import java.util.List;

import com.attendance.exception.DAOException;
import com.attendance.bean.AttendanceDetails;
import com.attendance.bean.Employee;



public interface AttendanceDAO {
	
	public void getEmployee(int empId,int cardno) throws Exception ;
	
	public List<AttendanceDetails> getAttendanceDetails() throws Exception ;
	
	public void insertSwipeHours(List<AttendanceDetails> employee) throws Exception ;
	

}
