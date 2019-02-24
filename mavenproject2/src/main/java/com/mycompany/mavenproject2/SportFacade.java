/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author baberu
 */
@Stateless
public class SportFacade extends AbstractFacade<Sport> {

    @PersistenceContext(unitName = "com.mycompany_mavenproject2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SportFacade() {
        super(Sport.class);
    }
    
    public List<Sport> sportFindAll(){
        TypedQuery<Sport> q = em.createNamedQuery("Sport.findAll", Sport.class);
        return q.getResultList();
    }
    
}
