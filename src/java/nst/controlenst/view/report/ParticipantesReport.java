/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.view.report;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRException;
import nst.controlenst.view.bean.facesutil.FacesUtil;

/**
 *
 * @author emidio
 */
@ManagedBean(name = "ParticipantesReport")
@SessionScoped
public class ParticipantesReport extends AbstractReport {

    private static final int DEFAULT_BUFFER_SIZE = 1024000;

    @Override
    public void setQuery(String query) {
        super.setQuery(query);
    }

    @Override
    public void setPathReport(String pathReport) {
        super.setPathReport(pathReport);
    }

    @Override
    public void setParameters(Map parameters) {
        super.setParameters(parameters);
    }

    @Override
    public String print() {
        final FacesContext context = FacesContext.getCurrentInstance();
        final String path = ((ServletContext) context.getExternalContext().getContext()).getRealPath("/");

        super.setNomeRelatorio("participantes");
        //caminho até o compilado do relatório
        this.setPathReport(path + "reports/" + this.NomeRelatorio + ".jasper");
        FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "", "Relatório gerado com sucesso!");
        this.setQuery("select * from participantes");
        /*Passando parâmetros para o ireport
        super.parameters.put("param1","param1valor");
         */
        super.print();
        super.setRelatorioGerado(path + "reports/" + this.NomeRelatorio + ".pdf");


        try {
            super.downloadReport(this.NomeRelatorio + ".pdf");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ParticipantesReport.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "", ex.getMessage()); 
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantesReport.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "", ex.getMessage()); 
        } catch (JRException ex) {
            Logger.getLogger(ParticipantesReport.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "", ex.getMessage()); 
        } catch (IOException ex) {
            Logger.getLogger(ParticipantesReport.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "", ex.getMessage()); 
        }

        return "relatorios.xhtml";
    }
}
