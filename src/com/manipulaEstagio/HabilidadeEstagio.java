package com.manipulaEstagio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table ( name = "habilidade_estagio")
public class HabilidadeEstagio implements Serializable{
	@Column ( name = "id_habilidade_estagio" )
	int id_habilidade_estagio;
	@Column ( name = "nivel_habilidade_id_nivel_habilidade" )
	int id_nivel_habilidade;
	@Column ( name = "habilidade_id_habilidade" )
	int id_habilidade;
	@Column ( name = "estagio_id_estagio" )
	int id_estagio;
	@Column ( name = "peso" )
	int peso;
	public int getId_habilidade_estagio() {
		return id_habilidade_estagio;
	}
	public void setId_habilidade_estagio(int id_habilidade_estagio) {
		this.id_habilidade_estagio = id_habilidade_estagio;
	}
	public int getId_nivel_habilidade() {
		return id_nivel_habilidade;
	}
	public void setId_nivel_habilidade(int id_nivel_habilidade) {
		this.id_nivel_habilidade = id_nivel_habilidade;
	}
	public int getId_habilidade() {
		return id_habilidade;
	}
	public void setId_habilidade(int id_habilidade) {
		this.id_habilidade = id_habilidade;
	}
	public int getId_estagio() {
		return id_estagio;
	}
	public void setId_estagio(int id_estagio) {
		this.id_estagio = id_estagio;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return  id_habilidade_estagio + ", "
				+ id_nivel_habilidade + ", " + id_habilidade
				+ ", " + id_estagio + "," + peso ;
	}

	
	

}
