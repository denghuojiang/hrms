package com.hrms.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hrms.dao.SalaryDao;
import com.hrms.dao.impl.SalaryDaoImpl;
import com.hrms.entity.Salary;
import com.hrms.service.SalaryService;
import com.hrms.util.DateUtil;
import com.hrms.util.ResultResponse;

public class SalaryServiceImpl implements SalaryService {

	private SalaryDao  sDao = new SalaryDaoImpl();

	@Override
	public List<Salary> getAllList() {
		return sDao.getAllList();
		
		
		
	}

	@Override
	public void SaveSalary(int parseInt, BigDecimal bigDecimal) {
		sDao.addSalaryByIdAndMonth(parseInt, new Date(), bigDecimal);
	}

	@Override
	public ResultResponse delSalary(int parseInt, String string) {
		boolean result = sDao.deleteSalary(parseInt, DateUtil.parse(string));
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
	public List<Salary> getBySalaryById(Integer geteId) {
		
		return  sDao.getSalariesById(geteId);
		
	}
	
	
	
	
}
