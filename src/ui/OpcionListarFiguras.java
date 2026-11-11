package ui;

import logica.ColeccionControlador;
import logica.Figura;

import java.util.Scanner;

public class OpcionListarFiguras extends Opcion {

    public OpcionListarFiguras(ColeccionControlador controlador, Scanner scanner) {
        super("Listar figuras", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        if (getControlador().getFiguras().isEmpty()) {
            System.out.println("No hay figuras registradas.");
            return;
        }
        for (Figura f : getControlador().getFiguras()) {
            f.imprimirInformacion();
        }
    }
}
