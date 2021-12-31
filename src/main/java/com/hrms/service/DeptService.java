package com.hrms.service;

import java.util.List;

import com.hrms.entity.Dept;
import com.hrms.util.ResultResponse;

public interface DeptService {

	List<Dept> getAllDeptList();

	ResultResponse updateUserInfo(Dept dept);

	ResultResponse addDeptInfo(Dept dept);

	ResultResponse delDept(int id);

}
