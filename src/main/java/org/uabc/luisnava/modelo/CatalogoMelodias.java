package org.uabc.luisnava.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CatalogoMelodias {
    ArrayList<Melodia> canciones = new ArrayList<>();
    private int id = 1;

    String [] formatosParaMelodia = {"mp3", "ogg", "wav"};

    public boolean registrarMelodia(Melodia obj){
        boolean ban = false;
        if (canciones != null){
            for (Melodia melodia:canciones){
                ban = melodia.equals(obj);
                if (ban){
                    break;
                }
            }
        }
        if (!ban){
            canciones.add(obj);
        }
        //False si se registro la cancion
        return ban;
    }

    public String mostrarTodasLasCanciones(){
        StringBuffer sb = new StringBuffer();
        for (Melodia melodia:canciones){
            sb.append(melodia);
            sb.append("\n");
        }
        return sb.toString();
    }

    public ArrayList<String> obtenerTodosLosGeneros(){
        ArrayList<String> generos = (ArrayList<String>) canciones.stream().map(Melodia::getGenero).distinct().collect(Collectors.toList());
        return generos;
    }


    public HashSet<String> obtenerTodosLosGenerosIterativo(){
        HashSet<String> genero = new HashSet<>();
        for(Melodia cancion:canciones){
            genero.add(cancion.getGenero());
        }
        return genero;
    }

    public ArrayList<Melodia> melodiasPorCompositor(String compositor){
        return (ArrayList<Melodia>) canciones.stream().filter(n -> n.getCompositor().equals(compositor)).collect(Collectors.toList());
    }

    public void crearObjetoMelodia(String nombre, String compositor, int anio, String genero , String cantante, double precio, String formato){
        registrarMelodia(new Melodia(nombre, compositor, anio, genero, cantante, precio, formato));
    }

    public void eliminarMelodiaPorNombre(String nombre){
        for (int i = 0; i < canciones.size(); i++){
            if (canciones.get(i).getNombre().equals(nombre)){
                canciones.remove(i);
                //Se hace un -- para que el indice no se rompa
                i--;
            }
        }
    }


    public ArrayList<Melodia> consultarMelodiaPorNombre(String nombre){
        ArrayList<Melodia> cancionesEncontradas = new ArrayList<>();
        for (int i = 0; i < canciones.size(); i++){
            if (canciones.get(i).getNombre().equals(nombre)){
                cancionesEncontradas.add(canciones.get(i));
            }
        }
        return cancionesEncontradas;
    }

    public Melodia corregirLosDatosDeUnaMelodia(Melodia melodia){

        return melodia;
    }

    public double valorDeLaColeccion(){
        double precioTotal = 0;

        for (int i = 0; i < canciones.size(); i++){
            precioTotal += canciones.get(i).getPrecio();
        }

        return precioTotal;
    }

    public int cantidadDeCantantes(){
        HashSet<String> cantantesDiferentes = new HashSet<>();
        int cantantesTotal = 0;

        for (int i = 0; i < canciones.size(); i++){
            cantantesDiferentes.add(canciones.get(i).getCantante());
        }

        cantantesTotal = cantantesDiferentes.size();

        return cantantesTotal;
    }

    public ArrayList<Melodia> melodiasPorGenero(){
        ArrayList<Melodia> todasLasCancionesOrdenadasPorGenero = new ArrayList<>();

        Genero [] generos = Genero.values();

        //Se ordenan las canciones por genero
        for (int i = 0; i < generos.length; i++){
            for (int j = 0; j < canciones.size(); j++) {
                if (canciones.get(j).getGenero().equals(generos[i].toString())) {
                    todasLasCancionesOrdenadasPorGenero.add(canciones.get(j));
                }
            }
        }

        return todasLasCancionesOrdenadasPorGenero;
    }

    public HashSet<String> generosMusicalesColeccion(){
        HashSet<String> generosSinRepetir = new HashSet<>();

        for (int i = 0; i < canciones.size(); i++){
            generosSinRepetir.add(canciones.get(i).getGenero());
        }
        return generosSinRepetir;
    }

    public HashMap<String, Integer> formatosMelodias(){
        HashMap<String, Integer> formatos = new HashMap<>();
        int mp3 = 0;
        int wav = 0;
        int ogg = 0;

        for (int i = 0; i < canciones.size(); i++){
            if (canciones.get(i).getFormato().equals(formatosParaMelodia[0])){
                mp3++;
            }
            else if (canciones.get(i).getFormato().equals(formatosParaMelodia[1])){
                ogg++;
            }
            else if (canciones.get(i).getFormato().equals(formatosParaMelodia[2])){
                wav++;
            }
        }

        formatos.put("mp3", mp3);
        formatos.put("ogg", ogg);
        formatos.put("wav", wav);


        return formatos;
    }


    public ArrayList<Melodia> melodiasPorCantante(String cantante){
        ArrayList<Melodia> todasLasCancionesOrdenadasPorCantante = new ArrayList<>();

        //Se ordenan las canciones por cantante
        for (int i = 0; i < canciones.size(); i++){
            if (canciones.get(i).getCantante().equals(cantante)) {
                todasLasCancionesOrdenadasPorCantante.add(canciones.get(i));
            }
        }

        return todasLasCancionesOrdenadasPorCantante;
    }


    public ArrayList<Melodia> melodiasPorAnio(int anio){
        ArrayList<Melodia> todasLasCancionesOrdenadasPorAnio = new ArrayList<>();

        //Se ordenan las canciones por cantante
        for (int i = 0; i < canciones.size(); i++){
            if (canciones.get(i).getAnio() == anio) {
                todasLasCancionesOrdenadasPorAnio.add(canciones.get(i));
            }
        }

        return todasLasCancionesOrdenadasPorAnio;
    }



}
