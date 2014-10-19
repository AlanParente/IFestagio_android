package com.example.estagio;


import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

public class OfertasActivity extends ActionBarActivity{

	private ImageButton check;
	private ImageButton refuse;
	private ImageButton info;
	private TextView infoText;
	private TextView companyTxt;
	private String ch = "";
	private String salario = "";
	private String empresa = "Nome da empresa";
	private static int imgcolor;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ofertas_activity);
		setTitle("Ofertas");
		check = (ImageButton) findViewById(R.id.checkButton);
		refuse = (ImageButton) findViewById(R.id.refuseButton);
		info = (ImageButton) findViewById(R.id.infoButton);
		infoText = (TextView) findViewById(R.id.infoTxt);
		companyTxt = (TextView) findViewById(R.id.companyTxt);
		imgcolor = Color.rgb(102, 102, 102);
		check.setColorFilter(imgcolor);
		refuse.setColorFilter(imgcolor);
		info.setColorFilter(imgcolor);
		
	}
	
	@Override
	public void onPostResume()
	{
		infoText.setText("Salário: "+salario+"\nCH: "+ch);
		companyTxt.setText(empresa);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dummy_swipe, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
