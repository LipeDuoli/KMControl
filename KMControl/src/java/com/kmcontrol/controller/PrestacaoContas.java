package com.kmcontrol.controller;

import com.kmcontrol.entities.Atendimento;
import com.kmcontrol.entities.TabelaPreco;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "PrestacaoContas")
@ViewScoped
public class PrestacaoContas {
    
    private TabelaPreco tabelaPreco;
    private Atendimento atendimento;

    public PrestacaoContas() {
    }
    
    public TabelaPreco getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(TabelaPreco tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }
    

}
