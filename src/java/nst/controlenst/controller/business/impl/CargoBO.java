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
import nst.controlenst.enums.EnumDAO;
import nst.controlenst.enums.EnumTypeFactory;
import nst.controlenst.model.entity.Cargo;
import nst.controlenst.persistence.dao.factory.interfaces.CargoDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/**
 *
 * @author pablosouza
 */
public class CargoBO implements IBusiness {

    private CargoDAO cargoDAO = null;
    private Cargo cargo = null;
  
    public CargoBO() {
        try {
            this.cargoDAO = (CargoDAO) FabricaDAO.getFactoryType(EnumTypeFactory.JDBC).getDAO(EnumDAO.CARGODAO);
        } catch (Exception ex) {
            Logger.getLogger(CargoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object objeto) throws BusinessExceptions {
        this.cargo = (Cargo) objeto;

        if (this.cargo.getId() == null || this.cargo.getId() == 0) {
            throw new BusinessExceptions("Não foi possível identificar o valor do índice no objeto.");
        }

        this.cargoDAO.delete(cargo);
    }

    @Override
    public ArrayList<Object> listar() throws BusinessExceptions {
        return (ArrayList<Object>) this.cargoDAO.getAll();
    }

    @Override
    public void save(Object objeto) throws BusinessExceptions {
        this.cargo = (Cargo) objeto;
        
        if ("".equalsIgnoreCase(this.cargo.getDescricao()) || this.cargo.getDescricao() == null) {
            throw new BusinessExceptions("O campo Descrição não pode ser nulo.");
        }   
        this.cargoDAO.save(cargo);
    }
    
    @Override
    public Object obter(Integer id) throws BusinessExceptions {
        return this.cargoDAO.getByPrimaryKey(id);
    }
}
