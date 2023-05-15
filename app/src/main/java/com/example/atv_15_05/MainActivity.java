package com.example.atv_15_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaração das variáveis
    EditText email, senha;
    Button entrar;

    //Declarar preferências
    public static final String MyPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.et_email);
        senha = (EditText) findViewById(R.id.et_senha);
        entrar = (Button) findViewById(R.id.btn_entrar);

        //CLASSE SHAREDPREFERENCES
        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, 0 );

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declaração das variáveis locais
                String emailLocal = email.getText().toString();
                String senhaLocal = senha.getText().toString();

                //Declaração do editor sharedpreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //Persistências dos dados
                editor.putString("str_email", emailLocal);
                editor.putString("str_senha", senhaLocal);
                editor.commit();
                //notificação
                Toast.makeText(MainActivity.this, "Bem Vindo", Toast.LENGTH_SHORT).show();
            }
        });
        //Login automatico
        SharedPreferences preferencia = getSharedPreferences(MyPREFERENCES, 0);
        if(preferencia.contains("str_email")){
            String str_email = preferencia.getString("str_email", "");
            email.setText(str_email);
        }
        if(preferencia.contains("str_senha")){
            String str_senha = preferencia.getString("str_senha", "");
            senha.setText("str_senha");
        }
    }
}