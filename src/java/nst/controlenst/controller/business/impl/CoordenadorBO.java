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
import nst.controlenst.persistence.dao.factory.interfaces.HistoricoCoordenadorDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class CoordenadorBO implements IBusiness {

    private CoordenadorDAO coordenadorDAO = null;
    private HistoricoCoordenadorDAO historicoCoordenadorDAO = null;
    private Coordenador coordenador = null;

    public CoordenadorBO() {
        try {
            this.coordenadorDAO = FabricaDAO.getFactoryType().getCoordenadorDAO();
            this.historicoCoordenadorDAO = FabricaDAO.getFactoryType().getHistoricoCoordenadorDAO();
        } catch (Exception ex) {
            Logger.getLogger(CoordenadorBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.coordenador = (Coordenador) objeto;

        /*
         * Nao pode ter Id nulo ou Zero
         */
        if (this.coordenador.getId() == null || this.coordenador.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }
        
        /*
         * Nao permite a exclusao de um Coordenador que esteja vinculado a um registro no Historico.
         */
        if(!this.historicoCoordenadorDAO.getAllByCoordenador(this.coordenador).isEmpty()){
            throw new BusinessExceptions("Não é permitido a exclusão de um Coordenador vinculado a um registro de Historico de Coordenadores.");
        }
        
        this.coordenadorDAO.delete(coordenador);
        
        
        
        //Não permitir a exclusao de um Coordenador que esteja vinculado a um projeto.
        
        
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
