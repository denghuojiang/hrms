package com.hrms.service.impl;

import java.util.List;

import com.hrms.dao.UserDao;
import com.hrms.dao.impl.UserDaoImpl;
import com.hrms.entity.User;
import com.hrms.service.UserService;
import com.hrms.util.ResultResponse;

public class UserServiceImpl implements UserService {
	private UserDao uDao = new UserDaoImpl();

	public ResultResponse loginService(String username, String password) {
		ResultResponse rr = new ResultResponse();
		try {
			// String ab = null;
			// ab.lastIndexOf(1);
			User user = uDao.getUserByPhoneAndPasswd(username, password);
			
			// System.out.println(user+"===================");
			if (user == null) {
				rr.setStatusCode("300");
				rr.setDesc("用户名不存在");
				rr.setObj(null);
			} else {
				rr.setStatusCode("200");
				rr.setDesc("登陆成功");
				rr.setObj(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rr.setDesc("系统错误");
			rr.setStatusCode("500");
			rr.setObj(e);
			return rr;
		}
		return rr;

	}

	@Override
	public List<User> listAll() {
		List<User> allUser = uDao.getAllUser();
		
		return allUser;
	}

	@Override
	public ResultResponse deleteUserInfo(int id) {
		User deleteUserById = uDao.deleteUserById(id);
		ResultResponse rr = new ResultResponse();
		if(deleteUserById==null) {
			rr.setStatusCode("300");
			rr.setDesc("删除失败！");
		}else {
			rr.setStatusCode("200");
		}
		return rr;
	}

	@Override
	public ResultResponse addUser(User user) {
		ResultResponse rr = new ResultResponse();
		boolean addUser = uDao.addUser(user);
		if(addUser) {
			rr.setStatusCode("200");
		}else {
			rr.setStatusCode("300");
			rr.setDesc("添加失败！");
		}
		return rr;
	}

	@Override
	public ResultResponse updateUserInfo(User user) {
		ResultResponse rr = new ResultResponse();
		boolean addUser = uDao.updateUser(user);
		if(addUser) {
			rr.setStatusCode("200");
		}else {
			rr.setStatusCode("300");
			rr.setDesc("添加失败！");
		}
		return rr;
	}

	@Override
	public ResultResponse changePasswd(int intId, String passwd) {
		boolean result =  uDao.changPasswd(intId , passwd);
		ResultResponse rr = new ResultResponse();
		if(result==true) {
			rr.setStatusCode("200");
		}else {
			rr.setStatusCode("300");
		}
		return rr;
	}

	@Override
	public String getUserEmailById(int eId) {
		User userById = uDao.getUserById(eId);
		String email = userById.getEmail();
		return email;
		
	}

}
