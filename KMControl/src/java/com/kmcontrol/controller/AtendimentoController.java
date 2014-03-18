package com.kmcontrol.controller;

import com.kmcontrol.dao.AtendimentoDao;
import com.kmcontrol.entities.Atendimento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AtendimentoController {
    
    private Atendimento atendimento;
    private AtendimentoDao atendimentoDao;

    public Atendimento getAtendimento() {
        if(this.atendimento == null){
            atendimento = new Atendimento();
        }
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public AtendimentoDao getAtendimentoDao() {
        return atendimentoDao;
    }

    public void setAtendimentoDao(AtendimentoDao atendimentoDao) {
        this.atendimentoDao = atendimentoDao;
    }
    
    public List retornaAtendimento(){
        //tem que colocar para receber o ID do usuario
        return atendimentoDao.listarAtendimento(Long.MIN_VALUE);
    }
}
