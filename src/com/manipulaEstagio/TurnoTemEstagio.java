package com.manipulaEstagio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table ( name = "turno_has_estagio")
public class TurnoTemEstagio implements Serializable{
	
	@Column ( name = "turno_id_turno" )
	int id_turno;
	@Column ( name = "estagio_id_estagio" )
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
		return  id_turno + ", "	+ id_estagio ;
	}
	
	
}
