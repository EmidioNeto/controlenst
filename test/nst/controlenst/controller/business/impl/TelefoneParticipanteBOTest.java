/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import nst.controlenst.model.entity.TelefoneParticipante;
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
public class TelefoneParticipanteBOTest {
    
    public TelefoneParticipanteBOTest() {
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
     * Test of save method, of class TelefoneParticipanteBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        TelefoneParticipante objeto = new TelefoneParticipante();
        objeto.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(7));
        objeto.setDdd("adj");
        objeto.setTelefone("asdsad");
        TelefoneParticipanteBO instance = new TelefoneParticipanteBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class TelefoneParticipanteBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        TelefoneParticipante objeto = new TelefoneParticipante();
        objeto.setId(8);
        TelefoneParticipanteBO instance = new TelefoneParticipanteBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class TelefoneParticipanteBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        TelefoneParticipanteBO instance = new TelefoneParticipanteBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
