/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "pro_baseball_team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProBaseballTeam.findAll", query = "SELECT p FROM ProBaseballTeam p")
    , @NamedQuery(name = "ProBaseballTeam.findById", query = "SELECT p FROM ProBaseballTeam p WHERE p.id = :id")
    , @NamedQuery(name = "ProBaseballTeam.findByName", query = "SELECT p FROM ProBaseballTeam p WHERE p.name = :name")})
public class ProBaseballTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proBaseballHomeTeamId", fetch = FetchType.LAZY)
    private List<ProBaseballTask> proBaseballTaskList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proBaseballAwayTeamId", fetch = FetchType.LAZY)
    private List<ProBaseballTask> proBaseballTaskList1;

    public ProBaseballTeam() {
    }

    public ProBaseballTeam(Integer id) {
        this.id = id;
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

    @XmlTransient
    public List<ProBaseballTask> getProBaseballTaskList() {
        return proBaseballTaskList;
    }

    public void setProBaseballTaskList(List<ProBaseballTask> proBaseballTaskList) {
        this.proBaseballTaskList = proBaseballTaskList;
    }

    @XmlTransient
    public List<ProBaseballTask> getProBaseballTaskList1() {
        return proBaseballTaskList1;
    }

    public void setProBaseballTaskList1(List<ProBaseballTask> proBaseballTaskList1) {
        this.proBaseballTaskList1 = proBaseballTaskList1;
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
        if (!(object instanceof ProBaseballTeam)) {
            return false;
        }
        ProBaseballTeam other = (ProBaseballTeam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.ProBaseballTeam[ id=" + id + " ]";
    }
    
}
