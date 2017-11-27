/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checkEvents.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.checkEvents.serializer.CustomContatoSerializer;
import br.com.checkEvents.serializer.CustomEventoOrganizadorSerializer;
import br.com.checkEvents.serializer.CustomEventoParticipanteSerializer;

/**
 *
 * @author rodrigo alves
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario extends BaseEntity {

    @Basic(optional = false)
    @NotNull
    @Column(name = "login")
    private String login;

    @Basic(optional = false)
    @NotNull
    @Column(name = "senha")
    private String senha;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_usuario")
    private boolean tipoUsuario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Column(name = "sobrenome")
    private String sobrenome;

    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private String sexo;

    @OneToOne
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "contato_id")
    @JsonSerialize(using = CustomContatoSerializer.class)
    private Contato contato;

    @OneToMany(mappedBy = "organizador")
    //@JoinColumn(name = "usuario_id", updatable = true, insertable = true)
    @Cascade({CascadeType.ALL})
    @JsonSerialize(using = CustomEventoOrganizadorSerializer.class)
    private List<Evento> eventos;

    @ManyToMany
//    @JoinTable(name = "usuario_evento",
//            joinColumns
//            = @JoinColumn(name = "usuario_id"),
//            inverseJoinColumns
//            = @JoinColumn(name = "evento_id")
//    )
    @Cascade({CascadeType.ALL})
    @JsonSerialize(using = CustomEventoParticipanteSerializer.class)
    private List<Evento> eventosParticipados;

    public Usuario() {
    }

    public Usuario(String login, String senha, boolean tipo) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Evento> getEventosParticipados() {
        return eventosParticipados;
    }

    public void setEventosParticipados(List<Evento> eventosParticipados) {
        this.eventosParticipados = eventosParticipados;
    }

}
