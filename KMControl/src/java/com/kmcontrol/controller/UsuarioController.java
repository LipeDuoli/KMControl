package com.kmcontrol.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.kmcontrol.dao.UsuarioDao;
import com.kmcontrol.entities.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class UsuarioController {

    private Usuario usuario;
    private UsuarioDao dao;

    public Usuario getUsuario() {
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List getListaUsuarios() {
        dao = new UsuarioDao();
        return dao.listarTodos();
    }

    public List getListaTecnicos() {
        dao = new UsuarioDao();
        return dao.listarTecnicos();
    }

    public void inserirUsuario() {
        dao = new UsuarioDao();
        if (dao.buscaLogin(usuario.getLogin()) == null) {
            String pass = Hashing.sha1().hashString(usuario.getSenha(), Charsets.UTF_8).toString();
            usuario.setSenha(pass);
            dao.salvar(usuario);
            this.usuario = new Usuario();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Usuario informado já existe"));

        }
    }

    public void alterarUsuario(Usuario usuario) {
        dao = new UsuarioDao();
        String pass = Hashing.sha1().hashString(usuario.getSenha(), Charsets.UTF_8).toString();
        usuario.setSenha(pass);
        dao.alterar(usuario);
    }

    public void excluir(Usuario usuario) {
        dao = new UsuarioDao();
        dao.excluir(usuario);
    }

}
