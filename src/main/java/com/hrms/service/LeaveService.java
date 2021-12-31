package com.hrms.service;

import java.util.List;

import com.hrms.entity.Leave;
import com.hrms.util.ResultResponse;

public interface LeaveService {

	List<Leave> getAllLeaveInfo();

	ResultResponse replyLeave(Leave leave);

	ResultResponse delLeaveInfo(int id);


	void addLeave(Leave leave);

	String searchNowStateByEid(int eId);


}
