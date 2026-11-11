package ui;

import logica.ColeccionControlador;

import java.util.Scanner;

// Clase padre de todas las opciones del menu
// Cada opcion hija sobreescribe el metodo ejecutar() (ligado dinamico)
public abstract class Opcion {

    private String descripcion;
    private ColeccionControlador controlador;
    private Scanner scanner;

    public Opcion(String descripcion, ColeccionControlador controlador, Scanner scanner) {
        this.descripcion = descripcion;
        this.controlador = controlador;
        this.scanner = scanner;
    }

    public abstract void ejecutar();

    // Solo la opcion Salir devuelve true
    public boolean esSalir() {
        return false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    protected ColeccionControlador getControlador() {
        return controlador;
    }

    protected Scanner getScanner() {
        return scanner;
    }

    // Pide un numero decimal y lo vuelve a pedir si el usuario escribe algo mal
    protected double leerNumero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();
            try {
                return Double.parseDouble(texto.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Debe escribir un numero.");
            }
        }
    }

    // Pide un numero entero entre min y max
    protected int leerOpcion(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();
            try {
                int n = Integer.parseInt(texto.trim());
                if (n >= min && n <= max) {
                    return n;
                }
            } catch (NumberFormatException e) {
                // no se hace nada, se vuelve a pedir
            }
            System.out.println("Opcion invalida, escriba un numero entre " + min + " y " + max);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opcion opcion = (Opcion) o;
        return descripcion.equals(opcion.descripcion);
    }

    @Override
    public int hashCode() {
        return descripcion.hashCode();
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
