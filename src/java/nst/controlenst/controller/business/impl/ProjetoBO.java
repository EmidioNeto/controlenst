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
import nst.controlenst.model.entity.Projeto;
import nst.controlenst.persistence.dao.factory.interfaces.ProjetoDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class ProjetoBO implements IBusiness {

    private Projeto projeto = null;
    private ProjetoDAO projetoDao = null;

    public ProjetoBO() {
        try {
            this.projetoDao = (ProjetoDAO)FabricaDAO.getFactoryType(EnumTypeFactory.JDBC).getDAO(EnumDAO.PROJETO_DAO);
        } catch (Exception ex) {
            Logger.getLogger(ProjetoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.projeto = (Projeto) objeto;


        if (this.projetoDao.isExiste(projeto)) {
            throw new BusinessExceptions("O Nome ou Identificador do projeto já existem no banco de dados.");
        } else {
            if ("".equalsIgnoreCase(this.projeto.getIdentificador()) || this.projeto.getIdentificador() == null) {
                throw new BusinessExceptions("O campo Identificador não pode ser Nulo ou Vazio");
            }

            if (this.projeto.getIdentificador().length() > 10) {
                throw new BusinessExceptions("O campo Identificador não pode conter mais de 10 caracteres");
            }

            if ("".equalsIgnoreCase(this.projeto.getNome()) || this.projeto.getNome() != null) {
                if (this.projeto.getNome().length() > 75) {
                    throw new BusinessExceptions("O campo Nome não pode conter mais de 75 caracteres");
                }
            }
        }

        if (this.projeto.getDataCadastro() == null) {
            throw new BusinessExceptions("O campo Data de Cadastro não pode ser Nulo ou Vazio");
        }

        if (this.projeto.getDataInicio() == null) {
            throw new BusinessExceptions("O campo Data de Inicio não pode ser Nulo ou Vazio");
        }

        if (this.projeto.getDataEncerramentoPrevisto() == null) {
            throw new BusinessExceptions("O campo Data de Encerramento Previsto não pode ser Nulo ou Vazio");
        }

        if ("".equalsIgnoreCase(this.projeto.getDescricao()) || this.projeto.getDescricao() == null) {
            throw new BusinessExceptions("O campo Descrição não pode ser Nulo ou Vazio");
        } else {
            if (this.projeto.getDescricao().length() > 255) {
                throw new BusinessExceptions("O campo Desricao não pode conter mais de 255 caracteres");
            }
        }

        if (this.projeto.getSituacao() == null) {
            throw new BusinessExceptions("Não é possível criar ou alterar um registro de Projeto sem uma Situação vinculada.");
        }

        if (this.projeto.getTipo() == null) {
            throw new BusinessExceptions("Não é possível criar ou alterar um registro de Projeto sem uma Tipo vinculado.");
        }

        this.projetoDao.save(projeto);

    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.projeto = (Projeto) objeto;

        if (this.projeto.getId() == null || this.projeto.getId() == 0) {
            throw new BusinessExceptions("Nao foi possível encontrar o indice do registro.");
        }

        this.projetoDao.delete(projeto);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.projetoDao.getAll();
    }
    
    @Override
    public Object obter(Integer id) throws BusinessExceptions {
        return this.projetoDao.getByPrimaryKey(id);
    }
}
