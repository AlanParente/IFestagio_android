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

 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
 
public class ManipulaJson {
	
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
    public static void main(String[] args) throws IOException, ParseException {
    	String jsonUsu = "{\"id_usuario\":\"3\","
                + "\"login\":\"admin\","
                + "\"senha\":\"admin\"}";
        
        String jsonEmp= "{\"id_empresa\":\"1\","
                + "\"ds_empresa\":\"IFCE\"}";
        
        String jsonEsta= "{\"id_estagio\":\"2\","
                + "\"ds_estagio\":\"Programador Java\","
                + "\"empresa_id_empresa\":\"1\","
                + "\"bolsa\":\"800.56\","
                + "\"ch_semanal\":\"30\","
                + "\"dt_inicio\":\"01/01/2014\","
                + "\"dt_fim\":\"30/01/2014\","
                + "\"beneficios\":\"Vale Alimentação: 500,00 e Vale Transporte: 50,00\"}";
        
    	ManipulaJson mj = new ManipulaJson();
    	   System.out.println(mj.PopulaUsuario(jsonUsu));
           System.out.println(mj.PopulaEmpresa(jsonEmp));
           System.out.println(mj.PopulaEstagio(jsonEsta));

           

    } 
}
