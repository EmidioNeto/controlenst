/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.view.report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import nst.controlenst.persistence.dao.connection.ConnectionJDBC;
import nst.controlenst.view.bean.facesutil.FacesUtil;

/**
 *
 * @author emidio
 */
public class AbstractReport {

    private static final int DEFAULT_BUFFER_SIZE = 1024000;
    protected String query = "";
    protected String NomeRelatorio = "";
    protected Map parameters;
    protected String nomeRelatorio;
    protected String pathReport;
    protected String relatorioGerado;
    protected Statement stm;
    protected ResultSet rs;

    public AbstractReport() {
        this.parameters = new HashMap();
    }

    public String getNomeRelatorio() {
        return NomeRelatorio;
    }

    public void setNomeRelatorio(String NomeRelatorio) {
        this.NomeRelatorio = NomeRelatorio;
    }

    public Map getParameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    public String getPathReport() {
        return pathReport;
    }

    public void setPathReport(String pathReport) {
        this.pathReport = pathReport;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRelatorioGerado() {
        return relatorioGerado;
    }

    public void setRelatorioGerado(String relatorioGerado) {
        this.relatorioGerado = relatorioGerado;
    }

    public String print() {
        try {
            Connection con = ConnectionJDBC.getConnection();
            this.stm = con.createStatement();
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            this.rs = stm.executeQuery(this.query);
            JasperRunManager.runReportToPdfFile(this.pathReport, this.parameters, jrRS);
        } catch (JRException ex) {
            Logger.getLogger(AbstractReport.class.getName()).log(Level.SEVERE, null, ex);
          FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "", ex.getMessage()); 
        } catch(SQLException ex){
            Logger.getLogger(AbstractReport.class.getName()).log(Level.SEVERE, null, ex);
          FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "", ex.getMessage()); 
        }
        return "";
    }

    public void downloadReport(String nomeArquivo) throws ClassNotFoundException, SQLException, JRException, IOException {
        final FacesContext context = FacesContext.getCurrentInstance();

        final String path = ((ServletContext) context.getExternalContext().getContext()).getRealPath("/");

        ExternalContext externalContext = context.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        File file = new File(path + "reports/", nomeArquivo);
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
        try {
            input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);

            response.reset();
            response.setHeader("Content-Type", "application/pdf");
            response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Content-Disposition", "inline; filename=\"" + nomeArquivo + "\"");
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

            output.flush();
        }catch (IOException ex) {
            Logger.getLogger(AbstractReport.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "", ex.getMessage()); 
        } finally {
            close(output);
            close(input);
            file.delete();
        }

        context.responseComplete();

    }

    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
