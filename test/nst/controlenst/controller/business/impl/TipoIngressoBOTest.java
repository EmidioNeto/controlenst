/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import nst.controlenst.model.entity.TipoIngresso;
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
public class TipoIngressoBOTest {
    
    public TipoIngressoBOTest() {
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
     * Test of save method, of class TipoIngressoBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        TipoIngresso objeto = new TipoIngresso();
        objeto.setDescricao("ashdsajkj");
        TipoIngressoBO instance = new TipoIngressoBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class TipoIngressoBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        TipoIngresso objeto = new TipoIngresso();
        objeto.setId(8);
        TipoIngressoBO instance = new TipoIngressoBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class TipoIngressoBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        TipoIngressoBO instance = new TipoIngressoBO();
        ArrayList expResult = null;
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
