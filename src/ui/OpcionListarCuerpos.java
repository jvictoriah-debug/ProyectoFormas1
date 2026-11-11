package ui;

import logica.ColeccionControlador;
import logica.Cuerpo;

import java.util.Scanner;

public class OpcionListarCuerpos extends Opcion {

    public OpcionListarCuerpos(ColeccionControlador controlador, Scanner scanner) {
        super("Listar cuerpos", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        if (getControlador().getCuerpos().isEmpty()) {
            System.out.println("No hay cuerpos registrados.");
            return;
        }
        for (Cuerpo c : getControlador().getCuerpos()) {
            c.imprimirInformacion();
        }
    }
}
