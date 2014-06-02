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
        int cont;

        for (Atendimento atendimento : atendimentos) {
            cont = atendimento.getId().intValue();

            if (atendimento.getId().intValue() != cont) {
                dadosRelatorios.add(new DadosRelatorio(totalKm, outrasDespesas, totalKm * valorKm, atendimento.getUsuario().getLogin()));
                totalKm = 0;
                outrasDespesas = 0;
            }

            totalKm += atendimento.getKmfinal() - atendimento.getKminicial();
            outrasDespesas += atendimento.getQtdAlimentacao() * atendimento.getValorAlimentacao();
            outrasDespesas += atendimento.getQtdEstacionamento() * atendimento.getValorEstacionamento();
            outrasDespesas += atendimento.getQtdHospedagem() * atendimento.getValorHospedagem();
            outrasDespesas += atendimento.getQtdPedagio() * atendimento.getValorPedagio();

        }

    }

    private static class DadosRelatorio {

        private long totalKm;
        private double outrasDespesas;
        private double valorTotal;
        private String login;

        public DadosRelatorio(long totalKm, double outrasDespesas, double valorTotal, String login) {
            this.totalKm = totalKm;
            this.outrasDespesas = outrasDespesas;
            this.valorTotal = valorTotal;
            this.login = login;
        }

        public long getTotalKm() {
            return totalKm;
        }

        public double getOutrasDespesas() {
            return outrasDespesas;
        }

        public double getValorTotal() {
            return valorTotal;
        }

        public String getLogin() {
            return login;
        }

    }

}
