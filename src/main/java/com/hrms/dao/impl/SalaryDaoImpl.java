package com.hrms.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrms.dao.SalaryDao;
import com.hrms.entity.Salary;
import com.hrms.util.DateUtil;
import com.hrms.util.JDBCUtil;

public class SalaryDaoImpl implements SalaryDao {

	@Override
	public boolean addSalaryByIdAndMonth(int eId, Date date, BigDecimal amount) {
		Connection connect = JDBCUtil.getConnect();
		String sql = " INSERT INTO `hrms`.`t_salary` (`e_id`, `s_month`, `s_amount`) VALUES (?,?,?)";

		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			prepareStatement.setInt(1, eId);
			prepareStatement.setString(2, DateUtil.getNowYearAndMonth());
			prepareStatement.setBigDecimal(3, amount);
			prepareStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(connect);
		}
		return true;
	}

	@Override
	public List<Salary> getSalariesById(int eId) {
		String sql = "SELECT e_id, s_month,s_time,s_amount FROM `hrms`.`t_salary`where  e_id = ?";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		ArrayList<Salary> salarys = new ArrayList<Salary>();
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			prepareStatement.setInt(1, eId);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Salary salary = new Salary();
				salary.seteId(result.getInt(1));
				salary.setsMonth(new Date(result.getTimestamp(2).getTime()));
				salary.setsTime(new Date(result.getTimestamp(3).getTime()));
				salary.setsAmount(result.getBigDecimal(4));
				salarys.add(salary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtil.close(connect);
		}
		return salarys;
	}

	@Override
	public List<Salary> getSalariesByDate(Date date) {
		String sql = "SELECT e_id,s_month,s_time,s_amount FROM `hrms`.`t_salary`where  YEAR(s_month)=? AND MONTH(s_month)=?  ";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		ArrayList<Salary> salarys = new ArrayList<Salary>();
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			System.out.println(DateUtil.getYear(date) + "   " + DateUtil.getMonth(date));
			prepareStatement.setString(1, DateUtil.getYear(date));
			prepareStatement.setString(2, DateUtil.getMonth(date));
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Salary salary = new Salary();
				salary.seteId(result.getInt(1));
				salary.setsMonth(new Date(result.getDate(2).getTime()));
				salary.setsTime(new Date(result.getDate(3).getTime()));
				salary.setsAmount(result.getBigDecimal(4));
				salarys.add(salary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtil.close(connect);
		}
		return salarys;
	}

	@Override
	public List<Salary> getAllList() {
		String sql = "SELECT e_id, s_month,s_time,s_amount FROM `hrms`.`t_salary`";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		ArrayList<Salary> salarys = new ArrayList<Salary>();
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Salary salary = new Salary();
				salary.seteId(result.getInt(1));
				salary.setsMonth(new Date(result.getDate(2).getTime()));
				salary.setsTime(new Date(result.getTimestamp(3).getTime()));
				salary.setsAmount(result.getBigDecimal(4));
				salarys.add(salary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(result,connect);
		}
		return salarys;
	}

	@Override
	public boolean deleteSalary(int parseInt, Date parse) {
		String sql = "delete from hrms.`t_salary` where `e_id` =? and `s_month` =? ";
		Connection connect = JDBCUtil.getConnect();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, parseInt);
			String stringDate = DateUtil.getDate(parse);
			statement.setString(2, stringDate);
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
