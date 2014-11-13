/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaUsuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Keylla
 */
@Entity
@Table ( name = "tipo_rede_social")
public class TipoRedeSocial {
	@Column ( name = "id_tipo_rede_social" )
    int id_tipo_rede_social;
	@Column ( name = "ds_tipo_rede_social" )
    String desc_tipo_rede_social;

    public int getId_tipo_rede_social() {
        return id_tipo_rede_social;
    }

    public void setId_tipo_rede_social(int id_tipo_rede_social) {
        this.id_tipo_rede_social = id_tipo_rede_social;
    }

    public String getDesc_tipo_rede_social() {
        return desc_tipo_rede_social;
    }

    public void setDesc_tipo_rede_social(String desc_tipo_rede_social) {
        this.desc_tipo_rede_social = desc_tipo_rede_social;
    }

    @Override
    public String toString() {
        return id_tipo_rede_social + ", " + desc_tipo_rede_social ;
    }
    
    
}
