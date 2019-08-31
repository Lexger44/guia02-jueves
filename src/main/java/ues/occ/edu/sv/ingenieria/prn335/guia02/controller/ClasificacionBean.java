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
import javax.persistence.*;
import ues.occ.edu.sv.ingenieria.prn335.guia02.jueves.Clasificacion;

/**
 *
 * @author mauricio
 */
public class ClasificacionBean {

    protected EntityManager em;
    final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("cinePU");

    public void iniciarEm() {
        this.em = EMF.createEntityManager();
    }

    public EntityTransaction getTx() {
        if (this.em != null) {
            return this.em.getTransaction();
        }
        return null;
    }

    public void crear(Clasificacion r) {
        EntityTransaction tx = this.getTx();
        tx.begin();
        this.em.persist(r);
        tx.commit();

    }

    public void modificar(Clasificacion r) {

        EntityTransaction tx = this.getTx();
        tx.begin();
        em.merge(r);
        tx.commit();

    }

    public String clasificacionPorDescripcion(String clasificacion) {
        String descripcion = "";
        String cadena = "";
        if (clasificacion == "A") {
            String clasifica = "familiares";
            String escenas = "comedia";
            String publico = "todo publico";
            descripcion = "Clasifica las películas " + clasifica + " y que contengan escenas de " + escenas + " se considera que puede ser vista por " + publico;

            return descripcion;
        } else if (clasificacion == "B") {
            String clasifica = "de ficcion";
            String escenas = "accion";
            String publico = "mayores de 12 años";
            descripcion = "Clasifica las películas " + clasifica + " y que contengan escenas de " + escenas + " se considera que puede ser vista por " + publico;
            return descripcion;
        } else if (clasificacion == "C") {
            String clasifica = "de terror";
            String escenas = "violencia";
            String publico = "mayores de 15 años";
            descripcion = "Clasifica las películas " + clasifica + " y que contengan escenas de " + escenas + " se considera que puede ser vista por " + publico;
            return descripcion;
        } else {
            return "Clasificacion no encontrada";
        }
    }
}
