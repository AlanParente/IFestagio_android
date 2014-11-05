package com.persistiDados;


import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.manipulaEstagio.Estagio;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class ManipulaJsonEstagio {
	
	public Estagio PopulaEstagio(String jsonEst) throws ParseException{  
	    
	    DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);   
	    Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonEst, map.getClass());
	   
	    String id_estagio = (String) map.get("id_estagio");
	    String id_contato_estagio = (String) map.get("contato_estagio_id_contato_estagio");
	    String id_empresa = (String) map.get("empresa_id_empresa");
	    String desc_estagio = (String) map.get("ds_estagio");
	    String data_inicio = (String) map.get("dt_inicio");
	    String data_final = (String) map.get("dt_fim");
	    String valor_bolsa = (String) map.get("bolsa");
	    String beneficio = (String)map.get("beneficios");
	    String carga_horaria = (String) map.get("ch_semanal");
	    
	    
	    Date dt_inicio = format.parse(data_inicio);
	    Date dt_fim = format.parse(data_final);
	    
	    
	    //Populando o objeto Estágio para persistencia
	    Estagio estagio = new Estagio();
	    estagio.setId_estagio(parseInt(id_estagio));
	    
	    try{
	    estagio.setId_contato_estagio(parseInt(id_contato_estagio));
	    }
	    catch (NumberFormatException nfe) {
	        estagio.setId_contato_estagio(-1);
	    }
	    try{
	    estagio.setId_empresa(parseInt(id_empresa));
	    }
	    catch (NumberFormatException nfe) {
	        estagio.setId_empresa(-1);
	    }
	    estagio.setDesc_estagio(desc_estagio);
	    estagio.setData_inicio(dt_inicio);
	    estagio.setData_fim(dt_fim);
	    try{
	        estagio.setValor_bolsa(parseFloat(valor_bolsa));
	    }
	    catch (NumberFormatException nfe) {
	        estagio.setValor_bolsa(-1);
	    }
	    
	    estagio.setBeneficios(beneficio);
	     try{
	        estagio.setCarga_horaria(parseInt(carga_horaria));
	    }
	    catch (NumberFormatException nfe) {
	        estagio.setCarga_horaria(-1);
	    }
	    
	    
	   return estagio;
	  }

}
