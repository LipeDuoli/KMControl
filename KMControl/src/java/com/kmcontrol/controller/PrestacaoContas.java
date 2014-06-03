package com.kmcontrol.controller;

import com.kmcontrol.arquivos.GeraRelatorio;
import com.kmcontrol.dao.AtendimentoDao;
import com.kmcontrol.dao.TabelaPrecoDao;
import com.kmcontrol.entities.Atendimento;
import com.kmcontrol.entities.TabelaPreco;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
        tabelaPrecoDao.alterar(tabelaPreco);
    }
    
    public void geraPlanilha(){
        GeraRelatorio gr = new GeraRelatorio();
        gr.gerarXls(dataInicial, dataFinal, tabelaPreco.getKm());
    }

}
