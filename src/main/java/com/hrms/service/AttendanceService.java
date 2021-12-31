package com.hrms.service;

import java.util.Date;
import java.util.List;

import com.hrms.entity.Attendance;
import com.hrms.util.ResultResponse;

public interface AttendanceService {
	List<Attendance> getAllAttendances();
	List<Attendance> getCurrentAmonthAtdnc();
	ResultResponse updateAttend(Attendance attendance);
	ResultResponse delAttend(int parseInt, String string);
	ResultResponse doAttendance(String id, Date date);
	List<Attendance> getAttendenceById(int intId);
 }
