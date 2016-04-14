package com.example.giaccomo.controlnutricional;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Pantalla_Login extends AppCompatActivity {

    EditText password;
    EditText correo;
    private static final String URL = "http://10.0.2.2:5002/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__login);

        password = (EditText) findViewById(R.id.TxtFldContrasenia);
        password.setTypeface(Typeface.DEFAULT);
        password.setTransformationMethod(new PasswordTransformationMethod());

        correo = (EditText) findViewById(R.id.TxtFldCorreo);
    }

    public void login(View v){
        for(int i=0; i<Persona.BDPersonas.size(); i++){
            if(Persona.BDPersonas.get(i).correo == correo.getText().toString()){
                if(Persona.BDPersonas.get(i).contrasenia == password.getText().toString()){
                    Persona.ultimoIDLogueado = Persona.BDPersonas.get(i).idPersona;
                    Intent intent = new Intent(this, Pantalla_Principal.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Pantalla_Login.this, "Datos incorrectos1", Toast.LENGTH_SHORT).show();
                }
            }
        }
        Log.d("onResponse()", "LISTA DE PERSONAS: " + Persona.BDPersonas.toString());
        Toast.makeText(Pantalla_Login.this, "Datos incorrectos2", Toast.LENGTH_SHORT).show();
    }

    public void registrarse(View v){
                Intent intent = new Intent(this, Pantalla_Registro.class);
                startActivity(intent);
    }




}

