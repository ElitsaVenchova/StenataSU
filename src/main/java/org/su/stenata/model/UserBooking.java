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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author evenchova
 */
@Entity
@Table(name = "user_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBooking.findAll", query = "SELECT u FROM UserBooking u"),
    @NamedQuery(name = "UserBooking.findById", query = "SELECT u FROM UserBooking u WHERE u.id = :id"),
    @NamedQuery(name = "UserBooking.findByType", query = "SELECT u FROM UserBooking u WHERE u.type = :type"),
    @NamedQuery(name = "UserBooking.findByBookDate", query = "SELECT u FROM UserBooking u WHERE u.bookDate = :bookDate"),
    @NamedQuery(name = "UserBooking.findByPrice", query = "SELECT u FROM UserBooking u WHERE u.price = :price"),
    @NamedQuery(name = "UserBooking.findByIsUsed", query = "SELECT u FROM UserBooking u WHERE u.isUsed = :isUsed")})
public class UserBooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    private Character type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_date")
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    private BigInteger price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_used")
    private Character isUsed;
    @JoinColumn(name = "slot_time_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NomSlotTimes slotTimeId;
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private SysUsers userName;

    public UserBooking() {
    }

    public UserBooking(Integer id) {
        this.id = id;
    }

    public UserBooking(Integer id, Character type, Date bookDate, Character isUsed) {
        this.id = id;
        this.type = type;
        this.bookDate = bookDate;
        this.isUsed = isUsed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Character getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Character isUsed) {
        this.isUsed = isUsed;
    }

    public NomSlotTimes getSlotTimeId() {
        return slotTimeId;
    }

    public void setSlotTimeId(NomSlotTimes slotTimeId) {
        this.slotTimeId = slotTimeId;
    }

    public SysUsers getUserName() {
        return userName;
    }

    public void setUserName(SysUsers userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBooking)) {
            return false;
        }
        UserBooking other = (UserBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.UserBooking[ id=" + id + " ]";
    }
    
}
