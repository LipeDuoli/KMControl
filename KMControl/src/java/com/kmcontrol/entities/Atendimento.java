package com.kmcontrol.entities;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "atendimento", catalog = "dbkm")
public class Atendimento implements java.io.Serializable {

    private Long id;
    private Usuario usuario;
    private Date data;
    private Integer chamado;
    private String origem;
    private String destino;
    private int kminicial;
    private int kmfinal;
    private String obsAtendimento;
    private String motivoAlteracao;
    private Boolean aprovado;
    private Boolean pago;
    private Integer qtdHospedagem;
    private Double valorHospedagem;
    private Integer qtdPedagio;
    private Double valorPedagio;
    private Integer qtdEstacionamento;
    private Double valorEstacionamento;
    private Integer qtdAlimentacao;
    private Double valorAlimentacao;

    public Atendimento() {
    }

    public Atendimento(Usuario usuario, Date data, String origem, String destino, int kminicial, int kmfinal) {
        this.usuario = usuario;
        this.data = data;
        this.origem = origem;
        this.destino = destino;
        this.kminicial = kminicial;
        this.kmfinal = kmfinal;
    }

    public Atendimento(Usuario usuario, Date data, Integer chamado, String origem, String destino, int kminicial, int kmfinal, String obsAtendimento, String motivoAlteracao, Boolean aprovado, Boolean pago, Integer qtdHospedagem, Double valorHospedagem, Integer qtdPedagio, Double valorPedagio, Integer qtdEstacionamento, Double valorEstacionamento, Integer qtdAlimentacao, Double valorAlimentacao) {
        this.usuario = usuario;
        this.data = data;
        this.chamado = chamado;
        this.origem = origem;
        this.destino = destino;
        this.kminicial = kminicial;
        this.kmfinal = kmfinal;
        this.obsAtendimento = obsAtendimento;
        this.motivoAlteracao = motivoAlteracao;
        this.aprovado = aprovado;
        this.pago = pago;
        this.qtdHospedagem = qtdHospedagem;
        this.valorHospedagem = valorHospedagem;
        this.qtdPedagio = qtdPedagio;
        this.valorPedagio = valorPedagio;
        this.qtdEstacionamento = qtdEstacionamento;
        this.valorEstacionamento = valorEstacionamento;
        this.qtdAlimentacao = qtdAlimentacao;
        this.valorAlimentacao = valorAlimentacao;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false, length = 10)
    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Column(name = "chamado")
    public Integer getChamado() {
        return this.chamado;
    }

    public void setChamado(Integer chamado) {
        this.chamado = chamado;
    }

    @Column(name = "origem", nullable = false, length = 50)
    public String getOrigem() {
        return this.origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @Column(name = "destino", nullable = false, length = 50)
    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Column(name = "kminicial", nullable = false)
    public int getKminicial() {
        return this.kminicial;
    }

    public void setKminicial(int kminicial) {
        this.kminicial = kminicial;
    }

    @Column(name = "kmfinal", nullable = false)
    public int getKmfinal() {
        return this.kmfinal;
    }

    public void setKmfinal(int kmfinal) {
        this.kmfinal = kmfinal;
    }

    @Column(name = "obs_atendimento")
    public String getObsAtendimento() {
        return this.obsAtendimento;
    }

    public void setObsAtendimento(String obsAtendimento) {
        this.obsAtendimento = obsAtendimento;
    }

    @Column(name = "motivo_alteracao")
    public String getMotivoAlteracao() {
        return this.motivoAlteracao;
    }

    public void setMotivoAlteracao(String motivoAlteracao) {
        this.motivoAlteracao = motivoAlteracao;
    }

    @Column(name = "aprovado")
    public Boolean getAprovado() {
        return this.aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Column(name = "pago")
    public Boolean getPago() {
        return this.pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    @Column(name = "qtd_hospedagem")
    public Integer getQtdHospedagem() {
        return this.qtdHospedagem;
    }

    public void setQtdHospedagem(Integer qtdHospedagem) {
        this.qtdHospedagem = qtdHospedagem;
    }

    @Column(name = "valor_hospedagem", precision = 22, scale = 0)
    public Double getValorHospedagem() {
        return this.valorHospedagem;
    }

    public void setValorHospedagem(Double valorHospedagem) {
        this.valorHospedagem = valorHospedagem;
    }

    @Column(name = "qtd_pedagio")
    public Integer getQtdPedagio() {
        return this.qtdPedagio;
    }

    public void setQtdPedagio(Integer qtdPedagio) {
        this.qtdPedagio = qtdPedagio;
    }

    @Column(name = "valor_pedagio", precision = 22, scale = 0)
    public Double getValorPedagio() {
        return this.valorPedagio;
    }

    public void setValorPedagio(Double valorPedagio) {
        this.valorPedagio = valorPedagio;
    }

    @Column(name = "qtd_estacionamento")
    public Integer getQtdEstacionamento() {
        return this.qtdEstacionamento;
    }

    public void setQtdEstacionamento(Integer qtdEstacionamento) {
        this.qtdEstacionamento = qtdEstacionamento;
    }

    @Column(name = "valor_estacionamento", precision = 22, scale = 0)
    public Double getValorEstacionamento() {
        return this.valorEstacionamento;
    }

    public void setValorEstacionamento(Double valorEstacionamento) {
        this.valorEstacionamento = valorEstacionamento;
    }

    @Column(name = "qtd_alimentacao")
    public Integer getQtdAlimentacao() {
        return this.qtdAlimentacao;
    }

    public void setQtdAlimentacao(Integer qtdAlimentacao) {
        this.qtdAlimentacao = qtdAlimentacao;
    }

    @Column(name = "valor_alimentacao", precision = 22, scale = 0)
    public Double getValorAlimentacao() {
        return this.valorAlimentacao;
    }

    public void setValorAlimentacao(Double valorAlimentacao) {
        this.valorAlimentacao = valorAlimentacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atendimento other = (Atendimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
