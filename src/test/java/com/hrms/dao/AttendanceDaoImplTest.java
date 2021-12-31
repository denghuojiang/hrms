package com.hrms.dao;

import java.util.Date;

import org.junit.Test;

import com.hrms.dao.impl.AttendanceDaoImpl;

public class AttendanceDaoImplTest {

	private AttendanceDao attendanceDao = new AttendanceDaoImpl();
	@Test
	public void updateAmount() {
		attendanceDao.updateAmount(1, new Date());
	}

	@Test
	public void updateAmountByIdAndAmount() {
		attendanceDao.updateAmountByIdAndAmount(1, new Date(),30);
	}
	
	@Test
	public void deleteAttendance() {
		attendanceDao.deleteAttendance(2,new Date());
	}
}
