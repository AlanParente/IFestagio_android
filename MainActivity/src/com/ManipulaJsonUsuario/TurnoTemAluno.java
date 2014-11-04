/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulajson;

/**
 *
 * @author Keylla
 */
public class TurnoTemAluno {
    int id_turno;
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
        return "TurnoTemAluno{" + "id_turno=" + id_turno + ", id_aluno=" + id_aluno + '}';
    }
    
    
    
}
