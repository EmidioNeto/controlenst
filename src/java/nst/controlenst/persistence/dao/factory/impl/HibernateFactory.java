/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.factory.impl;

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
import nst.controlenst.persistence.dao.GenericJDBCDAO;
/**
 *
 * @author pablosouza
 */
public class HibernateFactory implements DAOFactory
{
    @Override
    public GenericJDBCDAO getDAO(EnumDAO D) {
        
        if(D.equals(EnumDAO.CARGODAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.COORDENADORDAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.CURSODAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.EMAILCOORDENADORDAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.EMAILPARTICIPANTEDAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.HISTO_COOR_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.HIST_PARTI_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.MOTIVO_SAIDA_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.PARTI_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.PROJETO_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.SITU_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.TEL_COOR_DAO) ){    
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.TEL_PARTI_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.TIPO_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.TIPO_INGRE_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else if(D.equals(EnumDAO.VINCU_DAO) ){
            throw new UnsupportedOperationException("Not supported yet.");
        }else{
            return  null;
        }
        
    }
}