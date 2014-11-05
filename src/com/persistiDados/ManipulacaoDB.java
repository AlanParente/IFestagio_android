package com.persistiDados;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ManipulacaoDB {
	private SQLiteDatabase db;
	private CriaDataBase cdb;
	 
	public ManipulacaoDB(Context context) {
	 cdb = new CriaDataBase(context);
     db = cdb.getDatabase();		  
	}
	
	public List<String> buscaUsuario(String usu) {
	    List<String> result = new ArrayList<String>();
	    int count = 0;	
	    Cursor cursor = 
	      db.query("USUARIO", new String[]{"ID","ID_EMPRESA","ID_TIPO_USUARIO","ID_PESSOA","LOGIN", "SENHA"}, 
	               "LOGIN = ?", /* condição de busca*/
	               new String[]{usu}, 
	               null, 
	               null, 
	               null);
	    
	    cursor.moveToFirst();
	    while(!cursor.isAfterLast()) {
	      
	      try{
	    	  result.add(cursor.getString(count));
	    	  count++;
	      }catch (Exception e) {
	      }

	      cursor.moveToNext();
	    }
	    
	    cursor.close();
	    return result;
	  }

}