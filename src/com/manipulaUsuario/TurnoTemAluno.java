/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manipulaUsuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Keylla
 */
@Entity
@Table ( name = "turno_has_aluno")
public class TurnoTemAluno implements Serializable{
	@Column ( name = "turno_id_turno" )
    int id_turno;
	@Column ( name = "aluno_id_aluno" )
    int id_aluno;

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    @Override
    public String toString() {
        return id_turno + ", " + id_aluno ;
    }
    
    
    
}
