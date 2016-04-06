package com.example.giaccomo.controlnutricional;

/**
 * Created by Giaccomo on 05/04/2016.
 */
public class Alimento {
    int idAlimento;
    String nombre;
    String marca;
    int tamanioPorcion;
    int grasas;
    int carbohidratos;
    int proteinas;
    int calorias;

    public static int idAlimentoIncremental = 0;

    public Alimento(String pNombre, String pMarca, int pTamanioPorcion,
                    int pGrasas, int pCarbohidratos, int pProteinas, int pCalorias){
        this.idAlimento = idAlimentoIncremental++;
        this.nombre = pNombre;
        this.marca = pMarca;
        this.tamanioPorcion = pTamanioPorcion;
        this.grasas = pGrasas;
        this.carbohidratos = pCarbohidratos;
        this.proteinas = pProteinas;
        this.calorias = pCalorias;
    }
}
