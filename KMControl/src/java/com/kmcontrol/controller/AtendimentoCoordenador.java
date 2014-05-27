package com.kmcontrol.controller;

import com.kmcontrol.dao.AtendimentoDao;
import com.kmcontrol.dao.UsuarioDao;
import com.kmcontrol.entities.Atendimento;
import com.kmcontrol.entities.Usuario;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PostPersist;

@ManagedBean(name = "AtendimentoCoordenador")
@ViewScoped
public class AtendimentoCoordenador {

    private Atendimento atendimento;
    private AtendimentoDao atendimentoDao;
    private UsuarioDao usuarioDao;
    private Usuario usuario;
    private Date dataInicial;
    private Date dataFinal;
    private String LoginUsuarioSelecionado;

    public AtendimentoCoordenador() {
    }

    @PostConstruct
    public void carregaData() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        this.dataInicial = calendar.getTime();
    }

    public Atendimento getAtendimento() {
        if (this.atendimento == null) {
            atendimento = new Atendimento();
        }
        return atendimento;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public String getLoginUsuarioSelecionado() {
        return LoginUsuarioSelecionado;
    }

    public void setLoginUsuarioSelecionado(String LoginUsuarioSelecionado) {
        this.LoginUsuarioSelecionado = LoginUsuarioSelecionado;
    }

    public void alterarChamado() {
        atendimentoDao = new AtendimentoDao();
        try {
            atendimentoDao.alterar(this.atendimento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Chamado alterado com exito.", "Chamado alterado com exito."));
            atendimento = new Atendimento();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possivel salvar o chamado", "Não foi possivel salvar o chamado"));
        }
    }

    public Integer getKmFinal(Integer kmInicial, Integer kmFinal) {
        return kmFinal - kmInicial;
    }

    public List getAtendimentosTecnico() {
        atendimentoDao = new AtendimentoDao();
        if (LoginUsuarioSelecionado != null) {
            preparaFiltrarUsuario();
        }
        return atendimentoDao.listarAtendimento(this.usuario, dataInicial, dataFinal);
    }

    public void preparaAlterarChamado(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    private void preparaFiltrarUsuario() {
        usuarioDao = new UsuarioDao();
        this.usuario = usuarioDao.buscaLogin(LoginUsuarioSelecionado);
    }
}
