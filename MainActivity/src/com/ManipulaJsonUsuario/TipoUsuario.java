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
public class TipoUsuario {
    int id_tipo_usuario;
    String desc_tipo;

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getDesc_tipo() {
        return desc_tipo;
    }

    public void setDesc_tipo(String desc_tipo) {
        this.desc_tipo = desc_tipo;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "id_tipo_usuario=" + id_tipo_usuario + ", desc_tipo=" + desc_tipo + '}';
    }
    
    
    
    
}
