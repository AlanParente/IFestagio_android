package com.example.estagio;

//import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button myButton;
	private EditText  username=null;
	private EditText  password=null;
	int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
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
}
