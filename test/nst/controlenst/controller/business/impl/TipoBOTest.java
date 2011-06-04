/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nst.controlenst.controller.business.exception.BusinessExceptions;
import nst.controlenst.model.entity.Tipo;
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
public class TipoBOTest {
    
    public TipoBOTest() {
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
     * Test of adcionar method, of class TipoBO.
     */
    @Test
    public void testAdcionar() {
        System.out.println("adcionar");
        Tipo objeto = new Tipo();
        objeto.setDescricao("Testanso mais uma vez");
        TipoBO instance = new TipoBO();
        try {
            instance.save(objeto);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(TipoBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of excluir method, of class TipoBO.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        Tipo objeto = new Tipo();
        objeto.setId(1);
        TipoBO instance = new TipoBO();
        try {
            instance.excluir(objeto);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(TipoBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of alterar method, of class TipoBO.
     */
    @Test
    public void testAlterar() throws BusinessExceptions {
        System.out.println("alterar");
        Tipo objeto = new Tipo();
        objeto.setDescricao("estando");
        objeto.setId(6);
        TipoBO instance = new TipoBO();
        instance.save(objeto);
    }

    /**
     * Test of listar method, of class TipoBO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        TipoBO instance = new TipoBO();
        
        ArrayList result = null;
        try {
            result = instance.listar();
        } catch (BusinessExceptions ex) {
            Logger.getLogger(TipoBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(result);
    }
}
