/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.util;

import nst.controlenst.persistence.dao.factory.impl.JDBCFactory;
import nst.controlenst.persistence.dao.factory.interfaces.DAOFactory;

/**
 *
 * @author pablosouza
 */
public class FabricaDAO {

    private static DAOFactory factory = new JDBCFactory();

    public static DAOFactory getFactoryType() throws Exception {
        if (factory != null) {
            return factory;
        } else {
            throw new Exception("DAOFactory nao foi inicializado.");
        }
    }

    //Colocar o argumento como ENUM
    public static void setFactoryType(DAOFactory factory) {
        FabricaDAO.factory = factory;
    }
}
