package com.example.estagio;
import java.util.ArrayList;



public class UsuarioREST {
	
	 public ArrayList<Usuario> buscarUsuario(String usuario) {
	     UsuarioConnect uc = new UsuarioConnect();
	     return uc.busca(usuario);
	    }

}
