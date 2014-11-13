/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaUsuario;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *
 * @author Keylla
 */
@Entity
@Table ( name = "cv")
public class Curriculum {
	@Column ( name = "id_cv" )
    int id_cv;
	@Column ( name = "ds_cv" )
    String desc_cv;
	@Column ( name = "cv" )
    Blob cv;

    public int getId_cv() {
        return id_cv;
    }

    public void setId_cv(int id_cv) {
        this.id_cv = id_cv;
    }

    public String getDesc_cv() {
        return desc_cv;
    }

    public void setDesc_cv(String desc_cv) {
        this.desc_cv = desc_cv;
    }

    public Blob getCv() {
        return cv;
    }

    public void setCv(Blob cv) {
        this.cv = cv;
    }
    
    
}
