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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Pantalla_Login extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    EditText password;
    EditText correo;
    private static final String URL = "https://10.0.2.2:5000/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__login);

        password = (EditText) findViewById(R.id.TxtFldContrasenia);
        password.setTypeface(Typeface.DEFAULT);
        password.setTransformationMethod(new PasswordTransformationMethod());

        correo = (EditText) findViewById(R.id.TxtFldCorreo);


        RequestQueue request = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, this, this);
        jsonArrayRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
        request.add(jsonArrayRequest);

    }

    public void login(View v){
       /* for(int i=0; i<Persona.BDPersonas.size(); i++){
            if(Persona.BDPersonas.get(i).correo == correo.getText().toString()){
                if(Persona.BDPersonas.get(i).contrasenia == password.getText().toString()){*/
                    //Persona.ultimoIDLogueado = Persona.BDPersonas.get(i).idPersona;
                    Intent intent = new Intent(this, Pantalla_Principal.class);
                    startActivity(intent);
               /* }else{
                    Toast.makeText(Pantalla_Login.this, "Datos incorrectos1", Toast.LENGTH_SHORT).show();
                }
            }
        }
        Toast.makeText(Pantalla_Login.this, "Datos incorrectos2", Toast.LENGTH_SHORT).show();*/
    }

    public void registrarse(View v){
        Intent intent = new Intent(this, Pantalla_Registro.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(JSONArray response) {
        try{
            Log.d("onResponse()", response.toString(0));
            response.toString(0);
            //System.out.print("AKIIIIIIIIIIIIII" + response.toString(0));
            //Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
        }catch(JSONException e){
            System.out.print(response);
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("onErrorResponse()", error.toString());
    }

}
