package com.example.estagio;

import com.example.estagio.FiltroDeGestos.SimpleGestureListener;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
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
	//private TextView myTv;
	private ImageButton check;
	private ImageButton refuse;
	private ImageButton info;
	private static int imgcolor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dummy_swipe);
		listener = new FiltroDeGestos(this, this);
		//myTv = (TextView) findViewById(R.id.texto);
		//myTv.setText("");
		check = (ImageButton) findViewById(R.id.checkButton);
		refuse = (ImageButton) findViewById(R.id.refuseButton);
		info = (ImageButton) findViewById(R.id.infoButton);
		imgcolor = Color.rgb(102, 102, 102);
		check.setColorFilter(imgcolor);
		refuse.setColorFilter(imgcolor);
		info.setColorFilter(imgcolor);
		
		
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
	      		check.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
	      		check.startAnimation(check.getAnimation());
	      		check.setVisibility(View.GONE);
	      		break;
	      	case FiltroDeGestos.SWIPE_LEFT:  
	      		str = "Swipe Left";
	      		/**
	      		 * Seta a animação de "saída pela esquerda".
	      		 */
	      		refuse.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
	      		refuse.startAnimation(refuse.getAnimation());
	      		refuse.setVisibility(View.GONE);
	      		break;
	      	case FiltroDeGestos.SWIPE_DOWN:  
	      		str = "Swipe Down";
	            break;
	      	case FiltroDeGestos.SWIPE_UP:    
	      		str = "Swipe Up";
	            break;
	      }
	       Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	       
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
		check.setVisibility(View.VISIBLE);
		refuse.setVisibility(View.VISIBLE);
		
		Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
		
	}
}
