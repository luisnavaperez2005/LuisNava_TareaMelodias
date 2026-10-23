package org.uabc.luisnava.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CatalogoMelodias {
    ArrayList<Melodia> canciones = new ArrayList<>();
    private int id = 1;

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
        //melodia.setNombre();

        return melodia;
    }


}
