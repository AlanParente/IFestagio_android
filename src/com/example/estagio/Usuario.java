package com.example.estagio;

public class Usuario {
	
	private String senha ;
	private String usuario;

	public Usuario(String usuario, String senha){
		this.usuario = usuario;
		this.senha = senha;
		
	}

	public Usuario() {
		this.usuario = usuario;
		this.senha = senha;
	}

	protected String getSenha() {
		return senha;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}

	protected String getUsuario() {
		return usuario;
	}

	protected void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
