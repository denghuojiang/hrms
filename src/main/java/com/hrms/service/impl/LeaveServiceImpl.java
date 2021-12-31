package com.hrms.service.impl;

import java.util.Date;
import java.util.List;

import com.hrms.dao.LeaveDao;
import com.hrms.dao.UserDao;
import com.hrms.dao.impl.LeaveDaoImpl;
import com.hrms.dao.impl.UserDaoImpl;
import com.hrms.entity.Leave;
import com.hrms.service.LeaveService;
import com.hrms.util.DateUtil;
import com.hrms.util.MailUtils;
import com.hrms.util.ResultResponse;

public class LeaveServiceImpl implements LeaveService {

	
	private LeaveDao lDao= new LeaveDaoImpl();
	
	private UserDao uDao= new UserDaoImpl();
	@Override
	public List<Leave> getAllLeaveInfo() {	
		return lDao.getAll();
	}


	
	@Override
	public void addLeave(Leave leave) {
		lDao.addLeave(leave);
		
	}



	@Override
	public ResultResponse replyLeave(Leave leave) {
		boolean updateLeave = lDao.replyLeave(leave);
		String email = uDao.getUserById(leave.geteId()).getEmail();
		ResultResponse rr = new ResultResponse();
		if(updateLeave) {
			rr.setStatusCode("200");
			try {
				MailUtils.sendMail(email, leave.getReply());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				rr.setStatusCode("300");
				rr.setDesc("回复失败");
			} 
		}else {
			rr.setStatusCode("300");
			rr.setDesc("回复失败");
		}
		return rr;
	}



	@Override
	public ResultResponse delLeaveInfo(int id) {
		Leave updateLeave = lDao.deleteLeaveById(id);
		ResultResponse rr = new ResultResponse();
		if(updateLeave!=null) {
			rr.setStatusCode("200");
			
		}else {
			rr.setStatusCode("300");
			rr.setDesc("回复失败");
		}
		return rr;
		
		
	}



	@Override
	public String searchNowStateByEid(int eId) {
		Leave lastByEId = lDao.getLastByEId(eId);
		if(lastByEId==null) {
			return "上班日！";
		}
		Date start = lastByEId.getStart();
		Date end = lastByEId.getEnd();
		if(DateUtil.nowIsBetweenBAndC(start, end)) {
			return"假期中";
		}else {
			
			return "上班日！";
		}
		
	}

}
