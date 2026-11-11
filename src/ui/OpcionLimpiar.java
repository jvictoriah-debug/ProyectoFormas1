package ui;

import logica.ColeccionControlador;

import java.util.Scanner;

// Borra las figuras y cuerpos agregados para que la siguiente consulta empiece de cero
public class OpcionLimpiar extends Opcion {

    public OpcionLimpiar(ColeccionControlador controlador, Scanner scanner) {
        super("Limpiar consulta", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        int respuesta = leerOpcion("Seguro que desea borrar todas las figuras y cuerpos? (1 = Si, 2 = No): ", 1, 2);
        if (respuesta == 1) {
            getControlador().limpiar();
            System.out.println("Consulta limpiada. Puede empezar una nueva.");
        } else {
            System.out.println("No se borro nada.");
        }
    }
}
