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
@Table(name = "hist_nom_slot_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistNomSlotCategories.findAll", query = "SELECT h FROM HistNomSlotCategories h"),
    @NamedQuery(name = "HistNomSlotCategories.findById", query = "SELECT h FROM HistNomSlotCategories h WHERE h.histNomSlotCategoriesPK.id = :id"),
    @NamedQuery(name = "HistNomSlotCategories.findByName", query = "SELECT h FROM HistNomSlotCategories h WHERE h.name = :name"),
    @NamedQuery(name = "HistNomSlotCategories.findByDuration", query = "SELECT h FROM HistNomSlotCategories h WHERE h.duration = :duration"),
    @NamedQuery(name = "HistNomSlotCategories.findByOperation", query = "SELECT h FROM HistNomSlotCategories h WHERE h.operation = :operation"),
    @NamedQuery(name = "HistNomSlotCategories.findByOperationUser", query = "SELECT h FROM HistNomSlotCategories h WHERE h.histNomSlotCategoriesPK.operationUser = :operationUser"),
    @NamedQuery(name = "HistNomSlotCategories.findByOperationTime", query = "SELECT h FROM HistNomSlotCategories h WHERE h.histNomSlotCategoriesPK.operationTime = :operationTime")})
public class HistNomSlotCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistNomSlotCategoriesPK histNomSlotCategoriesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String name;
    @Basic(optional = false)
    @NotNull
    private BigInteger duration;
    @Basic(optional = false)
    @NotNull
    private Character operation;

    public HistNomSlotCategories() {
    }

    public HistNomSlotCategories(HistNomSlotCategoriesPK histNomSlotCategoriesPK) {
        this.histNomSlotCategoriesPK = histNomSlotCategoriesPK;
    }

    public HistNomSlotCategories(HistNomSlotCategoriesPK histNomSlotCategoriesPK, String name, BigInteger duration, Character operation) {
        this.histNomSlotCategoriesPK = histNomSlotCategoriesPK;
        this.name = name;
        this.duration = duration;
        this.operation = operation;
    }

    public HistNomSlotCategories(int id, String operationUser, Date operationTime) {
        this.histNomSlotCategoriesPK = new HistNomSlotCategoriesPK(id, operationUser, operationTime);
    }

    public HistNomSlotCategoriesPK getHistNomSlotCategoriesPK() {
        return histNomSlotCategoriesPK;
    }

    public void setHistNomSlotCategoriesPK(HistNomSlotCategoriesPK histNomSlotCategoriesPK) {
        this.histNomSlotCategoriesPK = histNomSlotCategoriesPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
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
        hash += (histNomSlotCategoriesPK != null ? histNomSlotCategoriesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistNomSlotCategories)) {
            return false;
        }
        HistNomSlotCategories other = (HistNomSlotCategories) object;
        if ((this.histNomSlotCategoriesPK == null && other.histNomSlotCategoriesPK != null) || (this.histNomSlotCategoriesPK != null && !this.histNomSlotCategoriesPK.equals(other.histNomSlotCategoriesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.HistNomSlotCategories[ histNomSlotCategoriesPK=" + histNomSlotCategoriesPK + " ]";
    }
    
}
