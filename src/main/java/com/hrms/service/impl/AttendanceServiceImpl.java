package com.hrms.service.impl;

import java.util.Date;
import java.util.List;

import com.hrms.dao.AttendanceDao;
import com.hrms.dao.DeptDao;
import com.hrms.dao.impl.AttendanceDaoImpl;
import com.hrms.entity.Attendance;
import com.hrms.service.AttendanceService;
import com.hrms.util.DateUtil;
import com.hrms.util.ResultResponse;

public class AttendanceServiceImpl implements AttendanceService {

	private AttendanceDao aDao = new AttendanceDaoImpl();
	
	@Override
	public List<Attendance> getAllAttendances() {
		List<Attendance> all = aDao.getAll();
		return all;
	}

	@Override
	public List<Attendance> getCurrentAmonthAtdnc() {
		List<Attendance> all = aDao.getCurentMonthAttendance(new Date());
		
		return all;
	}

	@Override
	public ResultResponse updateAttend(Attendance attendance) {
		boolean result = aDao.updateAmountByIdAndAmount(attendance.geteId(), attendance.getaMonth(),attendance.getAmount());
		ResultResponse rr = new ResultResponse();
		if(result) {
			rr.setStatusCode("200");
		}else {
			rr.setStatusCode("300");
			rr.setDesc("更改失败！");
		}
		return rr;
	}

	@Override
	public ResultResponse delAttend(int parseInt, String string) {
		boolean result = aDao.deleteAttendance(parseInt, DateUtil.parse(string));
		ResultResponse rr = new ResultResponse();
		if(result) {
			rr.setStatusCode("200");
		}else {
			rr.setStatusCode("300");
			rr.setDesc("更改失败！");
		}
		return rr;
	}

	@Override
	public ResultResponse doAttendance(String id, Date date) {
		boolean result = aDao.updateAmount(Integer.parseInt(id), date);
		ResultResponse rr = new ResultResponse();
		if(result) {
			rr.setStatusCode("200");
		}else {
			rr.setStatusCode("300");
			rr.setDesc("更改失败！");
		}
		return rr;
	}

	@Override
	public List<Attendance> getAttendenceById(int intId) {
		 
		List< Attendance> list =  aDao.getAttendancesByEId(intId);
		return list;
	}

}
