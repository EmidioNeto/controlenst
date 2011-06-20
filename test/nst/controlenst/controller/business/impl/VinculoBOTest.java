/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import nst.controlenst.model.entity.Vinculo;
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
public class VinculoBOTest {
    
    public VinculoBOTest() {
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
     * Test of excluir method, of class VinculoBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Vinculo objeto = new Vinculo();
        objeto.setId(14);
        VinculoBO instance = new VinculoBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class VinculoBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        VinculoBO instance = new VinculoBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }

    /**
     * Test of save method, of class VinculoBO.
     */
    
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Vinculo objeto = new Vinculo();
        VinculoBO instance = new VinculoBO();
        objeto.setDescricao("teste");
        instance.save(objeto);
    }
}
