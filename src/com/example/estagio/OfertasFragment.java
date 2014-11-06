package com.example.estagio;


import android.support.v4.app.Fragment;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OfertasFragment extends Fragment{

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
			+ " A descrição deve parar antes do nome da empresa.";
	private static int corImagemNormal;
	private static int corImagemPress;
	
	public OfertasFragment(){}
	
	/**
	 * Animação que faz o logo sumir.
	 */
	public void logoGone()
	{	
		int duracao = getResources().getInteger(android.R.integer.config_shortAnimTime);
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
	
	/**
	 * Animação que faz o logo voltar.
	 */
	public void logoBack()
	{
		int duracao = getResources().getInteger(android.R.integer.config_shortAnimTime);
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootview = inflater.inflate(R.layout.ofertas_fragment, container, false);
		check = (ImageButton) rootview.findViewById(R.id.checkButton);
		refuse = (ImageButton) rootview.findViewById(R.id.refuseButton);
		info = (ImageButton) rootview.findViewById(R.id.infoButton);
		infoText = (TextView) rootview.findViewById(R.id.infoTxt);
		logo = (ImageView) rootview.findViewById(R.id.imgCompany);
		companyTxt = (TextView) rootview.findViewById(R.id.companyTxt);
		desTxt = (TextView) rootview.findViewById(R.id.descriptionTxt);
		
		desTxt.setVisibility(View.INVISIBLE);
		corImagemNormal = Color.rgb(102, 102, 102);
		corImagemPress = Color.rgb(246, 246, 246);
		check.setColorFilter(corImagemNormal);
		refuse.setColorFilter(corImagemNormal);
		info.setColorFilter(corImagemNormal);
		infoText.setText("Salário: "+salario+"\nCH: "+ch);
		companyTxt.setText(empresa);
		desTxt.setText(descricao);
		info.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(logo.getVisibility() == View.VISIBLE)
				{
					info.setColorFilter(corImagemPress);
					info.setSelected(true);
					logoGone();
				}
				else
				{
					info.setColorFilter(corImagemNormal);
					info.setSelected(false);
					logoBack();
				}
				
			}
		});
		return rootview;
	}
		
}
