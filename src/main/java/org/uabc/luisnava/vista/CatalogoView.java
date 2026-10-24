package org.uabc.luisnava.vista;


import org.uabc.luisnava.modelo.Genero;
import org.uabc.luisnava.modelo.Melodia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CatalogoView {
    private Scanner leerNumeros = new Scanner(System.in);
    private Scanner leerCadenas = new Scanner(System.in);

    String [] formatos = {"mp3", "ogg", "wav"};

    public int mostrarMenu(){
        leerCadenas = new Scanner(System.in);
        leerNumeros = new Scanner(System.in);

        System.out.println("\n---- Menu Catalogo de Melodias ----");
        System.out.println("1. Registrar Melodia");
        System.out.println("2. Mostrar todo el catalogo");
        System.out.println("3. Eliminar melodia por nombre");
        System.out.println("4. Datos de melodia por nombre");
        System.out.println("5. Corregir datos de Melodia");
        System.out.println("6. Costo total de la coleccion");
        System.out.println("7. Cantidad Cantantes Diferentes");
        System.out.println("8. Cantantes en la coleccion");
        System.out.println("9. Melodias por genero");
        System.out.println("10. Generos en la coleccion");
        System.out.println("11. Melodias por compositor");
        System.out.println("12. Melodias por Cantante");
        System.out.println("13. Melodias por año");
        System.out.println("14. Consulta General");
        System.out.println("15. Cantidad de formatos en la coleccion");
        System.out.println("16. Salir");
        System.out.println("Elige una opcion: ");
        return leerNumeros.nextInt();
    }

    public String leerNombreMelodia(){
        System.out.println("Ingresa el nombre de la melodia: ");
        return leerCadenas.nextLine();
    }

    public String leerCompositor(){
        System.out.println("Ingresa el nombre del compositor: ");
        return leerCadenas.nextLine();
    }

    public String leerCantante(){
        System.out.println("Ingresa el nombre del cantante: ");
        return leerCadenas.nextLine();
    }

    public int leerAnioMelodia(){
        System.out.println("Ingresa el año de la melodia: ");
        return leerCadenas.nextInt();
    }

    public String leerGenero(){
        System.out.println("Ingresa el Genero de la melodia: ");
        return leerCadenas.nextLine();
    }

    public void mostrarCatalogo(String catalago){
        System.out.println(catalago);
    }

    public void mostrarCadena(String cadena){
        System.out.println(cadena);
    }


    public String mostrarObtenerGenero(){
        Genero[] generos = Genero.values();
        int numero = 1;
        int seleccion;

        for (Genero g: Genero.values()){
            System.out.println(numero + ". Genero " + g);
            numero++;
        }

        System.out.println("Ingresa el numero del genero");
        numero = leerNumeros.nextInt();
        return generos[numero - 1].toString();

    }

    //para leer y regresar el precio que le asignare a melodia
    public double leerPrecioMelodia(){
        System.out.println("Ingresa el precio de la melodia: ");
        return leerCadenas.nextInt();
    }

    //Para leer y regresar el formato que le asignemos a melodia
    public String mostrarObtenerFormato(){
        int numero = 1;
        int seleccion;

        for (String g: formatos){
            System.out.println(numero + ". Formato " + g);
            numero++;
        }

        System.out.println("Ingresa el numero del genero");
        numero = leerNumeros.nextInt();
        return formatos[numero - 1].toString();

    }


    public void mostrarArrayList(ArrayList<Melodia> melodias){
        System.out.println(melodias);
    }

    public int leerIdMelodia(){
        System.out.println("Ingresa el ID de la melodia: ");
        return leerCadenas.nextInt();
    }

    public void mostrarInt(int entero){
        System.out.println(entero);
    }

    public void mostrarDouble(double numero){
        System.out.println(numero);
    }

    public void mostrarHashSet(HashSet<String> hashSet){
        System.out.println(hashSet);
    }

    public int leerOpcion(){
        System.out.println("La opcion: ");
        return leerCadenas.nextInt();
    }


    public void mostrarHashMap(HashMap<String, Integer> hashMap){
        System.out.println(hashMap);
    }

    public void mostrarMenuConsultaGeneral(){
        System.out.println("1. Orden alfabetico (A-Z)");
        System.out.println("2. Por Artista (A-Z)");
        System.out.println("3. Por compositor (A-Z)");
        System.out.println("4. Por genero (A-Z)");
        System.out.println("5. Por formato");
        System.out.println("7. Por año");
    }


}
