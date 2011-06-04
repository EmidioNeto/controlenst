/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import nst.controlenst.model.entity.Cargo;
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
public class CargoBOTest {
    
    public CargoBOTest() {
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
     * Test of save method, of class CargoBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Cargo objeto = new Cargo();
        objeto.setDescricao("cargo1");
        CargoBO instance = new CargoBO();
        instance.save(objeto);
    }
    /**
     * Test of excluir method, of class CargoBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Cargo objeto = new Cargo();
        objeto.setId(2);
        CargoBO instance = new CargoBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class CargoBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        CargoBO instance = new CargoBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }

    
}
