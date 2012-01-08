/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import nst.controlenst.controller.business.IBusiness;
import nst.controlenst.controller.business.exception.BusinessExceptions;
import nst.controlenst.enums.EnumDAO;
import nst.controlenst.enums.EnumTypeFactory;
import nst.controlenst.model.entity.EmailParticipante;
import nst.controlenst.model.entity.Participante;
import nst.controlenst.persistence.dao.connection.ConnectionJDBC;
import nst.controlenst.persistence.dao.factory.interfaces.EmailParticipanteDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;
import nst.controlenst.view.bean.facesutil.FacesUtil;

/**
 *
 * @author pablosouza
 */
public class EmailParticipanteBO implements IBusiness{
    
    private EmailParticipante emailParticipante = null;
    private EmailParticipanteDAO emailParticipanteDAO = null;

    public EmailParticipanteBO() {
        try {
            emailParticipanteDAO = (EmailParticipanteDAO)FabricaDAO.getFactoryType(EnumTypeFactory.JDBC).getDAO(EnumDAO.EMAILPARTICIPANTEDAO);
        } catch (Exception ex) {
            Logger.getLogger(EmailParticipanteBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.emailParticipante = (EmailParticipante) objeto;
        
        //expressao regular para testar o email
        
        if("".equalsIgnoreCase(this.emailParticipante.getDescricao()) || this.emailParticipante.getDescricao() == null){
            ConnectionJDBC.doRollback();
            throw new BusinessExceptions("O campo Descrição não pode ser Nulo ou Vazio");
        }
        this.emailParticipanteDAO.save(emailParticipante);
        ConnectionJDBC.doCommit();
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.emailParticipante = (EmailParticipante) objeto;
        
        if(this.emailParticipante.getId() == null || this.emailParticipante.getId() == 0){
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }
        
        this.emailParticipanteDAO.delete(emailParticipante);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.emailParticipanteDAO.getAll();
    }
    
    @Override
    public Object obter(Integer id) throws BusinessExceptions {
        return this.emailParticipanteDAO.getByPrimaryKey(id);
    }
    
    public Object obterPorParticipante(Participante p) throws BusinessExceptions {
        return this.emailParticipanteDAO.getByParticipante(p.getId());
    }        
    
}
