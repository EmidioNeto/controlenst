/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.obj.impl;

import java.sql.ResultSet;
import java.util.List;
import nst.controlenst.model.entity.Participante;
import nst.controlenst.model.entity.TelefoneParticipante;
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
public class JDBCTelefoneParticipanteTest {
    
    JDBCTelefoneParticipante instance = null;
    
    public JDBCTelefoneParticipanteTest() {
        instance = JDBCTelefoneParticipante.getInstance();
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
     * Test of save method, of class JDBCTelefoneParticipante.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        TelefoneParticipante telefone = new TelefoneParticipante();
        telefone.setDdd("71");
        telefone.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(4));
        telefone.setTelefone("99837775");
        instance.save(telefone);
    }
    
     /**
     * Test of save method, of class JDBCTelefoneParticipante.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        TelefoneParticipante telefone = new TelefoneParticipante();
        telefone.setId(1);
        telefone.setTelefone("teste");
        telefone.setDdd("11");
        telefone.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(4));
        instance.save(telefone);
        
    }

    
    /**
     * Test of delete method, of class JDBCTelefoneParticipante.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        TelefoneParticipante telefone = new TelefoneParticipante();
        telefone.setId(2);
        instance.delete(telefone);
        
    }

    /**
     * Test of getAll method, of class JDBCTelefoneParticipante.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List result = instance.getAll();
        assertNotNull(result);
    }

    /**
     * Test of getByPrimaryKey method, of class JDBCTelefoneParticipante.
     */
    @Test
    public void testGetByPrimaryKey() {
        System.out.println("getByPrimaryKey");
        Integer id = 3;
        TelefoneParticipante result = instance.getByPrimaryKey(id);
        assertNotNull(result);
    }

   

}
