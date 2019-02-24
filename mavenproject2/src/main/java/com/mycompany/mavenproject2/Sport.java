/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author baberu
 */
@Entity
@Table(name = "sport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sport.findAll", query = "SELECT s FROM Sport s")
    , @NamedQuery(name = "Sport.findByIdsport", query = "SELECT s FROM Sport s WHERE s.idsport = :idsport")
    , @NamedQuery(name = "Sport.findBySportName", query = "SELECT s FROM Sport s WHERE s.sportName = :sportName")})
public class Sport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsport")
    private Integer idsport;
    @Size(max = 45)
    @Column(name = "sportName")
    private String sportName;

    public Sport() {
    }

    public Sport(Integer idsport) {
        this.idsport = idsport;
    }

    public Integer getIdsport() {
        return idsport;
    }

    public void setIdsport(Integer idsport) {
        this.idsport = idsport;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsport != null ? idsport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sport)) {
            return false;
        }
        Sport other = (Sport) object;
        if ((this.idsport == null && other.idsport != null) || (this.idsport != null && !this.idsport.equals(other.idsport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.Sport[ idsport=" + idsport + " ]";
    }
    
}
