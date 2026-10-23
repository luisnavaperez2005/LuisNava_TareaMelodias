package org.uabc.luisnava.control;

import org.uabc.luisnava.modelo.CatalogoMelodias;
import org.uabc.luisnava.vista.CatalogoView;

public class ControlCatalogo {
    private CatalogoMelodias modelo;
    private CatalogoView vista;

    public ControlCatalogo(CatalogoView vista, CatalogoMelodias modelo){
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar(){
        int opcion = 1;
        while (opcion != 0){
            opcion = vista.mostrarMenu();

            switch (opcion){
                case 1: vista.mostrarCadena("Registra una Nueva Melodia");
                String n = vista.leerNombreMelodia();
                String nca = vista.leerCantante();
                String nco = vista.leerCompositor();
                String gen = vista.mostrarObtenerGenero();
                int anio = vista.leerAnioMelodia();
                double precio = vista.leerPrecioMelodia();
                String formato = vista.mostrarObtenerFormato();
                modelo.crearObjetoMelodia(n, nco, anio, gen, nca, precio, formato);
                    break;
                case 2:
                    vista.mostrarCadena(modelo.mostrarTodasLasCanciones());
                    break;


                case 3:
                    vista.mostrarCadena("Adios");
                    break;

            }

        }
    }


}
