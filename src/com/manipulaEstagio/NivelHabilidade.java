package com.manipulaEstagio;

public class NivelHabilidade {
	
	int id_nivel_habilidade;
	String desc_nivel_habilidade;
	public int getId_nivel_habilidade() {
		return id_nivel_habilidade;
	}
	public void setId_nivel_habilidade(int id_nivel_habilidade) {
		this.id_nivel_habilidade = id_nivel_habilidade;
	}
	public String getDesc_nivel_habilidade() {
		return desc_nivel_habilidade;
	}
	public void setDesc_nivel_habilidade(String desc_nivel_habilidade) {
		this.desc_nivel_habilidade = desc_nivel_habilidade;
	}
	@Override
	public String toString() {
		return "NivelHabilidade [id_nivel_habilidade=" + id_nivel_habilidade
				+ ", desc_nivel_habilidade=" + desc_nivel_habilidade + "]";
	}
	
	

}
