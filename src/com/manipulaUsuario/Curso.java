/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaUsuario;

/**
 *
 * @author Keylla
 */
public class Curso {
    int id_curso;
    String desc_curso;

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getDesc_curso() {
        return desc_curso;
    }

    public void setDesc_curso(String desc_curso) {
        this.desc_curso = desc_curso;
    }

    @Override
    public String toString() {
        return "Curso{" + "id_curso=" + id_curso + ", desc_curso=" + desc_curso + '}';
    }
    
    
}
