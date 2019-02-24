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
public class ProBaseballTaskFacade extends AbstractFacade<ProBaseballTask> {

    @PersistenceContext(unitName = "com.mycompany_mavenproject2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProBaseballTaskFacade() {
        super(ProBaseballTask.class);
    }
    
    
    public List<ProBaseballTask> sportFindTask(){
        TypedQuery<ProBaseballTask> q = em.createNamedQuery("ProBaseballTask.findTask", ProBaseballTask.class);
        return q.getResultList();
    }
}
