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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer eId;

    private String eName;

    private String eGender;

    /**
     * 部门id
     */
    private Integer eDepartment;

    /**
     * 职位
     */
    private String eJob;

    private Date eBirthday;

    /**
     * 是否是领导
     */
    private Integer lead;

    private String passwd;

    private Date createTime;

    private Date updateTime;

    private String phone;
    
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String email;
    
    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
    public String geteGender() {
        return eGender;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender;
    }
    public Integer geteDepartment() {
        return eDepartment;
    }

    public void seteDepartment(Integer eDepartment) {
        this.eDepartment = eDepartment;
    }
    public String geteJob() {
        return eJob;
    }

    public void seteJob(String eJob) {
        this.eJob = eJob;
    }
    public Date geteBirthday() {
        return eBirthday;
    }

    public void seteBirthday(Date eBirthday) {
        this.eBirthday = eBirthday;
    }
    public Integer getLead() {
        return lead;
    }

    public void setLead(Integer lead) {
        this.lead = lead;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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

    @Override
    public String toString() {
        return "User{" +
            "eId=" + eId +
            ", eName=" + eName +
            ", eGender=" + eGender +
            ", eDepartment=" + eDepartment +
            ", eJob=" + eJob +
            ", eBirthday=" + eBirthday +
            ", lead=" + lead +
            ", passwd=" + passwd +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
