package com.persitirdados;
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

public class PesisteDados extends SQLiteOpenHelper {
	
	private static final String BANCO_DADOS = "IFestagio";
	private static final int VERSAO_BANCO = 1;
	private static final String LOG_TAG = "IFestagio";
	private final Context contexto;

  public PesisteDados (Context context) {
	        super(context, BANCO_DADOS, null, VERSAO_BANCO);
	        this.contexto = context;
	        }
	 
	    @Override
	    public void onCreate(SQLiteDatabase db)
	    {
	        String[] sql = contexto.getString(R.string.Banco_onCreate).split("\n");
	        db.beginTransaction();
	 
	        try
	        {
	            ExecutaSQL(db, sql);
	            db.setTransactionSuccessful();        }
	        catch (SQLException e)
	        {
	            Log.e("Erro ao criar tabela", e.toString());
	        }
	        finally        {
	            db.endTransaction();
	        }
	    }
	 
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	    {
	        Log.w(LOG_TAG, "Atualizando a base de dados da versão " + oldVersion + " para " + newVersion);
	        String[] sql = contexto.getString(R.string.Banco_onUpgrade).split("\n");
	        db.beginTransaction();
	 
	        try
	        {
	            ExecutaSQL(db, sql);
	            db.setTransactionSuccessful();
	        }
	        catch (SQLException e)
	        {
	            Log.e("Erro ao atualizar tabela", e.toString());
	            throw e;
	        }
	        finally
	        {
	            db.endTransaction();
	        }

	        onCreate(db);
	    }
	 
	    
	    private void ExecutaSQL(SQLiteDatabase db, String[] sql)
	    {
	        for( String s : sql )
	            if (s.trim().length()>0)
	                db.execSQL(s);
	    }

	    public UsuarioCursor RetornaUsuario(UsuarioCursor.OrdenarPor ordenarPor)
	    {
	        String sql = UsuarioCursor.CONSULTA;
	        SQLiteDatabase bd = getReadableDatabase();
	        UsuarioCursor cc = (UsuarioCursor) bd.rawQueryWithFactory(new UsuarioCursor.Factory(), sql, null, null);
	        cc.moveToFirst();
	        return cc;
	    }
	    public long InseriUsuario(String login, String senha)

	    {

	        SQLiteDatabase db = getReadableDatabase();

	        try

	        {
	            ContentValues initialValues = new ContentValues();
	            initialValues.put("login", login);
	            initialValues.put("senha", senha);
	            return db.insert("USUARIO", null, initialValues);
	        }
	        finally
	        {
	            db.close();
	        }
	    }

	    
	    /*Cria classe de cursor onde estaram definidas a consulta ao usuário.
	     * Forma de ordenação e implementação do cursor de consulta. */
	    
	    public static class UsuarioCursor extends SQLiteCursor
	    {
	        public static enum OrdenarPor{
	            NomeCrescente,
	            NomeDecrescente

	        }

	        private static final String CONSULTA = "SELECT LOGIN, SENHA FROM USUARIO WHERE LOGIN = ?";

	        private UsuarioCursor(SQLiteDatabase db, SQLiteCursorDriver driver, String editTable, SQLiteQuery query)
	        {
	            super(db, driver, editTable, query);
	        }

	        private static class Factory implements SQLiteDatabase.CursorFactory

	        {
	            @Override

	            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver driver, String editTable, SQLiteQuery query)

	            {
	                return new UsuarioCursor(db, driver, editTable, query);
	            }
	        }


	        public long getID()

	        {
	            return getLong(getColumnIndexOrThrow("ID"));
	        }

	        public String getLogin()
	        {
	            return getString(getColumnIndexOrThrow("LOGIN"));
	        }

	        public String getSenha()
	        {
	            return getString(getColumnIndexOrThrow("SENHA"));
	        }

	    }
}
