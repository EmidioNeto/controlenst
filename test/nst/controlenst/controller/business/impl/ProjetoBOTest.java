/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import java.sql.Timestamp;
import nst.controlenst.model.entity.Projeto;
import nst.controlenst.persistence.dao.obj.impl.JDBCSituacao;
import nst.controlenst.persistence.dao.obj.impl.JDBCTipo;
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
public class ProjetoBOTest {
    
    public ProjetoBOTest() {
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

//    /**
//     * Test of save method, of class ProjetoBO.
//     */
//    @Test
//    public void testSave() throws Exception {
//        System.out.println("save");
//        Projeto objeto = new Projeto();
//        Timestamp tm = new Timestamp(System.currentTimeMillis());
//        objeto.setNome("projeto1");
//        objeto.setIdentificador("testando1");
//        objeto.setDataCadastro(tm);
//        objeto.setDataInicio(tm);
//        objeto.setDataEncerramentoPrevisto(tm);
//        objeto.setDescricao("dakdaldkjaldkja ldkja ldja ldkj alkdj alkjd alskjd alkjd lajd laskj dlajd alskjd alkjd laskj dlakj");
//        objeto.setSituacao(JDBCSituacao.getInstance().getByPrimaryKey(11));
//        objeto.setTipo(JDBCTipo.getInstance().getByPrimaryKey(17));
//        ProjetoBO instance = new ProjetoBO();
//        instance.save(objeto);
//    }

    /**
     * Test of excluir method, of class ProjetoBO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Projeto objeto = new Projeto();
        objeto.setId(23);
        ProjetoBO instance = new ProjetoBO();
        instance.excluir(objeto);
    }

    /**
     * Test of listar method, of class ProjetoBO.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        ProjetoBO instance = new ProjetoBO();
        ArrayList result = instance.listar();
        assertNotNull(result);
    }
}
