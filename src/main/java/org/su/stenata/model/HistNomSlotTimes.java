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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "hist_nom_slot_times")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistNomSlotTimes.findAll", query = "SELECT h FROM HistNomSlotTimes h"),
    @NamedQuery(name = "HistNomSlotTimes.findById", query = "SELECT h FROM HistNomSlotTimes h WHERE h.histNomSlotTimesPK.id = :id"),
    @NamedQuery(name = "HistNomSlotTimes.findByCategoryId", query = "SELECT h FROM HistNomSlotTimes h WHERE h.categoryId = :categoryId"),
    @NamedQuery(name = "HistNomSlotTimes.findByStartTime", query = "SELECT h FROM HistNomSlotTimes h WHERE h.startTime = :startTime"),
    @NamedQuery(name = "HistNomSlotTimes.findByIsForRegularUsers", query = "SELECT h FROM HistNomSlotTimes h WHERE h.isForRegularUsers = :isForRegularUsers"),
    @NamedQuery(name = "HistNomSlotTimes.findByOperation", query = "SELECT h FROM HistNomSlotTimes h WHERE h.operation = :operation"),
    @NamedQuery(name = "HistNomSlotTimes.findByOperationUser", query = "SELECT h FROM HistNomSlotTimes h WHERE h.histNomSlotTimesPK.operationUser = :operationUser"),
    @NamedQuery(name = "HistNomSlotTimes.findByOperationTime", query = "SELECT h FROM HistNomSlotTimes h WHERE h.histNomSlotTimesPK.operationTime = :operationTime")})
public class HistNomSlotTimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistNomSlotTimesPK histNomSlotTimesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_for_regular_users")
    private Character isForRegularUsers;
    @Basic(optional = false)
    @NotNull
    private Character operation;

    public HistNomSlotTimes() {
    }

    public HistNomSlotTimes(HistNomSlotTimesPK histNomSlotTimesPK) {
        this.histNomSlotTimesPK = histNomSlotTimesPK;
    }

    public HistNomSlotTimes(HistNomSlotTimesPK histNomSlotTimesPK, int categoryId, Date startTime, Character isForRegularUsers, Character operation) {
        this.histNomSlotTimesPK = histNomSlotTimesPK;
        this.categoryId = categoryId;
        this.startTime = startTime;
        this.isForRegularUsers = isForRegularUsers;
        this.operation = operation;
    }

    public HistNomSlotTimes(int id, String operationUser, Date operationTime) {
        this.histNomSlotTimesPK = new HistNomSlotTimesPK(id, operationUser, operationTime);
    }

    public HistNomSlotTimesPK getHistNomSlotTimesPK() {
        return histNomSlotTimesPK;
    }

    public void setHistNomSlotTimesPK(HistNomSlotTimesPK histNomSlotTimesPK) {
        this.histNomSlotTimesPK = histNomSlotTimesPK;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Character getIsForRegularUsers() {
        return isForRegularUsers;
    }

    public void setIsForRegularUsers(Character isForRegularUsers) {
        this.isForRegularUsers = isForRegularUsers;
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
        hash += (histNomSlotTimesPK != null ? histNomSlotTimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistNomSlotTimes)) {
            return false;
        }
        HistNomSlotTimes other = (HistNomSlotTimes) object;
        if ((this.histNomSlotTimesPK == null && other.histNomSlotTimesPK != null) || (this.histNomSlotTimesPK != null && !this.histNomSlotTimesPK.equals(other.histNomSlotTimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.HistNomSlotTimes[ histNomSlotTimesPK=" + histNomSlotTimesPK + " ]";
    }
    
}
