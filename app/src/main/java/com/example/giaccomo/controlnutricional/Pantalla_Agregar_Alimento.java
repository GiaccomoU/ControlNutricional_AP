package com.example.giaccomo.controlnutricional;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.ActionBar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Pantalla_Agregar_Alimento extends AppCompatActivity {

    private ListView mDrawerList;
    private ListView listaAlimentos;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ArrayAdapter<String> AdaptadorAlimentos;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private ActionBar myActionBar;
    private Button btnAbrirMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__agregar__alimento);

        listaAlimentos = (ListView) findViewById(R.id.listaAlimentos);

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        btnAbrirMenu = (Button)findViewById(R.id.btnAbrirMenu);

        addDrawerItems();

    }

    public void sacarMenuLateral(View v){
        if(mDrawerLayout.isDrawerOpen(Gravity.LEFT)){
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }

    private void addDrawerItems() {
        String[] osArray = { "Inicio", "Mi Perfil", "Registrar Alimento", "Cerrar Sesión" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Pantalla_Agregar_Alimento.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void llenarLista(){
        ArrayList<String> array = new ArrayList<String>();
        for(Alimento i: Persona.BDPersonas.get(Persona.ultimoIDLogueado).alimentosCreados){
            array.add(i.nombre);
        }
        AdaptadorAlimentos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listaAlimentos.setAdapter(AdaptadorAlimentos);
    }

    public void crearAlimento(View v){
        Intent intent = new Intent(this, Pantalla_Crear_Alimento.class);
        startActivity(intent);
    }

}
