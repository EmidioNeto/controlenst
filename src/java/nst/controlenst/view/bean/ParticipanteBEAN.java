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
import nst.controlenst.persistence.dao.connection.ConnectionJDBC;
import nst.controlenst.view.bean.facesutil.FacesUtil;

/**
 *
 * @author emidio
 */
@ManagedBean(name = "ParticipanteBean")
@SessionScoped
public class ParticipanteBEAN implements Serializable {

    ParticipanteBO participanteBO;
    VinculoBO vinculoBO;
    TipoIngressoBO TipoIngressoBO;
    CargoBO cargoBO;
    TelefoneParticipanteBO telefoneParticipanteBO;
    HistoricoParticipantesBO historicoParticipanteBO;
    CursoBO cursoBO;
    ProjetoBO projetoBO;
    MotivoSaidaBO motivoSaidaBO;
    EmailParticipanteBO emailParticipanteBO;
    Participante participante;
    EmailParticipante emailParticipante;
    HistoricoParticipante historicoParticipante;
    HistoricoParticipante historicoParticipanteEdit;
    TelefoneParticipante telefoneParticipante;
    Date data_saida;
    Date data_entrada;
    List<Object> listaPaticipantes;
    List<Object> listaHistoricoPaticipante;
    //Itens selecionados no formulário
    Vinculo vinculo = new Vinculo();
    Curso curso = new Curso();
    Integer semestre;
    Integer id_tipo_ingresso;
    Integer id_motivo_saida;
    Integer id_cargo;
    Integer id_projeto;
    Integer id_curso;
    Integer id_vinculo;
    //Lista dos itens para o formulário
    ArrayList<SelectItem> listaVinculos;
    ArrayList<SelectItem> listaTipoIngresso;
    ArrayList<SelectItem> listaMotivoSaida;
    ArrayList<SelectItem> listaCargos;
    ArrayList<SelectItem> listaProjeto;
    ArrayList<SelectItem> listaCurso;

