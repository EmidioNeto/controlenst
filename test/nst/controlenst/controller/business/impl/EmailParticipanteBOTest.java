/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import nst.controlenst.model.entity.EmailParticipante;
import java.util.ArrayList;
import nst.controlenst.persistence.dao.obj.impl.JDBCParticipante;
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
public class EmailParticipanteBOTest {
    
    public EmailParticipanteBOTest() {
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
     * Test of save method, of class EmailParticipanteBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        EmailParticipante objeto = new EmailParticipante();
        objeto.setDescricao("teste@teste.com.br");
        objeto.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(3));
        EmailParticipanteBO instance = new EmailParticipanteBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class EmailParticipanteBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        EmailParticipante objeto = new EmailParticipante();
        objeto.setId(4);
        EmailParticipanteBO instance = new EmailParticipanteBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class EmailParticipanteBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        EmailParticipanteBO instance = new EmailParticipanteBO();
        ArrayList expResult = null;
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
