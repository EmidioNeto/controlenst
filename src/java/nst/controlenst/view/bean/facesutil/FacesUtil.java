/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.view.bean.facesutil;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author emidio
 */
public class FacesUtil {
    
    public static void adicionarMenssagem(Severity severidade, String identificador,  
            String msg) {  
        FacesContext.getCurrentInstance().addMessage(identificador,  
                new FacesMessage(severidade, msg, msg));  
    }
}
