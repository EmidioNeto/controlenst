/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import nst.controlenst.model.entity.Situacao;
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
public class SituacaoBOTest {
    
    public SituacaoBOTest() {
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
     * Test of save method, of class SituacaoBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Situacao objeto = new Situacao();
        objeto.setDescricao("Teste");
        SituacaoBO instance = new SituacaoBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class SituacaoBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Situacao objeto = new Situacao();
        objeto.setId(10);
        SituacaoBO instance = new SituacaoBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class SituacaoBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        SituacaoBO instance = new SituacaoBO();
        
        ArrayList result = instance.listar();
        assertNotNull(result);
        
        
    }
}
