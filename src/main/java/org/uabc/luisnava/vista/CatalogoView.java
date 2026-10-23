package org.uabc.luisnava.vista;


import org.uabc.luisnava.modelo.Genero;
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
        System.out.println("3. Salir");
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


    /*
        Melodia cancion1 = new Melodia();
        Melodia cancion2 = new Melodia();
        Melodia cancion3 = new Melodia();

        ArrayList<Melodia> cancionesPorCompositor = new ArrayList<>();

        CatalogoMelodias catalogoMelodias = new CatalogoMelodias();

        cancion1.setNombre("Si no te hubieras ido");
        cancion2.setNombre("Las mañanitas");
        cancion3.setNombre("Las mañanitas");

        cancion1.setGenero("Romantica");
        cancion2.setGenero("Regional Mexicana");
        cancion3.setGenero("Grupera");


        cancion1.setCantante("Marco Antonio Solis");
        cancion2.setCantante("Vicente Fernandez");
        cancion3.setCantante("Alejandro Fernandez");


        cancion1.setCompositor("Juan Gabriel");
        cancion2.setCompositor("Juan Gabriel");
        cancion3.setCompositor("Espinoza Paz");

        catalogoMelodias.registrarMelodia(cancion1);
        catalogoMelodias.registrarMelodia(cancion2);
        catalogoMelodias.registrarMelodia(cancion3);


        System.out.println(catalogoMelodias.obtenerTodosLosGenerosIterativo());

        System.out.println(catalogoMelodias.melodiasPorCompositor("Juan Gabriel"));
        */


}
