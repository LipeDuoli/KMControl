package com.kmcontrol.arquivos;

import com.kmcontrol.dao.AtendimentoDao;
import com.kmcontrol.entities.Atendimento;
import java.util.Date;
import java.util.List;

public class GeraRelatorio {

    private List<Atendimento> atendimentos;
    private List<DadosRelatorio> dadosRelatorios;

    public void gerarXls(Date dataInicial, Date dataFinal, double valorKm) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        dadosRelatorios = atendimentoDao.listaRelatorio(dataInicial, dataFinal);
        
        for (DadosRelatorio d : dadosRelatorios) {
            System.out.println(d);
        }
        
    }

}
