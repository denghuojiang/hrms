package com.hrms.dao;

import java.util.List;

import com.hrms.entity.Leave;
import com.hrms.entity.Salary;

public interface LeaveDao {

	// 通过假条id查询假条详情
	Leave findLeaveById(int id);

	// 查询 指定用户的所有假条
	List<Leave> getUserByEId(int eId);

	// 查询 所有假条
	List<Leave> getAll();

	// 查询 所有没有批准的假条
	List<Leave> getAllNoAdmint();

	// 删除指定假条
	Leave deleteLeaveById(int id);

	// 更新假条
	boolean updateLeave(Leave leave);

	// 添加
	boolean addLeave(Leave leave);

	boolean replyLeave(Leave leave);
	
	Leave getLastByEId(int eid);

}
