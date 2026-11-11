package ui;

import logica.ColeccionControlador;

import java.util.Scanner;

public class OpcionSalir extends Opcion {

    public OpcionSalir(ColeccionControlador controlador, Scanner scanner) {
        super("Salir", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        System.out.println("Gracias por usar el programa. Adios!");
    }

    @Override
    public boolean esSalir() {
        return true;
    }
}
