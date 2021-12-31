package com.hrms.dao;

import java.util.Date;
import java.util.List;

import com.hrms.entity.Attendance;

public interface AttendanceDao {

	// 根据系统时间出勤操作+1 如果是零添加表项 ，否做添加
	//insert into `hrms`.`t_attendance` (`e_id`, `a_month`, `amount`)  values('1', '2021-12-01', '1') on  DUPLICATE key update amount=amount+values(amount)
	boolean updateAmount(int eid,Date date);
	
	// 根据id和日期更改 出勤天数
	boolean updateAmountByIdAndAmount(int eid,Date date, int amount);
	
	// 根据id和日期 del
	boolean deleteAttendance(int eid,Date date);
	
	
	List<Attendance> getAll();
	 
	List<Attendance> getCurentMonthAttendance(Date date);
	
	List<Attendance> getAttendancesByEId(int id);

	
}
