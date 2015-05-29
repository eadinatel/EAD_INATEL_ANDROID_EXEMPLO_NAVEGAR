package com.example.rafaelliberato.exemploead1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    //Declaracao dos elementos para vinculacao
    private EditText txtParametros;
    private Button btnComParametros;
    private Button btnSemParametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculando os elementos da VIEW com o codigo de logica Java
        txtParametros = (EditText)findViewById(R.id.txtParametros);
        btnComParametros = (Button)findViewById(R.id.btnComParametros);
        btnSemParametros = (Button)findViewById(R.id.btnSemParametros);

        //Criação do Evento de Click do botao btnComParametros
        btnComParametros.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //Get Texto do elemento txtParametros referenciado na View
                String parametro = txtParametros.getText().toString();

                //Cria-se um objeto Bundle para armazenar o parametro a ser enviado através na navegação entre paginas
                Bundle bundle = new Bundle();
                //Armazena no obj.Bundle uma Chave / Valor , onde a chave "dados" ira conter o valor da variável parametro
                bundle.putString("dados", parametro);

                Intent intent = new Intent(getApplicationContext(), Page2.class);
                //Associa-se o obj Bundle com a intent de navegacao.
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });//Fim do Listener btnComParametros


        btnSemParametros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //Cria-se o obj de intenção de navegacao, com destino da navegacao sendo classe Page2
                Intent intent = new Intent(getApplicationContext(), Page2.class);
                startActivity(intent);
            }
        });//Fim do Listener btnSemParametros

    }//Fim do Metodo OnCreate()




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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