    /** Creates a new instance of ParticipanteBEAN */
    public ParticipanteBEAN() {
        this.participanteBO = new ParticipanteBO();
        this.vinculoBO = new VinculoBO();
        this.TipoIngressoBO = new TipoIngressoBO();
        this.cargoBO = new CargoBO();
        this.telefoneParticipanteBO = new TelefoneParticipanteBO();
        this.historicoParticipanteBO = new HistoricoParticipantesBO();
        this.cursoBO = new CursoBO();
        this.projetoBO = new ProjetoBO();
        this.motivoSaidaBO = new MotivoSaidaBO();
        this.emailParticipanteBO = new EmailParticipanteBO();
        this.participante = new Participante();
        this.emailParticipante = new EmailParticipante();
        this.historicoParticipante = new HistoricoParticipante();
        this.historicoParticipanteEdit = new HistoricoParticipante();
        this.telefoneParticipante = new TelefoneParticipante();
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

    public void EditarHistorico(Integer id) {
        try {
            this.historicoParticipanteEdit = (HistoricoParticipante) historicoParticipanteBO.obter(id);

            this.id_cargo = this.historicoParticipanteEdit.getCargo() != null ? this.historicoParticipanteEdit.getCargo().getId() : 0;
            this.id_curso = this.historicoParticipanteEdit.getCurso() != null ? this.historicoParticipanteEdit.getCurso().getId() : 0;
            this.id_motivo_saida = this.historicoParticipanteEdit.getMotivoSaida() != null ? this.historicoParticipanteEdit.getMotivoSaida().getId() : 0;
            this.id_projeto = this.historicoParticipanteEdit.getProjeto() != null ? this.historicoParticipanteEdit.getProjeto().getId() : 0;
            this.id_tipo_ingresso = this.historicoParticipanteEdit.getTipoIngresso() != null ? this.historicoParticipanteEdit.getTipoIngresso().getId() : 0;
            this.id_vinculo = this.historicoParticipanteEdit.getVinculo() != null ? this.historicoParticipanteEdit.getVinculo().getId() : 0;

            this.data_entrada = this.historicoParticipanteEdit.getEntrada();
            this.data_saida = this.historicoParticipanteEdit.getSaida();
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SalvarHistorico() {
        this.historicoParticipante.setEntrada(new Timestamp(data_entrada.getTime()));
        if (data_saida == null) {
            this.historicoParticipante.setSaida(null);
        } else {
            this.historicoParticipante.setSaida(new Timestamp(data_saida.getTime()));
        }
        try {
            this.historicoParticipante.setMotivoSaida((MotivoSaida) motivoSaidaBO.obter(id_motivo_saida));

            this.historicoParticipanteEdit.setCurso((Curso) cursoBO.obter(id_curso));
            this.historicoParticipanteEdit.setParticipante(this.participante);
            this.historicoParticipanteEdit.setVinculo((Vinculo) vinculoBO.obter(id_vinculo));
            this.historicoParticipanteEdit.setTipoIngresso((TipoIngresso) TipoIngressoBO.obter(id_tipo_ingresso));
            this.historicoParticipanteEdit.setProjeto((Projeto) projetoBO.obter(id_projeto));
            this.historicoParticipanteEdit.setCargo((Cargo) cargoBO.obter(id_cargo));
            this.historicoParticipanteEdit.setSemestre(this.semestre);
            this.historicoParticipanteBO.save(this.historicoParticipanteEdit);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Carrega os dados do participante
    public String editar(Integer id) {
        try {
            this.participante = (Participante) this.participanteBO.obter(id);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.listaHistoricoPaticipante = this.historicoParticipanteBO.obterPorParticipante(this.participante);
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

        this.id_cargo = this.historicoParticipante.getCargo() != null ? this.historicoParticipante.getCargo().getId() : 0;
        this.id_curso = this.historicoParticipante.getCurso() != null ? this.historicoParticipante.getCurso().getId() : 0;
        this.id_motivo_saida = this.historicoParticipante.getMotivoSaida() != null ? this.historicoParticipante.getMotivoSaida().getId() : 0;
        this.id_projeto = this.historicoParticipante.getProjeto() != null ? this.historicoParticipante.getProjeto().getId() : 0;
        this.id_tipo_ingresso = this.historicoParticipante.getTipoIngresso() != null ? this.historicoParticipante.getTipoIngresso().getId() : 0;
        this.id_vinculo = this.historicoParticipante.getVinculo() != null ? this.historicoParticipante.getVinculo().getId() : 0;

        return "editar_participante";
    }

    public void deletar(Integer id) {
        try {
            this.participante = (Participante) this.participanteBO.obter(id);
            this.participanteBO.excluir(participante);
            this.resetarValores();
        } catch (BusinessExceptions ex) {
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", "Não foi possível deletar este registro!");
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", "Deletado com sucesso!");
    }

    public void deletarHistorico(Integer id) {
        try {
            this.historicoParticipante = (HistoricoParticipante) this.historicoParticipanteBO.obter(id);
            this.historicoParticipanteBO.excluir(historicoParticipante);
        } catch (BusinessExceptions ex) {
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", "Não foi possível deletar este registro!");
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", "Deletado com sucesso!");

    }

    //Inclui um novo registro no banco para este participante
    public String editarParticipante() {
        try {
            this.participanteBO.save(this.participante);
            this.historicoParticipanteBO.save(this.historicoParticipante);
            this.telefoneParticipanteBO.save(this.telefoneParticipante);
            this.emailParticipanteBO.save(this.emailParticipante);
            this.resetarValores();
            return "editar_participante";
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "editar_participante";
    }

    public void excluirParticipante(Integer id) {
        try {
            this.participanteBO.excluir(this.participante);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String inserirParticipante() {
        try {
            this.participanteBO.save(this.participante);

            this.participante = (Participante) this.participanteBO.obterPorMatricula(this.participante.getMatricula());

            this.historicoParticipante.setEntrada(new Timestamp(data_entrada.getTime()));
            if (data_saida == null) {
                this.historicoParticipante.setSaida(null);
            } else {
                this.historicoParticipante.setSaida(new Timestamp(data_saida.getTime()));
            }
            this.historicoParticipante.setMotivoSaida((MotivoSaida) motivoSaidaBO.obter(id_motivo_saida));
            this.historicoParticipante.setCurso((Curso) cursoBO.obter(id_curso));
            this.historicoParticipante.setParticipante(this.participante);
            this.historicoParticipante.setVinculo((Vinculo) vinculoBO.obter(id_vinculo));
            this.historicoParticipante.setTipoIngresso((TipoIngresso) TipoIngressoBO.obter(id_tipo_ingresso));
            this.historicoParticipante.setProjeto((Projeto) projetoBO.obter(id_projeto));
            this.historicoParticipante.setCargo((Cargo) cargoBO.obter(id_cargo));
            this.historicoParticipante.setSemestre(this.semestre);
            this.historicoParticipanteBO.save(this.historicoParticipante);


            this.telefoneParticipante.setParticipante(this.participante);
            this.telefoneParticipanteBO.save(this.telefoneParticipante);

            this.emailParticipante.setParticipante(this.participante);
            this.emailParticipanteBO.save(this.emailParticipante);

            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", "Cadastrado com Sucesso!");


            this.resetarValores();
            return "cadastroSucesso";
        } catch (BusinessExceptions ex) {
            ConnectionJDBC.doRollback();
            FacesUtil.adicionarMenssagem(FacesMessage.SEVERITY_ERROR, "", ex.getMessage());
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            return "cadastroErro";
        }

    }

    public void resetarValores() {
        this.participante = null;
        this.participante = new Participante();
        this.historicoParticipante = null;
        this.historicoParticipante = new HistoricoParticipante();
        this.emailParticipante = null;
        this.emailParticipante = new EmailParticipante();
        this.telefoneParticipante = null;
        this.telefoneParticipante = new TelefoneParticipante();

        this.data_entrada = null;
        this.data_saida = null;

        this.semestre = 0;

        this.id_tipo_ingresso = 0;

        this.id_motivo_saida = 0;

        this.id_cargo = 0;

        this.id_projeto = 0;

        this.id_curso = 0;

        this.id_vinculo = 0;
    }

    public String initCadastro() {
        this.resetarValores();
        return "novo_participante";
    }

    public ArrayList<SelectItem> getListaCurso() {
        if (this.listaCurso == null) {
            List<Object> listCurso;
            this.listaCurso = new ArrayList<SelectItem>();
            try {
                listCurso = cursoBO.listar();
                for (Object curso : listCurso) {
                    Curso c = (Curso) curso;
                    this.listaCurso.add(new SelectItem(c.getId(), c.getDescricao()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCurso;
    }

    public ArrayList<SelectItem> getListaProjeto() {
        if (this.listaProjeto == null) {
            List<Object> listProjeto;
            this.listaProjeto = new ArrayList<SelectItem>();
            try {
                listProjeto = projetoBO.listar();
                for (Object projeto : listProjeto) {
                    Projeto p = (Projeto) projeto;
                    this.listaProjeto.add(new SelectItem(p.getId(), p.getDescricao()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProjeto;
    }

    public ArrayList<SelectItem> getListaMotivoSaida() {
        if (this.listaMotivoSaida == null) {
            List<Object> listMotivoSaida;
            this.listaMotivoSaida = new ArrayList<SelectItem>();
            try {
                listMotivoSaida = motivoSaidaBO.listar();
                for (Object motivoSaida : listMotivoSaida) {
                    MotivoSaida m = (MotivoSaida) motivoSaida;
                    this.listaMotivoSaida.add(new SelectItem(m.getId(), m.getDescricao()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaMotivoSaida;
    }

    public ArrayList<SelectItem> getlistaCargos() {
        if (this.listaCargos == null) {
            List<Object> listCargos;
            this.listaCargos = new ArrayList<SelectItem>();
            try {
                listCargos = cargoBO.listar();
                for (Object cargo : listCargos) {
                    Cargo c = (Cargo) cargo;
                    this.listaCargos.add(new SelectItem(c.getId(), c.getDescricao()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCargos;
    }

    public ArrayList<SelectItem> getListaTipoIngresso() {
        if (this.listaTipoIngresso == null) {
            List<Object> listTipoIngressos;
            this.listaTipoIngresso = new ArrayList<SelectItem>();
            try {
                listTipoIngressos = TipoIngressoBO.listar();
                for (Object tipoIngresso : listTipoIngressos) {
                    TipoIngresso t = (TipoIngresso) tipoIngresso;
                    this.listaTipoIngresso.add(new SelectItem(t.getId(), t.getDescricao()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaTipoIngresso;
    }

    public ArrayList<SelectItem> getListaVinculos() {
        if (this.listaVinculos == null) {
            List<Object> listVinculos;
            this.listaVinculos = new ArrayList<SelectItem>();
            try {
                listVinculos = vinculoBO.listar();
                for (Object vinculo : listVinculos) {
                    Vinculo v = (Vinculo) vinculo;
                    this.listaVinculos.add(new SelectItem(v.getId(), v.getDescricao()));
                }
            } catch (BusinessExceptions ex) {
                Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaVinculos;
    }

    public List<Object> getListaHistoricoPaticipante() {
        try {
            this.listaHistoricoPaticipante = this.historicoParticipanteBO.obterPorParticipante(this.participante);
        } catch (BusinessExceptions ex) {
            Logger.getLogger(ParticipanteBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.listaHistoricoPaticipante;
    }

    public void setListaHistoricoPaticipante(List<Object> listaHistoricoPaticipante) {
        this.listaHistoricoPaticipante = listaHistoricoPaticipante;
    }
}