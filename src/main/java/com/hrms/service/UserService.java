package com.hrms.service;

import java.util.List;

import com.hrms.entity.User;
import com.hrms.util.ResultResponse;

public interface UserService {
	ResultResponse loginService(String username, String password);
	List<User> listAll();
	ResultResponse deleteUserInfo(int id);
	ResultResponse addUser(User user);
	ResultResponse updateUserInfo(User user);
	ResultResponse changePasswd(int intId, String passwd);
	String getUserEmailById(int eId);
}
