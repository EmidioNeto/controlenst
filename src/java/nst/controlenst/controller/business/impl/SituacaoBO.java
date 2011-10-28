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
import nst.controlenst.model.entity.Situacao;
import nst.controlenst.persistence.dao.factory.interfaces.SituacaoDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */

/*
 * Quando for feita a alteração de um registro de situação padrão nao permitir.
 */
public class SituacaoBO implements IBusiness{
    
    private Situacao situacao = null;
    private SituacaoDAO situacaoDao = null;

    public SituacaoBO() {
        try {
            this.situacaoDao = (SituacaoDAO)FabricaDAO.getFactoryType(EnumTypeFactory.JDBC).getDAO(EnumDAO.SITU_DAO);
        } catch (Exception ex) {
            Logger.getLogger(SituacaoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.situacao = (Situacao) objeto;
        
        if ("".equalsIgnoreCase(this.situacao.getDescricao()) || this.situacao.getDescricao() == null) {
            throw new BusinessExceptions("O campo Descrição não pode ser nulo.");
        }
        
        this.situacaoDao.save(situacao);
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.situacao = (Situacao) objeto;

        if (this.situacao.getId() == null || this.situacao.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }

        this.situacaoDao.delete(situacao);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.situacaoDao.getAll();
    }
    
    @Override
    public Object obter(Integer id) throws BusinessExceptions {
        return this.situacaoDao.getByPrimaryKey(id);
    }
    
}
