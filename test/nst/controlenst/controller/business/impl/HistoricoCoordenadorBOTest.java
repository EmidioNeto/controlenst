/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import nst.controlenst.model.entity.HistoricoCoordenador;
import nst.controlenst.persistence.dao.obj.impl.JDBCCoordenador;
import nst.controlenst.persistence.dao.obj.impl.JDBCProjeto;
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
public class HistoricoCoordenadorBOTest {
    
    public HistoricoCoordenadorBOTest() {
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
     * Test of save method, of class HistoricoCoordenadorBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        HistoricoCoordenador objeto = new HistoricoCoordenador();
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        objeto.setDataEntrada(tm);
        objeto.setCoordenador(JDBCCoordenador.getInstance().getByPrimaryKey(6));
        objeto.setProjeto(JDBCProjeto.getInstance().getByPrimaryKey(19));
        HistoricoCoordenadorBO instance = new HistoricoCoordenadorBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class HistoricoCoordenadorBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        HistoricoCoordenador objeto = new HistoricoCoordenador();
        objeto.setId(7);
        HistoricoCoordenadorBO instance = new HistoricoCoordenadorBO();
        instance.excluir(objeto); 
        
    }

    /**
     * Test of listar method, of class HistoricoCoordenadorBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        HistoricoCoordenadorBO instance = new HistoricoCoordenadorBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
