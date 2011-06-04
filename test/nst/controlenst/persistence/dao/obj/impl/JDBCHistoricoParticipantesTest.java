/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.obj.impl;

import java.sql.Timestamp;
import java.util.List;
import nst.controlenst.model.entity.HistoricoParticipante;
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
public class JDBCHistoricoParticipantesTest {
    
    
    private JDBCHistoricoParticipantes instance = null;
   
    
    public JDBCHistoricoParticipantesTest() {
        instance = JDBCHistoricoParticipantes.getInstance();
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
     * Test of save method, of class JDBCHistoricoParticipantes.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        HistoricoParticipante historico = new HistoricoParticipante();
        historico.setCargo(JDBCCargo.getInstance().getByPrimaryKey(1));
        historico.setCurso(JDBCCurso.getInstance().getByPrimaryKey(3));
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        historico.setEntrada(tm);
        historico.setMotivoSaida(JDBCMotivoSaida.getInstance().getByPrimaryKey(3));
        historico.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(4));
        historico.setProjeto(JDBCProjeto.getInstance().getByPrimaryKey(10));
        historico.setSaida(tm);
        historico.setTipoIngresso(JDBCTipoIngresso.getInstance().getByPrimaryKey(5));
        historico.setVinculo(JDBCVinculo.getInstance().getByPrimaryKey(7));
       
        instance.save(historico);
       }
    
    /**
     * Test of save method, of class JDBCHistoricoParticipantes.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        HistoricoParticipante historico = new HistoricoParticipante();
        historico.setCargo(JDBCCargo.getInstance().getByPrimaryKey(1));
        historico.setCurso(JDBCCurso.getInstance().getByPrimaryKey(3));
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        historico.setEntrada(tm);
        historico.setMotivoSaida(JDBCMotivoSaida.getInstance().getByPrimaryKey(3));
        historico.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(4));
        historico.setProjeto(JDBCProjeto.getInstance().getByPrimaryKey(10));
        historico.setSaida(tm);
        historico.setTipoIngresso(JDBCTipoIngresso.getInstance().getByPrimaryKey(5));
        historico.setVinculo(JDBCVinculo.getInstance().getByPrimaryKey(7));
        instance.save(historico);
    }

    
    /**
     * Test of delete method, of class JDBCHistoricoParticipantes.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        HistoricoParticipante historico = new HistoricoParticipante();
        historico.setId(2);
        
        instance.delete(historico);
        
    }

    /**
     * Test of getAll method, of class JDBCHistoricoParticipantes.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List result = instance.getAll();
        assertNotNull(result);
    }

    /**
     * Test of getByPrimaryKey method, of class JDBCHistoricoParticipantes.
     */
    @Test
    public void testGetByPrimaryKey() {
        System.out.println("getByPrimaryKey");
        Integer id = 3;
        HistoricoParticipante result = instance.getByPrimaryKey(id);
        assertNotNull(result);
    }  

    
}
