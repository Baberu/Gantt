/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author baberu
 */
@Entity
@Table(name = "pro_baseball_task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProBaseballTask.findAll", query = "SELECT p FROM ProBaseballTask p")
    , @NamedQuery(name = "ProBaseballTask.findById", query = "SELECT p FROM ProBaseballTask p WHERE p.id = :id")
    , @NamedQuery(name = "ProBaseballTask.findByStartDatetime", query = "SELECT p FROM ProBaseballTask p WHERE p.startDatetime = :startDatetime")
    , @NamedQuery(name = "ProBaseballTask.findByRemarks", query = "SELECT p FROM ProBaseballTask p WHERE p.remarks = :remarks")
    , @NamedQuery(name = "ProBaseballTask.findTask", query = "SELECT p FROM ProBaseballTask p left join fetch p.proBaseballPlaceId left join fetch p.proBaseballHomeTeamId left join fetch p.proBaseballAwayTeamId")})
public class ProBaseballTask implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDatetime;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "pro_baseball_place_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProBaseballPlace proBaseballPlaceId;
    @JoinColumn(name = "pro_baseball_home_team_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProBaseballTeam proBaseballHomeTeamId;
    @JoinColumn(name = "pro_baseball_away_team_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProBaseballTeam proBaseballAwayTeamId;

    public ProBaseballTask() {
    }

    public ProBaseballTask(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ProBaseballPlace getProBaseballPlaceId() {
        return proBaseballPlaceId;
    }

    public void setProBaseballPlaceId(ProBaseballPlace proBaseballPlaceId) {
        this.proBaseballPlaceId = proBaseballPlaceId;
    }

    public ProBaseballTeam getProBaseballHomeTeamId() {
        return proBaseballHomeTeamId;
    }

    public void setProBaseballHomeTeamId(ProBaseballTeam proBaseballHomeTeamId) {
        this.proBaseballHomeTeamId = proBaseballHomeTeamId;
    }

    public ProBaseballTeam getProBaseballAwayTeamId() {
        return proBaseballAwayTeamId;
    }

    public void setProBaseballAwayTeamId(ProBaseballTeam proBaseballAwayTeamId) {
        this.proBaseballAwayTeamId = proBaseballAwayTeamId;
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
        if (!(object instanceof ProBaseballTask)) {
            return false;
        }
        ProBaseballTask other = (ProBaseballTask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.ProBaseballTask[ id=" + id + " ]";
    }
    
}
