package com.hrms.dao;

import java.util.List;

import com.hrms.entity.Dept;

public interface DeptDao {

	// 通过部门名查询详情
	Dept getDeptByName(String name);
	Dept getDeptByDeptId(int  deptId);

	// 添加部门信息 
	boolean addDept(Dept dept);

	// 更新部门信息
	boolean updateDept(Dept dept);

	// 删除部门信息
	Dept deleteDeptByID(int id);
	
	// all
	List<Dept> getAllDepts();
}
