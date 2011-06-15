/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import nst.controlenst.model.entity.Curso;
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
public class CursoBOTest {
    
    public CursoBOTest() {
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
     * Test of save method, of class CursoBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Curso objeto = new Curso();
        objeto.setDescricao("Teste de BO 1");
        CursoBO instance = new CursoBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class CursoBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Curso objeto = new Curso();
        objeto.setId(9);
        CursoBO instance = new CursoBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class CursoBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        CursoBO instance = new CursoBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
