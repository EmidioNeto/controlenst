/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import nst.controlenst.model.entity.Participante;
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
public class ParticipanteBOTest {
    
    public ParticipanteBOTest() {
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
     * Test of save method, of class ParticipanteBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Participante objeto = new Participante();
        objeto.setMatricula("123456789012");
        objeto.setNome("123456789012");
        ParticipanteBO instance = new ParticipanteBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class ParticipanteBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Participante objeto = new Participante();
        objeto.setId(3);
        ParticipanteBO instance = new ParticipanteBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class ParticipanteBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        ParticipanteBO instance = new ParticipanteBO();
        ArrayList expResult = null;
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
