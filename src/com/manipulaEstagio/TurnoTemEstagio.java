package com.manipulaEstagio;

public class TurnoTemEstagio {
	
	int id_turno;
	int id_estagio;
	public int getId_turno() {
		return id_turno;
	}
	public void setId_turno(int id_turno) {
		this.id_turno = id_turno;
	}
	public int getId_estagio() {
		return id_estagio;
	}
	public void setId_estagio(int id_estagio) {
		this.id_estagio = id_estagio;
	}
	@Override
	public String toString() {
		return "TurnoTemEstagio [id_turno=" + id_turno + ", id_estagio="
				+ id_estagio + "]";
	}
	
	
}
