package com.hrms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrms.dao.LeaveDao;
import com.hrms.entity.Leave;
import com.hrms.util.DateUtil;
import com.hrms.util.JDBCUtil;

public class LeaveDaoImpl implements LeaveDao {

	@Override
	public Leave findLeaveById(int id) {
		String sql = "SELECT `l_id`,`e_id`,`createTime`,`updateTime`,`reply`,`state`,`start`,`end`,`desc` FROM `hrms`.`t_leave`where  l_id = ?";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		Leave leave = null;
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			result = prepareStatement.executeQuery();

			while (result.next()) {
				leave = new Leave();
				leave.setlId(result.getInt(1));
				leave.seteId(result.getInt(2));
				leave.setCreateTime(new Date(result.getDate(3).getTime()));
				leave.setUpdateTime(new Date(result.getDate(4).getTime()));
				leave.setReply(result.getString(5));
				leave.setState(result.getInt(6));

				if (result.getDate(7) != null) {
					leave.setStart(result.getDate(7));
				}
				if (result.getDate(8) != null) {
					leave.setEnd(result.getDate(8));
				}
				leave.setDesc(result.getString(9));

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

		return leave;
	}

	@Override
	public List<Leave> getUserByEId(int eId) {
		String sql = "SELECT `l_id`,`e_id`,`createTime`,`updateTime`,`reply`,`state`,`start`,`end`,`desc` FROM `hrms`.`t_leave`where  e_id = ?";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		List<Leave> leaves = new ArrayList<>();
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			prepareStatement.setInt(1, eId);
			result = prepareStatement.executeQuery();

			while (result.next()) {
				Leave leave = new Leave();
				leave.setlId(result.getInt(1));
				leave.seteId(result.getInt(2));
				leave.setCreateTime(new Date(result.getDate(3).getTime()));
				leave.setUpdateTime(new Date(result.getDate(4).getTime()));
				leave.setReply(result.getString(5));
				leave.setState(result.getInt(6));

				if (result.getDate(7) != null) {
					leave.setStart(result.getDate(7));
				}
				if (result.getDate(8) != null) {
					leave.setEnd(result.getDate(8));
				}
				leave.setDesc(result.getString(9));
				leaves.add(leave);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JDBCUtil.close(result, connect);
		}

		return leaves;

	}

	@Override
	public Leave deleteLeaveById(int id) {
		String sql = "DELETE FROM `hrms`.`t_leave` WHERE `l_id` = ?";
		Connection connect = JDBCUtil.getConnect();
		Leave leaveById = findLeaveById(id);
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connect);
		}
		return leaveById;
	}

	@Override
	public boolean updateLeave(Leave leave) {

		String sql = "UPDATE `hrms`.`t_leave` SET  `e_id` = ?, `updateTime`=?,`reply`=?,`state`=?,`start`=?,`end`=?,`desc`=? WHERE `l_id` = ? ";
		Connection connect = JDBCUtil.getConnect();

		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, leave.geteId());
			statement.setTimestamp(2, new Timestamp(new Date().getTime()));
			Integer state = leave.getState();
			statement.setObject(3, leave.getReply());
			if (state != null) {
				statement.setInt(4, state);

			} else {
				statement.setInt(4, 0);
			}
			statement.setTimestamp(5, new Timestamp(leave.getStart().getTime()));
			statement.setTimestamp(6, new Timestamp(leave.getEnd().getTime()));
			statement.setObject(7, leave.getDesc());
			statement.setInt(8, leave.getlId());
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
	public boolean addLeave(Leave leave) {
		String sql = "INSERT INTO `hrms`.`t_leave` (`e_id`, `start`,`end`,`desc`) VALUES (?,?,?,?)";
		Connection connect = JDBCUtil.getConnect();

		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, leave.geteId());
			statement.setObject(2, DateUtil.getDate(leave.getStart()));
			statement.setObject(3, DateUtil.getDate(leave.getEnd()));
			statement.setObject(4, leave.getDesc());
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
	public List<Leave> getAll() {
		String sql = "SELECT `l_id`,`e_id`,`createTime`,`updateTime`,`reply`,`state`,`start`,`end`,`desc` FROM `hrms`.`t_leave`";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		List<Leave> leaves = new ArrayList<>();
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			result = prepareStatement.executeQuery();

			while (result.next()) {
				Leave leave = new Leave();
				leave.setlId(result.getInt(1));
				leave.seteId(result.getInt(2));
				leave.setCreateTime(new Date(result.getDate(3).getTime()));
				leave.setUpdateTime(new Date(result.getDate(4).getTime()));
				leave.setReply(result.getString(5));
				leave.setState(result.getInt(6));
				leave.setStart(result.getDate(7));
				leave.setEnd(result.getDate(8));
				leave.setDesc(result.getString(9));
				leaves.add(leave);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			JDBCUtil.close(result, connect);
		}
		return leaves;
	}

	@Override
	public List<Leave> getAllNoAdmint() {
		String sql = "SELECT `l_id`,`e_id`,`createTime`,`updateTime`,`reply`,`state`,`start`,`end`,`desc` FROM `hrms`.`t_leave`where `state`=0";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;
		List<Leave> leaves = new ArrayList<>();
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				Leave leave = new Leave();
				leave.setlId(result.getInt(1));
				leave.seteId(result.getInt(2));
				leave.setCreateTime(new Date(result.getDate(3).getTime()));
				leave.setUpdateTime(new Date(result.getDate(4).getTime()));
				leave.setReply(result.getString(5));
				leave.setState(result.getInt(6));

				if (result.getDate(7) != null) {
					leave.setStart(result.getDate(7));
				}
				if (result.getDate(8) != null) {
					leave.setEnd(result.getDate(8));
				}
				leave.setDesc(result.getString(9));
				leaves.add(leave);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			JDBCUtil.close(result, connect);
		}
		return leaves;
	}

	@Override
	public boolean replyLeave(Leave leave) {
		String sql = "UPDATE `hrms`.`t_leave` SET  `reply`=?,`state`=? WHERE `l_id` = ? ";
		Connection connect = JDBCUtil.getConnect();

		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(3, leave.getlId());
			statement.setInt(2, leave.getState());

			statement.setString(1, leave.getReply());
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
	public Leave getLastByEId(int eid) {
		String sql = "SELECT `l_id`,`e_id`,`createTime`,`updateTime`,`reply`,`state`,`start`,`end`,`desc`  FROM `t_leave` WHERE `e_id`=? AND `state`=1 ORDER BY `start` DESC LIMIT 1";
		Connection connect = JDBCUtil.getConnect();
		ResultSet result = null;		
		Leave leave = null;
		try {
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			prepareStatement.setInt(1, eid);
			result = prepareStatement.executeQuery();
			while (result.next()) {
				leave = new Leave();
				leave.setlId(result.getInt(1));
				leave.seteId(result.getInt(2));
				leave.setCreateTime(new Date(result.getDate(3).getTime()));
				leave.setUpdateTime(new Date(result.getDate(4).getTime()));
				leave.setReply(result.getString(5));
				leave.setState(result.getInt(6));

				if (result.getDate(7) != null) {
					leave.setStart(result.getDate(7));
				}
				if (result.getDate(8) != null) {
					leave.setEnd(result.getDate(8));
				}
				leave.setDesc(result.getString(9));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(result,connect);
		}
		return leave;
		
		
		
	
		
		
		
	}

}
