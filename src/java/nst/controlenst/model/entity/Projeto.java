/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.model.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author pablosouza
 */
public class Projeto {
    private Integer id;
    private String nome;
    private String identificador;
    private Timestamp dataCadastro;
    private Timestamp dataInicio;
    private Timestamp dataEncerramentoPrevisto;
    private Timestamp dataEncerramento;
    private String descricao;
    private Situacao situacao;
    private Tipo tipo;

    public Projeto() {
    }
    
    public Projeto(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Timestamp getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Timestamp dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Timestamp getDataEncerramentoPrevisto() {
        return dataEncerramentoPrevisto;
    }

    public void setDataEncerramentoPrevisto(Timestamp dataEncerramentoPrevisto) {
        this.dataEncerramentoPrevisto = dataEncerramentoPrevisto;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projeto other = (Projeto) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.identificador == null) ? (other.identificador != null) : !this.identificador.equals(other.identificador)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 79 * hash + (this.identificador != null ? this.identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString(){
        return this.getDescricao();
    }   
}
