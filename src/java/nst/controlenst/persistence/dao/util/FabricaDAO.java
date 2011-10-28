/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.util;

import nst.controlenst.enums.EnumTypeFactory;
import nst.controlenst.persistence.dao.factory.impl.HibernateFactory;
import nst.controlenst.persistence.dao.factory.impl.JDBCFactory;
import nst.controlenst.persistence.dao.factory.interfaces.DAOFactory;

/**
 *
 * @author pablosouza
 */
public class FabricaDAO {

    private static DAOFactory factoryJDBC = new JDBCFactory();
    private static DAOFactory factoryHIBERNATE = new HibernateFactory();

    public static DAOFactory getFactoryType(EnumTypeFactory F) throws Exception {
        if (F.equals(EnumTypeFactory.JDBC)) 
            return factoryJDBC;
        else if(F.equals(EnumTypeFactory.HIBERNATE))
            return factoryHIBERNATE;
        else{
            throw new Exception("DAOFactory nao foi inicializado.");            
        }           
            
        
    }
}
