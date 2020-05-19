/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.su.stenata.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author evenchova
 */
@Entity
@Table(name = "sys_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUsers.findAll", query = "SELECT s FROM SysUsers s"),
    @NamedQuery(name = "SysUsers.findByUserName", query = "SELECT s FROM SysUsers s WHERE s.userName = :userName"),
    @NamedQuery(name = "SysUsers.findByPassword", query = "SELECT s FROM SysUsers s WHERE s.password = :password"),
    @NamedQuery(name = "SysUsers.findByEmail", query = "SELECT s FROM SysUsers s WHERE s.email = :email"),
    @NamedQuery(name = "SysUsers.findByCredits", query = "SELECT s FROM SysUsers s WHERE s.credits = :credits"),
    @NamedQuery(name = "SysUsers.findByPhoneNumber", query = "SELECT s FROM SysUsers s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "SysUsers.findByIsRegular", query = "SELECT s FROM SysUsers s WHERE s.isRegular = :isRegular"),
    @NamedQuery(name = "SysUsers.findByIsAdmin", query = "SELECT s FROM SysUsers s WHERE s.isAdmin = :isAdmin")})
public class SysUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sysUsers1")
    private SysUsers sysUsers;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SysUsers sysUsers1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<UserBooking> userBookingCollection;

    public SysUsers() {
    }

    public SysUsers(String userName) {
        this.userName = userName;
    }

    public SysUsers(String userName, String password, String email, BigInteger credits, String phoneNumber, Character isRegular, Character isAdmin) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.credits = credits;
        this.phoneNumber = phoneNumber;
        this.isRegular = isRegular;
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public SysUsers getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(SysUsers sysUsers) {
        this.sysUsers = sysUsers;
    }

    public SysUsers getSysUsers1() {
        return sysUsers1;
    }

    public void setSysUsers1(SysUsers sysUsers1) {
        this.sysUsers1 = sysUsers1;
    }

    @XmlTransient
    public Collection<UserBooking> getUserBookingCollection() {
        return userBookingCollection;
    }

    public void setUserBookingCollection(Collection<UserBooking> userBookingCollection) {
        this.userBookingCollection = userBookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysUsers)) {
            return false;
        }
        SysUsers other = (SysUsers) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.SysUsers[ userName=" + userName + " ]";
    }
    
}
