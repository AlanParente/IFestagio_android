package com.persistiDados;
import com.example.estagio.R;
import com.example.estagio.R.string;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaDataBase extends SQLiteOpenHelper  {
   static String DATA_BASE = "IFestagio";
   static int VERSAO = 1;
   String sql = "CREATE TABLE USUARIO " +
   				   "(ID INT," +
		           "ID_EMPRESA INT," +
		           "ID_TIPO_USUARIO INT," +
		           "ID_PESSOA INT," +
                   "LOGIN VARCHAR(50)," +
                   "SENHA VARCHAR(50)," +
                   "PRIMARY KEY(ID));";
	public CriaDataBase(Context contexto) {
     super(contexto, DATA_BASE, null, VERSAO);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sql);
		//InsertDB(db,"USUARIO",  "1, 12, 3, 45,'admin', 1234");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// TODO Auto-generated method stub
		
	}
	
	public void InsertDB(SQLiteDatabase db,String tabela, String valor){
	/*	ContentValues values = new ContentValues();
		values.put("ID", 1);
	    values.put(coluna1, valor1);
	    values.put(coluna2, valor2);*/
		String sqlInsert = "INSERT INTO "+tabela+" VALUES ("+valor+")";
		try{
			if (db.isOpen()){
				db.execSQL(sqlInsert);
			    db.close(); 
			}
		}
		catch (Exception e) {
			System.out.println("Erro durante a inserção!!");
			
		}
	}
	
	 public SQLiteDatabase getDatabase() {
		    return this.getWritableDatabase();
		  }
}
