/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaEstagio;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Keylla
 */
@Entity
@Table ( name = "estagio")
public class Estagio {
   @Column ( name = "id_estagio" )	
   private int id_estagio;
   @Column ( name = "contato_estagio_id_contato_estagio" )	
   private int id_contato_estagio;
   @Column ( name = "empresa_id_empresa" )	
   private int id_empresa;
   @Column ( name = "ds_estagio" )	
   private String desc_estagio;
   @Column ( name = "dt_inicio" )	
   private Date data_inicio;
   @Column ( name = "dt_fim" )	
   private Date data_fim;
   @Column ( name = "bolsa" )	
   private float valor_bolsa;
   @Column ( name = "beneficios" )	
   private String beneficios;
   @Column ( name = "ch_semanal" )	
   private int carga_horaria;
    
    public int getId_contato_estagio() {
        return id_contato_estagio;
    }

    public void setId_contato_estagio(int id_contato_estagio) {
        this.id_contato_estagio = id_contato_estagio;
    }
    
    public int getId_estagio() {
        return id_estagio;
    }

    public void setId_estagio(int id_estagio) {
        this.id_estagio = id_estagio;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    
    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getDesc_estagio() {
        return desc_estagio;
    }

    public void setDesc_estagio(String desc_estagio) {
        this.desc_estagio = desc_estagio;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public float getValor_bolsa() {
        return valor_bolsa;
    }

    public void setValor_bolsa(float valor_bolsa) {
        this.valor_bolsa = valor_bolsa;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

	@Override
	public String toString() {
		return  id_estagio + ","+ id_contato_estagio + "," + id_empresa	+ "," + desc_estagio 
				+ data_inicio + "," + data_fim + ","
				+ valor_bolsa + "," + beneficios
				+ "," + carga_horaria;
	}

     
}
