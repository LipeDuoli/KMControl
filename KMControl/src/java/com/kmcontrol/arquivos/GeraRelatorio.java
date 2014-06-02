package com.kmcontrol.arquivos;

import com.kmcontrol.dao.AtendimentoDao;
import com.kmcontrol.entities.Atendimento;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class GeraRelatorio {

    private List<Atendimento> atendimentos;
    private List<DadosRelatorio> dadosRelatorios = dadosRelatorios = new LinkedList<>();

    public void gerar(Date dataInicial, Date dataFinal, double valorKm) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentos = atendimentoDao.listarAtendimento(null, dataInicial, dataFinal, "id");
        long totalKm = 0;
        double outrasDespesas = 0;
        int posicao = 0;
        short init = 0;


        for (Atendimento atendimento : atendimentos) {
            if (init == 0) {
                posicao = atendimento.getUsuario().getId().intValue();
                init = 1;
            }

            if (atendimento.getUsuario().getId().intValue() != posicao) {
                dadosRelatorios.add(new DadosRelatorio(totalKm, outrasDespesas, totalKm * valorKm, atendimento.getUsuario().getLogin()));
                totalKm = 0;
                outrasDespesas = 0;
            }

            totalKm += atendimento.getKmfinal() - atendimento.getKminicial();
            if (atendimento.getQtdAlimentacao() != null && atendimento.getValorAlimentacao() != null) {
                outrasDespesas += atendimento.getQtdAlimentacao() * atendimento.getValorAlimentacao();
            }
            if (atendimento.getQtdEstacionamento() != null && atendimento.getValorEstacionamento() != null) {
                outrasDespesas += atendimento.getQtdEstacionamento() * atendimento.getValorEstacionamento();
            }
            if (atendimento.getQtdHospedagem() != null && atendimento.getValorHospedagem() != null) {
                outrasDespesas += atendimento.getQtdHospedagem() * atendimento.getValorHospedagem();
            }
            if (atendimento.getQtdPedagio() != null && atendimento.getValorPedagio() != null) {
                outrasDespesas += atendimento.getQtdPedagio() * atendimento.getValorPedagio();
            }
        }

        for (DadosRelatorio dr : dadosRelatorios) {
            System.out.println(dr);
        }

    }

}
