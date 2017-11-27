/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checkEvents.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.checkEvents.serializer.CustomContatoSerializer;
import br.com.checkEvents.serializer.CustomEnderecoSerializer;
import br.com.checkEvents.serializer.CustomLocalizacaoSerializer;
import br.com.checkEvents.serializer.CustomOrganizadorEventoSerializer;
import br.com.checkEvents.serializer.CustomTipoEventoSerializer;
import br.com.checkEvents.serializer.CustomUsuarioParticipanteSerializer;

/**
 *
 * @author rodrigo alves
 */
@Entity
@Table(name = "evento")
public class Evento extends BaseEntity {

    @Basic(optional = false)
    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataInicio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataTermino;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    @Cascade({CascadeType.ALL})
    @JsonSerialize(using = CustomEnderecoSerializer.class)
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "localizacao_id")
    @Cascade({CascadeType.ALL})
    @JsonSerialize(using = CustomLocalizacaoSerializer.class)
    private Localizacao localizacao;

    @OneToOne
    @JoinColumn(name = "contato_id")
    @Cascade({CascadeType.ALL})
    @JsonSerialize(using = CustomContatoSerializer.class)
    private Contato contato;

    @OneToOne
    @JoinColumn(name = "tipo_evento_id")
    @Cascade({CascadeType.ALL})
    @JsonSerialize(using = CustomTipoEventoSerializer.class)
    private TipoEvento tipoEvento;

    @ManyToOne
    //@JoinColumn(insertable = true, updatable = true)
    @JsonSerialize(using = CustomOrganizadorEventoSerializer.class)
    private Usuario organizador;

    @ManyToMany(mappedBy = "eventosParticipados")
   // @JoinColumn(insertable = true, updatable = true)
    @JsonSerialize(using = CustomUsuarioParticipanteSerializer.class)
    @Cascade({CascadeType.ALL})
    private List<Usuario> participantes;

    public Evento() {
    }

    public Evento(String descricao, Date dataInicio, Date dataTermino, Endereco endereco, Localizacao localizacao, Contato contato, TipoEvento tipoEvento, Usuario organizador) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.endereco = endereco;
        this.localizacao = localizacao;
        this.contato = contato;
        this.tipoEvento = tipoEvento;
        this.organizador = organizador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public String toString() {
        return " Evento[ id=" + this.getId() + " ]";
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Usuario getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

}
