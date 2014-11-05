package com.manipulaEstagio;

public class HabilidadeEstagio {
	
	int id_habilidade_estagio;
	int id_nivel_habilidade;
	int id_estagio;
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
		return "HabilidadeEstagio [id_habilidade_estagio="
				+ id_habilidade_estagio + ", id_nivel_habilidade="
				+ id_nivel_habilidade + ", id_estagio=" + id_estagio
				+ ", peso=" + peso + "]";
	}
	
	

}
