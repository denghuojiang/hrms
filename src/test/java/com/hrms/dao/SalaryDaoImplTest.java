package com.hrms.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hrms.dao.impl.SalaryDaoImpl;
import com.hrms.entity.Salary;

public class SalaryDaoImplTest {

	private SalaryDao salaryDao = new SalaryDaoImpl();
 	@Test
	public void test() {
		boolean result = salaryDao.addSalaryByIdAndMonth(1, new Date(), new BigDecimal(100));
		System.out.println(result);
	}
 	@Test
 	public void testGetById() {
 		List<Salary> s = salaryDao.getSalariesById(1);
 		System.out.println(s);
 	}

 	@Test
 	public void testGetByDate() {
 		List<Salary> s = salaryDao.getSalariesByDate(new Date());
 		System.out.println(s);
 	}
}
