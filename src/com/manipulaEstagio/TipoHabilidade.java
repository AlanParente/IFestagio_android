package com.manipulaEstagio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table ( name = "tipo_habilidade")
public class TipoHabilidade {
	@Column ( name = "id_tipo_habilidade" )
	int id_tipo_habilidade;
	@Column ( name = "ds_tipo_habilidade" )
	String desc_tipo_habilidade;
	
	public int getId_tipo_habilidade() {
		return id_tipo_habilidade;
	}
	public void setId_tipo_habilidade(int id_tipo_habilidade) {
		this.id_tipo_habilidade = id_tipo_habilidade;
	}
	public String getDesc_tipo_habilidade() {
		return desc_tipo_habilidade;
	}
	public void setDesc_tipo_habilidade(String desc_tipo_habilidade) {
		this.desc_tipo_habilidade = desc_tipo_habilidade;
	}
	
	@Override
	public String toString() {
		return id_tipo_habilidade+ ", " + desc_tipo_habilidade ;
	}
	
	

}
