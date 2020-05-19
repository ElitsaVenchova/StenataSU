/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.su.stenata.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author evenchova
 */
@Embeddable
public class HistSysUsersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "operation_user")
    private String operationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationTime;

    public HistSysUsersPK() {
    }

    public HistSysUsersPK(String userName, String operationUser, Date operationTime) {
        this.userName = userName;
        this.operationUser = operationUser;
        this.operationTime = operationTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        hash += (operationUser != null ? operationUser.hashCode() : 0);
        hash += (operationTime != null ? operationTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistSysUsersPK)) {
            return false;
        }
        HistSysUsersPK other = (HistSysUsersPK) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        if ((this.operationUser == null && other.operationUser != null) || (this.operationUser != null && !this.operationUser.equals(other.operationUser))) {
            return false;
        }
        if ((this.operationTime == null && other.operationTime != null) || (this.operationTime != null && !this.operationTime.equals(other.operationTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.HistSysUsersPK[ userName=" + userName + ", operationUser=" + operationUser + ", operationTime=" + operationTime + " ]";
    }
    
}
