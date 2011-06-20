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
import nst.controlenst.model.entity.TelefoneCoordenador;
import nst.controlenst.persistence.dao.factory.interfaces.TelefoneCoordenadorDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class TelefoneCoordenadorBO implements IBusiness {

    private TelefoneCoordenador telefoneCoordenador = null;
    private TelefoneCoordenadorDAO telefoneCoordenadorDao = null;

    public TelefoneCoordenadorBO() {
        try {
            this.telefoneCoordenadorDao = FabricaDAO.getFactoryType().getTelefoneCoordenadorDAO();
        } catch (Exception ex) {
            Logger.getLogger(TelefoneCoordenadorBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.telefoneCoordenador = (TelefoneCoordenador) objeto;
        //telefone, dd, coo
        if (this.telefoneCoordenador.getCoordenador() == null) {
            throw new BusinessExceptions("Não é permitido cadastrar um Telefone de Coordenador sem estar vinculado a um Coordenador");
        }

        if ("".equalsIgnoreCase(this.telefoneCoordenador.getDdd()) || this.telefoneCoordenador.getDdd() == null) {
            throw new BusinessExceptions("O campo DDD não pode ser Nulo ou Vazio");
        } else {
            if (this.telefoneCoordenador.getDdd().length() > 4) {
                throw new BusinessExceptions("O campo DDD não pode conter mais de 4 caracteres");
            }
        }


        if ("".equalsIgnoreCase(this.telefoneCoordenador.getTelefone()) || this.telefoneCoordenador.getTelefone() == null) {
            throw new BusinessExceptions("O campo Telefone não pode ser Nulo ou Vazio");
        } else {
            if (this.telefoneCoordenador.getTelefone().length() > 12) {
                throw new BusinessExceptions("O campo Telefone não pode conter mais de 12 caracteres");
            }
        }

        this.telefoneCoordenadorDao.save(telefoneCoordenador);

    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.telefoneCoordenador = (TelefoneCoordenador) objeto;

        if (this.telefoneCoordenador.getId() == null || this.telefoneCoordenador.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }

        this.telefoneCoordenadorDao.delete(telefoneCoordenador);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.telefoneCoordenadorDao.getAll();
    }
}
