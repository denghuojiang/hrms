package com.hrms.service;

import java.math.BigDecimal;
import java.util.List;

import com.hrms.entity.Salary;
import com.hrms.util.ResultResponse;

public interface SalaryService {

	
	List<Salary> getAllList();

	void SaveSalary(int parseInt, BigDecimal bigDecimal);

	ResultResponse delSalary(int parseInt, String string);

	List<Salary> getBySalaryById(Integer geteId);
}
