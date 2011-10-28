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
import nst.controlenst.model.entity.TelefoneParticipante;
import nst.controlenst.persistence.dao.GenericJDBCDAO;
import nst.controlenst.persistence.dao.factory.interfaces.TelefoneParticipanteDAO;

/**
 *
 * @author pablosouza
 */
public class JDBCTelefoneParticipante extends GenericJDBCDAO implements TelefoneParticipanteDAO{
    
    private static JDBCTelefoneParticipante instancia = null;
    
    private static final String SQL_ADD_TELPART = "INSERT INTO telefones_participantes(tel_part_ddd, tel_part_telefone, fk_part_id) VALUES (?, ?, ?)";
    private static final String SQL_UPD_TELPART = "UPDATE telefones_participantes SET tel_part_ddd = ?, tel_part_telefone = ?, fk_part_id = ? WHERE tel_part_id = ?";
    private static final String SQL_DEL_TELPART = "DELETE FROM telefones_participantes WHERE tel_part_id = ?";
    private static final String SQL_SEL_BYPARTI = "SELECT * FROM telefones_participantes WHERE fk_part_id = ?";
    private static final String SQL_SEL_BYID = "SELECT * FROM telefones_participantes WHERE tel_part_id= ?";
    private static final String SQL_SEL_ALL = "SELECT * FROM telefones_participantes";
    
    private JDBCTelefoneParticipante(){
        
    }
    
    public static JDBCTelefoneParticipante getInstance(){
        if(instancia == null){
            instancia = new JDBCTelefoneParticipante();
        }
        
        return instancia;
    }

    @Override
    public void delete(TelefoneParticipante telefone) {
        try {
            executarComando(SQL_DEL_TELPART, telefone.getId());
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTelefoneParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List getAll() {
        List<TelefoneParticipante> telefones = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_ALL);
            if(rs.next()){
                telefones = new ArrayList<TelefoneParticipante>();
                do{
                    TelefoneParticipante telefone = (TelefoneParticipante) preencherEntidade(rs);
                    telefones.add(telefone);
                }while(rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTelefoneParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return telefones;
    }

    @Override
    public TelefoneParticipante getByPrimaryKey(Integer id) {
        TelefoneParticipante telefone = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_BYID, id);
            if(rs.next()){
                telefone = (TelefoneParticipante) preencherEntidade(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTelefoneParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return telefone;
    }

    @Override
    public void save(TelefoneParticipante telefone) {
        if(telefone.getId() == null || telefone.getId() == 0){
            try {
                executarComando(SQL_ADD_TELPART, telefone.getDdd(), telefone.getTelefone(), telefone.getParticipante().getId());
            } catch (SQLException ex) {
                Logger.getLogger(JDBCTelefoneParticipante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                System.out.println("Entrou aqui...");
                executarComando(SQL_UPD_TELPART, telefone.getDdd(), telefone.getTelefone(), telefone.getParticipante().getId(), telefone.getId());
            } catch (SQLException ex) {
                Logger.getLogger(JDBCTelefoneParticipante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected Object preencherEntidade(ResultSet rs) throws SQLException {
        TelefoneParticipante telefone = new TelefoneParticipante();
        telefone.setDdd(rs.getString("tel_part_ddd"));
        telefone.setId(rs.getInt("tel_part_id"));
        telefone.setParticipante(JDBCParticipante.getInstance().getByPrimaryKey(rs.getInt("fk_part_id")));
        telefone.setTelefone(rs.getString("tel_part_telefone"));
        return telefone;
        
    }

    @Override
    public TelefoneParticipante getByParticipante(Integer id) {
        TelefoneParticipante telefone = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_BYPARTI, id);
            if (rs.next()) {
                telefone = (TelefoneParticipante) preencherEntidade(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTelefoneParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return telefone;
    }
    
}
