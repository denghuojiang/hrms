package com.hrms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrms.dao.AttendanceDao;
import com.hrms.entity.Attendance;
import com.hrms.util.DateUtil;
import com.hrms.util.JDBCUtil;

public class AttendanceDaoImpl implements AttendanceDao {

	@Override
	public boolean updateAmount(int eid, Date date) {
		Connection connect = JDBCUtil.getConnect();
		String sql = "insert into `hrms`.`t_attendance` (`e_id`, `a_month`, `amount`)  values(?, ?, '1') on  DUPLICATE key update amount=amount+values(amount),updateTime= ?";
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, eid);
			String stringDate = DateUtil.getNowYearAndMonth(date);
			statement.setString(2, stringDate);
			statement.setTimestamp(3, new Timestamp(new Date().getTime()));
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
	public boolean updateAmountByIdAndAmount(int eid, Date date, int amount) {
		String sql = "UPDATE `hrms`.`t_attendance` SET `amount` = ? ,`updateTime`=? WHERE `e_id` = ? AND `a_month` = ?";
		Connection connnect = JDBCUtil.getConnect();
		try {
			PreparedStatement statement = connnect.prepareStatement(sql);
			statement.setInt(1, amount);
			statement.setTimestamp(2, new Timestamp(new Date().getTime()));
			statement.setInt(3, eid);
			String stringDate = DateUtil.getNowYearAndMonth(date);
			statement.setString(4, stringDate);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(connnect);

		}
		return true;

	}

	@Override
	public boolean deleteAttendance(int eid, Date date) {
		String sql = "delete from hrms.`t_attendance` where `e_id` =? and `a_month` =? ";
		Connection connect = JDBCUtil.getConnect();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, eid);
			String stringDate = DateUtil.getNowYearAndMonth(date);
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

	@Override
	public List<Attendance> getAll() {
		String sql = "select  `e_id`,`a_month`,`amount` from hrms.`t_attendance` ";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		List<Attendance> attendances = new ArrayList<>();
		try {
			PreparedStatement st = connect.prepareStatement(sql);
			result = st.executeQuery();
			while (result.next()) {
				Attendance attendance = new Attendance();

				int id = result.getInt(1);
				java.sql.Date date = result.getDate(2);
				int amount = result.getInt(3);
				attendance.seteId(id);
				attendance.setaMonth(date);
				attendance.setAmount(amount);
				attendances.add(attendance);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(result, connect);
		}
		return attendances;
	}

	@Override
	public List<Attendance> getCurentMonthAttendance(Date date) {
		String sql = "select  `e_id`,`a_month`,`amount` from hrms.`t_attendance` where `a_month`= ?";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		List<Attendance> attendances = new ArrayList<>();
		try {
			PreparedStatement st = connect.prepareStatement(sql);
			st.setString(1, DateUtil.getNowYearAndMonth(date));
			result = st.executeQuery();
			while (result.next()) {
				Attendance attendance = new Attendance();

				int id = result.getInt(1);
				java.sql.Date d = result.getDate(2);
				int amount = result.getInt(3);
				attendance.seteId(id);
				attendance.setaMonth(d);
				attendance.setAmount(amount);
				attendances.add(attendance);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(result, connect);
		}
		return attendances;
		
		
		
	}

	@Override
	public List<Attendance> getAttendancesByEId(int id) {
		String sql = "select  `e_id`,`a_month`,`amount` from hrms.`t_attendance` where `e_id`= ?";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		List<Attendance> attendances = new ArrayList<>();
		try {
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, id);
			result = st.executeQuery();
			while (result.next()) {
				Attendance attendance = new Attendance();

				int i = result.getInt(1);
				java.sql.Date d = result.getDate(2);
				int amount = result.getInt(3);
				attendance.seteId(i);
				attendance.setaMonth(d);
				attendance.setAmount(amount);
				attendances.add(attendance);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(result, connect);
		}
		return attendances;
	}
}
