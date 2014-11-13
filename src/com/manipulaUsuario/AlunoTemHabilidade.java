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
@Table ( name = "aluno_has_habilidade")
public class AlunoTemHabilidade {
	@Column ( name = "aluno_id_aluno" )
    int id_aluno;
	@Column ( name = "habilidade_id_habilidade" )
    int id_habilidade;

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_habilidade() {
        return id_habilidade;
    }

    public void setId_habilidade(int id_habilidade) {
        this.id_habilidade = id_habilidade;
    }

    @Override
    public String toString() {
        return  id_aluno + ", " + id_habilidade;
    }
    
    
    
}
