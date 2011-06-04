/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import nst.controlenst.controller.business.IBusiness;
import java.util.ArrayList;
import nst.controlenst.controller.business.exception.BusinessExceptions;
import nst.controlenst.model.entity.Tipo;
import nst.controlenst.persistence.dao.factory.interfaces.TipoDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class TipoBO implements IBusiness {

    private TipoDAO tipoDAO = null;
    private Tipo tipo = null;

    //Meu bo nao deve ta lgiado a nada relacionado a controle de fabricas Visto que pode ser de qualquer tipo.
    public TipoBO() {
        try {
            this.tipoDAO = FabricaDAO.getFactoryType().getTipoDAO();
        } catch (Exception ex) {
            Logger.getLogger(TipoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.tipo = (Tipo) objeto;
        if (this.tipo.getId() == null || this.tipo.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        } else {
            this.tipoDAO.delete(tipo);
        }
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.tipoDAO.getAll();
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.tipo = (Tipo) objeto;
        if ("".equalsIgnoreCase(this.tipo.getDescricao()) || this.tipo.getDescricao() == null) {
            throw new BusinessExceptions("O campo Descrição não pode ser nulo.");
        } else {
            this.tipoDAO.save(tipo);
        }
    }
}
