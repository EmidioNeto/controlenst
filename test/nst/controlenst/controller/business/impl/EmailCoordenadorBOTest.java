/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import nst.controlenst.model.entity.Coordenador;
import java.util.ArrayList;
import nst.controlenst.model.entity.EmailCoordenador;
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
public class EmailCoordenadorBOTest {
    
    public EmailCoordenadorBOTest() {
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
     * Test of save method, of class EmailCoordenadorBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        EmailCoordenador objeto = new EmailCoordenador();
        objeto.setDescricao("teste@teste.com.br");
        Coordenador coordenador = JDBCCoordenador.getInstance().getByPrimaryKey(6);
        objeto.setCoordenador(coordenador);
        EmailCoordenadorBO instance = new EmailCoordenadorBO();
        instance.save(objeto);
    }

    /**
     * Test of excluir method, of class EmailCoordenadorBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        EmailCoordenador objeto = new EmailCoordenador();
        objeto.setId(5);
        EmailCoordenadorBO instance = new EmailCoordenadorBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class EmailCoordenadorBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        EmailCoordenadorBO instance = new EmailCoordenadorBO();
        
        ArrayList result = instance.listar();
        assertNotNull(result);
        
    }
}
