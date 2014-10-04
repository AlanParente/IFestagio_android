package com.example.estagio;

import android.app.Activity;

import android.util.Log;
import android.view.*;
import android.view.GestureDetector.SimpleOnGestureListener;

/**
 * Implementação do FiltroDeGestos adaptado de http://tinyurl.com/n8sg9br
 * @author ruriel
 *
 */
public class FiltroDeGestos extends SimpleOnGestureListener
{
	 /**
	  * Interface que contém métodos para o deslizamento e clique duplo.
	  * @author ruriel
	  *
	  */
	 public static interface SimpleGestureListener
	 {
		     void onSwipe(int direction);
	         void onDoubleTap();
	 }
	 
	 /**
	  * Constantes que indicam a direção do deslizamento.
	  */
	 public final static int SWIPE_UP    = 1;
     public final static int SWIPE_DOWN  = 2;
     public final static int SWIPE_LEFT  = 3;
     public final static int SWIPE_RIGHT = 4;
     
     /**
      * Constantes que indicam o modo do gesto.
      */
     public final static int MODE_TRANSPARENT = 0;
     public final static int MODE_SOLID       = 1;
     public final static int MODE_DYNAMIC     = 2;
      
     private final static int ACTION_FAKE = -13; //just an unlikely number
     /**
      * Distâncias mínima e máxima do swipe e a velocidade mínima. Ajuste
      * estas variáveis para mexer na sensibilidade.
      */
     private int swipe_Min_Distance = 20;
     private int swipe_Max_Distance = 350;
     private int swipe_Min_Velocity = 100;
  
     private int mode             = MODE_DYNAMIC;
     private boolean running      = true;
     private boolean tapIndicator = false;
  
     private Activity context;
     private GestureDetector detector;
     private SimpleGestureListener listener;
     
     public FiltroDeGestos(Activity context, SimpleGestureListener sgl) 
     {
         
         this.context = context;
         this.detector = new GestureDetector(context, this);
         this.listener = sgl;
     }
	
     public void onTouchEvent(MotionEvent event)
     {
        
        if(!this.running)
        return;
        
        boolean result = this.detector.onTouchEvent(event);
        /**
         * Seta o evento de acordo com o modo.
         *
         */
        if(this.mode == MODE_SOLID)
          event.setAction(MotionEvent.ACTION_CANCEL);
        else if (this.mode == MODE_DYNAMIC) 
        	 {
        		if(event.getAction() == ACTION_FAKE)
        			event.setAction(MotionEvent.ACTION_UP);
        		else if(result)
        			   event.setAction(MotionEvent.ACTION_CANCEL);
        			 else if(this.tapIndicator)
        			 	  {
        				  	event.setAction(MotionEvent.ACTION_DOWN);
        				  	this.tapIndicator = false;
        			 	  }
        
        	 }
         //else just do nothing, it's Transparent
      }
     
     /**
      * Método que define o Swipe.
      */
     @Override
     public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
      
      /**
       * Pega as distâncias de acordo com as coordenadas dos eventos de toque.
       */
      final float xDistance = Math.abs(e1.getX() - e2.getX());
      final float yDistance = Math.abs(e1.getY() - e2.getY());
      boolean result = false;
      /**
       * Se a distância for maior do que a definida, considera que não houve gesto.
       */
      if(xDistance > this.swipe_Max_Distance || yDistance > this.swipe_Max_Distance)
       return result;
      
      /**
       * Pega o módulo das velocidades.
       */
      velocityX = Math.abs(velocityX);
      velocityY = Math.abs(velocityY);
      Log.d("DEBUG_TAG", "onFling: " + e1.toString()+e2.toString());
      
      /**
       * Se a velocidade e a distância do eixo x ou y forem maiores que a mínima, 
       * compara os pontos dos dois eventos.
       * Se o primeiro for maior que o segunto, o movimento é de direita para esquerda/baixo para cima. 
       * Caso contrário, esquerda para direita/cima para baixo.
       */
      if(velocityX > this.swipe_Min_Velocity && xDistance > this.swipe_Min_Distance)
      {
    	  if(e1.getX() > e2.getX()) // right to left
    		  this.listener.onSwipe(SWIPE_LEFT);
    	  else
    		  this.listener.onSwipe(SWIPE_RIGHT);
    	  result = true;
      }
      else if(velocityY > this.swipe_Min_Velocity && yDistance > this.swipe_Min_Distance)
      	   {
    	  		if(e1.getY() > e2.getY()) // bottom to up
    	  			this.listener.onSwipe(SWIPE_UP);
    	  		else
    	  			this.listener.onSwipe(SWIPE_DOWN);
    	  		result = true;
      	   }
      return result;
     }
  
     @Override
     public boolean onSingleTapUp(MotionEvent e) 
     {
    	 this.tapIndicator = true;
    	 return false;
     }
  
     @Override
     public boolean onDoubleTap(MotionEvent arg) 
     {
    	 this.listener.onDoubleTap();;
    	 return true;
     }
  
     @Override
     public boolean onDoubleTapEvent(MotionEvent arg) 
     {
    	 return true;
     }
  
     @Override
     public boolean onSingleTapConfirmed(MotionEvent arg) 
     {
  
    	 if(this.mode == MODE_DYNAMIC)
    	 {        							   // we owe an ACTION_UP, so we fake an
    		 arg.setAction(ACTION_FAKE);      //action which will be converted to an ACTION_UP later.
    		 this.context.dispatchTouchEvent(arg);
    	 } 
    	 return false;
     }
}
