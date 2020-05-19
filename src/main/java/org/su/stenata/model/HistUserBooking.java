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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author evenchova
 */
@Entity
@Table(name = "hist_user_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistUserBooking.findAll", query = "SELECT h FROM HistUserBooking h"),
    @NamedQuery(name = "HistUserBooking.findById", query = "SELECT h FROM HistUserBooking h WHERE h.histUserBookingPK.id = :id"),
    @NamedQuery(name = "HistUserBooking.findByUserName", query = "SELECT h FROM HistUserBooking h WHERE h.userName = :userName"),
    @NamedQuery(name = "HistUserBooking.findBySlotTimeId", query = "SELECT h FROM HistUserBooking h WHERE h.slotTimeId = :slotTimeId"),
    @NamedQuery(name = "HistUserBooking.findByType", query = "SELECT h FROM HistUserBooking h WHERE h.type = :type"),
    @NamedQuery(name = "HistUserBooking.findByBookDate", query = "SELECT h FROM HistUserBooking h WHERE h.bookDate = :bookDate"),
    @NamedQuery(name = "HistUserBooking.findByPrice", query = "SELECT h FROM HistUserBooking h WHERE h.price = :price"),
    @NamedQuery(name = "HistUserBooking.findByIsUser", query = "SELECT h FROM HistUserBooking h WHERE h.isUser = :isUser"),
    @NamedQuery(name = "HistUserBooking.findByOperation", query = "SELECT h FROM HistUserBooking h WHERE h.operation = :operation"),
    @NamedQuery(name = "HistUserBooking.findByOperationUser", query = "SELECT h FROM HistUserBooking h WHERE h.histUserBookingPK.operationUser = :operationUser"),
    @NamedQuery(name = "HistUserBooking.findByOperationTime", query = "SELECT h FROM HistUserBooking h WHERE h.histUserBookingPK.operationTime = :operationTime")})
public class HistUserBooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistUserBookingPK histUserBookingPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slot_time_id")
    private int slotTimeId;
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
    @Column(name = "is_user")
    private Character isUser;
    @Basic(optional = false)
    @NotNull
    private Character operation;

    public HistUserBooking() {
    }

    public HistUserBooking(HistUserBookingPK histUserBookingPK) {
        this.histUserBookingPK = histUserBookingPK;
    }

    public HistUserBooking(HistUserBookingPK histUserBookingPK, String userName, int slotTimeId, Character type, Date bookDate, Character isUser, Character operation) {
        this.histUserBookingPK = histUserBookingPK;
        this.userName = userName;
        this.slotTimeId = slotTimeId;
        this.type = type;
        this.bookDate = bookDate;
        this.isUser = isUser;
        this.operation = operation;
    }

    public HistUserBooking(int id, String operationUser, Date operationTime) {
        this.histUserBookingPK = new HistUserBookingPK(id, operationUser, operationTime);
    }

    public HistUserBookingPK getHistUserBookingPK() {
        return histUserBookingPK;
    }

    public void setHistUserBookingPK(HistUserBookingPK histUserBookingPK) {
        this.histUserBookingPK = histUserBookingPK;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSlotTimeId() {
        return slotTimeId;
    }

    public void setSlotTimeId(int slotTimeId) {
        this.slotTimeId = slotTimeId;
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

    public Character getIsUser() {
        return isUser;
    }

    public void setIsUser(Character isUser) {
        this.isUser = isUser;
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
        hash += (histUserBookingPK != null ? histUserBookingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistUserBooking)) {
            return false;
        }
        HistUserBooking other = (HistUserBooking) object;
        if ((this.histUserBookingPK == null && other.histUserBookingPK != null) || (this.histUserBookingPK != null && !this.histUserBookingPK.equals(other.histUserBookingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.HistUserBooking[ histUserBookingPK=" + histUserBookingPK + " ]";
    }
    
}
