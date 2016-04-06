package com.example.giaccomo.controlnutricional;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Giaccomo on 05/04/2016.
 */
public class Diario {
    Persona persona;
    int vasosAgua;
    Date fecha;
    ArrayList<Alimento> alimentos;
    ArrayList<Actividad_Fisica> actividadesFisicas;

    public Diario(Persona pPersona, int pVasosDeAgua, Date pFecha, ArrayList<Alimento> pAlimentos, ArrayList<Actividad_Fisica> pActividadesFisicas){
        this.persona = pPersona;
        this.vasosAgua = pVasosDeAgua;
        this.fecha = pFecha;
        this.alimentos = pAlimentos;
        this.actividadesFisicas = pActividadesFisicas;
    }
}
