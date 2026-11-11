package ui;

import logica.ColeccionControlador;

import java.util.Scanner;

public class OpcionVolumenTotal extends Opcion {

    public OpcionVolumenTotal(ColeccionControlador controlador, Scanner scanner) {
        super("Calcular volumen total", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        System.out.println("Volumen total: " + String.format("%.2f", getControlador().getVolumenTotal()));
    }
}
