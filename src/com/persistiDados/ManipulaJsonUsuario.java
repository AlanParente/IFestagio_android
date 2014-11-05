package com.persistiDados;

/**
 *
 * @author Keylla
 */


import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.manipulaUsuario.TipoUsuario;
import com.manipulaUsuario.Usuario;
import static java.lang.Integer.parseInt;


public class ManipulaJsonUsuario {
	
	public Usuario PopulaUsuario(String jsonUsu){  
	    Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonUsu, map.getClass());
	   
	    String id = (String) map.get("id_usuario");
	    String login = (String) map.get("login");
	    String senha = (String) map.get("senha");
	    String id_empresa = (String) map.get("empresa_id_empresa");
	    String id_tipo_usuario = (String) map.get("tipo_usuario_id_tipo_usuario");
	    String id_pessoa = (String)map.get("pessoa_id_pessoa");


	    //Populando o objeto Usuario para persistencia
	    Usuario usuario = new Usuario();
	    try{
	    usuario.setId(parseInt(id));
	    }
	    catch (NumberFormatException nfe) {
	       usuario.setId(-1);
	    }
	    usuario.setLogin(login);
	    usuario.setSenha(senha);
	    try{
	    usuario.setId_empresa(parseInt(id_empresa));
	    }
	    catch (NumberFormatException nfe) {
	       usuario.setId_empresa(-1);
	    }
	    try{
	    usuario.setId_tipo_usuario(parseInt(id_tipo_usuario));
	    }
	    catch (NumberFormatException nfe) {
	       usuario.setId_tipo_usuario(-1);
	    }
	    try{
	    usuario.setId_pessoa(parseInt(id_pessoa));
	    }
	    catch (NumberFormatException nfe) {
	       usuario.setId_pessoa(-1);
	    }

	   return usuario;
	  }
	  
	 public  TipoUsuario PopulaTipoUsuario (String jsonPTU){
	       Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonPTU, map.getClass());
	    String id_tipo_usuario = (String)map.get("id_tipo_usuario");
	    String ds_tipo_usuario = (String)map.get("ds_tipo_usuario");
	    
	    TipoUsuario tipousuario = new TipoUsuario();
	    tipousuario.setId_tipo_usuario(parseInt(id_tipo_usuario));
	    tipousuario.setDesc_tipo(ds_tipo_usuario);
	   
	    return tipousuario;
	   }  

}
