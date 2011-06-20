/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import nst.controlenst.model.entity.MotivoSaida;
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
public class MotivoSaidaBOTest {
    
    public MotivoSaidaBOTest() {
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
     * Test of save method, of class MotivoSaidaBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        MotivoSaida objeto = new MotivoSaida();
        objeto.setDescricao("Teste 1");
        MotivoSaidaBO instance = new MotivoSaidaBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class MotivoSaidaBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        MotivoSaida objeto = new MotivoSaida();
        objeto.setId(6);
        MotivoSaidaBO instance = new MotivoSaidaBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class MotivoSaidaBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        MotivoSaidaBO instance = new MotivoSaidaBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
