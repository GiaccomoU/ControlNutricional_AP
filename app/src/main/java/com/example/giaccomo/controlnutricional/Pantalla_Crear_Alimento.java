package com.example.giaccomo.controlnutricional;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Pantalla_Crear_Alimento extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private ActionBar myActionBar;
    private Button btnAbrirMenu;

    private EditText editTextNombreAlimento;
    private EditText editTextMarca;
    private EditText editTextTamanioPorcion;
    private EditText editTextCalorias;
    private EditText editTextCarbohidratos;
    private EditText editTextGrasas;
    private EditText editTextProteinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__crear__alimento);

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        btnAbrirMenu = (Button)findViewById(R.id.btnAbrirMenu);

        addDrawerItems();

        editTextNombreAlimento = (EditText) findViewById(R.id.editTextNombreAlimento);
        editTextMarca = (EditText) findViewById(R.id.editTextMarcaAlimento);
        editTextTamanioPorcion = (EditText) findViewById(R.id.editTextTamanioPorcion);
        editTextCalorias = (EditText) findViewById(R.id.editTextCalorias);
        editTextCarbohidratos = (EditText) findViewById(R.id.editTextCarbohidratos);
        editTextGrasas = (EditText) findViewById(R.id.editTextGrasas);
        editTextProteinas = (EditText) findViewById(R.id.editTextProteinas);
    }

    public void sacarMenuLateral(View v){
        if(mDrawerLayout.isDrawerOpen(Gravity.LEFT)){
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }

    private void addDrawerItems() {
        String[] osArray = { "Inicio", "Registrar Alimento", "Cerrar Sesión" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(Pantalla_Crear_Alimento.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
                selectItem(position);
            }
        });
    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void selectItem(int position){
        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(this, Pantalla_Principal.class);
                startActivity(intent);
                break;
            case 2:
                break;
            case 3:
                intent = new Intent(this, Pantalla_Login.class);
                startActivity(intent);
                break;
        }
    }

    public void crearAlimento(View v){
        String pNombre = editTextNombreAlimento.getText().toString();
        String pMarca = editTextMarca.getText().toString();
        int pPorcion = Integer.parseInt(editTextTamanioPorcion.getText().toString());
        int pCalorias = Integer.parseInt(editTextCalorias.getText().toString());
        int pCarbohidratos = Integer.parseInt(editTextCarbohidratos.getText().toString());
        int pGrasas = Integer.parseInt(editTextGrasas.getText().toString());
        int pProteinas = Integer.parseInt(editTextProteinas.getText().toString());

        Alimento nuevoAlimento = new Alimento(pNombre, pMarca, pPorcion, pCalorias, pCarbohidratos, pGrasas, pProteinas);
        Persona.BDPersonas.get(Persona.ultimoIDLogueado).alimentosCreados.add(nuevoAlimento);
        Intent intent = new Intent(this, Pantalla_Agregar_Alimento.class);
    }
}
