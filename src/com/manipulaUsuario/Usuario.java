/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaUsuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Keylla
 */
@Entity
@Table ( name = "usuario")
public class Usuario {
		@Column ( name = "id_usuario" )
		private int id_usuario;
		@Column ( name = "empresa_id_empresa" )
        private int id_empresa;
		@Column ( name = "tipo_usuario_id_tipo_usuario" )
        private int id_tipo_usuario;
		@Column ( name = "pessoa_id_pessoa" )
        private int id_pessoa;
		@Column ( name = "senha" )
		private String senha;
		@Column ( name = "login" )
        private String login;
		

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
	
    public int getId() {
	return id_usuario;
    }
    
    public void setId(int id) {
	this.id_usuario = id;
    }
    
    public String getLogin() {
	return login;
    }
    
    public void setLogin(String login) {
	this.login = login;
    }
    
    public String getSenha() {
	return senha;
    }
     
    public void setSenha(String senha) {
	this.senha = senha;
    }
	
    @Override
    public String toString() {
        return id_usuario + "," + id_empresa + ", " + id_tipo_usuario + ", " + id_pessoa + ", " + login + ", " + senha ;
    }
	
	

}