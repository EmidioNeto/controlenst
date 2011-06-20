/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import nst.controlenst.model.entity.TelefoneCoordenador;
import nst.controlenst.persistence.dao.obj.impl.JDBCCoordenador;
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
public class TelefoneCoordenadorBOTest {
    
    public TelefoneCoordenadorBOTest() {
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
     * Test of save method, of class TelefoneCoordenadorBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        TelefoneCoordenador  objeto = new TelefoneCoordenador();
        objeto.setCoordenador(JDBCCoordenador.getInstance().getByPrimaryKey(6));
        objeto.setDdd("1287");
        objeto.setTelefone("1871987323");
        TelefoneCoordenadorBO instance = new TelefoneCoordenadorBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class TelefoneCoordenadorBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        TelefoneCoordenador  objeto = new TelefoneCoordenador();
        objeto.setId(12);
        TelefoneCoordenadorBO instance = new TelefoneCoordenadorBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class TelefoneCoordenadorBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        TelefoneCoordenadorBO instance = new TelefoneCoordenadorBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
