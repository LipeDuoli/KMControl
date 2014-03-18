/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmcontrol.controller;

import com.kmcontrol.entities.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fillipe
 */
public class UsuarioControllerTest {
    
    public UsuarioControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetListaUsuarios() {
    }

    @Test
    public void testInserirUsuario() {
        Usuario u = new Usuario("teste", "login2", "senha", false, true);
        UsuarioController uc = new UsuarioController();
        uc.setUsuario(u);
        uc.inserirUsuario();
    }

    @Test
    public void testAlterarUsuario() {
    }

    @Test
    public void testExcluir() {
    }
    
}
