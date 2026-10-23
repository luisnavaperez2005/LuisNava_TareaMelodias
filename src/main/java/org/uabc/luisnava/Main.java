package org.uabc.luisnava;

import org.uabc.luisnava.control.ControlCatalogo;
import org.uabc.luisnava.modelo.CatalogoMelodias;
import org.uabc.luisnava.modelo.Melodia;
import org.uabc.luisnava.vista.CatalogoView;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        CatalogoMelodias modelo = new CatalogoMelodias();
        CatalogoView vista = new CatalogoView();
        ControlCatalogo control = new ControlCatalogo(vista, modelo);

        control.iniciar();


    }
}
