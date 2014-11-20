package com.manipulaEmpresa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turno")
public class Turno implements Serializable{
	@Column(name = "id_turno")
	int id_turno;
	@Column(name = "ds_turno")
	String desc_turno;
	

	public int getId_turno() {
		return id_turno;
	}
	public void setId_turno(int id_turno) {
		this.id_turno = id_turno;
	}
	public String getDesc_turno() {
		return desc_turno;
	}
	public void setDesc_turno(String desc_turno) {
		this.desc_turno = desc_turno;
	}
	@Override
	public String toString() {
		return id_turno + "," + desc_turno;
	}
	
	
}
