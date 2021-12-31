package com.hrms.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.hrms.entity.Dept;
import com.hrms.entity.Leave;
import com.hrms.entity.Salary;

public class EntityUtil {
	
	
	
	public static Dept resultToDept(ResultSet result) throws SQLException {
		Dept dept = new Dept();
		dept.setDeptId(result.getInt(1));
		dept.setDeptName(result.getString(2));
		dept.setpDept(result.getInt(3));
		dept.setDeptLocal(result.getString(4));
		dept.setCreateTime(new Date(result.getDate(5).getTime()));
		dept.setUpdateTime(new Date(result.getDate(6).getTime()));
		return dept;
		
	}
	public static Leave resultToLeave(ResultSet result) throws SQLException {
		Leave leave = new Leave();
		leave.setlId(result.getInt(1));
		leave.seteId(result.getInt(2));
		leave.setCreateTime(new Date(result.getDate(3).getTime()));
		leave.setUpdateTime(new Date(result.getDate(4).getTime()));
		leave.setReply(result.getString(5));
		leave.setState(result.getInt(6));
		leave.setStart(new Date(result.getDate(7).getTime()));
		leave.setEnd(new Date(result.getDate(7).getTime()));
		return leave;
		
	}
	
	public static Salary resultToSalary(ResultSet result) throws SQLException {
		Salary salary = new Salary();
		salary.seteId(result.getInt(1));
		salary.setsMonth(new Date(result.getDate(2).getTime()));
		salary.setsTime(new Date(result.getDate(3).getTime()));
		salary.setsAmount(result.getBigDecimal(4));
		return salary;
	}
//	e_id , e_name , e_gender , e_department , e_job , e_birthday, lead , passwd, phone, email ,createTime, updateTime
	 public static String getStringFromInputStream(InputStream inputStream) {
	        String resultData = null;      //需要返回的结果
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        byte[] data = new byte[1024];
	        int len = 0;
	        try {
	            while((len = inputStream.read(data)) != -1) {
	                byteArrayOutputStream.write(data, 0, len);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        resultData = new String("{"+ byteArrayOutputStream.toByteArray()+"}");    
	        return resultData;
	    }
}
