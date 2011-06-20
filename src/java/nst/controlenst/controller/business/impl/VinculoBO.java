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
import nst.controlenst.model.entity.Vinculo;
import nst.controlenst.persistence.dao.factory.interfaces.VinculoDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class VinculoBO implements IBusiness {

    private VinculoDAO vinculoDAO = null;
    private Vinculo vinculo = null;

    public VinculoBO() {
        try {
            this.vinculoDAO = FabricaDAO.getFactoryType().getVinculoDAO();
        } catch (Exception ex) {
            Logger.getLogger(VinculoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.vinculo = (Vinculo) objeto;

        if (this.vinculo.getId() == null || this.vinculo.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }

        this.vinculoDAO.delete(vinculo);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.vinculoDAO.getAll();
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.vinculo = (Vinculo) objeto;

        if ("".equalsIgnoreCase(this.vinculo.getDescricao()) || this.vinculo.getDescricao() == null) {
            throw new BusinessExceptions("O campo Descrição não pode ser nulo.");
        } else {
            if (this.vinculo.getDescricao().length() > 50) {
                throw new BusinessExceptions("O campo Descrição não pode conter mais de 50 caracteres.");
            }
        }

        this.vinculoDAO.save(vinculo);
    }
}
