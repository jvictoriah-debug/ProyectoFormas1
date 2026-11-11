package ui;

import logica.ColeccionControlador;

import java.util.ArrayList;
import java.util.Scanner;

// Menu de consola. Guarda las opciones como objetos de tipo Opcion
// y al elegir una se llama a ejecutar() de la clase hija (ligado dinamico)
public class Menu {

    private ArrayList<Opcion> opciones;
    private Scanner scanner;

    public Menu(ColeccionControlador controlador) {
        scanner = new Scanner(System.in);
        opciones = new ArrayList<>();
        opciones.add(new OpcionAgregarFigura(controlador, scanner));
        opciones.add(new OpcionAgregarCuerpo(controlador, scanner));
        opciones.add(new OpcionListarFiguras(controlador, scanner));
        opciones.add(new OpcionListarCuerpos(controlador, scanner));
        opciones.add(new OpcionAreaTotal(controlador, scanner));
        opciones.add(new OpcionPerimetroTotal(controlador, scanner));
        opciones.add(new OpcionVolumenTotal(controlador, scanner));
        opciones.add(new OpcionLimpiar(controlador, scanner));
        opciones.add(new OpcionSalir(controlador, scanner));
    }

    public ArrayList<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }

    public void mostrar() {
        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("===== PROYECTO FORMAS =====");
            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i).getDescripcion());
            }
            System.out.print("Elija una opcion: ");

            int numero;
            try {
                numero = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe escribir un numero.");
                continue;
            }
            if (numero < 1 || numero > opciones.size()) {
                System.out.println("Esa opcion no existe.");
                continue;
            }

            Opcion opcion = opciones.get(numero - 1);
            try {
                opcion.ejecutar();
                salir = opcion.esSalir();
            } catch (IllegalArgumentException e) {
                // Por ejemplo si los lados no forman un triangulo o una medida es negativa
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Menu{" + "opciones=" + opciones.size() + '}';
    }
}
