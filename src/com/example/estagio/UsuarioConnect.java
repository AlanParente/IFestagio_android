package com.example.estagio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import com.example.estagio.Usuario;

public class UsuarioConnect extends ConnectionPost {
	
	 public ArrayList<Usuario> busca(String usuario) {

	     Connection conn = null;
	     ResultSet resultSet = null;
	     PreparedStatement stmt = null;
	     conn =  getConnection();
	     ArrayList<Usuario> listaUsuario = null;

	     try {

	         stmt = conn.prepareStatement("SELECT * FROM tab_usuario WHERE usuario = ?");
	         resultSet = stmt.executeQuery();
	         listaUsuario = new ArrayList<Usuario>();

	         while (resultSet.next()) {
	             Usuario user = new Usuario();
	             user.setUsuario(resultSet.getString("usuario"));
	             user.setSenha(resultSet.getString("senha"));
	             listaUsuario.add(user);
	         }

	     } catch (SQLException e) {
	         e.printStackTrace();
	         listaUsuario = null;
	     } finally {
	         closeConnection(conn, stmt, resultSet);
	     }
	     return listaUsuario;
	    }
	
	
}
