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
import nst.controlenst.model.entity.TelefoneParticipante;
import nst.controlenst.persistence.dao.factory.interfaces.TelefoneParticipanteDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class TelefoneParticipanteBO implements IBusiness{

    private TelefoneParticipante telefoneParticipante = null;
    private TelefoneParticipanteDAO telefoneParticipanteDao = null;

    public TelefoneParticipanteBO() {
        try {
            this.telefoneParticipanteDao = (TelefoneParticipanteDAO)FabricaDAO.getFactoryType(EnumTypeFactory.JDBC).getDAO(EnumDAO.TEL_PARTI_DAO);
        } catch (Exception ex) {
            Logger.getLogger(TelefoneParticipanteBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.telefoneParticipante = (TelefoneParticipante) objeto;
        //telefone, dd, coo
        if (this.telefoneParticipante.getParticipante() == null) {
            throw new BusinessExceptions("Não é permitido cadastrar um Telefone de Participante sem estar vinculado a um Participante");
        }

        if ("".equalsIgnoreCase(this.telefoneParticipante.getDdd()) || this.telefoneParticipante.getDdd() == null) {
            throw new BusinessExceptions("O campo DDD não pode ser Nulo ou Vazio");
        } else {
            if (this.telefoneParticipante.getDdd().length() > 4) {
                throw new BusinessExceptions("O campo DDD não pode conter mais de 4 caracteres");
            }
        }


        if ("".equalsIgnoreCase(this.telefoneParticipante.getTelefone()) || this.telefoneParticipante.getTelefone() == null) {
            throw new BusinessExceptions("O campo Telefone não pode ser Nulo ou Vazio");
        } else {
            if (this.telefoneParticipante.getTelefone().length() > 12) {
                throw new BusinessExceptions("O campo Telefone não pode conter mais de 12 caracteres");
            }
        }

        this.telefoneParticipanteDao.save(telefoneParticipante);

    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.telefoneParticipante = (TelefoneParticipante) objeto;

        if (this.telefoneParticipante.getId() == null || this.telefoneParticipante.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }

        this.telefoneParticipanteDao.delete(telefoneParticipante);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.telefoneParticipanteDao.getAll();
    }
    
    @Override
    public Object obter(Integer id) throws BusinessExceptions {
        return this.telefoneParticipanteDao.getByPrimaryKey(id);
    }
    
    public Object obterPorParticipante(Participante p) throws BusinessExceptions {
        return this.telefoneParticipanteDao.getByParticipante(p.getId());
    }        
}
