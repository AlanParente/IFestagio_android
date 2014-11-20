package com.example.estagio;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class HistoricoFragment extends ListFragment{
	/*
	 * 
	 SUBSTITUIR POR CONSULTA NO BANCO
	 
	 REFER�CIA PARA IMPLEMENTA��O FUTURA:
	 
	 for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
    		String nome_empresa = c.getString(c.getColumnIndex(dba.KEY_NOME_EMPRESA));
    		String remuneracao = c.getString(c.getColumnIndex(dba.KEY_REMUNERACAO));
    		String horas = c.getString(c.getColumnIndex(dba.KEY_HORAS));  
    		//*Fazer para a imagem*        
    		
    		hashMap = new HashMap<String, String>();
    		hashMap.put("empresa", nome_empresa);
    		hashMap.put("remuneracao", remuneracao);
    		hashMap.put("img", imagem );  
    		hashMap.put("horas", horas);
    		aList.add(hashMap);
	}
	
	 // Keys used in Hashmap
        String[] from = { "img","empresa","remuneracao", "horas" };
 
        // Ids of views in listview_layout
        int[] to = { R.id.nome_empresa,R.id.remuneracao,R.id.imagem,R.id.horas};
 
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_row, from, to);
 
        setListAdapter(adapter);
        
	 */
	public static final String[] titles = new String[] {"Facebook",
        "Google", "Microsoft", "Sony"};

	public static final String[] descriptions = new String[] {
        "$2000",
        "$3000", "$4000",
        "$5000" };

	public static final Integer[] images = { R.drawable.facebook,
        R.drawable.google, R.drawable.microsoft, R.drawable.sony };
	
	public static final String[] horas = { "15h", "20h", "30h", "40h" };

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
 
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
 
        for(int i=0;i<4;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("titl", titles[i]);
            hm.put("desc", "Remunera\u00e7\u00e3o: " + descriptions[i]);
			hm.put("img", Integer.toString(images[i]) );
            hm.put("hor", "Carga Hor\u00e1ria: " + horas[i]);
            aList.add(hm);
        }
 
        // Keys used in Hashmap
        String[] from = { "img","titl","desc", "hor" };
 
        // Ids of views in listview_layout
        int[] to = { R.id.icon,R.id.title,R.id.desc,R.id.horas};
 
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_row, from, to);
 
        setListAdapter(adapter);
 
        return super.onCreateView(inflater, container, savedInstanceState);
	}
	
}