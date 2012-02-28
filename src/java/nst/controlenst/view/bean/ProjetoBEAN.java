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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import nst.controlenst.controller.business.exception.BusinessExceptions;
import nst.controlenst.controller.business.impl.CargoBO;
import nst.controlenst.controller.business.impl.CoordenadorBO;
import nst.controlenst.controller.business.impl.HistoricoParticipantesBO;
import nst.controlenst.controller.business.impl.ParticipanteBO;
import nst.controlenst.controller.business.impl.ProjetoBO;
import nst.controlenst.controller.business.impl.SituacaoBO;
import nst.controlenst.controller.business.impl.TipoBO;
import nst.controlenst.model.entity.Cargo;
import nst.controlenst.model.entity.Coordenador;
import nst.controlenst.model.entity.HistoricoParticipante;
import nst.controlenst.model.entity.Participante;
import nst.controlenst.model.entity.Projeto;
import nst.controlenst.model.entity.Situacao;
import nst.controlenst.model.entity.Tipo;
import nst.controlenst.view.bean.facesutil.FacesUtil;

/**
 *
 * @author emidio
 */
@ManagedBean(name = "ProjetoBean")
@SessionScoped
public class ProjetoBEAN implements Serializable {

    Projeto projeto;
    Projeto projetoSelecionado;
    ProjetoBO projetoBO;
    SituacaoBO situacaoBO;
    TipoBO tipoBO;
    CoordenadorBO coordenadorBO;
    ParticipanteBO participanteBO;
    HistoricoParticipantesBO historicoParticipanteBO;
    CargoBO cargoBO;
    ArrayList<Object> listaSituacao;
    ArrayList<SelectItem> listaTipo;
    ArrayList<SelectItem> listaCoordenador;
    ArrayList<SelectItem> listaCargo;
    ArrayList<SelectItem> listaParticipante;
    ArrayList<SelectItem> listaStatus;
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
    HistoricoParticipante historicoParticipante = new HistoricoParticipante();
    Participante participante = new Participante();
    Cargo cargo = new Cargo();
    List listaParticipanteProjeto = new ArrayList<HistoricoParticipante>();

    /** Creates a new instance of ParticipanteBEAN */
    public ProjetoBEAN() {
        this.projeto = new Projeto();
        this.projetoSelecionado = new Projeto();
        this.projetoBO = new ProjetoBO();
        this.situacaoBO = new SituacaoBO();
        this.tipoBO = new TipoBO();
        this.coordenadorBO = new CoordenadorBO();
        this.participanteBO = new ParticipanteBO();
        this.historicoParticipanteBO = new HistoricoParticipantesBO();
        this.cargoBO = new CargoBO();
    }

