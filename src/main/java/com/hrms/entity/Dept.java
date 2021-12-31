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

public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer deptId;

    private String deptName;

    private Integer status;

    private Integer pDept;

    /**
     * 部门地点
     */
    private String deptLocal;

    private Date createTime;

    private Date updateTime;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getpDept() {
        return pDept;
    }

    public void setpDept(Integer pDept) {
        this.pDept = pDept;
    }
    public String getDeptLocal() {
        return deptLocal;
    }

    public void setDeptLocal(String deptLocal) {
        this.deptLocal = deptLocal;
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
        return "Dept{" +
            "deptId=" + deptId +
            ", deptName=" + deptName +
            ", status=" + status +
            ", pDept=" + pDept +
            ", deptLocal=" + deptLocal +
            ", createTime=" + createTime +
            ", upDate=" + updateTime +
        "}";
    }
}
