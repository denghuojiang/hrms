package com.hrms.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hrms.dao.impl.LeaveDaoImpl;
import com.hrms.entity.Leave;

public class LeaveDaoImplTest {

	private LeaveDao leaveDao = new LeaveDaoImpl();
	@Test
	public void findLeaveById() {
		Leave findLeaveById = leaveDao.findLeaveById(3);
		System.out.println(findLeaveById);
	}
	
	@Test
	public void addLeave() {
		Leave leave = new Leave();
		leave.setStart(new Date());
		leave.setEnd(new Date(2000, 12, 27));
		leave.seteId(1);
		leave.setDesc("222");
		leaveDao.addLeave(leave);
	}
	
	@Test
	public void updateLeave() {
		Leave leave = new Leave();
		leave.setStart(new Date());
		leave.setEnd(new Date(2000, 12, 27));
		leave.seteId(1);
		leave.setlId(2);
		leave.setDesc("333");
		leaveDao.updateLeave(leave);
	}
	@Test
	public void deleteLeaveById() {
		leaveDao.deleteLeaveById(2);
	}
	@Test
	public void getAll() {
		List<Leave> all = leaveDao.getAll();
		System.out.println(all);
		
	}
	@Test
	public void getAllNoAdmit() {
		List<Leave> all = leaveDao.getAllNoAdmint();
		System.out.println(all);
		
	}
}
