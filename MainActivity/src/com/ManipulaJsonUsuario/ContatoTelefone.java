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
public class ContatoTelefone {
    int id_contato;
    String desc_telefone;

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getDesc_telefone() {
        return desc_telefone;
    }

    public void setDesc_telefone(String desc_telefone) {
        this.desc_telefone = desc_telefone;
    }

    @Override
    public String toString() {
        return "ContatoTelefone{" + "id_contato=" + id_contato + ", desc_telefone=" + desc_telefone + '}';
    }
    
   
    
}
