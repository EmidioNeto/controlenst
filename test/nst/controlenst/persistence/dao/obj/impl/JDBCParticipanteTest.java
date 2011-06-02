/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.obj.impl;

import java.sql.ResultSet;
import java.util.List;
import nst.controlenst.model.entity.Participante;
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
public class JDBCParticipanteTest {
    
    private JDBCParticipante instance;
    
    public JDBCParticipanteTest() {
        instance = JDBCParticipante.getInstance();
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
     * Test of save method, of class JDBCParticipante.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Participante participante = new Participante();
        participante.setMatricula("123456");
        participante.setNome("Participante 2");
        instance.save(participante);
    }
    
    /**
     * Test of save method, of class JDBCParticipante.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Participante participante = new Participante();
        participante.setId(1);
        participante.setMatricula("123214");
        participante.setNome("Participante 1 - Modificado");
        instance.save(participante);
        
    }

    /**
     * Test of delete method, of class JDBCParticipante.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Participante participante = new Participante();
        participante.setId(2);
        
        instance.delete(participante);
        
    }

    /**
     * Test of getAll method, of class JDBCParticipante.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List result = instance.getAll();
        assertNotNull(result);
    }

    /**
     * Test of getByPrimaryKey method, of class JDBCParticipante.
     */
    @Test
    public void testGetByPrimaryKey() {
        System.out.println("getByPrimaryKey");
        Integer id = 3;
        Participante result = instance.getByPrimaryKey(id);
        assertNotNull(result);
    }

}
