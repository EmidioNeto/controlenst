/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.factory.impl;

import nst.controlenst.persistence.dao.GenericJDBCDAO;
import nst.controlenst.persistence.dao.factory.interfaces.DAOFactory;
import nst.controlenst.persistence.dao.obj.impl.JDBCCargo;
import nst.controlenst.persistence.dao.obj.impl.JDBCCoordenador;
import nst.controlenst.persistence.dao.obj.impl.JDBCCurso;
import nst.controlenst.persistence.dao.obj.impl.JDBCEmailCoordenadores;
import nst.controlenst.persistence.dao.obj.impl.JDBCEmailParticipante;
import nst.controlenst.persistence.dao.obj.impl.JDBCHIstoricoCoordenador;
import nst.controlenst.persistence.dao.obj.impl.JDBCHistoricoParticipantes;
import nst.controlenst.persistence.dao.obj.impl.JDBCMotivoSaida;
import nst.controlenst.persistence.dao.obj.impl.JDBCParticipante;
import nst.controlenst.persistence.dao.obj.impl.JDBCProjeto;
import nst.controlenst.persistence.dao.obj.impl.JDBCSituacao;
import nst.controlenst.persistence.dao.obj.impl.JDBCTelefoneCoordenador;
import nst.controlenst.persistence.dao.obj.impl.JDBCTelefoneParticipante;
import nst.controlenst.persistence.dao.obj.impl.JDBCTipo;
import nst.controlenst.persistence.dao.obj.impl.JDBCTipoIngresso;
import nst.controlenst.persistence.dao.obj.impl.JDBCVinculo;
import nst.controlenst.enums.EnumDAO;

/**
 *
 * @author pablosouza
 */
public class JDBCFactory implements DAOFactory{
    @Override
    public GenericJDBCDAO getDAO(EnumDAO D) {
        
        if(D.equals(EnumDAO.CARGODAO) ){
            return JDBCCargo.getInstance();
        }else if(D.equals(EnumDAO.COORDENADORDAO) ){
            return JDBCCoordenador.getInstance();
        }else if(D.equals(EnumDAO.CURSODAO) ){
            return JDBCCurso.getInstance();
        }else if(D.equals(EnumDAO.EMAILCOORDENADORDAO) ){
            return JDBCEmailCoordenadores.getInstance();
        }else if(D.equals(EnumDAO.EMAILPARTICIPANTEDAO) ){
            return JDBCEmailParticipante.getInstance();
        }else if(D.equals(EnumDAO.HISTO_COOR_DAO) ){
            return JDBCHIstoricoCoordenador.getInstance();
        }else if(D.equals(EnumDAO.HIST_PARTI_DAO) ){
            return JDBCHistoricoParticipantes.getInstance();
        }else if(D.equals(EnumDAO.MOTIVO_SAIDA_DAO) ){
            return JDBCMotivoSaida.getInstance();
        }else if(D.equals(EnumDAO.PARTI_DAO) ){
            return JDBCParticipante.getInstance();
        }else if(D.equals(EnumDAO.PROJETO_DAO) ){
            return JDBCProjeto.getInstance();
        }else if(D.equals(EnumDAO.SITU_DAO) ){
            return JDBCSituacao.getInstance();
        }else if(D.equals(EnumDAO.TEL_COOR_DAO) ){    
            return JDBCTelefoneCoordenador.getInstance();
        }else if(D.equals(EnumDAO.TEL_PARTI_DAO) ){
            return JDBCTelefoneParticipante.getInstance();
        }else if(D.equals(EnumDAO.TIPO_DAO) ){
            return JDBCTipo.getInstance();
        }else if(D.equals(EnumDAO.TIPO_INGRE_DAO) ){
            return JDBCTipoIngresso.getInstance();
        }else if(D.equals(EnumDAO.VINCU_DAO) ){
            return JDBCVinculo.getInstance();
        }else{
            return  null;
        }
        
    }
    
}
