package com.hrms.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hrms.dao.impl.UserDaoImpl;
import com.hrms.entity.User;

public class UserDaoImplTest {

	private UserDao userDao = new UserDaoImpl();



	@SuppressWarnings("deprecation")
	@Test
	public void testAddUser() {
		User user = new User();
		user.seteBirthday(new Date(2000, 12, 27));
		user.seteDepartment(1);
		user.seteGender("男");
		user.seteJob("管理员");
		user.setEmail("heshinuo@163.com");
		user.seteName("灯火酱");
		user.setLead(1);
		user.setPasswd("123456");
		user.setPhone("110");
		
		userDao.addUser(user);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testUpdateUser() {

		User user = new User();
		user.seteBirthday(new Date(2000, 12, 27));
//		user.seteDepartment(1);
		user.seteGender("女");
//		user.seteJob("管理员");
		user.setEmail("heshinuo@163.com");
		user.seteName("灯火酱");
		user.setLead(1);
		user.setPasswd("123456");
		user.setPhone("110");
		userDao.updateUser(user);
	}

	@Test
	public void testDelUserById() {
		User user = userDao.deleteUserById(1);
		System.out.println(user);

	}

	@Test
	public void testGetUserById() {
		User userById = userDao.getUserById(1);
		System.out.println(userById);
	}
	
	@Test
	public void testGetAll() {
		List<User> users = userDao.getAllUser();
		System.out.println(users);

	}
}
