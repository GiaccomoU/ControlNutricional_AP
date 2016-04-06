package com.example.giaccomo.controlnutricional;

/**
 * Created by Giaccomo on 05/04/2016.
 */
public class Actividad_Fisica {
    int idActividadFisica;
    String nombre;
    int caloriasXHoras;

    public Actividad_Fisica(int pIdActividadFisica, String pNombre, int pCaloriasXHoras){
        this.idActividadFisica = pIdActividadFisica;
        this.nombre = pNombre;
        this.caloriasXHoras = pCaloriasXHoras;
    }
}
