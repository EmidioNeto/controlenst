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
import nst.controlenst.model.entity.TipoIngresso;
import nst.controlenst.persistence.dao.factory.interfaces.TipoIngressoDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class TipoIngressoBO implements IBusiness {

    private TipoIngresso tipoIngresso = null;
    private TipoIngressoDAO tipoIngressoDao = null;

    public TipoIngressoBO() {
        try {
            this.tipoIngressoDao = FabricaDAO.getFactoryType().getTipoIngressoDAO();
        } catch (Exception ex) {
            Logger.getLogger(TipoIngressoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.tipoIngresso = (TipoIngresso) objeto;

        if ("".equalsIgnoreCase(this.tipoIngresso.getDescricao()) || this.tipoIngresso.getDescricao() == null) {
            throw new BusinessExceptions("O campo Descrição não pode ser nulo.");
        }else{
            if(this.tipoIngresso.getDescricao().length() > 50){
                throw new BusinessExceptions("O campo Descrição não pode conter mais de 50 caracteres.");
            }
        }

        this.tipoIngressoDao.save(tipoIngresso);
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.tipoIngresso = (TipoIngresso) objeto;
        if (this.tipoIngresso.getId() == null || this.tipoIngresso.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }
        this.tipoIngressoDao.delete(tipoIngresso);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
       return (ArrayList<Object>) this.tipoIngressoDao.getAll();
    }
}
