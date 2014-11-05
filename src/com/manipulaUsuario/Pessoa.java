package com.manipulaUsuario;

import java.util.Date;

public class Pessoa {
	
	int id_pessoa;
	int id_contato;
	int id_rede_social;
	String nome;
	char sexo;
	int cpf;
	String e_mail;
	Date data_nascimento;
	String url_lattes;
	
	
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public int getId_contato() {
		return id_contato;
	}
	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}
	public int getId_rede_social() {
		return id_rede_social;
	}
	public void setId_rede_social(int id_rede_social) {
		this.id_rede_social = id_rede_social;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getUrl_lattes() {
		return url_lattes;
	}
	public void setUrl_lattes(String url_lattes) {
		this.url_lattes = url_lattes;
	}
	
    
}
