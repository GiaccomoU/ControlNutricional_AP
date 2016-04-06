package com.example.giaccomo.controlnutricional;

import java.util.ArrayList;

public class Persona {
    int idPersona;
    String nombre;
    String correo;
    String contrasenia;
    int edad;
    String sexo;
    int estatura;
    int peso;
    String nivelActFisica;
    ArrayList<Alimento> alimentosCreados;

    public static ArrayList<Persona> BDPersonas = new ArrayList<Persona>();
    public static int idIncremental = 0;
    public static int ultimoIDLogueado;

    public Persona(String pNombre, String pCorreo, String pContrasenia, int pEdad,
                   String pSexo, int pEstatura, int pPeso, String pNivelActFisica){
        this.idPersona = idIncremental++;
        this.nombre = pNombre;
        this.correo = pCorreo;
        this.contrasenia = pContrasenia;
        this.edad = pEdad;
        this.sexo = pSexo;
        this.estatura = pEstatura;
        this.peso = pPeso;
        this.nivelActFisica = pNivelActFisica;
    }



}


