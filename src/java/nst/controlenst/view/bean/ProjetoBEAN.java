/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.view.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import nst.controlenst.controller.business.exception.BusinessExceptions;
import nst.controlenst.controller.business.impl.CargoBO;
import nst.controlenst.controller.business.impl.CoordenadorBO;
import nst.controlenst.controller.business.impl.ParticipanteBO;
import nst.controlenst.controller.business.impl.ProjetoBO;
import nst.controlenst.controller.business.impl.SituacaoBO;
import nst.controlenst.controller.business.impl.TipoBO;
import nst.controlenst.model.entity.Cargo;
import nst.controlenst.model.entity.Coordenador;
import nst.controlenst.model.entity.Participante;
import nst.controlenst.model.entity.Projeto;
import nst.controlenst.model.entity.Situacao;
import nst.controlenst.model.entity.Tipo;

/**
 *
 * @author emidio
 */
@ManagedBean(name="ProjetoBean")
@SessionScoped
public class ProjetoBEAN implements Serializable {
    
    Projeto projeto = new Projeto();
    
    ProjetoBO projetoBO = new ProjetoBO();
    SituacaoBO situacaoBO = new SituacaoBO();
    TipoBO tipoBO = new TipoBO();
    CoordenadorBO coordenadorBO = new CoordenadorBO();
    ParticipanteBO participanteBO = new ParticipanteBO();
    CargoBO cargoBO = new CargoBO();
    
    ArrayList<Object> listaSituacao = new ArrayList<Object>();
    
    ArrayList<SelectItem> listaTipo = new ArrayList<SelectItem>();            

    ArrayList<SelectItem> listaCoordenador = new ArrayList<SelectItem>();            
    
    ArrayList<SelectItem> listaCargo = new ArrayList<SelectItem>();            
    
    ArrayList<SelectItem> listaParticipante = new ArrayList<SelectItem>();            
    
    ArrayList<SelectItem> listaStatus = new ArrayList<SelectItem>();            
    
    Date data_cadastro = new Date();
    Date data_inicio;
    Date data_encer_previsto;
    Date data_encerramento;
    
    List<Object> listaProjetos;
    
    Integer id_tipo_projeto;
    
    Integer id_status;
    
    Integer id_coordenador;
    
    Integer id_participante;
    
    Integer id_cargo;
    
    ArrayList<Object> listaParticipanteProjeto = new ArrayList<Object>();
    
    /** Creates a new instance of ParticipanteBEAN */
    public ProjetoBEAN() {
        this.initCadastro();
    }

