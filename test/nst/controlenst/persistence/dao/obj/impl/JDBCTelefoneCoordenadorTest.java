/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.obj.impl;

import java.sql.ResultSet;
import java.util.List;
import nst.controlenst.model.entity.TelefoneCoordenador;
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
public class JDBCTelefoneCoordenadorTest {
    
    JDBCTelefoneCoordenador instance = null;
    
    public JDBCTelefoneCoordenadorTest() {
        instance = JDBCTelefoneCoordenador.getInstance();
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
     * Test of save method, of class JDBCTelefoneCoordenador.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        TelefoneCoordenador telefone = new TelefoneCoordenador();
        telefone.setCoordenador(JDBCCoordenador.getInstance().getByPrimaryKey(3));
        telefone.setDdd("121");
        telefone.setTelefone("31231");
        instance.save(telefone);
        
    }
    
    /**
     * Test of save method, of class JDBCTelefoneCoordenador.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        TelefoneCoordenador telefone = new TelefoneCoordenador();
        telefone.setCoordenador(JDBCCoordenador.getInstance().getByPrimaryKey(3));
        telefone.setDdd("11");
        telefone.setTelefone("123");
        instance.save(telefone);
    }

    /**
     * Test of delete method, of class JDBCTelefoneCoordenador.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        TelefoneCoordenador telefone = new TelefoneCoordenador();
        telefone.setId(2);
        
        instance.delete(telefone);
    }

    /**
     * Test of getAll method, of class JDBCTelefoneCoordenador.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List result = instance.getAll();
        assertNotNull(result);
    }

    /**
     * Test of getByPrimaryKey method, of class JDBCTelefoneCoordenador.
     */
    @Test
    public void testGetByPrimaryKey() {
        System.out.println("getByPrimaryKey");
        Integer id = 3;
        TelefoneCoordenador result = instance.getByPrimaryKey(id);
        assertNotNull(result);
    }

    
}
