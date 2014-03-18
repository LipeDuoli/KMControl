package com.kmcontrol.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private boolean coordenador;
    private boolean carroparticular;
    private String cpf;
    private String nomeBanco;
    private Integer conta;
    private Integer agencia;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, boolean coordenador, boolean carroparticular) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.coordenador = coordenador;
        this.carroparticular = carroparticular;
    }

    public Usuario(String nome, String login, String senha, boolean coordenador, boolean carroparticular, String cpf, String nomeBanco, Integer conta, Integer agencia) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.coordenador = coordenador;
        this.carroparticular = carroparticular;
        this.cpf = cpf;
        this.nomeBanco = nomeBanco;
        this.conta = conta;
        this.agencia = agencia;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false, length = 100)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "login", nullable = false, length = 45, unique = true)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "senha", nullable = false, length = 45)
    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "coordenador", nullable = false)
    public boolean isCoordenador() {
        return this.coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }

    @Column(name = "carroparticular", nullable = false)
    public boolean isCarroparticular() {
        return this.carroparticular;
    }

    public void setCarroparticular(boolean carroparticular) {
        this.carroparticular = carroparticular;
    }

    @Column(name = "cpf", length = 14)
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "nome_banco", length = 45)
    public String getNomeBanco() {
        return this.nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    @Column(name = "conta")
    public Integer getConta() {
        return this.conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    @Column(name = "agencia")
    public Integer getAgencia() {
        return this.agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
