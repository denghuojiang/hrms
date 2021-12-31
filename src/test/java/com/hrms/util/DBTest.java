package com.hrms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class DBTest {
	
	@Test
	public void getConnect() {
		Connection connect = JDBCUtil.getConnect();
		System.out.println(connect);
		JDBCUtil.close(connect);
	}
	@Test
	public void addTime() throws SQLException {
		String date = DateUtil.getNowYearAndMonth();
		System.out.println(date);
		Connection connect = JDBCUtil.getConnect();
//		String sql = "INSERT INTO `hrms`.`t_attendance` (`e_id`, `a_month`, `amount`) VALUES ('1', ?, '1')";
		String sql1 = "insert into `hrms`.`t_attendance` (`e_id`, `a_month`, `amount`)  values('1', '2021-12-01', '1') on  DUPLICATE key update amount=amount+values(amount)";
		PreparedStatement statement = connect.prepareStatement(sql1);
//		statement.setString(1, date);
		statement.execute();
		System.out.println("end");
		
	}

}
