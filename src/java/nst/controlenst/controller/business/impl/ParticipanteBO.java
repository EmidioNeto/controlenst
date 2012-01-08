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
import nst.controlenst.enums.EnumDAO;
import nst.controlenst.enums.EnumTypeFactory;
import nst.controlenst.model.entity.Participante;
import nst.controlenst.persistence.dao.connection.ConnectionJDBC;
import nst.controlenst.persistence.dao.factory.interfaces.ParticipanteDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class ParticipanteBO implements IBusiness {

    private Participante participante = null;
    private ParticipanteDAO participanteDao = null;

    public ParticipanteBO() {
        try {
            this.participanteDao = (ParticipanteDAO)FabricaDAO.getFactoryType(EnumTypeFactory.JDBC).getDAO(EnumDAO.PARTI_DAO);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.participante = (Participante) objeto;

        if ("".equalsIgnoreCase(this.participante.getMatricula()) || this.participante.getMatricula() == null) {
            throw new BusinessExceptions("O campo Matricula não pode ser Nulo ou Vazio.");
        }

        if (this.participante.getMatricula().length() > 12) {
            throw new BusinessExceptions("O campo Matricula não pode conter mais de 12 caracteres");
        }

        if ("".equalsIgnoreCase(this.participante.getNome()) || this.participante.getNome() == null) {
            throw new BusinessExceptions("O campo Nome não pode ser Nulo ou Vazio.");
        }

        this.participanteDao.save(participante);
        ConnectionJDBC.doCommit();
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.participante = (Participante) objeto;

        if (this.participante.getId() == null || this.participante.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }        
        this.participanteDao.delete(participante);
        ConnectionJDBC.doCommit();
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.participanteDao.getAll();
    }
    
    @Override
    public Object obter(Integer id) throws BusinessExceptions {
        return this.participanteDao.getByPrimaryKey(id);
    }
    
    public Object obterPorMatricula(String matricula) throws BusinessExceptions {
        return this.participanteDao.getByMatricula(matricula);
    }
}