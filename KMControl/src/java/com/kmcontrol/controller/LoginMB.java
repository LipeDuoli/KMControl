package com.kmcontrol.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.kmcontrol.dao.UsuarioDao;
import com.kmcontrol.entities.Usuario;
import com.kmcontrol.util.Util;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

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

    public String autenticar() {
        dao = new UsuarioDao();
        Usuario u = dao.buscaLogin(usuario.getLogin());
        if (u != null) {
            String pass = Hashing.sha1().hashString(usuario.getSenha(), Charsets.UTF_8).toString();
            if (pass.equals(u.getSenha())) {
                this.usuario = u;
                HttpSession session = Util.getSession();
                session.setAttribute("login", u.getLogin());
                if (u.isCoordenador()) {
                    return "indexCoordenador";
                } else {
                    return "indexTecnico";
                }
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Usuario ou senha invalido"));
        return "index";
    }

    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "index";
    }
    
}
