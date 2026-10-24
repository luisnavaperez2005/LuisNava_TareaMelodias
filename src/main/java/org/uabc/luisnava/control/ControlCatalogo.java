package org.uabc.luisnava.control;

import org.uabc.luisnava.modelo.CatalogoMelodias;
import org.uabc.luisnava.modelo.Melodia;
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
                    vista.mostrarCadena("Ingresa el nombre de la melodia");
                    modelo.eliminarMelodiaPorNombre(vista.leerNombreMelodia());
                    break;

                case 4:
                    vista.mostrarCadena("Ingresa el nombre de la melodia a buscar");
                    vista.mostrarArrayList(modelo.consultarMelodiaPorNombre(vista.leerNombreMelodia()));
                    break;

                case 5:
                    int id = vista.leerIdMelodia();

                    Melodia melodia = modelo.buscarMelodiaID(id);

                    if (melodia != null) {
                        vista.mostrarCadena("Ingresa los datos de la melodia para cambiar");
                        modelo.corregirLosDatosDeUnaMelodia(id, vista.leerNombreMelodia(), vista.leerCompositor(),
                                vista.leerAnioMelodia(), vista.leerGenero(), vista.leerCantante(), vista.leerPrecioMelodia(),
                                vista.mostrarObtenerFormato());
                    }
                    else {
                        vista.mostrarCadena("No existe la melodia con ese ID");
                    }
                    break;

                case 6:
                    vista.mostrarCadena("Precio total de la coleccion: ");
                    vista.mostrarDouble(modelo.valorDeLaColeccion());
                    break;

                case 7:
                    vista.mostrarCadena("Cantidad de cantantes diferentes: ");
                    vista.mostrarInt(modelo.cantidadDeCantantes());
                    break;

                case 8:
                    vista.mostrarCadena("Cantantes con melodias: ");
                    vista.mostrarHashSet(modelo.nombreDeLosCantantes());
                    break;

                case 9:
                    vista.mostrarCadena("Melodias por generos: ");
                    vista.mostrarArrayList(modelo.melodiasPorGenero());
                    break;

                case 10:
                    vista.mostrarCadena("Generos en la coleccion: ");
                    vista.mostrarHashSet(modelo.generosMusicalesColeccion());
                    break;

                case 11:
                    vista.mostrarCadena("Melodias por compositor: ");
                    vista.mostrarArrayList(modelo.melodiasPorCompositor(vista.leerCompositor()));
                    break;

                case 12:
                    vista.mostrarCadena("Melodias por cantante: ");
                    vista.mostrarArrayList(modelo.melodiasPorCantante(vista.leerCantante()));
                    break;

                case 13:
                    vista.mostrarCadena("Melodias por año: ");
                    vista.mostrarArrayList(modelo.melodiasPorAnio(vista.leerAnioMelodia()));
                    break;

                case 14:
                    vista.mostrarMenuConsultaGeneral();
                    vista.mostrarArrayList(modelo.consultaGeneral(vista.leerOpcion()));
                    break;

                case 15:
                    vista.mostrarCadena("Formatos: ");
                    vista.mostrarHashMap(modelo.formatosMelodias());
                    break;

            }

        }
    }


}
