package com.hrms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrms.dao.DeptDao;
import com.hrms.entity.Dept;
import com.hrms.util.JDBCUtil;

public class DeptDaoImpl implements DeptDao {

	@Override
	public Dept getDeptByName(String name) {
		String sql = "SELECT `dept_id`,`dept_name`,`p_dept`,`dept_local`,`createTime`,`updateTime`,`status` FROM `hrms`.`t_dept` where  dept_name = ?";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		Dept dept = null;
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			prepareStatement.setString(1, name);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				dept = new Dept();
				dept.setDeptId(result.getInt(1));
				dept.setDeptName(result.getString(2));
				dept.setpDept(result.getInt(3));
				dept.setDeptLocal(result.getString(4));
				dept.setCreateTime(result.getDate(5));
				dept.setUpdateTime(result.getDate(6));
				dept.setStatus(result.getInt(7));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			JDBCUtil.close(result, connect);
		}

		return dept;

	}

	@Override
	public Dept getDeptByDeptId(int deptId) {
		String sql = "SELECT `dept_id`,`dept_name`,`p_dept`,`dept_local`,`createTime`,`updateTime`,`status` FROM `hrms`.`t_dept` where  dept_id = ?";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		Dept dept = null;
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			prepareStatement.setInt(1, deptId);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				dept = new Dept();
				dept.setDeptId(result.getInt(1));
				dept.setDeptName(result.getString(2));
				dept.setpDept(result.getInt(3));
				dept.setDeptLocal(result.getString(4));
				dept.setCreateTime(result.getDate(5));
				dept.setUpdateTime(result.getDate(6));
				dept.setStatus(result.getInt(7));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			JDBCUtil.close(result, connect);
		}

		return dept;
	}

	@Override
	public boolean addDept(Dept dept) {
		String sql = "INSERT INTO `hrms`.`t_dept`(`dept_name`,`dept_local`)VALUES (?,?)";
		Connection connect = JDBCUtil.getConnect();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, dept.getDeptName());
//			statement.setInt(2, dept.getStatus());
			statement.setString(2, dept.getDeptLocal());
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
	public boolean updateDept(Dept dept) {
		String sql = "UPDATE `hrms`.`t_dept` SET `dept_name`=?,`status`=?,`p_dept`=?,`dept_local`=?,`updateTime`=? where `dept_id`=?";
		Connection connect = JDBCUtil.getConnect();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, dept.getDeptName());
			statement.setInt(2, dept.getStatus());
			
			Integer getpDept = dept.getpDept();
			if(getpDept!=null) {
				statement.setInt(3, getpDept);				
			}else {
				statement.setNull(3, Types.INTEGER);
			}
			statement.setObject(4, dept.getDeptLocal());
			statement.setTimestamp(5, new Timestamp(new Date().getTime()));
			statement.setInt(6, dept.getDeptId());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(connect);
		}
		return true;
	}

	@Override
	public Dept deleteDeptByID(int id) {
		String sql = "delete  from t_dept where dept_id = ?";
		Connection connect = JDBCUtil.getConnect();
		Dept dept = getDeptByDeptId(id);
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(connect);
		}

		return dept;
	}

	@Override
	public List<Dept> getAllDepts() {
		String sql = "SELECT `dept_id`,`dept_name`,`p_dept`,`dept_local`,`createTime`,`updateTime`,`status` FROM `hrms`.`t_dept`";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		List<Dept> depts = new ArrayList<>();
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Dept dept = new Dept();
				dept.setDeptId(result.getInt(1));
				dept.setDeptName(result.getString(2));
				dept.setpDept(result.getInt(3));
				dept.setDeptLocal(result.getString(4));
				dept.setCreateTime(result.getDate(5));
				dept.setUpdateTime(result.getDate(6));
				dept.setStatus(result.getInt(7));
				depts.add(dept);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(result, connect);
		}

		return depts;
	}

}
