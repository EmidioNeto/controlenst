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
import nst.controlenst.model.entity.Coordenador;
import nst.controlenst.persistence.dao.factory.interfaces.CoordenadorDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class CoordenadorBO implements IBusiness {

    private CoordenadorDAO coordenadorDAO = null;
    private Coordenador coordenador = null;

    public CoordenadorBO() {
        try {
            this.coordenadorDAO = FabricaDAO.getFactoryType().getCoordenadorDAO();
        } catch (Exception ex) {
            Logger.getLogger(CoordenadorBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.coordenador = (Coordenador) objeto;

        if (this.coordenador.getId() == null || this.coordenador.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }

        this.coordenadorDAO.delete(coordenador);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.coordenadorDAO.getAll();
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.coordenador = (Coordenador) objeto;

        if ("".equalsIgnoreCase(this.coordenador.getNome()) || this.coordenador.getNome() == null) {
            throw new BusinessExceptions("O campo Nome não pode ser nulo.");
        }

        this.coordenadorDAO.save(coordenador);
    }
}
