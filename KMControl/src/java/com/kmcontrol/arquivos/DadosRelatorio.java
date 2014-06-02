package com.kmcontrol.arquivos;

class DadosRelatorio {

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

    @Override
    public String toString() {
        return login + " | " + totalKm + " | " + outrasDespesas + " | " + valorTotal;
    }

}
