package com.example.estagio;

import com.example.estagio.FiltroDeGestos.SimpleGestureListener;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class DummySwipe extends ActionBarActivity implements SimpleGestureListener{

	/**Instancia do Filtro de Gestos
	 * 
	 */
	private FiltroDeGestos listener;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dummy_swipe);
		listener = new FiltroDeGestos(this, this);
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
	            break;
	      	case FiltroDeGestos.SWIPE_LEFT:  
	      		str = "Swipe Left";
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
		Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
		
	}
}
