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
import nst.controlenst.model.entity.HistoricoParticipante;
import nst.controlenst.persistence.dao.factory.interfaces.HIstoricoParticipanteDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class HistoricoParticipantesBO implements IBusiness {

    private HistoricoParticipante historicoParticipante = null;
    private HIstoricoParticipanteDAO historicoParticipanteDao = null;

    public HistoricoParticipantesBO() {
        try {
            historicoParticipanteDao = FabricaDAO.getFactoryType().getHistoricoParticipanteDAO();
        } catch (Exception ex) {
            Logger.getLogger(HistoricoParticipantesBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.historicoParticipante = (HistoricoParticipante) objeto;

        //se não for uma atualizacao...
        if (this.historicoParticipante.getId() == null || this.historicoParticipante.getId() == 0) {
            if (this.historicoParticipante.getEntrada() == null) {
                throw new BusinessExceptions("O campo Data de Entrada não pode ser Nula ou Vazia.");
            }

            if (this.historicoParticipante.getCargo() == null) {
                throw new BusinessExceptions("Não é possível criar ou alterar um registro de Historico sem um Cargo vinculado.");
            }

            if (this.historicoParticipante.getCurso() == null) {
                throw new BusinessExceptions("Não é possível criar ou alterar um registro de Historico sem um Curso vinculado.");
            }

            if (this.historicoParticipante.getVinculo() == null) {
                throw new BusinessExceptions("Não é possível criar ou alterar um registro de Historico sem um Vinculo vinculado.");
            }

            if (this.historicoParticipante.getParticipante() == null) {
                throw new BusinessExceptions("Não é possível criar ou alterar um registro de Historico sem um Participante vinculado.");
            }

            if (this.historicoParticipante.getTipoIngresso() == null) {
                throw new BusinessExceptions("Não é possível criar ou alterar um registro de Historico sem um Tipo de Ingresso vinculado.");
            }

            if (this.historicoParticipante.getProjeto() == null) {
                throw new BusinessExceptions("Não é possível criar ou alterar um registro de Historico sem um Projeto vinculado.");
            }
        }else{
            if(this.historicoParticipante.getMotivoSaida() == null || this.historicoParticipante.getSaida() == null){
                throw new BusinessExceptions("Não é permitido atualizar o histórico sem informar o Motivo da Saida e a Data da Saída.");
            }
        }
        this.historicoParticipanteDao.save(historicoParticipante);
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.historicoParticipante = (HistoricoParticipante) objeto;

        if (this.historicoParticipante.getId() == null || this.historicoParticipante.getId() == 0) {
            throw new BusinessExceptions("Nao foi possível encontrar o indice do registro.");
        }

        this.historicoParticipanteDao.delete(historicoParticipante);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.historicoParticipanteDao.getAll();
    }
}
