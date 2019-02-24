/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author baberu
 */
@Entity
@Table(name = "pro_baseball_place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProBaseballPlace.findAll", query = "SELECT p FROM ProBaseballPlace p")
    , @NamedQuery(name = "ProBaseballPlace.findById", query = "SELECT p FROM ProBaseballPlace p WHERE p.id = :id")
    , @NamedQuery(name = "ProBaseballPlace.findByPlaceName", query = "SELECT p FROM ProBaseballPlace p WHERE p.placeName = :placeName")})
public class ProBaseballPlace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "place_name")
    private String placeName;
    @OneToMany(mappedBy = "proBaseballPlaceId", fetch = FetchType.LAZY)
    private List<ProBaseballTask> proBaseballTaskList;

    public ProBaseballPlace() {
    }

    public ProBaseballPlace(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @XmlTransient
    public List<ProBaseballTask> getProBaseballTaskList() {
        return proBaseballTaskList;
    }

    public void setProBaseballTaskList(List<ProBaseballTask> proBaseballTaskList) {
        this.proBaseballTaskList = proBaseballTaskList;
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
        if (!(object instanceof ProBaseballPlace)) {
            return false;
        }
        ProBaseballPlace other = (ProBaseballPlace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.ProBaseballPlace[ id=" + id + " ]";
    }
    
}
