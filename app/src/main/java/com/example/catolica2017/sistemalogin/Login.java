package com.example.catolica2017.sistemalogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    SharedPreferences bdlogin;

    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.bdlogin = getSharedPreferences("login", Context.MODE_PRIVATE);

        this.btn_login = (Button) findViewById(R.id.btn_login);
        this.btn_login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                EditText txt_login = (EditText) findViewById(R.id.txt_login);
                EditText txt_pass = (EditText) findViewById(R.id.txt_pwd);

                String user = txt_login.getText().toString();
                String pass = txt_pass.getText().toString();

                if (user.equals("william") && pass.equals("12345")) {

                    Intent intencao = new Intent(getcontex(), Profile.class);
                    Bundle paramentros = new Bundle();
                    paramentros.putString("user", user);
                    paramentros.putString("pass", pass);

                    intencao.putExtras(paramentros);

                    startActivity(intencao);

                    alert("Bem vindo " + user + " seu login foi realizado com Sucesso!");
                } else {
                    alert("Nome do Usuario ou Senha estao incorretos");
                }
            }

        });
    }

    public Context getcontex() {

        return this;

    }


    public void alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }


    public void salvarSessao(String user, String pass) {
        SharedPreferences.Editor vrEditor = bdlogin.edit();
        vrEditor.putString("user", user);
        vrEditor.putString("pwd", pass);
        vrEditor.commit();
    }

    public String getDadosSessao(String chave) {
        String user = bdlogin.getString(chave, "falha");
        return user;

    }
}
