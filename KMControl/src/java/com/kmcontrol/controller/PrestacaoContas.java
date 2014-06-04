package com.kmcontrol.controller;

import com.kmcontrol.arquivos.GeraRelatorio;
import com.kmcontrol.dao.TabelaPrecoDao;
import com.kmcontrol.entities.TabelaPreco;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "PrestacaoContas")
@ViewScoped
public class PrestacaoContas implements Serializable {

    private TabelaPreco tabelaPreco;
    private final TabelaPrecoDao tabelaPrecoDao = new TabelaPrecoDao();
    private Date dataInicial;
    private Date dataFinal;

    public PrestacaoContas() {
    }

    public TabelaPreco getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(TabelaPreco tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    @PostConstruct
    private void carregaCampos() {
        tabelaPreco = new TabelaPreco();
        tabelaPreco = tabelaPrecoDao.carregaKm();
    }

    public void atualizaValorKm() {
        try {
            tabelaPrecoDao.alterar(tabelaPreco);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado o valor do KM", "Atualizado o valor do KM"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar Valor do KM", "Erro ao atualizar Valor do KM"));
        }
    }

    public void geraPlanilha() {
        GeraRelatorio gr = new GeraRelatorio();
        try {
            gr.gerarXls(dataInicial, dataFinal, tabelaPreco.getKm());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Relatorio Salvo no D: do micro.", "Relatorio Salvo no D: do micro."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar o Relatorio", "Erro ao salvar o relatorio."));
        }
    }

}
