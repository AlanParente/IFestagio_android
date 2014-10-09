package com.example.estagio;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;




@Path("/Usuario")
public class UsuarioWS {
	  @GET
	    @Path("/buscaJson")
	    @Produces("application/json")
	    public ArrayList<Usuario> selecionaUser(@PathParam("usuario") String usuario){
	     return new UsuarioREST().buscarUsuario(usuario);
	    }

}
