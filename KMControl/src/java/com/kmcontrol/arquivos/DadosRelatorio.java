package com.kmcontrol.arquivos;

public class DadosRelatorio {

    private long totalKm;
    private double outrasDespesas;
    private String nome;
    private String nomeBanco;
    private Integer conta;
    private Integer agencia;

    public DadosRelatorio() {
    }

    public DadosRelatorio(long totalKm, double outrasDespesas, String nome, String nomeBanco, Integer conta, Integer agencia) {
        this.totalKm = totalKm;
        this.outrasDespesas = outrasDespesas;
        this.nome = nome;
        this.nomeBanco = nomeBanco;
        this.conta = conta;
        this.agencia = agencia;
    }

    public long getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(long totalKm) {
        this.totalKm = totalKm;
    }

    public double getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(double outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return nome + " | " + totalKm + " | " + outrasDespesas;
    }
    
    
    
}
