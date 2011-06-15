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
import nst.controlenst.model.entity.Curso;
import nst.controlenst.persistence.dao.factory.interfaces.CursoDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class CursoBO implements IBusiness {

    private CursoDAO cursoDao = null;
    private Curso curso = null;

    public CursoBO() {
        try {
            this.cursoDao = FabricaDAO.getFactoryType().getCursoDAO();
        } catch (Exception ex) {
            Logger.getLogger(CursoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.curso = (Curso) objeto;

        if ("".equalsIgnoreCase(this.curso.getDescricao()) || this.curso.getDescricao() == null) {
            throw new BusinessExceptions("O campo Nome não pode ser nulo.");
        }

        this.cursoDao.save(curso);

    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.curso = (Curso) objeto;

        /*
         * Nao pode ter Id nulo ou Zero
         */
        if (this.curso.getId() == null || this.curso.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }

        this.cursoDao.delete(curso);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.cursoDao.getAll();
    }
}
