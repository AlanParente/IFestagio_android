/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaEmpresa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Keylla
 */
@Entity
@Table( name= "empresa")
public class Empresa implements Serializable {
   @Column(name = "id_empresa")	
   private int id_empresa;
   @Column(name = "cnpj")	
   private String cnpj;
   @Column(name = "ds_empresa")	
   private String nome_empresa;
   @Column(name = "endereco")	
   private String endereco;
   @Column(name = "foco_atividade")	
   private String foco_atividade;
   @Column(name = "site")
   private String site;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFoco_atividade() {
        return foco_atividade;
    }

    public void setFoco_atividade(String foco_atividade) {
        this.foco_atividade = foco_atividade;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    @Override
    public String toString() {
        return id_empresa + "," + cnpj + "," + nome_empresa + "," + endereco + "," + foco_atividade + "," + site ;
    }
    
    
}
