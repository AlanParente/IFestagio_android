package com.manipulaEstagio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table ( name = "habilidade")
public class Habilidade {
	@Column ( name = "id_habilidade")
	int id_habilidade;
	@Column ( name = "tipo_habilidade_id_tipo_habilidade")
	int id_tipo_habilidade;
	@Column ( name = "ds_habilidade")
	String desc_habilidade;
	
	public int getId_habilidade() {
		return id_habilidade;
	}
	public void setId_habilidade(int id_habilidade) {
		this.id_habilidade = id_habilidade;
	}
	public int getId_tipo_habilidade() {
		return id_tipo_habilidade;
	}
	public void setId_tipo_habilidade(int id_tipo_habilidade) {
		this.id_tipo_habilidade = id_tipo_habilidade;
	}
	public String getDesc_habilidade() {
		return desc_habilidade;
	}
	public void setDesc_habilidade(String desc_habilidade) {
		this.desc_habilidade = desc_habilidade;
	}
	@Override
	public String toString() {
		return  id_habilidade
				+ "," + id_tipo_habilidade
				+ "," + desc_habilidade ;
	}
	
	

}
