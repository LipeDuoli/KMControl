package com.kmcontrol.controller;

import com.kmcontrol.dao.AtendimentoDao;
import com.kmcontrol.dao.UsuarioDao;
import com.kmcontrol.entities.Atendimento;
import com.kmcontrol.entities.Usuario;
import com.kmcontrol.util.SessionUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "AtendimentoTecnico")
@ViewScoped
public class AtendimentoTecnico {

    private Atendimento atendimento;
    private AtendimentoDao atendimentoDao;
    private UsuarioDao usuarioDao;
    private Date dataInicial;
    private Date dataFinal;

    public AtendimentoTecnico() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        this.dataInicial = calendar.getTime();
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

    public Atendimento getAtendimento() {
        if (this.atendimento == null) {
            atendimento = new Atendimento();
        }
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public void cadastrarChamado() {
        usuarioDao = new UsuarioDao();
        atendimentoDao = new AtendimentoDao();
        try {
            atendimento.setUsuario(usuarioDao.buscaLogin(SessionUtil.getLogin()));
            removeNull();
            atendimentoDao.salvar(atendimento);
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Chamado registrado com exito.", "Chamado registrado com exito."));
            atendimento = new Atendimento();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possivel salvar o chamado", "Não foi possivel salvar o chamado"));
        }
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
        usuarioDao = new UsuarioDao();
        Usuario usuario = new UsuarioDao().buscaLogin(SessionUtil.getLogin());
        return atendimentoDao.listarAtendimento(usuario, dataInicial, dataFinal, "data");
    }

    public void deletarAtendimento(Atendimento u) {
        atendimentoDao = new AtendimentoDao();
        try {
            atendimentoDao.excluir(u);
            FacesContext.getCurrentInstance().addMessage("messageLista", new FacesMessage(FacesMessage.SEVERITY_INFO, "Chamado excluido com exito.", "Chamado excluido com exito."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("messageLista", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chamado excluido com exito.", "Chamado excluido com exito."));
        }
    }

    public void preparaAlterarChamado(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    private void removeNull() {
        if (atendimento.getQtdAlimentacao() == null) {
            atendimento.setQtdAlimentacao(0);
        }
        if (atendimento.getQtdEstacionamento() == null) {
            atendimento.setQtdEstacionamento(0);
        }
        if (atendimento.getQtdHospedagem() == null) {
            atendimento.setQtdHospedagem(0);
        }
        if (atendimento.getQtdPedagio() == null) {
            atendimento.setQtdPedagio(0);
        }
        if (atendimento.getValorAlimentacao() == null) {
            atendimento.setValorAlimentacao(0.0);
        }
        if (atendimento.getValorEstacionamento() == null) {
            atendimento.setValorEstacionamento(0.0);
        }
        if (atendimento.getValorHospedagem() == null) {
            atendimento.setValorHospedagem(0.0);
        }
        if (atendimento.getValorPedagio() == null) {
            atendimento.setValorPedagio(0.0);
        }
    }
}
