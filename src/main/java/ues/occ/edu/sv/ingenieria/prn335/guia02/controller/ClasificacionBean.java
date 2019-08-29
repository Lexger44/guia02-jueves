/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.guia02.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.ingenieria.prn335.guia02.jueves.Clasificacion;

/**
 *
 * @author mauricio
 */
public class ClasificacionBean {

    protected EntityManager em;

    public void crear(Clasificacion r) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinePU");
        this.em = emf.createEntityManager();
        EntityTransaction tx = this.em.getTransaction();

        tx.commit();

    }
}
