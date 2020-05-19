/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.su.stenata.model;

import java.io.Serializable;
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
@Table(name = "hist_nom_zones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistNomZones.findAll", query = "SELECT h FROM HistNomZones h"),
    @NamedQuery(name = "HistNomZones.findById", query = "SELECT h FROM HistNomZones h WHERE h.histNomZonesPK.id = :id"),
    @NamedQuery(name = "HistNomZones.findByName", query = "SELECT h FROM HistNomZones h WHERE h.name = :name"),
    @NamedQuery(name = "HistNomZones.findByDescription", query = "SELECT h FROM HistNomZones h WHERE h.description = :description"),
    @NamedQuery(name = "HistNomZones.findByOperation", query = "SELECT h FROM HistNomZones h WHERE h.operation = :operation"),
    @NamedQuery(name = "HistNomZones.findByOperationUser", query = "SELECT h FROM HistNomZones h WHERE h.histNomZonesPK.operationUser = :operationUser"),
    @NamedQuery(name = "HistNomZones.findByOperationTime", query = "SELECT h FROM HistNomZones h WHERE h.histNomZonesPK.operationTime = :operationTime")})
public class HistNomZones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistNomZonesPK histNomZonesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    private String description;
    @Basic(optional = false)
    @NotNull
    private Character operation;

    public HistNomZones() {
    }

    public HistNomZones(HistNomZonesPK histNomZonesPK) {
        this.histNomZonesPK = histNomZonesPK;
    }

    public HistNomZones(HistNomZonesPK histNomZonesPK, String name, String description, Character operation) {
        this.histNomZonesPK = histNomZonesPK;
        this.name = name;
        this.description = description;
        this.operation = operation;
    }

    public HistNomZones(int id, String operationUser, Date operationTime) {
        this.histNomZonesPK = new HistNomZonesPK(id, operationUser, operationTime);
    }

    public HistNomZonesPK getHistNomZonesPK() {
        return histNomZonesPK;
    }

    public void setHistNomZonesPK(HistNomZonesPK histNomZonesPK) {
        this.histNomZonesPK = histNomZonesPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (histNomZonesPK != null ? histNomZonesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistNomZones)) {
            return false;
        }
        HistNomZones other = (HistNomZones) object;
        if ((this.histNomZonesPK == null && other.histNomZonesPK != null) || (this.histNomZonesPK != null && !this.histNomZonesPK.equals(other.histNomZonesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.HistNomZones[ histNomZonesPK=" + histNomZonesPK + " ]";
    }
    
}
