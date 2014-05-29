package com.kmcontrol.estorias.passos;

import com.kmcontrol.controller.AtendimentoCoordenador;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class AtendimentosCoordenadorPasso {

    private AtendimentoCoordenador AtendimentoCoordenador;

    @Given("que a nutricionista vai calcular o IMC")
    public void inicializa() {
        AtendimentoCoordenador = new AtendimentoCoordenador();
    }

    @When("ele entra com o peso <peso>")
    public void setPeso(@Named ("peso") float peso) {
        calculadoraImc.setPeso(peso);
    }

    @When("ele entra com a altura <altura>")
    public void setAltura(@Named("altura")float altura) {
        calculadoraImc.setAltura(altura);
    }

    @Then("deve voltar o imc <imc>")
    public void resultadoImc(@Named("imc")float imc) {
        Assert.assertEquals(imc, calculadoraImc.calcularImc(),0.01d);
    }

    @Then("deve retornar a situacao <situacao>")
    public void resultadoSituacao(@Named("situacao") String situacao) {
        Assert.assertEquals(situacao, calculadoraImc.situacao());
    }

}
