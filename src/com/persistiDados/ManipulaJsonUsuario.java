package com.persistiDados;

/**
 *
 * @author Keylla
 */


import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.manipulaUsuario.Aluno;
import com.manipulaUsuario.AlunoTemHabilidade;
import com.manipulaUsuario.ContatoTelefone;
import com.manipulaUsuario.Curriculum;
import com.manipulaUsuario.Curso;
import com.manipulaUsuario.Pessoa;
import com.manipulaUsuario.RedeSocial;
import com.manipulaUsuario.TipoRedeSocial;
import com.manipulaUsuario.TipoUsuario;
import com.manipulaUsuario.TurnoTemAluno;
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
	 public  Aluno PopulaAluno (String jsonAlu){
	       Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonAlu, map.getClass());
	    String id_aluno = (String)map.get("id_aluno");
	    String id_cv = (String)map.get("cv_id_cv");
	    String id_pessoa = (String)map.get("pessoa_id_pessoa");
	    String id_curso = (String)map.get("curso_id_curso");
	    String mat = (String)map.get("matricula");


	    
	    Aluno aluno = new Aluno();
	    aluno.setId_aluno(parseInt(id_aluno)); 
	    aluno.setId_cv(parseInt(id_cv));
	    aluno.setId_pessoa(parseInt(id_pessoa));
	    aluno.setId_curso(parseInt(id_curso));
	    aluno.setMatricula(parseInt(mat));
	   
	    return aluno;
	   }  
	 
	 public  AlunoTemHabilidade PopulaAlunoTemHabilidade (String jsonAluThab){
	       Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonAluThab, map.getClass());
	    String id_aluno = (String)map.get("aluno_id_aluno");
	    String id_habilidade = (String)map.get("habilidade_id_habilidade");

	    AlunoTemHabilidade alunoTemHab = new AlunoTemHabilidade();
	    alunoTemHab.setId_aluno(parseInt(id_aluno));
	    alunoTemHab.setId_habilidade(parseInt(id_habilidade));
	   
	    return alunoTemHab;
	   }  
	 
	 public  ContatoTelefone PopulaContatoTelefone (String jsonContTel){
	       Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonContTel, map.getClass());
	    String id_contato = (String)map.get("id_contato");
	    String telefone = (String)map.get("ds_telefone");

	    ContatoTelefone contatoTel = new ContatoTelefone();
	    contatoTel.setId_contato(parseInt(id_contato));
	    contatoTel.setDesc_telefone(telefone);
	   
	    return contatoTel;
	   } 
	 
	 public  Curriculum PopulaCurriculum (String jsonCV) throws SerialException, SQLException{
	       Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonCV, map.getClass());
	    String id_cv = (String)map.get("id_cv");
	    String desc_cv = (String)map.get("ds_cv");
	    String arqcv = (String)map.get("cv");
	    Blob arq =new SerialBlob(arqcv.getBytes());  

	    Curriculum cv = new Curriculum();
	    cv.setId_cv(parseInt(id_cv));
	    cv.setDesc_cv(desc_cv);
	    cv.setCv(arq);
	    
	   
	    return cv;
	   }
	 
	 public  Curso PopulaCurso (String jsonCurso){
	       Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonCurso, map.getClass());
	    String id_curso = (String)map.get("id_curso");
	    String desc_curso = (String)map.get("ds_curso");

	    Curso curso = new Curso();
	    curso.setId_curso(parseInt(id_curso));
	    curso.setDesc_curso(desc_curso);
	   
	    return curso;
	   } 
	 
	 public  Pessoa PopulaPessoa (String jsonPes) throws ParseException{
		DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);   
	    Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonPes, map.getClass());
	    String id_pessoa = (String)map.get("id_pessoa");
	    String id_contato = (String)map.get("contato_telefone_id_contato");
	    String rede_social = (String)map.get("rede_social_id_rede_social");
	    String nome = (String)map.get("nome");
	    String sexo = (String)map.get("sexo");
	    String cpf = (String)map.get("cpf");
	    String email = (String)map.get("email");
	    String nascimento = (String)map.get("dt_nascimento");
	    String lattes = (String)map.get("url_lattes");
	    Date dt_nascim = format.parse(nascimento);
	    
	    Pessoa pes = new Pessoa();
	    pes.setId_pessoa(parseInt(id_pessoa));
	    pes.setId_contato(parseInt(id_contato));
	    pes.setId_rede_social(parseInt(rede_social));
	    pes.setNome(nome);
	    pes.setSexo(sexo.charAt(0));
	    pes.setCpf(parseInt(cpf));
	    pes.setE_mail(email);
	    pes.setData_nascimento(dt_nascim);
	    pes.setUrl_lattes(lattes);

	   
	    return pes;
	   }
	 
	 public  RedeSocial PopulaRedeSocial (String jsonRedeSoc){
	    Gson gson = new Gson();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = (Map<String, Object>)gson.fromJson(jsonRedeSoc, map.getClass());
	    String id_rede = (String)map.get("id_rede_social");
	    String tipo_rede = (String)map.get("tipo_rede_social_id_tipo_rede_social");
	    String desc_rede = (String)map.get("ds_rede_social");

	    RedeSocial rd = new RedeSocial();
	    rd.setId_rede_social(parseInt(id_rede));
	    rd.setId_tp_rede_social(parseInt(tipo_rede));
	    rd.setDes_rede_social(desc_rede);

	    return rd;
	   }
	 
	 public  TipoRedeSocial PopulaTipoRedeSocial (String jsonTRedeSoc){
		    Gson gson = new Gson();
		    Map<String, Object> map = new HashMap<String, Object>();
		    map = (Map<String, Object>)gson.fromJson(jsonTRedeSoc, map.getClass());
		    String id_tipo_rede = (String)map.get("id_tipo_rede_social");
		    String desc_tipo_rede = (String)map.get("ds_tipo_rede_social");

		    TipoRedeSocial trd = new TipoRedeSocial();
		    trd.setId_tipo_rede_social(parseInt(id_tipo_rede));
		    trd.setDesc_tipo_rede_social(desc_tipo_rede);

		    return trd;
		   }
	 
	 public  TurnoTemAluno PopulaTurnoTemAluno (String jsonTTAluno){
		    Gson gson = new Gson();
		    Map<String, Object> map = new HashMap<String, Object>();
		    map = (Map<String, Object>)gson.fromJson(jsonTTAluno, map.getClass());
		    String id_turno = (String)map.get("turno_id_turno");
		    String id_aluno = (String)map.get("aluno_id_aluno");

		    TurnoTemAluno ttaluno = new TurnoTemAluno();
		    ttaluno.setId_aluno(parseInt(id_aluno));
		    ttaluno.setId_turno(parseInt(id_turno));

		    return ttaluno;
		   }
}
