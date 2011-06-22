/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.sql.Timestamp;
import nst.controlenst.model.entity.HistoricoParticipante;
import nst.controlenst.persistence.dao.obj.impl.JDBCCargo;
import nst.controlenst.persistence.dao.obj.impl.JDBCCurso;
import nst.controlenst.persistence.dao.obj.impl.JDBCParticipante;
import nst.controlenst.persistence.dao.obj.impl.JDBCProjeto;
import nst.controlenst.persistence.dao.obj.impl.JDBCTipoIngresso;
import nst.controlenst.persistence.dao.obj.impl.JDBCVinculo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pablosouza
 */
public class HistoricoParticipantesBOTest {
    
    public HistoricoParticipantesBOTest() {
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
     * Test of save method, of class HistoricoParticipantesBO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        //inclusao
        HistoricoParticipante objeto = new HistoricoParticipante();
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        objeto.setEntrada(tm);
        objeto.setCargo(JDBCCargo.getInstance().getByPrimaryKey(10));
        objeto.setCurso(JDBCCurso.getInstance().getByPrimaryKey(5));
        objeto.setVinculo(JDBCVinculo.getInstance().getByPrimaryKey(15));
        objeto.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(4));
        objeto.setTipoIngresso(JDBCTipoIngresso.getInstance().getByPrimaryKey(9));
        objeto.setProjeto(JDBCProjeto.getInstance().getByPrimaryKey(21));
        HistoricoParticipantesBO instance = new HistoricoParticipantesBO();
        
//        //atualizacao
//        HistoricoParticipante objeto = new HistoricoParticipante();
//        Timestamp tm = new Timestamp(System.currentTimeMillis());
//        objeto.setId(9);
//        objeto.setMotivoSaida(JDBCMotivoSaida.getInstance().getByPrimaryKey(9));
//        objeto.setSaida(tm);
//        HistoricoParticipantesBO instance = new HistoricoParticipantesBO();

        instance.save(objeto);
    }

//    /**
//     * Test of excluir method, of class HistoricoParticipantesBO.
//     */
//    @Test
//    public void testExcluir() throws Exception {
//        System.out.println("excluir");
//        Object objeto = null;
//        HistoricoParticipantesBO instance = new HistoricoParticipantesBO();
//        instance.excluir(objeto);
//    }
//
//    /**
//     * Test of listar method, of class HistoricoParticipantesBO.
//     */
//    @Test
//    public void testListar() throws Exception {
//        System.out.println("listar");
//        HistoricoParticipantesBO instance = new HistoricoParticipantesBO();
//        ArrayList expResult = null;
//        ArrayList result = instance.listar();
//        assertEquals(expResult, result);
//    }
}
