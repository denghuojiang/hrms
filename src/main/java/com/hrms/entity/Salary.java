package com.hrms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author denghuo
 * @since 2021-12-24
 */
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date sMonth;

    private Integer eId;

    private Date sTime;

    private BigDecimal sAmount;

	public Date getsMonth() {
		return sMonth;
	}

	public void setsMonth(Date sMonth) {
		this.sMonth = sMonth;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public Date getsTime() {
		return sTime;
	}

	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}

	public BigDecimal getsAmount() {
		return sAmount;
	}

	public void setsAmount(BigDecimal sAmount) {
		this.sAmount = sAmount;
	}

	@Override
	public String toString() {
		return "Salary [sMonth=" + sMonth + ", eId=" + eId + ", sTime=" + sTime + ", sAmount=" + sAmount + "]";
	}


  
}
