package com.example.estagio;

import com.example.estagio.FiltroDeGestos.SimpleGestureListener;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class DummySwipe extends ActionBarActivity implements SimpleGestureListener{

	/**Instancia do Filtro de Gestos
	 * 
	 */
	private FiltroDeGestos listener;
	/**
	 * Referência da TextView
	 */
	private TextView myTv;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dummy_swipe);
		listener = new FiltroDeGestos(this, this);
		myTv = (TextView) findViewById(R.id.texto);
	}
	
	/**
	 * É importante colocar este método para que os gestos tenham resposta.
	 */
	@Override
    public boolean dispatchTouchEvent(MotionEvent me)
	{
        // Call onTouchEvent of SimpleGestureFilter class
       this.listener.onTouchEvent(me);
       return super.dispatchTouchEvent(me);
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

	/**
	 * Implementação das interfaces de Swipe. Basta comparar a direction da entrada com as constantes
	 * definidas na classe do FiltroDeGestos.
	 */
	@Override
	public void onSwipe(int direction) 
	{
		String str = "";
	      
	      switch (direction) 
	      {
	      
	      	case FiltroDeGestos.SWIPE_RIGHT: 
	      		str = "Swipe Right";
	      		/**
	      		 * Seta a animação de "saída pela direita".
	      		 */
	      		myTv.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
	      		break;
	      	case FiltroDeGestos.SWIPE_LEFT:  
	      		str = "Swipe Left";
	      		/**
	      		 * Seta a animação de "saída pela esquerda".
	      		 */
	      		myTv.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_left));
	      		break;
	      	case FiltroDeGestos.SWIPE_DOWN:  
	      		str = "Swipe Down";
	            break;
	      	case FiltroDeGestos.SWIPE_UP:    
	      		str = "Swipe Up";
	            break;
	      }
	       Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	       /**
	        * Mostra animação e deixa a View invisível.
	        */
	       myTv.startAnimation(myTv.getAnimation());
     	   myTv.setVisibility(View.GONE);
	 }
		
	/**
	 * Clique duplo.
	 */
	@Override
	public void onDoubleTap() 
	{
		/**
		 * Deixa a View visível novamente.
		 */
		myTv.setVisibility(View.VISIBLE);
		Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
		
	}
}
