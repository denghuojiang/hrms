package com.hrms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author denghuo
 * @since 2021-12-24
 */
public class Attendance implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer eId;

	/**
	 * 年月份
	 */
	private Date aMonth;

	/**
	 * 出勤天数
	 */
	private Integer amount;

	private Date createTime;

	private Date upDate;

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public Date getaMonth() {
		return aMonth;
	}

	public void setaMonth(Date aMonth) {
		this.aMonth = aMonth;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	@Override
	public String toString() {
		return "Attendance{" + "eId=" + eId + ", aMonth=" + aMonth + ", amount=" + amount + ", createTime=" + createTime
				+ ", upDate=" + upDate + "}";
	}
}
