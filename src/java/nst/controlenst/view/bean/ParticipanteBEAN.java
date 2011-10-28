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
import nst.controlenst.controller.business.impl.CursoBO;
import nst.controlenst.controller.business.impl.EmailParticipanteBO;
import nst.controlenst.controller.business.impl.HistoricoParticipantesBO;
import nst.controlenst.controller.business.impl.MotivoSaidaBO;
import nst.controlenst.controller.business.impl.ParticipanteBO;
import nst.controlenst.controller.business.impl.ProjetoBO;
import nst.controlenst.controller.business.impl.TelefoneParticipanteBO;
import nst.controlenst.controller.business.impl.TipoIngressoBO;
import nst.controlenst.controller.business.impl.VinculoBO;
import nst.controlenst.model.entity.Cargo;
import nst.controlenst.model.entity.Curso;
import nst.controlenst.model.entity.EmailParticipante;
import nst.controlenst.model.entity.HistoricoParticipante;
import nst.controlenst.model.entity.MotivoSaida;
import nst.controlenst.model.entity.Participante;
import nst.controlenst.model.entity.Projeto;
import nst.controlenst.model.entity.TelefoneParticipante;
import nst.controlenst.model.entity.TipoIngresso;
import nst.controlenst.model.entity.Vinculo;
import nst.controlenst.view.bean.facesutil.FacesUtil;

/**
 *
 * @author emidio
 */
@ManagedBean(name="ParticipanteBean")
@SessionScoped
public class ParticipanteBEAN implements Serializable {
    
    ParticipanteBO participanteBO = new ParticipanteBO();
    VinculoBO vinculoBO = new VinculoBO();
    TipoIngressoBO TipoIngressoBO = new TipoIngressoBO();
    CargoBO cargoBO = new CargoBO();
    TelefoneParticipanteBO telefoneParticipanteBO = new TelefoneParticipanteBO();
    HistoricoParticipantesBO historicoParticipanteBO = new HistoricoParticipantesBO();
    CursoBO cursoBO = new CursoBO();
    ProjetoBO projetoBO = new ProjetoBO();
    MotivoSaidaBO motivoSaidaBO = new MotivoSaidaBO();
    EmailParticipanteBO emailParticipanteBO = new EmailParticipanteBO();    
    Participante participante = new Participante();
    EmailParticipante emailParticipante = new EmailParticipante();
    HistoricoParticipante historicoParticipante = new HistoricoParticipante();
    TelefoneParticipante telefoneParticipante = new TelefoneParticipante();
    
    Date data_saida;

    Date data_entrada;    
    
    List<Object> listaPaticipantes;
    List<Object> listaHistoricoPaticipante;
    //Itens selecionados no formulário
    Vinculo vinculo =  new Vinculo();
    Curso curso = new Curso();    

    Integer semestre;
    
    Integer id_tipo_ingresso;
    
    Integer id_motivo_saida;
    
    Integer id_cargo;
    
    Integer id_projeto;
    
    Integer id_curso;
    
    Integer id_vinculo;
    //Lista dos itens para o formulário
    ArrayList<SelectItem> listaVinculos = new ArrayList<SelectItem>();
    
    ArrayList<SelectItem> listaTipoIngresso = new ArrayList<SelectItem>();
    
    ArrayList<SelectItem> listaMotivoSaida = new ArrayList<SelectItem>();
    
    ArrayList<SelectItem> listaCargos = new ArrayList<SelectItem>();
    
    ArrayList<SelectItem> listaProjeto  = new ArrayList<SelectItem>();
    
    ArrayList<SelectItem> listaCurso  = new ArrayList<SelectItem>();

