package com.example.rafaelliberato.exemploead1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class Page2 extends Activity {

    //Declaracao dos elementos para vinculacao
    private String txtDados;
    private TextView txtRecebeDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        //Vinculo do objeto txtRecebeDados, com o elemento txtDados presente na VIEW
        txtRecebeDados = (TextView)findViewById(R.id.txtDados);

        //Pega-se o parametro vindo através da INTENT de navegacao
        Intent intent = getIntent();
        Bundle params = intent.getExtras();


        if(params!=null)
        {
            txtDados = params.getString("dados");
            txtRecebeDados.setText(txtDados);
            Toast.makeText(this, "Parâmetro = " + txtDados, Toast.LENGTH_LONG).show();
        }
        else {
            txtDados = "Sem Parâmetros na Página" ;
            txtRecebeDados.setText(txtDados);
            Toast.makeText(this,txtDados,Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page2, menu);
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
