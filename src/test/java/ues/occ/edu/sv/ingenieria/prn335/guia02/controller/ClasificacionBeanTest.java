/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.guia02.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.ingenieria.prn335.guia02.jueves.Clasificacion;

/**
 *
 * @author mauricio
 */
@ExtendWith(MockitoExtension.class)
public class ClasificacionBeanTest {

    public ClasificacionBeanTest() {

    }

    @Test
    public void crearTest() throws Exception {
        System.out.println("crear");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);

        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        ClasificacionBean cut = new ClasificacionBean();
        cut.em = mockEM;
        Clasificacion r = new Clasificacion();
        r.setClasificacion("A");
        r.setDescripcion("Familiar");
        r.setIdClasificacion(1);
        cut.crear(r);
        Mockito.verify(mockEM, Mockito.times(1)).persist(Mockito.any());
    }

    @Test
    public void modificarClasificacionTest() throws Exception {
        System.out.println("modificarClasificacion");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        Clasificacion r = new Clasificacion();
        ClasificacionBean cut = new ClasificacionBean();
        cut.em = mockEM;
        r.setClasificacion("A");
        r.setDescripcion("familiares, comedia, todo público");
        cut.crear(r);
        System.out.println(r.getClasificacion() + "\n" + r.getDescripcion());
        r.setClasificacion("B");
        r.setDescripcion("de ficcion, accion, mayores 12 años");
        cut.modificar(r);
        Mockito.verify(mockEM, Mockito.times(1)).persist(Mockito.any());
        System.out.println(r.getClasificacion() + "\n" + r.getDescripcion());
//        fail("la hora sad :"v");
    }

    @Test
    public void clasificacionPorDescripcion() throws Exception {
        System.out.println("clasificacionPorDescripcion");
        ClasificacionBean cut = new ClasificacionBean();
        String cadena = "alguna descripcion";
        cadena=cut.clasificacionPorDescripcion("A");
        assertEquals(cadena, "Clasifica las películas familiares y que contengan escenas de comedia se considera que puede ser vista por todo publico");
//        fail("esta vaina no funciona");

//        cadena=cut.clasificacionPorDescripcion("B");
//        assertEquals(cadena, "Clasifica las películas de ficcion y que contengan escenas de accion se considera que puede ser vista por mayores de 12 años");
//
//        cadena = cut.clasificacionPorDescripcion("C");
//        assertEquals(cadena, "Clasifica las películas de terror y que contengan escenas de violencia se considera que puede ser vista por mayores de 15 años");
    }
}
