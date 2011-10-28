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
import nst.controlenst.model.entity.Participante;
import nst.controlenst.persistence.dao.GenericJDBCDAO;
import nst.controlenst.persistence.dao.factory.interfaces.ParticipanteDAO;

/**
 *
 * @author pablosouza
 */
public class JDBCParticipante extends GenericJDBCDAO implements ParticipanteDAO{
    
    private static JDBCParticipante instancia = null;
    
    private static final String SQL_ADD_PART = "INSERT INTO participantes(part_nome, part_matricula) VALUES (?, ?)";
    private static final String SQL_UPD_PART = "UPDATE participantes SET part_nome = ?, part_matricula = ? WHERE part_id = ?";
    private static final String SQL_DEL_PART = "DELETE FROM participantes WHERE part_id = ?";
    private static final String SQL_SEL_BYID = "SELECT * FROM participantes WHERE part_id= ?";
    private static final String SQL_SEL_BYMATRICULA = "SELECT * FROM participantes WHERE part_matricula= ?";
    private static final String SQL_SEL_ALL = "SELECT * FROM participantes";
    
    private JDBCParticipante(){
        
    }
    
    public static JDBCParticipante getInstance(){
        if(instancia == null){
            instancia = new JDBCParticipante();
        }
        
        return instancia;
    }

    @Override
    public void delete(Participante participante) {
        try {
            executarComando(SQL_DEL_PART, participante.getId());
        } catch (SQLException ex) {
            Logger.getLogger(JDBCParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List getAll() {
        List<Participante> participantes = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_ALL);
            if(rs.next()){
                participantes = new ArrayList<Participante>();
                do{
                    Participante participante = (Participante) preencherEntidade(rs);
                    participantes.add(participante);
                }while(rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participantes;
    }

    @Override
    public Participante getByPrimaryKey(Integer id) {
        Participante participante = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_BYID, id);
            if(rs.next()){
                participante = (Participante) preencherEntidade(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participante;
    }
    
    public Participante getByMatricula(String matricula) {
        Participante participante = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_BYMATRICULA, matricula);
            if(rs.next()){
                participante = (Participante) preencherEntidade(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participante;
    }

    @Override
    public void save(Participante participante) {
        if(participante.getId() == null || participante.getId() == 0){
            try {
                executarComando(SQL_ADD_PART, participante.getNome(), participante.getMatricula());
            } catch (SQLException ex) {
                Logger.getLogger(JDBCParticipante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                executarComando(SQL_UPD_PART, participante.getNome(), participante.getMatricula(), participante.getId());
            } catch (SQLException ex) {
                Logger.getLogger(JDBCParticipante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected Object preencherEntidade(ResultSet rs) throws SQLException {
        Participante parti = new Participante();
        parti.setId(rs.getInt("part_id"));
        parti.setMatricula(rs.getString("part_matricula"));
        parti.setNome(rs.getString("part_nome"));
        return parti;
    }
    
}
