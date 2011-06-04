/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business;

import java.util.ArrayList;
import nst.controlenst.controller.business.exception.BusinessExceptions;

/**
 *
 * @author pablosouza
 */
public interface IBusiness {
    public void save(Object objeto) throws BusinessExceptions;
    public void excluir(Object objeto) throws BusinessExceptions;
    public ArrayList<Object> listar() throws BusinessExceptions;
}
