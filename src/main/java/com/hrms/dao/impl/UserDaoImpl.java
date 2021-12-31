package com.hrms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrms.dao.UserDao;
import com.hrms.entity.User;
import com.hrms.util.DateUtil;
import com.hrms.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserById(int eId) {
		String sql = "select e_id , e_name , e_gender , e_department , e_job , e_birthday, `lead` , passwd, phone, email ,createTime, updateTime  from t_user where e_id = ?";
		Connection connect = JDBCUtil.getConnect();
		User user = null;
		ResultSet result = null;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, eId);
			result = statement.executeQuery();
			while (result.next()) {
				user = new User();
				user.seteId(result.getInt(1));
				user.seteName(result.getString(2));
				user.seteGender(result.getString(3));
				user.seteDepartment(result.getInt(4));
				user.seteJob(result.getString(5));
				user.seteBirthday(result.getDate(6));
				user.setLead(result.getInt(7));
				user.setPasswd(result.getString(8));
				user.setPhone(result.getString(9));
				user.setEmail(result.getString(10));
				user.setCreateTime(result.getDate(11));
				user.setUpdateTime(result.getDate(12));

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(result, connect);
		}
		return user;
	}

	@Override
	public boolean addUser(User user) {
		String sql = "insert into t_user ( e_name , e_gender , e_department , e_job , e_birthday, `lead` , passwd,phone,email) values (?,?,?,?,?,?,?,?,?)";
		Connection connect = JDBCUtil.getConnect();
		System.out.println(connect);
		System.out.println(user);
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, user.geteName());
			statement.setString(2, user.geteGender());
			statement.setInt(3, user.geteDepartment());
			statement.setString(4, user.geteJob());
			if (user.geteBirthday() == null) {
				statement.setNull(5, Types.DATE);
			} else {
				statement.setDate(5, new java.sql.Date(user.geteBirthday().getTime()));

			}if(user.getLead()==null) {
				statement.setNull(6, Types.INTEGER);
			}else {
				
				statement.setInt(6, user.getLead());
			}
			statement.setString(7, user.getPasswd());
			statement.setString(8, user.getPhone());
			statement.setString(9, user.getEmail());

			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(connect);
		}

		return true;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update t_user set e_name=? , e_gender=? , e_department=? , e_job=? , e_birthday=?, `lead`=? , passwd=?,email=? , phone=? , updateTime=? where e_id=?";
		Connection connect = JDBCUtil.getConnect();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setObject(1, user.geteName());
			statement.setObject(2, user.geteGender());
			Integer geteDepartment = user.geteDepartment();
			if (geteDepartment == null) {
				statement.setNull(3, java.sql.Types.INTEGER);
			} else {
				statement.setInt(3, geteDepartment);
			}

			statement.setObject(4, user.geteJob());
			statement.setObject(5, DateUtil.getDate(user.geteBirthday()));
			statement.setLong(6, user.getLead());
			statement.setString(7, user.getPasswd());
			statement.setObject(8, user.getEmail());
			statement.setObject(9, user.getPhone());
			statement.setTimestamp(10, new Timestamp(new Date().getTime()));
			statement.setInt(11, user.geteId());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(connect);
		}

		return true;

	}

	@Override
	public User deleteUserById(int id) {
		String sql = "delete  from t_user where e_id = ?";
		Connection connect = JDBCUtil.getConnect();
		User user = null;
		user = getUserById(id);
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, user.geteId());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connect);
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		String sql = "select e_id , e_name , e_gender , e_department , e_job , e_birthday, `lead` , passwd, phone, email ,createTime, updateTime from t_user";
		Connection connect = JDBCUtil.getConnect();
		List<User> users = new ArrayList<>();
		ResultSet result = null;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {
				User user = new User();
				user.seteId(result.getInt(1));
				user.seteName(result.getString(2));
				user.seteGender(result.getString(3));
				user.seteDepartment(result.getInt(4));
				user.seteJob(result.getString(5));
				user.seteBirthday(result.getDate(6));
				user.setLead(result.getInt(7));
				user.setPasswd(result.getString(8));
				user.setPhone(result.getString(9));
				user.setEmail(result.getString(10));
				user.setCreateTime(result.getDate(11));
				user.setUpdateTime(result.getDate(12));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(result, connect);
		}

		return users;

	}

	@Override
	public User getUserByPhoneAndPasswd(String phString, String pwString) {
		String sql = "select e_id , e_name , e_gender , e_department , e_job , e_birthday, `lead` , passwd, phone, email ,createTime, updateTime from t_user where phone = ? and passwd =?";
		Connection connect = JDBCUtil.getConnect();
		User user = null;
		ResultSet result = null;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, phString);
			statement.setString(2, pwString);
			result = statement.executeQuery();
			while (result.next()) {
				user = new User();
				user.seteId(result.getInt(1));
				user.seteName(result.getString(2));
				user.seteGender(result.getString(3));
				user.seteDepartment(result.getInt(4));
				user.seteJob(result.getString(5));
				user.seteBirthday(result.getDate(6));
				user.setLead(result.getInt(7));
				user.setPasswd(result.getString(8));
				user.setPhone(result.getString(9));
				user.setEmail(result.getString(10));
				user.setCreateTime(result.getDate(11));
				user.setUpdateTime(result.getDate(12));

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(result, connect);
		}
		return user;
	}

	/**
	 *
	 */
	@Override
	public boolean changPasswd(int intId, String passwd) {
		String sql = "UPDATE `hrms`.`t_user` SET `passwd` = ? WHERE `e_id` = ?";
		Connection connect = JDBCUtil.getConnect();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, passwd);
			statement.setInt(2, intId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(connect);
		}
		return true;
	}
}
