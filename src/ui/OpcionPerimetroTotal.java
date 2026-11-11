package ui;

import logica.ColeccionControlador;

import java.util.Scanner;

public class OpcionPerimetroTotal extends Opcion {

    public OpcionPerimetroTotal(ColeccionControlador controlador, Scanner scanner) {
        super("Calcular perimetro total", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        System.out.println("Perimetro total: " + String.format("%.2f", getControlador().getPerimetroTotal()));
    }
}
