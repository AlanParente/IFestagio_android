package com.example.estagio;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private Button myButton;
	private EditText  username=null;
	private EditText  password=null;
	int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.fragment_main);
        
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        myButton = (Button) findViewById(R.id.button1);
    }
    
    // Trata o Bot�o "Acessar" da tela inicial
    public void login(View view)
    {
        if(username.getText().toString().equals("admin") && 
        		password.getText().toString().equals("admin"))
        {
	        Toast.makeText(getApplicationContext(), "Redirecionando...",Toast.LENGTH_SHORT).show();
	        Intent myIntent = new Intent(MainActivity.this, TabsActivity.class);
	        //Intent myIntent = new Intent(MainActivity.this, OfertasActivity.class);
	    	MainActivity.this.startActivity(myIntent);
	    	finish();
        }	
        else{
	        Toast.makeText(getApplicationContext(), "Credenciais erradas!",Toast.LENGTH_SHORT).show();
	        counter--;
	        if(counter==0){
	           myButton.setEnabled(false);
	        }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
