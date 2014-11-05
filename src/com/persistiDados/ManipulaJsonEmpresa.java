package com.persistiDados;

/**
*
* @author Keylla
*/


import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.manipulaEmpresa.Empresa;
import static java.lang.Integer.parseInt;

public class ManipulaJsonEmpresa {
	
	   public Empresa PopulaEmpresa(String jsonEmp){  
		    Gson gson = new Gson();
		    Map<String, Object> map = new HashMap<String, Object>();
		    map = (Map<String, Object>)gson.fromJson(jsonEmp, map.getClass());
		   
		    String id_empresa = (String) map.get("id_empresa");
		    String nome_empresa = (String) map.get("ds_empresa");
		    String cnpj = (String) map.get("cnpj");
		    String endereco = (String) map.get("endereco");
		    String foco_atividade = (String) map.get("foco_atividade");
		    String site = (String) map.get("site");

		    //Populando o objeto Empresa para persistencia
		    Empresa empresa = new Empresa();
		    try{
		        empresa.setId_empresa(parseInt(id_empresa));
		    }
		    catch (NumberFormatException nfe) {
		        empresa.setId_empresa(-1);
		    }
		    
		    empresa.setNome_empresa(nome_empresa);
		    empresa.setCnpj(cnpj);
		    empresa.setEndereco(endereco);
		    empresa.setFoco_atividade(foco_atividade);
		    empresa.setSite(site);
		    
		   return empresa;
		  }

}
