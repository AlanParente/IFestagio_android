package com.persistiDados;


import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.manipulaEstagio.ContatoEstagio;
import com.manipulaEstagio.Estagio;
import com.manipulaEstagio.Habilidade;
import com.manipulaEstagio.HabilidadeEstagio;
import com.manipulaEstagio.NivelHabilidade;
import com.manipulaEstagio.TipoHabilidade;
import com.manipulaEstagio.TurnoTemEstagio;

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
	
public ContatoEstagio PopulaContatoEstagio(String jsonConEst) throws ParseException{  
	    
	    DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);   
	    Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonConEst, map.getClass());
	   
	    String id_cont_estagio = (String) map.get("id_contato_estagio");
	    String desc_contato_estagio = (String) map.get("ds_contato_estagio");
	  
	    //Populando o objeto Contato Estágio para persistencia
	    ContatoEstagio contatoestagio = new ContatoEstagio();
	    
	    
	    try{
	    	contatoestagio.setId_contato_estagio(parseInt(id_cont_estagio));
	    }
	    catch (NumberFormatException nfe) {
	    	contatoestagio.setId_contato_estagio(-1);
	    }
	    contatoestagio.setDesc_contato_estagio(desc_contato_estagio);
	    
	   return contatoestagio;
	  }

public Habilidade PopulaHabilidade(String jsonHabil) throws ParseException{  
    
    DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);   
    Gson gson = new Gson();
    Map<String, Object> map = new HashMap<String, Object>();
    map = (Map<String, Object>)gson.fromJson(jsonHabil, map.getClass());
   
    String id_habil = (String) map.get("id_habilidade");
    String id_tipo_habl = (String) map.get("tipo_habilidade_id_tipo_habilidade");
    String desc_tipo_habl = (String) map.get("ds_habilidade");

  
    //Populando o objeto Habilidade para persistencia
    Habilidade habilidade = new Habilidade();
    
    
    try{
    	habilidade.setId_habilidade(parseInt(id_habil));
    }
    catch (NumberFormatException nfe) {
    	habilidade.setId_habilidade(-1);
    }
    try{
    	habilidade.setId_tipo_habilidade(parseInt(id_tipo_habl));
    }
    catch (NumberFormatException nfe) {
    	habilidade.setId_tipo_habilidade(-1);
    }
    habilidade.setDesc_habilidade(desc_tipo_habl);
    
   return habilidade;
  }


public HabilidadeEstagio PopulaHabilidadeEstagio(String jsonHabilEst) throws ParseException{  
    
    DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);   
    Gson gson = new Gson();
    Map<String, Object> map = new HashMap<String, Object>();
    map = (Map<String, Object>)gson.fromJson(jsonHabilEst, map.getClass());
   
    String id_habil_est = (String) map.get("id_habilidade_estagio");
    String id_nivel_habil = (String) map.get("nivel_habilidade_id_nivel_habilidade");
    String id_habil = (String) map.get("habilidade_id_habilidade");
    String id_est = (String) map.get("estagio_id_estagio");
    String peso = (String) map.get("peso");

  
    //Populando o objeto Habilidade Estagio para persistencia
    HabilidadeEstagio habilidadeestagio = new HabilidadeEstagio();
    
    
    try{
    	habilidadeestagio.setId_habilidade_estagio(parseInt(id_habil_est));
    }
    catch (NumberFormatException nfe) {
    	habilidadeestagio.setId_habilidade_estagio(-1);
    }
    try{
    	habilidadeestagio.setId_nivel_habilidade(parseInt(id_nivel_habil));
    }
    catch (NumberFormatException nfe) {
    	habilidadeestagio.setId_nivel_habilidade(-1);
    }
    try{
    	habilidadeestagio.setId_habilidade(parseInt(id_habil));
    }
    catch (NumberFormatException nfe) {
    	habilidadeestagio.setId_habilidade(-1);
    }
    try{
    	habilidadeestagio.setPeso(parseInt(peso));
    }
    catch (NumberFormatException nfe) {
    	habilidadeestagio.setPeso(-1);
    }
    
   return habilidadeestagio;
  }


public NivelHabilidade PopulaNivelHabilidade(String jsonNivHabil) throws ParseException{  
    
    DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);   
    Gson gson = new Gson();
    Map<String, Object> map = new HashMap<String, Object>();
    map = (Map<String, Object>)gson.fromJson(jsonNivHabil, map.getClass());
   
    String id_nivel_habilidade = (String) map.get("id_nivel_habilidade");
    String desc_nivel_habilidade = (String) map.get("ds_nivel_habilidade");
  
    //Populando o objeto Nivel Habilidade para persistencia
    NivelHabilidade nivelhabil = new NivelHabilidade();
    
    
    try{
    	nivelhabil.setId_nivel_habilidade(parseInt(id_nivel_habilidade));
    }
    catch (NumberFormatException nfe) {
    	nivelhabil.setId_nivel_habilidade(-1);
    }
    nivelhabil.setDesc_nivel_habilidade(desc_nivel_habilidade);
    
   return nivelhabil;
  }

public TipoHabilidade PopulaTipoHabilidade(String jsonTipHabil) throws ParseException{  
    
    DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);   
    Gson gson = new Gson();
    Map<String, Object> map = new HashMap<String, Object>();
    map = (Map<String, Object>)gson.fromJson(jsonTipHabil, map.getClass());
   
    String id_tipo_habilidade = (String) map.get("id_tipo_habilidade");
    String desc_tipo_habilidade = (String) map.get("ds_tipo_habilidade");
  
    //Populando o objeto Tipo Habilidade para persistencia
    TipoHabilidade tiphabil = new TipoHabilidade();
    
    
    try{
    	tiphabil.setId_tipo_habilidade(parseInt(id_tipo_habilidade));
    }
    catch (NumberFormatException nfe) {
    	tiphabil.setId_tipo_habilidade(-1);
    }
    tiphabil.setDesc_tipo_habilidade(desc_tipo_habilidade);
    
   return tiphabil;
  }

public TurnoTemEstagio PopulaTurnoTemEst(String jsontrunTemEs) throws ParseException{  
    
    DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);   
    Gson gson = new Gson();
    Map<String, Object> map = new HashMap<String, Object>();
    map = (Map<String, Object>)gson.fromJson(jsontrunTemEs, map.getClass());
   
    String id_turno = (String) map.get("turno_id_turno");
    String id_estagio = (String) map.get("estagio_id_estagio");
  
    //Populando o objeto Tipo Habilidade para persistencia
    TurnoTemEstagio ttest = new TurnoTemEstagio();
    
    
    try{
    	ttest.setId_turno(parseInt(id_turno));
    }
    catch (NumberFormatException nfe) {
    	ttest.setId_turno(-1);
    }
    
    try{
    	ttest.setId_estagio(parseInt(id_estagio ));
    }
    catch (NumberFormatException nfe) {
    	ttest.setId_estagio(-1);
    }
    
   return ttest;
  }
}
