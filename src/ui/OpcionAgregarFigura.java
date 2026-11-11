package ui;

import logica.Circulo;
import logica.ColeccionControlador;
import logica.Cuadrado;
import logica.Figura;
import logica.Rectangulo;
import logica.Rombo;
import logica.Triangulo;

import java.util.Scanner;

public class OpcionAgregarFigura extends Opcion {

    public OpcionAgregarFigura(ColeccionControlador controlador, Scanner scanner) {
        super("Agregar figura", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        System.out.println("1. Circulo");
        System.out.println("2. Rectangulo");
        System.out.println("3. Cuadrado");
        System.out.println("4. Rombo");
        System.out.println("5. Triangulo");
        int tipo = leerOpcion("Elija la figura: ", 1, 5);

        Figura figura = null;
        if (tipo == 1) {
            double radio = leerNumero("Radio: ");
            figura = new Circulo(radio);
        } else if (tipo == 2) {
            double base = leerNumero("Base: ");
            double altura = leerNumero("Altura: ");
            figura = new Rectangulo(base, altura);
        } else if (tipo == 3) {
            double lado = leerNumero("Lado: ");
            figura = new Cuadrado(lado);
        } else if (tipo == 4) {
            double diagonalMayor = leerNumero("Diagonal mayor: ");
            double diagonalMenor = leerNumero("Diagonal menor: ");
            figura = new Rombo(diagonalMayor, diagonalMenor);
        } else if (tipo == 5) {
            double a = leerNumero("Lado A: ");
            double b = leerNumero("Lado B: ");
            double c = leerNumero("Lado C: ");
            // El tipo de triangulo se decide segun los lados
            figura = Triangulo.crearTriangulo(a, b, c);
        }

        getControlador().agregarFigura(figura);
        System.out.println("Se agrego: " + figura);
    }
}
