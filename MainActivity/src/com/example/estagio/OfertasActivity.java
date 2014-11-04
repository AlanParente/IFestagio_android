package com.example.estagio;


import android.support.v7.app.ActionBarActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OfertasActivity extends ActionBarActivity{

	private ImageButton check;
	private ImageButton refuse;
	private ImageButton info;
	private ImageView logo;
	private TextView infoText;
	private TextView companyTxt;
	private TextView desTxt;
	private String ch = "";
	private String salario = "";
	private String empresa = "Nome da empresa";
	private String descricao = "Aqui será inserido a descrição da"
			+ " vaga ao apertar a tecla de informação localizada no meio"
			+ " A descrição deve parar antes do nome da empresa. Posteriormente"
			+ " contaremos os caracteres para se ter uma descrição mais precisa."
			+ " Por isso estou enchendo esse texto de besteira para se ter uma boa"
			+ " noção do tamanho máximo que a descrição poderia ter.";
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
		logo = (ImageView) findViewById(R.id.imgCompany);
		companyTxt = (TextView) findViewById(R.id.companyTxt);
		desTxt = (TextView) findViewById(R.id.descriptionTxt);
		desTxt.setVisibility(View.INVISIBLE);
		imgcolor = Color.rgb(102, 102, 102);
		check.setColorFilter(imgcolor);
		refuse.setColorFilter(imgcolor);
		info.setColorFilter(imgcolor);
		infoText.setText("Salário: "+salario+"\nCH: "+ch);
		companyTxt.setText(empresa);
		desTxt.setText(descricao);
		
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
	
		@TargetApi(Build.VERSION_CODES.HONEYCOMB)
		@SuppressLint("NewApi")
		public void onInfoButtonClick(View v)
		{
			int duracao = getResources().getInteger(android.R.integer.config_shortAnimTime);
			if(logo.getVisibility() == View.VISIBLE)
			{
				desTxt.setAlpha(0f);
				desTxt.setVisibility(View.VISIBLE);
				desTxt.animate().alpha(1f).setDuration(duracao).setListener(null);
				
				logo.animate().alpha(0f).setListener(new AnimatorListenerAdapter()
				{
					@Override
					public void onAnimationEnd(Animator animation)
					{
						logo.setVisibility(View.GONE);
					}
				});
			}
			else
			{
				logo.setAlpha(0f);
				logo.setVisibility(View.VISIBLE);
				logo.animate().alpha(1f).setDuration(duracao).setListener(null);
				
				desTxt.animate().alpha(0f).setListener(new AnimatorListenerAdapter()
				{
					@Override
					public void onAnimationEnd(Animator animation)
					{
						desTxt.setVisibility(View.GONE);
					}
				});
			}
		}
}
