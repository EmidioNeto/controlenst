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
import nst.controlenst.model.entity.TelefoneCoordenador;
import nst.controlenst.persistence.dao.GenericJDBCDAO;
import nst.controlenst.persistence.dao.factory.interfaces.TelefoneCoordenadorDAO;

/**
 *
 * @author pablosouza
 */
public class JDBCTelefoneCoordenador extends GenericJDBCDAO implements TelefoneCoordenadorDAO {
    
    private static JDBCTelefoneCoordenador instacia = null;
    
    private static final String SQL_ADD_COOR = "INSERT INTO telefones_coordenadores(tel_coord_ddd, tel_coord_telefone, fk_coord_id) VALUES (?, ?, ?)";
    private static final String SQL_UPD_COOR = "UPDATE telefones_coordenadores SET tel_coord_ddd = ?, tel_coord_telefone = ?, fk_coord_id = ? WHERE tel_coord_id = ?";
    private static final String SQL_DEL_COOR = "DELETE FROM telefones_coordenadores WHERE tel_coord_id = ?";
    private static final String SQL_SEL_BYID = "SELECT * FROM telefones_coordenadores WHERE tel_coord_id= ?";
    private static final String SQL_SEL_ALL = "SELECT * FROM telefones_coordenadores";
    
    
    private JDBCTelefoneCoordenador(){
        
    }
    
    public static JDBCTelefoneCoordenador getInstance(){
        if(instacia == null){
            instacia = new JDBCTelefoneCoordenador();
        }
        
        return instacia;
    }

    @Override
    public void delete(TelefoneCoordenador telefone) {
        try {
            executarComando(SQL_DEL_COOR, telefone.getId());
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTelefoneCoordenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List getAll() {
        List<TelefoneCoordenador> telefones = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_ALL);
            if(rs.next()){
                telefones = new ArrayList<TelefoneCoordenador>();
                do{
                    TelefoneCoordenador telefone = (TelefoneCoordenador) preencherEntidade(rs);
                    telefones.add(telefone);
                }while(rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTelefoneCoordenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return telefones;
    }

    @Override
    public TelefoneCoordenador getByPrimaryKey(Integer id) {
        TelefoneCoordenador telefone = null;
        try {
            ResultSet rs = executarQuery(SQL_SEL_BYID, id);
            if(rs.next()){
                telefone = (TelefoneCoordenador) preencherEntidade(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTelefoneCoordenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return telefone;
    }

    @Override
    public void save(TelefoneCoordenador telefone) {
        if(telefone.getId() == null || telefone.getId() == 0){
            try {
                executarComando(SQL_ADD_COOR, telefone.getDdd(), telefone.getTelefone(), telefone.getCoordenador().getId());
            } catch (SQLException ex) {
                Logger.getLogger(JDBCTelefoneCoordenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                executarComando(SQL_UPD_COOR, telefone.getDdd(), telefone.getTelefone(), telefone.getCoordenador().getId(), telefone.getId());
            } catch (SQLException ex) {
                Logger.getLogger(JDBCTelefoneCoordenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected Object preencherEntidade(ResultSet rs) throws SQLException {
        TelefoneCoordenador telefone = new TelefoneCoordenador();
        telefone.setCoordenador(JDBCCoordenador.getInstance().getByPrimaryKey(rs.getInt("fk_coord_id")));
        telefone.setDdd(rs.getString("tel_coord_ddd"));
        telefone.setTelefone(rs.getString("tel_coord_telefone"));
        return telefone;
    }
    
}
