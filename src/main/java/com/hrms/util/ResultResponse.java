package com.hrms.util;

import java.io.Serializable;

public class ResultResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String statusCode;
	private String desc;
	private Object obj;
	public ResultResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultResponse(String statusCode, String desc, Object obj) {
		super();
		this.statusCode = statusCode;
		this.desc = desc;
		this.obj = obj;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "ResultResponse [statusCode=" + statusCode + ", desc=" + desc + ", obj=" + obj + "]";
	}
	
	

}
