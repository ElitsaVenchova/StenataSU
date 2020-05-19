/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.su.stenata.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author evenchova
 */
@Entity
@Table(name = "hist_sys_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistSysUsers.findAll", query = "SELECT h FROM HistSysUsers h"),
    @NamedQuery(name = "HistSysUsers.findByUserName", query = "SELECT h FROM HistSysUsers h WHERE h.histSysUsersPK.userName = :userName"),
    @NamedQuery(name = "HistSysUsers.findByPassword", query = "SELECT h FROM HistSysUsers h WHERE h.password = :password"),
    @NamedQuery(name = "HistSysUsers.findByEmail", query = "SELECT h FROM HistSysUsers h WHERE h.email = :email"),
    @NamedQuery(name = "HistSysUsers.findByCredits", query = "SELECT h FROM HistSysUsers h WHERE h.credits = :credits"),
    @NamedQuery(name = "HistSysUsers.findByPhoneNumber", query = "SELECT h FROM HistSysUsers h WHERE h.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "HistSysUsers.findByIsRegular", query = "SELECT h FROM HistSysUsers h WHERE h.isRegular = :isRegular"),
    @NamedQuery(name = "HistSysUsers.findByIsAdmin", query = "SELECT h FROM HistSysUsers h WHERE h.isAdmin = :isAdmin"),
    @NamedQuery(name = "HistSysUsers.findByOperation", query = "SELECT h FROM HistSysUsers h WHERE h.operation = :operation"),
    @NamedQuery(name = "HistSysUsers.findByOperationUser", query = "SELECT h FROM HistSysUsers h WHERE h.histSysUsersPK.operationUser = :operationUser"),
    @NamedQuery(name = "HistSysUsers.findByOperationTime", query = "SELECT h FROM HistSysUsers h WHERE h.histSysUsersPK.operationTime = :operationTime")})
public class HistSysUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistSysUsersPK histSysUsersPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    private String email;
    @Basic(optional = false)
    @NotNull
    private BigInteger credits;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_regular")
    private Character isRegular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_admin")
    private Character isAdmin;
    @Basic(optional = false)
    @NotNull
    private Character operation;

    public HistSysUsers() {
    }

    public HistSysUsers(HistSysUsersPK histSysUsersPK) {
        this.histSysUsersPK = histSysUsersPK;
    }

    public HistSysUsers(HistSysUsersPK histSysUsersPK, String password, String email, BigInteger credits, String phoneNumber, Character isRegular, Character isAdmin, Character operation) {
        this.histSysUsersPK = histSysUsersPK;
        this.password = password;
        this.email = email;
        this.credits = credits;
        this.phoneNumber = phoneNumber;
        this.isRegular = isRegular;
        this.isAdmin = isAdmin;
        this.operation = operation;
    }

    public HistSysUsers(String userName, String operationUser, Date operationTime) {
        this.histSysUsersPK = new HistSysUsersPK(userName, operationUser, operationTime);
    }

    public HistSysUsersPK getHistSysUsersPK() {
        return histSysUsersPK;
    }

    public void setHistSysUsersPK(HistSysUsersPK histSysUsersPK) {
        this.histSysUsersPK = histSysUsersPK;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getCredits() {
        return credits;
    }

    public void setCredits(BigInteger credits) {
        this.credits = credits;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Character getIsRegular() {
        return isRegular;
    }

    public void setIsRegular(Character isRegular) {
        this.isRegular = isRegular;
    }

    public Character getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Character isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Character getOperation() {
        return operation;
    }

    public void setOperation(Character operation) {
        this.operation = operation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (histSysUsersPK != null ? histSysUsersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistSysUsers)) {
            return false;
        }
        HistSysUsers other = (HistSysUsers) object;
        if ((this.histSysUsersPK == null && other.histSysUsersPK != null) || (this.histSysUsersPK != null && !this.histSysUsersPK.equals(other.histSysUsersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.HistSysUsers[ histSysUsersPK=" + histSysUsersPK + " ]";
    }
    
}