    /** Creates a new instance of ParticipanteBEAN */
    public ParticipanteBEAN() {
        this.initCadastro();
    }
    
    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
    
    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }
    
    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {        
        this.data_entrada = data_entrada;
    } 
    
    public void setListaVinculos(ArrayList<SelectItem> listaVinculo) {
        this.listaVinculos = listaVinculo;
    }

    public EmailParticipante getEmailParticipante() {
        return emailParticipante;
    }

    public void setEmailParticipante(EmailParticipante emailParticipante) {
        this.emailParticipante = emailParticipante;
    }

    public HistoricoParticipante getHistoricoParticipante() {
        return historicoParticipante;
    }

    public void setHistoricoParticipante(HistoricoParticipante historicoParticipante) {
        this.historicoParticipante = historicoParticipante;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public TelefoneParticipante getTelefoneParticipante() {
        return telefoneParticipante;
    }

    public void setTelefoneParticipante(TelefoneParticipante telefoneParticipante) {
        this.telefoneParticipante = telefoneParticipante;
    }

    public Vinculo getSel_vinculo() {
        return vinculo;
    }

    public void setSel_vinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public void setListaCurso(ArrayList<SelectItem> listaCurso) {
        this.listaCurso = listaCurso;
    }


    public void setListaMotivoSaida(ArrayList<SelectItem> listaMotivoSaida) {
        this.listaMotivoSaida = listaMotivoSaida;
    }

    public void setListaProjeto(ArrayList<SelectItem> listaProjeto) {
        this.listaProjeto = listaProjeto;
    }

    public void setlistaCargos(ArrayList<SelectItem> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public void setListaTipoIngresso(ArrayList<SelectItem> listaTipoIngresso) {
        this.listaTipoIngresso = listaTipoIngresso;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public Integer getId_motivo_saida() {
        return id_motivo_saida;
    }

    public void setId_motivo_saida(Integer id_motivo_saida) {
        this.id_motivo_saida = id_motivo_saida;
    }

    public Integer getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(Integer id_projeto) {
        this.id_projeto = id_projeto;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Integer getId_tipo_ingresso() {
        return id_tipo_ingresso;
    }

    public void setId_tipo_ingresso(Integer id_tipo_ingresso) {
        this.id_tipo_ingresso = id_tipo_ingresso;
    }

    public Integer getId_vinculo() {
        return id_vinculo;
    }

    public void setId_vinculo(Integer id_vinculo) {
        this.id_vinculo = id_vinculo;
    }
    
    public void setListaPaticipantes(List<Object> listaPaticipantes) {
        this.listaPaticipantes = listaPaticipantes;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public List<Object> getListaPaticipantes() {
        try {
            this.listaPaticipantes = participanteBO.listar();
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPaticipantes;
    }
    public String editar(Integer id){
        try {
            this.participante = (Participante) this.participanteBO.obter(id);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.historicoParticipante = (HistoricoParticipante) this.historicoParticipanteBO.obterPorParticipante(this.participante);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.telefoneParticipante = (TelefoneParticipante) this.telefoneParticipanteBO.obterPorParticipante(this.participante);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.emailParticipante = (EmailParticipante) this.emailParticipanteBO.obterPorParticipante(this.participante);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.id_cargo = this.historicoParticipante.getCargo() !=null ? this.historicoParticipante.getCargo().getId() : 0;
        this.id_curso = this.historicoParticipante.getCurso() !=null ? this.historicoParticipante.getCurso().getId() : 0;
        this.id_motivo_saida= this.historicoParticipante.getMotivoSaida()!=null ? this.historicoParticipante.getMotivoSaida().getId() : 0;
        this.id_projeto= this.historicoParticipante.getProjeto()!=null ? this.historicoParticipante.getProjeto().getId() : 0;
        this.id_tipo_ingresso = this.historicoParticipante.getTipoIngresso()!=null ? this.historicoParticipante.getTipoIngresso().getId() : 0;
        this.id_vinculo= this.historicoParticipante.getVinculo()!=null ? this.historicoParticipante.getVinculo().getId() : 0;
        
        return "editar_participante";
    }
    
    public void deletar(Integer id){
        try {
            this.participante = (Participante) this.participanteBO.obter(id);
            this.participanteBO.excluir(participante);
        } catch (BusinessExceptions ex) {
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", "Não foi possível deletar este registro!");
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", "Deletado com sucesso!");
    } 
    public String editarParticipante(){
        try {
            this.participanteBO.save(this.participante);
            this.historicoParticipanteBO.save(this.historicoParticipante);          
            this.telefoneParticipanteBO.save(this.telefoneParticipante);
            this.emailParticipanteBO.save(this.emailParticipante);
            return "editar_participante";
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "editar_participante";
    }
    public void excluirParticipante(Integer id ){
        try {
            this.participanteBO.excluir(this.participante);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String inserirParticipante(){
        try {
            this.participanteBO.save(this.participante);       
            
            this.participante = (Participante)this.participanteBO.obterPorMatricula(this.participante.getMatricula());
            
            this.historicoParticipante.setEntrada(new Timestamp(data_entrada.getTime()));
            if(data_saida==null){
                data_saida= new Date(0,0,0);
                this.historicoParticipante.setSaida(new Timestamp(data_saida.getTime()));
            }else{
                this.historicoParticipante.setSaida(new Timestamp(data_saida.getTime()));
            }
            this.historicoParticipante.setMotivoSaida((MotivoSaida)motivoSaidaBO.obter(id_motivo_saida));
            this.historicoParticipante.setCurso((Curso)cursoBO.obter(id_curso));                        
            this.historicoParticipante.setParticipante(this.participante);
            this.historicoParticipante.setVinculo((Vinculo)vinculoBO.obter(id_vinculo));
            this.historicoParticipante.setTipoIngresso((TipoIngresso)TipoIngressoBO.obter(id_tipo_ingresso));
            this.historicoParticipante.setProjeto((Projeto)projetoBO.obter(id_projeto));
            this.historicoParticipante.setCargo((Cargo)cargoBO.obter(id_cargo));
            this.historicoParticipante.setSemestre(this.semestre);
            this.historicoParticipanteBO.save(this.historicoParticipante);
            
            
            this.telefoneParticipante.setParticipante(this.participante);            
            this.telefoneParticipanteBO.save(this.telefoneParticipante);

            this.emailParticipante.setParticipante(this.participante);
            this.emailParticipanteBO.save(this.emailParticipante);
            return "cadastroSucesso";
            
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            return "cadastroErro";
        }
        
    }
    private void initCadastro() {    
        
            List<Object> cursos;
            try {
                cursos = cursoBO.listar();                
                for(Object curso : cursos){
                    Curso c = (Curso) curso;
                    this.listaCurso.add(new SelectItem(c.getId() , c.getDescricao()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            
            List<Object> projetos;
            try {
                projetos = projetoBO.listar();                
                for(Object projeto : projetos){
                    Projeto p = (Projeto) projeto;
                    this.listaProjeto.add(new SelectItem(p.getId() , p.getDescricao()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            List<Object> motivos;
            try {
                motivos = motivoSaidaBO.listar();                
                for(Object motivo : motivos){
                    MotivoSaida m = (MotivoSaida) motivo;
                    this.listaMotivoSaida.add(new SelectItem(m.getId() , m.getDescricao()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }     
            
            
            
            List<Object> tiposIngresso;
            try {
                tiposIngresso = TipoIngressoBO.listar();                
                for(Object tipo : tiposIngresso){
                    TipoIngresso t = (TipoIngresso) tipo;
                    this.listaTipoIngresso.add(new SelectItem(t.getId() , t.getDescricao()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            try {
                
            List<Object> cargos;
            try {
                cargos = cargoBO.listar();
                for(Object cargo : cargos){
                    Cargo c = (Cargo) cargo;
                    this.listaCargos.add(new SelectItem(c.getId() , c.getDescricao()));                
                }                
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }                
                
                
                List<Object> vinculos = vinculoBO.listar();
                for(Object vin : vinculos){
                    Vinculo v = (Vinculo) vin;
                    this.listaVinculos.add(new SelectItem(v.getId() , v.getDescricao()));                
                }

            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }    
    }
    public ArrayList<SelectItem> getListaCurso() {     
        return listaCurso;
    }    
    
    public ArrayList<SelectItem> getListaProjeto() {
        return listaProjeto;
    }
    
    public ArrayList<SelectItem> getListaMotivoSaida() {        
        return listaMotivoSaida;
    }
    
    public ArrayList<SelectItem> getlistaCargos() {
        return listaCargos;
    }
    public ArrayList<SelectItem> getListaTipoIngresso() {         
        return listaTipoIngresso;
    }
    
    public ArrayList<SelectItem> getListaVinculos() {
        return listaVinculos;
    }

    public List<Object> getListaHistoricoPaticipante() {
        return listaHistoricoPaticipante;
    }

    public void setListaHistoricoPaticipante(List<Object> listaHistoricoPaticipante) {
        this.listaHistoricoPaticipante = listaHistoricoPaticipante;
    }
    
}
