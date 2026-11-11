package ui;

import logica.ColeccionControlador;

import java.util.Scanner;

public class OpcionAreaTotal extends Opcion {

    public OpcionAreaTotal(ColeccionControlador controlador, Scanner scanner) {
        super("Calcular area total", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        System.out.println("Area total: " + String.format("%.2f", getControlador().getAreaTotal()));
    }
}
