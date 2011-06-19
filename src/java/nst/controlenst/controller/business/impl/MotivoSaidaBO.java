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
import nst.controlenst.model.entity.MotivoSaida;
import nst.controlenst.persistence.dao.factory.interfaces.MotivoSaidaDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

//Teste para checkout

/**
 *
 * @author pablosouza
 */
public class MotivoSaidaBO implements IBusiness{
    
    private MotivoSaida motivoSaida = null;
    private MotivoSaidaDAO motivoSaidaDao = null;

    public MotivoSaidaBO() {
        try {
            this.motivoSaidaDao = FabricaDAO.getFactoryType().getMotivoSaidaDAO();
        } catch (Exception ex) {
            Logger.getLogger(MotivoSaidaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.motivoSaida = (MotivoSaida) objeto;
        
        if("".equalsIgnoreCase(this.motivoSaida.getDescricao()) || this.motivoSaida.getDescricao() == null ){
            
        }
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.motivoSaidaDao.getAll();
    }
    
}
