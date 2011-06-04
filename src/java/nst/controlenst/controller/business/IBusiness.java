/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.controller.business;

import java.util.ArrayList;

/**
 *
 * @author pablosouza
 */
public interface IBusiness {
    public void save(Object objeto);
    public void excluir(Object objeto);
    public ArrayList<Object> listar();
}
