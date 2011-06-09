/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import nst.controlenst.model.entity.Coordenador;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablosouza
 */
public class CoordenadorBOTest {

    public CoordenadorBOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class CoordenadorBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Coordenador objeto = new Coordenador();
        objeto.setNome("Pablo mais um teste");
        CoordenadorBO instance = new CoordenadorBO();
        instance.save(objeto);
    }

    /**
     * Test of listar method, of class CoordenadorBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        CoordenadorBO instance = new CoordenadorBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }

    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Coordenador objeto = new Coordenador();
        
        /*
         * Coordenador que possui registro vinculado
         */
        //objeto.setId(7);
        
        /*
         * Coordenador que nao possui registro vinculado.
         */
        objeto.setId(1);
        CoordenadorBO instance = new CoordenadorBO();
        instance.excluir(objeto);
    }
}