    public ArrayList<Object> getListaSituacao() {
        if(this.listaSituacao.size()<1){            
            try {
                this.listaSituacao = situacaoBO.listar();                       
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaSituacao;
    }

    public void setListaSituacao(ArrayList<Object> listaSituacao) {
        this.listaSituacao = listaSituacao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    private void initCadastro(){
            List<Object> tipos;
            try {
                tipos = tipoBO.listar();                
                for(Object tipo : tipos){
                    Tipo t = (Tipo) tipo;
                    this.listaTipo.add(new SelectItem(t.getId() , t.getDescricao()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            List<Object> listStatus;
            try {
                listStatus = situacaoBO.listar();                
                for(Object status : listStatus){
                    Situacao s = (Situacao) status;
                    this.listaStatus.add(new SelectItem(s.getId() , s.getDescricao()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            List<Object> listCoordenador;
            try {
                listCoordenador = coordenadorBO.listar();                
                for(Object coordenador : listCoordenador){
                    Coordenador c = (Coordenador) coordenador;
                    this.listaCoordenador.add(new SelectItem(c.getId() , c.getNome()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            List<Object> listParticipante;
            try {
                listParticipante = participanteBO.listar();                
                for(Object participante : listParticipante){
                    Participante p = (Participante) participante;
                    this.listaParticipante.add(new SelectItem(p.getId() , p.getNome()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            List<Object> listCargo;
            try {
                listCargo = cargoBO.listar();                
                for(Object cargo : listCargo){
                    Cargo c = (Cargo) cargo;
                    this.listaCargo.add(new SelectItem(c.getId() , c.getDescricao()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
    }
    public ArrayList<SelectItem> getListaTipo() {
        return listaTipo;
    }

    public void setListaTipo(ArrayList<SelectItem> listaTipo) {
        this.listaTipo = listaTipo;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Date getData_encer_previsto() {
        return data_encer_previsto;
    }

    public void setData_encer_previsto(Date data_encer_previsto) {
        this.data_encer_previsto = data_encer_previsto;
    }

    public Date getData_encerramento() {
        return data_encerramento;
    }

    public void setData_encerramento(Date data_encerramento) {
        this.data_encerramento = data_encerramento;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }
    
    public void inserirProjeto(){
        this.projeto.setDataCadastro(converterDateToTimeStamp(this.data_cadastro));
        this.projeto.setDataEncerramentoPrevisto(converterDateToTimeStamp(this.data_encer_previsto));
        this.projeto.setDataEncerramento(converterDateToTimeStamp(this.data_encerramento));
        this.projeto.setDataInicio(converterDateToTimeStamp(this.data_inicio));
        
        try {
            this.projeto.setSituacao((Situacao)situacaoBO.obter(id_status));
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.projeto.setTipo((Tipo)tipoBO.obter(id_tipo_projeto));
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        try{
            this.projetoBO.save(projeto);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setListaProjetos(List<Object> listaProjetos) {
        this.listaProjetos = listaProjetos;
    }
    
    public List<Object> getListaProjetos() {
        try {
            this.listaProjetos = projetoBO.listar();
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProjetos;
    }    
    

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

    public Integer getId_tipo_projeto() {
        return id_tipo_projeto;
    }

    public void setId_tipo_projeto(Integer id_tipo_projeto) {
        this.id_tipo_projeto = id_tipo_projeto;
    }
    
    private Timestamp converterDateToTimeStamp(Date data){
        return new Timestamp(data.getTime());
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Integer getId_coordenador() {
        return id_coordenador;
    }

    public void setId_coordenador(Integer id_coordenador) {
        this.id_coordenador = id_coordenador;
    }

    public Integer getId_participante() {
        return id_participante;
    }

    public void setId_participante(Integer id_participante) {
        this.id_participante = id_participante;
    }

    public ArrayList<Object> getListaParticipanteProjeto() {
        return listaParticipanteProjeto;
    }

    public void setListaParticipanteProjeto(ArrayList<Object> listaParticipanteProjeto) {
        this.listaParticipanteProjeto = listaParticipanteProjeto;
    }

    public ArrayList<SelectItem> getListaCargo() {
        return listaCargo;
    }

    public void setListaCargo(ArrayList<SelectItem> listaCargo) {
        this.listaCargo = listaCargo;
    }

    public ArrayList<SelectItem> getListaCoordenador() {
        return listaCoordenador;
    }

    public void setListaCoordenador(ArrayList<SelectItem> listaCoordenador) {
        this.listaCoordenador = listaCoordenador;
    }

    public ArrayList<SelectItem> getListaParticipante() {
        return listaParticipante;
    }

    public void setListaParticipante(ArrayList<SelectItem> listaParticipante) {
        this.listaParticipante = listaParticipante;
    }

    public ArrayList<SelectItem> getListaStatus() {
        return listaStatus;
    }

    public void setListaStatus(ArrayList<SelectItem> listaStatus) {
        this.listaStatus = listaStatus;
    }
    
    public void adicionarAprojeto(){
        System.out.println(" ---------- Chamou adicionarAprojeto! ----------");
        try {
            Participante p = (Participante)this.participanteBO.obter(this.id_participante);
            
            listaParticipanteProjeto.add(p);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
