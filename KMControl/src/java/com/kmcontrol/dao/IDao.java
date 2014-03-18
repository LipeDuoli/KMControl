/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmcontrol.dao;

import java.util.List;

/**
 *
 * @author Fillipe
 */
public interface IDao {
    public void salvar(Object obj);
    public void alterar(Object obj);
    public void excluir(Object obj);
    public List<Object>listarTodos();
}