    public ArrayList<Object> getListaSituacao() {
        if(this.listaSituacao==null || this.listaSituacao.size()<1){
            try {
                this.listaSituacao = situacaoBO.listar();                       
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaSituacao;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }
    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Integer getId_participante() {
        return id_participante;
    }

    public void setId_participante(Integer id_participante) {
        this.id_participante = id_participante;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }


    public Cargo getCargo() {
        return cargo;
    }
    private void initCadastro(){
            List<Object> tipos;
            try {
                tipos = tipoBO.listar();                
                for(Object tipo : tipos){
                    Tipo t = (Tipo) tipo;
                    this.listaTipo.add(new SelectItem(t.getId() , t.getDescricao()));                
                }                
            
            
            List<Object> listStatus;
            
                listStatus = situacaoBO.listar();                
                for(Object status : listStatus){
                    Situacao s = (Situacao) status;
                    this.listaStatus.add(new SelectItem(s.getId() , s.getDescricao()));                
                }                
            
            
            List<Object> listCoordenador;
            
                listCoordenador = coordenadorBO.listar();                
                for(Object coordenador : listCoordenador){
                    Coordenador c = (Coordenador) coordenador;
                    this.listaCoordenador.add(new SelectItem(c.getId() , c.getNome()));                
                }                
            
            
            
            List<Object> listParticipante;
            
                listParticipante = participanteBO.listar();                
                for(Object participante : listParticipante){
                    Participante p = (Participante) participante;
                    this.listaParticipante.add(new SelectItem(p.getId() , p.getNome()));                
                }                
            
            
            List<Object> listCargo;
            
                listCargo = cargoBO.listar();                
                for(Object cargo : listCargo){
                    Cargo c = (Cargo) cargo;
                    this.listaCargo.add(new SelectItem(c.getId() , c.getDescricao()));                
                }                
            
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
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

    private Timestamp converterDateToTimeStamp(Date data) {
        return new Timestamp(data.getTime());
    }

    public Integer getId_coordenador() {
        return id_coordenador;
    }

    public void setId_coordenador(Integer id_coordenador) {
        this.id_coordenador = id_coordenador;
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }

    public List getListaParticipanteProjeto() {
        return listaParticipanteProjeto;
    }

    public void setListaParticipanteProjeto(List listaParticipanteProjeto) {
        this.listaParticipanteProjeto = listaParticipanteProjeto;
    }

    public ArrayList<SelectItem> getListaCargo() {
        if(this.listaCargo == null){
            List<Object> listCargo;
            this.listaCargo = new ArrayList<SelectItem>();
            try {
                listCargo = cargoBO.listar();
                for (Object cargo : listCargo) {
                    Cargo c = (Cargo) cargo;
                    this.listaCargo.add(new SelectItem(c.getId(), c.getDescricao()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCargo;
    }

    public void setListaCargo(ArrayList<SelectItem> listaCargo) {
        this.listaCargo = listaCargo;
    }

    public ArrayList<SelectItem> getListaCoordenador() {
        if(this.listaCoordenador ==  null){
            List<Object> listCoordenador;
            this.listaCoordenador = new ArrayList<SelectItem>();
            try {
                listCoordenador = coordenadorBO.listar();
                for (Object coordenador : listCoordenador) {
                    Coordenador c = (Coordenador) coordenador;
                    this.listaCoordenador.add(new SelectItem(c.getId(), c.getNome()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCoordenador;
    }

    public void setListaCoordenador(ArrayList<SelectItem> listaCoordenador) {
        this.listaCoordenador = listaCoordenador;
    }

    public ArrayList<SelectItem> getListaParticipante() {
        if(this.listaParticipante==null){
            List<Object> listParticipante;
            this.listaParticipante = new ArrayList<SelectItem>();
            try {
                listParticipante = participanteBO.listar();
                for (Object participante : listParticipante) {
                    Participante p = (Participante) participante;
                    this.listaParticipante.add(new SelectItem(p.getId(), p.getNome()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaParticipante;
    }

    public void setListaParticipante(ArrayList<SelectItem> listaParticipante) {
        this.listaParticipante = listaParticipante;
    }

    public ArrayList<SelectItem> getListaStatus() {
        if(this.listaStatus == null){
            List<Object> listStatus;
            this.listaStatus = new ArrayList<SelectItem>();
            try {
                listStatus = situacaoBO.listar();
                for (Object status : listStatus) {
                    Situacao s = (Situacao) status;
                    this.listaStatus.add(new SelectItem(s.getId(), s.getDescricao()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaStatus;
    }

    public void setListaStatus(ArrayList<SelectItem> listaStatus) {
        this.listaStatus = listaStatus;
    }

    public void setListaProjetos(List<Object> listaProjetos) {
        this.listaProjetos = listaProjetos;
    }

    

    public ArrayList<SelectItem> getListaTipo() {
        if(this.listaTipo == null){
            this.listaTipo = new ArrayList<SelectItem>();
                List<Object> tipos;
                this.listaTipo = new ArrayList<SelectItem>();
                try {
                    tipos = tipoBO.listar();
                    for (Object tipo : tipos) {
                        Tipo t = (Tipo) tipo;
                        this.listaTipo.add(new SelectItem(t.getId(), t.getDescricao()));
                    }
                } catch (BusinessExceptions ex) {
                    Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return listaTipo;
    }

    public void setListaTipo(ArrayList<SelectItem> listaTipo) {
        this.listaTipo = listaTipo;
    }

    public void setListaSituacao(ArrayList<Object> listaSituacao) {
        this.listaSituacao = listaSituacao;
    }

    public void deletar(Projeto projeto) {
        try {
            this.projetoBO.excluir(projeto);
            this.listaProjetos.remove(projeto);
        } catch (BusinessExceptions ex) {
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", "Não foi possível deletar este registro!");
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", "Deletado com sucesso!");
    }

    public void adicionarAprojeto() {
        HistoricoParticipante historico = new HistoricoParticipante();
        try {
            this.participante = (Participante) this.participanteBO.obter(this.id_participante);
            this.cargo = (Cargo) this.cargoBO.obter(this.id_cargo);

            if (participanteJaAdicionado(this.participante)) {
                FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_WARN, "Participante já adicionado!", "Participante já adicionado!");
            } else {
                historico.setParticipante(this.participante);
                historico.setCargo(this.cargo);
                this.listaParticipanteProjeto.add(historico);
                FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_WARN, "Participante adicionado", "Participante adicionado!");
            }

        } catch (BusinessExceptions ex) {
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerDoprojeto(HistoricoParticipante historico) {
        try {
            this.participante = (Participante) this.participanteBO.obter(this.participante.getId());
            if (participanteJaAdicionado(this.participante)) {
                this.listaParticipanteProjeto.remove(historico);
                FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_WARN, "Participante removido!", "Participante removido!");
            }

        } catch (BusinessExceptions ex) {
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean participanteJaAdicionado(Participante p) {
        boolean existe = false;
        for (Object h : this.listaParticipanteProjeto) {
            HistoricoParticipante historico = (HistoricoParticipante) h;
            if (historico.getParticipante().getMatricula().equals(p.getMatricula())) {
                existe = true;
            }
        }
        return existe;
    }

    public String editar(Projeto projeto) {
        this.projeto = projeto;
        this.data_cadastro = new Date(this.projeto.getDataCadastro().getTime());
        if(this.projeto.getDataInicio() != null)
            this.data_inicio = new Date(this.projeto.getDataInicio().getTime());
        if(this.projeto.getDataEncerramentoPrevisto() != null)
            this.data_encer_previsto = new Date(this.projeto.getDataEncerramentoPrevisto().getTime());
        if(this.projeto.getDataEncerramento() != null)
            this.data_encerramento = new Date(this.projeto.getDataEncerramento().getTime());
        return "editProjeto.xhtml";
        
    }

    public String editarProjeto() {
        try {
            
            if(this.data_cadastro!=null){
                this.projeto.setDataCadastro(converterDateToTimeStamp(this.data_cadastro));
            }
            
            if(this.data_encer_previsto!=null){
                this.projeto.setDataEncerramentoPrevisto(converterDateToTimeStamp(this.data_encer_previsto));
            }
            
            if(this.data_encerramento!=null){
                this.projeto.setDataEncerramento(converterDateToTimeStamp(this.data_encerramento));
            }
            
            if(this.data_inicio!=null){
                this.projeto.setDataInicio(converterDateToTimeStamp(this.data_inicio));
            }
            this.projetoBO.save(this.projeto);
            this.projetoSelecionado = new Projeto();
            this.historicoParticipante = new HistoricoParticipante();

            Participante p = (Participante)this.participanteBO.obter(this.id_participante);
            
            listaParticipanteProjeto.add(p);
            return "listProjetos.xhtml";
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ProjetoBEAN.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_WARN, "", ex.getMessage());
            return "editProjeto.xhtml";
        }
    }

    public String inserirProjeto() {
        try {
            this.projeto.setDataCadastro(converterDateToTimeStamp(new Date()));

            if (this.data_encer_previsto != null) {
                this.projeto.setDataEncerramentoPrevisto(converterDateToTimeStamp(this.data_encer_previsto));
            }

            if (this.data_encerramento != null) {
                this.projeto.setDataEncerramento(converterDateToTimeStamp(this.data_encerramento));
            }

            if (this.data_inicio != null) {
                this.projeto.setDataInicio(converterDateToTimeStamp(this.data_inicio));
            }
            this.projeto.setSituacao((Situacao) situacaoBO.obter(id_status));
            this.projeto.setTipo((Tipo) tipoBO.obter(id_tipo_projeto));
            this.projeto.setCoordenador((Coordenador) coordenadorBO.obter(id_coordenador));
            this.projetoBO.save(projeto);
            this.projeto = (Projeto) this.projetoBO.obterPorIdentificador(projeto.getIdentificador());
            
            this.resetarValores();
            return "listProjetos.xhtml";
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_WARN, "", ex.getMessage());
            return "newProjeto.xhtml";
        }
        
    }
    
    public void resetarValores(){
        this.data_encer_previsto = null;
        this.data_inicio = null;
        this.data_encerramento = null;
        this.id_tipo_projeto = 0;
        this.id_status = 0;
        this.id_coordenador = 0;
    }
    
}