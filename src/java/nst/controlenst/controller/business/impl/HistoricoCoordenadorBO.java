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
import nst.controlenst.model.entity.HistoricoCoordenador;
import nst.controlenst.persistence.dao.factory.interfaces.HistoricoCoordenadorDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class HistoricoCoordenadorBO implements IBusiness{
    
    
    private HistoricoCoordenador historicoCoordenador = null;
    private HistoricoCoordenadorDAO historicoCoordenadorDAO = null;

    public HistoricoCoordenadorBO() {
        try {
            historicoCoordenadorDAO = FabricaDAO.getFactoryType().getHistoricoCoordenadorDAO();
        } catch (Exception ex) {
            Logger.getLogger(HistoricoCoordenadorBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.historicoCoordenador = (HistoricoCoordenador) objeto;
        
        //dataentrada nao pode ser nula
        if(this.historicoCoordenador.getDataEntrada() == null){
            throw new BusinessExceptions("A Data de Entrada não pode ser nula");
        }
        
        //coordenador nao pode esta vazio
        if(this.historicoCoordenador.getCoordenador() == null){
            throw new BusinessExceptions("Não é possível criar ou alterar um registro de Historico sem um Coordenador vinculado.");
        }
        //projeto nao pode estar vazio
        //coordenador nao pode esta vazio
        if(this.historicoCoordenador.getProjeto() == null){
            throw new BusinessExceptions("Não é possível criar ou alterar um registro de Historico sem um Projeto vinculado.");
        }
        
        this.historicoCoordenadorDAO.save(historicoCoordenador);
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.historicoCoordenador = (HistoricoCoordenador) objeto;
        
        if(this.historicoCoordenador.getId() == null || this.historicoCoordenador.getId() == 0){
            throw new BusinessExceptions("Nao foi possível encontrar o indice do registro.");
        }
        
        this.historicoCoordenadorDAO.delete(historicoCoordenador);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.historicoCoordenadorDAO.getAll();
    }
    
}
