package com.example.juanpablo.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPass;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //invocar segunda activity
                Intent intent = new Intent(MainActivity.this, Logueado.class);
                //obtengo el usuario, contraseña y lo convierto a cadena
                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();
                if (validarLogin(user, pass)) {
                    //mandamos parametros
                    intent.putExtra("KEY_USER", user);
                    intent.putExtra("KEY_PASS", pass);
                    //iniciar intent con metodo startActivity
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Los datos ingresados son incorrectos", Toast.LENGTH_LONG).show();
                    txtUser.setText("");
                    txtPass.setText("");
                }
            }
        });
    }
    public boolean validarLogin(String user,String pass){

        if (user.equals("ites") && pass.equals("1234"))
            return true;
        else
            return false;
    }

    }

/*
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnIngresar:
                //invocar segunda activity
                Intent intent = new Intent(this, Logueado.class);
                //obtengo el usuario, contraseña y lo convierto a cadena
                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();
                if(validarLogin(user,pass)){
                    //mandamos parametros
                    intent.putExtra("KEY_USER",user);
                    intent.putExtra("KEY_PASS",pass);
                    //iniciar intent con metodo startActivity
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Los datos ingresados son incorrectos", Toast.LENGTH_LONG).show();
                    txtUser.setText("");
                    txtPass.setText("");
                }

                break;

        }

    }*/

