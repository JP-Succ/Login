package com.example.juanpablo.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

import static com.example.juanpablo.login.R.id.txtTelefono;

public class Logueado extends AppCompatActivity {

    //definimos
    private String user;
    public EditText txtTelefono;
    private Button btnFinalizar;
    private Button btnMarcar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueado);

        //captura id boton finalizar
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        //capturo id boton marcar
        btnMarcar = (Button) findViewById(R.id.btnMarcar);
        //capturo telefono
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        final String telefono = txtTelefono.getText().toString();
        final String uri = "tel: "+ telefono.trim();

        //recupero parametros
         Bundle parametros = getIntent().getExtras();

        user = parametros.getString("KEY_USER");
        //intent implicito para marcar
        btnMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent();
                dial.setAction("android.intent.action.DIAL");
                dial.setData(Uri.parse(uri));
                startActivity(dial);
            }
        });
        //referencia controles de UI
        TextView txtBienvenido = (TextView) findViewById(R.id.txtBienvenido);
        //asignacion parametros recuperados a UI
        txtBienvenido.setText("Bienvenido " + user);

        //evento onclick para volver a main
        btnFinalizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent volverAMain = new Intent(Logueado.this, MainActivity.class);
                startActivity(volverAMain);
            }
        });


    }
}
