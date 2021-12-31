package com.hrms.dao;

import org.junit.Test;

import com.hrms.dao.impl.DeptDaoImpl;
import com.hrms.entity.Dept;

public class DeptDaoImplTest {

	private DeptDao deptDao = new DeptDaoImpl();
	@Test
	public void getDeptByName() {
		Dept deptByName = deptDao.getDeptByName("所有部门");
		System.out.println(deptByName);
	}
	@Test
	public void getDeptByDeptId() {
		Dept deptByName = deptDao.getDeptByDeptId(1);
		System.out.println(deptByName);
	}
	@Test
	public void addDept() {
		Dept dept = new Dept();
		dept.setDeptLocal("河北唐山");
		dept.setDeptName("电气信息");
		boolean deptByName = deptDao.addDept(dept);
		System.out.println(deptByName);
	}
	@Test
	public void updateDept() {
		Dept dept = new Dept();
		dept.setDeptId(2);
		dept.setStatus(0);
		dept.setDeptLocal("河北石家庄");
		dept.setDeptName("电气信息");
		boolean deptByName = deptDao.updateDept(dept);
		System.out.println(deptByName);
	}
	
}
