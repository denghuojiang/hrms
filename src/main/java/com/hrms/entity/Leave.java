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

public class Leave implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 假条id
	 */
	private Integer lId;

	/**
	 * 员工id
	 */
	private Integer eId;

	/**
	 * 日期
	 */
	private Date createTime;

	private Date updateTime;
	
	private Date start;
	
	private Date end;
	
	private String desc;

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	/**
	 * 管理员回复
	 */
	private String reply;

	/**
	 * 是否批准
	 */
	private Integer state;

	public Integer getlId() {
		return lId;
	}

	public void setlId(Integer lId) {
		this.lId = lId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Leave [lId=" + lId + ", eId=" + eId + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", start=" + start + ", end=" + end + ", desc=" + desc + ", reply=" + reply + ", state=" + state
				+ "]";
	}

	
}
