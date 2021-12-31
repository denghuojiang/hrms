package com.hrms.dao;

import java.util.List;

import com.hrms.entity.User;

public interface UserDao {

	// 根据员工id 查询 用户信息
	User getUserById(int eId);

	// 查询 用户信息
	User getUserByPhoneAndPasswd(String  phString , String pwString);

	// 添加员工
	boolean addUser(User user);

	// 更新员工信息
	boolean updateUser(User user);

	// 删除
	User deleteUserById(int id);

	// 查询所有员工
	List<User> getAllUser();

	boolean changPasswd(int intId, String passwd);

}
