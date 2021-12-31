package com.hrms.service.impl;

import java.util.List;

import com.hrms.dao.DeptDao;
import com.hrms.dao.impl.DeptDaoImpl;
import com.hrms.entity.Dept;
import com.hrms.service.DeptService;
import com.hrms.util.ResultResponse;

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao = new DeptDaoImpl();

	@Override
	public List<Dept> getAllDeptList() {
		List<Dept> allDepts = deptDao.getAllDepts();

		return allDepts;
	}

	@Override
	public ResultResponse updateUserInfo(Dept dept) {
		ResultResponse rr = new ResultResponse();
		boolean updateDept = deptDao.updateDept(dept);

		if (updateDept) {
			rr.setStatusCode("200");
		} else {
			rr.setStatusCode("300");
			rr.setDesc("更新失败！");
		}
		return rr;
	}

	@Override
	public ResultResponse addDeptInfo(Dept dept) {
		ResultResponse rr = new ResultResponse();
		boolean updateDept = deptDao.addDept(dept);

		if (updateDept) {
			rr.setStatusCode("200");
		} else {
			rr.setStatusCode("300");
			rr.setDesc("更新失败！");
		}
		return rr;
	}

	@Override
	public ResultResponse delDept(int id) {
		ResultResponse rr = new ResultResponse();
		Dept deleteDeptByID = deptDao.deleteDeptByID(id);

		if (deleteDeptByID != null) {
			rr.setStatusCode("200");
		} else {
			rr.setStatusCode("300");
			rr.setDesc("删除失败！");
		}
		return rr;
	}

}
