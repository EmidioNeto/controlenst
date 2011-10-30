/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.obj.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nst.controlenst.model.entity.HistoricoParticipante;
import nst.controlenst.persistence.dao.GenericJDBCDAO;
import nst.controlenst.persistence.dao.factory.interfaces.HIstoricoParticipanteDAO;

/**
 *
 * @author pablosouza
 */
public class JDBCHistoricoParticipantes extends GenericJDBCDAO implements HIstoricoParticipanteDAO {

    private static JDBCHistoricoParticipantes instancia = null;
    private static final String SQL_ADD_HIST = "INSERT INTO"
            + " historico_participantes("
            + "histp_entrada, "
            + "fk_carg_id, "
            + "fk_cur_id,"
            + "fk_vinc_id,"
            + "fk_part_id,"
            + "histp_semestre,"            
            + "fk_ing_id,"
            + "fk_proj_id) VALUES (?,?,?,?,?,?,?,?)";
    /*
     * Constante utilizada considerando somente a saida do participante.
     */
    private static final String SQL_UPD_REG_HISTO = "UPDATE historico_participantes SET "
            + " histp_saida = ?,"
            + " fk_mot_id = ?"
            + " WHERE histp_id = ?";
    /*
     * Constante utilizada para d atualizar o registro sem considerar a a saida(motivo e data da saida)
     */
    private static final String SQL_UPD_HIST = "UPDATE historico_participantes SET "
            + "histp_entrada = ?,"
            + " fk_carg_id = ?,"
            + " fk_cur_id = ?,"
            + "fk_vinc_id = ?,"
            + "fk_part_id = ?,"
            + "fk_sit_id,"
            + "histp_semestre,"
            + "fk_ing_id = ?,"
            + "fk_proj_id = ?"
            + " WHERE histp_id = ?";
    private static final String SQL_DEL_HIST = "DELETE FROM historico_participantes WHERE histp_id = ?";
    private static final String SQL_SEL_BYID = "SELECT * FROM historico_participantes WHERE histp_id= ?";
    private static final String SQL_SEL_BYPARTI = "SELECT * FROM historico_participantes WHERE fk_part_id = ?";
    private static final String SQL_SEL_ALL = "SELECT * FROM historico_participantes";

    private JDBCHistoricoParticipantes() {
    }

    public static JDBCHistoricoParticipantes getInstance() {
        if (instancia == null) {
            instancia = new JDBCHistoricoParticipantes();
        }
        return instancia;
    }

    @Override
    public void delete(HistoricoParticipante historico) {
        try {
            executarComando(SQL_DEL_HIST, historico.getId());
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHistoricoParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List getAll() {
        List<HistoricoParticipante> historicos = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_ALL);
            if (rs.next()) {
                historicos = new ArrayList<HistoricoParticipante>();
                do {
                    HistoricoParticipante historico = (HistoricoParticipante) preencherEntidade(rs);
                    historicos.add(historico);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHistoricoParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historicos;
    }

    @Override
    public HistoricoParticipante getByPrimaryKey(Integer id) {
        HistoricoParticipante historico = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_BYID, id);
            if (rs.next()) {
                historico = (HistoricoParticipante) preencherEntidade(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHistoricoParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historico;
    }
    
    @Override
    public List getByParticipante(Integer id) {
        List<HistoricoParticipante> historicos = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_BYPARTI,id);
            if (rs.next()) {
                historicos = new ArrayList<HistoricoParticipante>();
                do {
                    HistoricoParticipante historico = (HistoricoParticipante) preencherEntidade(rs);
                    historicos.add(historico);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHistoricoParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historicos;
    }
    @Override
    public void save(HistoricoParticipante historico) {
        if (historico.getId() == null || historico.getId() == 0) {
            try {
                executarComando(SQL_ADD_HIST,
                        historico.getEntrada(),
                        historico.getCargo().getId(),
                        historico.getCurso().getId(),
                        historico.getVinculo().getId(),
                        historico.getParticipante().getId(),
                        historico.getSemestre(),
                        historico.getTipoIngresso().getId(),
                        historico.getProjeto().getId());
            } catch (SQLException ex) {
                Logger.getLogger(JDBCHistoricoParticipantes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (historico.getMotivoSaida() != null || historico.getSaida() != null) {
                    executarComando(SQL_UPD_REG_HISTO,
                            historico.getSaida(),
                            historico.getMotivoSaida().getId(),
                            historico.getId());
                } else {
                    executarComando(SQL_UPD_HIST, historico.getEntrada(),
                            historico.getCargo().getId(),
                            historico.getCurso().getId(),
                            historico.getVinculo().getId(),
                            historico.getParticipante().getId(),
                            historico.getSituacao().getId(),
                            historico.getSemestre(),
                            historico.getTipoIngresso().getId(),
                            historico.getProjeto().getId(),
                            historico.getId());
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBCHistoricoParticipantes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected Object preencherEntidade(ResultSet rs) throws SQLException {
        HistoricoParticipante historico = new HistoricoParticipante();
        historico.setId(rs.getInt("histp_id"));
        historico.setCargo(JDBCCargo.getInstance().getByPrimaryKey(rs.getInt("fk_carg_id")));
        historico.setCurso(JDBCCurso.getInstance().getByPrimaryKey(rs.getInt("fk_cur_id")));
        historico.setEntrada(rs.getTimestamp("histp_entrada"));
        historico.setMotivoSaida(JDBCMotivoSaida.getInstance().getByPrimaryKey(rs.getInt("fk_mot_id")));
        historico.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(rs.getInt("fk_part_id")));
        historico.setSemestre(rs.getInt("histp_semestre"));
        historico.setProjeto(JDBCProjeto.getInstance().getByPrimaryKey(rs.getInt("fk_proj_id")));
        historico.setSaida(rs.getTimestamp("histp_saida"));
        historico.setTipoIngresso(JDBCTipoIngresso.getInstance().getByPrimaryKey(rs.getInt("fk_ing_id")));
        historico.setVinculo(JDBCVinculo.getInstance().getByPrimaryKey(rs.getInt("fk_vinc_id")));

        return historico;
    }
}
