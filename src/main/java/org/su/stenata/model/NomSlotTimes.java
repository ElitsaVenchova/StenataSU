/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.su.stenata.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author evenchova
 */
@Entity
@Table(name = "nom_slot_times")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NomSlotTimes.findAll", query = "SELECT n FROM NomSlotTimes n"),
    @NamedQuery(name = "NomSlotTimes.findById", query = "SELECT n FROM NomSlotTimes n WHERE n.id = :id"),
    @NamedQuery(name = "NomSlotTimes.findByStartTime", query = "SELECT n FROM NomSlotTimes n WHERE n.startTime = :startTime"),
    @NamedQuery(name = "NomSlotTimes.findByIsForRegularUsers", query = "SELECT n FROM NomSlotTimes n WHERE n.isForRegularUsers = :isForRegularUsers")})
public class NomSlotTimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_for_regular_users")
    private Character isForRegularUsers;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NomSlotCategories categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "slotTimeId")
    private Collection<UserBooking> userBookingCollection;

    public NomSlotTimes() {
    }

    public NomSlotTimes(Integer id) {
        this.id = id;
    }

    public NomSlotTimes(Integer id, Date startTime, Character isForRegularUsers) {
        this.id = id;
        this.startTime = startTime;
        this.isForRegularUsers = isForRegularUsers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public NomSlotCategories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(NomSlotCategories categoryId) {
        this.categoryId = categoryId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomSlotTimes)) {
            return false;
        }
        NomSlotTimes other = (NomSlotTimes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.NomSlotTimes[ id=" + id + " ]";
    }
    
}
