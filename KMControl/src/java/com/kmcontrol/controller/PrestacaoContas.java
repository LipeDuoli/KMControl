package com.kmcontrol.controller;

import com.kmcontrol.dao.AtendimentoDao;
import com.kmcontrol.dao.TabelaPrecoDao;
import com.kmcontrol.entities.Atendimento;
import com.kmcontrol.entities.TabelaPreco;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "PrestacaoContas")
@ViewScoped
public class PrestacaoContas {

    private TabelaPreco tabelaPreco;
    private TabelaPrecoDao tabelaPrecoDao = new TabelaPrecoDao();
    private List<Atendimento> atendimentos;
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
        
    }

}
