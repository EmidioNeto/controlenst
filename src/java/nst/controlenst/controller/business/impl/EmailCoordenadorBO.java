/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nst.controlenst.controller.business.IBusiness;
import nst.controlenst.controller.business.exception.BusinessExceptions;
import nst.controlenst.model.entity.EmailCoordenador;
import nst.controlenst.persistence.dao.factory.interfaces.EmailCoordenadorDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;


/**
 *
 * @author pablosouza
 */
public class EmailCoordenadorBO implements IBusiness {
    
    private EmailCoordenador emailCoordenador = null;
    
    private EmailCoordenadorDAO emailCoordenadorDAO = null;

    public EmailCoordenadorBO() {
        try {
            this.emailCoordenadorDAO = FabricaDAO.getFactoryType().getEmailCoordenadorDAO();
        } catch (Exception ex) {
            Logger.getLogger(EmailCoordenadorBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @Override
    public void save(Object objeto) throws BusinessExceptions {
         this.emailCoordenador = (EmailCoordenador) objeto;
        
        //aqui podemos garantir com uma expressao regular a validade do email cadastrado.
         
        if("".equalsIgnoreCase(this.emailCoordenador.getDescricao()) || this.emailCoordenador.getDescricao() == null){
            throw new BusinessExceptions("O campo Descrição não pode ser Nulo ou Vazio");
        }
        
        this.emailCoordenadorDAO.save(emailCoordenador);
        
    }
        

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.emailCoordenador = (EmailCoordenador) objeto;
        
        if(this.emailCoordenador.getId() == null || this.emailCoordenador.getId() == 0){
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }
        
        this.emailCoordenadorDAO.delete(emailCoordenador);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.emailCoordenadorDAO.getAll();
    }
    
}
