/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.factory.interfaces;

import nst.controlenst.persistence.dao.GenericJDBCDAO;
import nst.controlenst.enums.EnumDAO;

/**
 *
 * @author pablosouza
 */
public interface DAOFactory {
    public GenericJDBCDAO getDAO(EnumDAO D);
}
