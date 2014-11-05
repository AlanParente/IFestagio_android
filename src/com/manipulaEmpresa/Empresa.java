/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaEmpresa;

/**
 *
 * @author Keylla
 */
public class Empresa {
   private int id_empresa;
   private String cnpj;
   private String nome_empresa;
   private String endereco;
   private String foco_atividade;
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
        return "Empresa{" + "id_empresa=" + id_empresa + ", cnpj=" + cnpj + ", nome_empresa=" + nome_empresa + ", endereco=" + endereco + ", foco_atividade=" + foco_atividade + ", site=" + site + '}';
    }
    
    
}
