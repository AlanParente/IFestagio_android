/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaUsuario;

import java.sql.Blob;



/**
 *
 * @author Keylla
 */
public class Curriculum {
    int id_cv;
    String desc_cv;
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
