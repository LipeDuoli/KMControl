package com.kmcontrol.controller;

import com.kmcontrol.dao.AtendimentoDao;
import com.kmcontrol.dao.UsuarioDao;
import com.kmcontrol.entities.Atendimento;
import com.kmcontrol.entities.Usuario;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "AtendimentoCoordenador")
@ViewScoped
public class AtendimentoCoordenador {

    private Atendimento atendimento;
    private AtendimentoDao atendimentoDao;
    private UsuarioDao usuarioDao;
    private Usuario usuario;
    private Date dataInicial, dataFinal;

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

    public Atendimento getAtendimento() {
        if (this.atendimento == null) {
            atendimento = new Atendimento();
        }
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
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
        return atendimentoDao.listarAtendimento(usuario, dataInicial, dataFinal);
    }

    public void preparaAlterarChamado(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
    
    public void preparaFiltrarUsuario(String login) {
        usuarioDao = new UsuarioDao();
        this.usuario = usuarioDao.buscaLogin(login);
    }
}
