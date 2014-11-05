package com.manipulaUsuario;

public class Aluno {
	
	int id_aluno;
	int id_cv;
	int id_pessoa;
	int id_curso;
	int matricula;
	public int getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}
	public int getId_cv() {
		return id_cv;
	}
	public void setId_cv(int id_cv) {
		this.id_cv = id_cv;
	}
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return "Aluno [id_aluno=" + id_aluno + ", id_cv=" + id_cv
				+ ", id_pessoa=" + id_pessoa + ", id_curso=" + id_curso
				+ ", matricula=" + matricula + "]";
	}
	
	

}
