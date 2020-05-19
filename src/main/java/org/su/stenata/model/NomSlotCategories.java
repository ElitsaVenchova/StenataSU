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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "nom_slot_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NomSlotCategories.findAll", query = "SELECT n FROM NomSlotCategories n"),
    @NamedQuery(name = "NomSlotCategories.findById", query = "SELECT n FROM NomSlotCategories n WHERE n.id = :id"),
    @NamedQuery(name = "NomSlotCategories.findByName", query = "SELECT n FROM NomSlotCategories n WHERE n.name = :name"),
    @NamedQuery(name = "NomSlotCategories.findByDuration", query = "SELECT n FROM NomSlotCategories n WHERE n.duration = :duration")})
public class NomSlotCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    private BigInteger duration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<NomSlotTimes> nomSlotTimesCollection;

    public NomSlotCategories() {
    }

    public NomSlotCategories(Integer id) {
        this.id = id;
    }

    public NomSlotCategories(Integer id, String name, BigInteger duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @XmlTransient
    public Collection<NomSlotTimes> getNomSlotTimesCollection() {
        return nomSlotTimesCollection;
    }

    public void setNomSlotTimesCollection(Collection<NomSlotTimes> nomSlotTimesCollection) {
        this.nomSlotTimesCollection = nomSlotTimesCollection;
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
        if (!(object instanceof NomSlotCategories)) {
            return false;
        }
        NomSlotCategories other = (NomSlotCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.su.stenata.model.NomSlotCategories[ id=" + id + " ]";
    }
    
}
