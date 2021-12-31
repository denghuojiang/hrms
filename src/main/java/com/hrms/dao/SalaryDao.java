package com.hrms.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hrms.entity.Salary;

public interface SalaryDao {
	// 根据 年月份和员工id添加月薪
	boolean addSalaryByIdAndMonth(int eId, Date date, BigDecimal amount);

	// 查询id 为eId 的员工所有月薪
	List<Salary> getSalariesById(int eId);

	// 查询指定年月的 所有月薪
	List<Salary> getSalariesByDate(Date date);

	List<Salary> getAllList();

	boolean deleteSalary(int parseInt, Date parse);
	
	
}
