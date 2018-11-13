package com.example.tecinfo.simulandochamada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SharedPreferences meusDados;
    public static final String mypreference = "call";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meusDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        final EditText email = findViewById(R.id.edit_email);
        final EditText senha = findViewById(R.id.edit_senha);
        Button btnlogin = findViewById(R.id.btn_login);
        TextView register = findViewById(R.id.txt_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String meuEmail = email.getText().toString();
                String minhaSenha = senha.getText().toString();

                if(meusDados.contains("email") && meusDados.contains("senha")) {

                    if(meuEmail.equals(meusDados.getString("email", ""))
                            && minhaSenha.equals(meusDados.getString("senha", "")) ) {

                        Intent intent = new Intent(MainActivity.this,
                                ligacaoActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(),"Email ou senha invalidos!", Toast.LENGTH_LONG).show();
                    }



                } else {

                    Toast.makeText(getApplicationContext(),"Não existem cadastros!", Toast.LENGTH_LONG).show();

                }

            }

        });

    }
}
