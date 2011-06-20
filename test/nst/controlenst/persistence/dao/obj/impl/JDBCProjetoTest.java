/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.obj.impl;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import nst.controlenst.model.entity.Projeto;
import nst.controlenst.model.entity.Situacao;
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
public class JDBCProjetoTest {
    
    
    private JDBCProjeto instance;
    
    public JDBCProjetoTest() {
        instance = JDBCProjeto.getInstance();
            
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
     * Test of save method, of class JDBCProjeto.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Projeto projeto = new Projeto();
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        projeto.setDataCadastro(tm);
        projeto.setDataEncerramento(tm);
        projeto.setDataEncerramentoPrevisto(tm);
        projeto.setDataInicio(tm);
        projeto.setDescricao("Teste de controle NST");
        projeto.setIdentificador("controle");
        projeto.setNome("ControleNst");
        projeto.setSituacao(JDBCSituacao.getInstance().getByPrimaryKey(11));
        projeto.setTipo(JDBCTipo.getInstance().getByPrimaryKey(17));
        instance.save(projeto);
        
    }
    
    /**
     * Test of save method, of class JDBCProjeto.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Projeto projeto = new Projeto();
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        projeto.setId(3);
        projeto.setDataCadastro(tm);
        projeto.setDataEncerramento(tm);
        projeto.setDataEncerramentoPrevisto(tm);
        projeto.setDataInicio(tm);
        projeto.setDescricao("Descricao1 para caralho");
        projeto.setIdentificador("teste");
        projeto.setNome("Teste do nome");
        Situacao situacao = new Situacao();
        situacao.setId(5);
        projeto.setSituacao(situacao);
        projeto.setTipo(JDBCTipo.getInstance().getByPrimaryKey(1));
        
        instance.save(projeto);
        
    }

    /**
     * Test of delete method, of class JDBCProjeto.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Projeto projeto = new Projeto();
        projeto.setId(6);
        instance.delete(projeto);
        
    }

    /**
     * Test of getAll method, of class JDBCProjeto.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List result = instance.getAll();
        assertNotNull(result);
    }

    /**
     * Test of getByPrimaryKey method, of class JDBCProjeto.
     */
    @Test
    public void testGetByPrimaryKey() {
        System.out.println("getByPrimaryKey");
        Integer id = 26;
        Projeto result = instance.getByPrimaryKey(id);
        System.out.println("Data de Cadastro:"+result.getDataCadastro());
        assertNotNull(result);
    }


    /**
     * Test of isExiste method, of class JDBCProjeto.
     */
    @Test
    public void testIsExiste() {
        System.out.println("isExiste");
        Projeto projeto = new Projeto();
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        projeto.setDataCadastro(tm);
        projeto.setDataEncerramento(tm);
        projeto.setDataEncerramentoPrevisto(tm);
        projeto.setDataInicio(tm);
        projeto.setDescricao("Teste de controle NST");
        projeto.setIdentificador("controle");
        projeto.setNome("ControleNst");
        projeto.setSituacao(JDBCSituacao.getInstance().getByPrimaryKey(11));
        projeto.setTipo(JDBCTipo.getInstance().getByPrimaryKey(17));
        boolean expResult = true;
        boolean result = instance.isExiste(projeto);
        assertEquals(expResult, result);
    }
}
