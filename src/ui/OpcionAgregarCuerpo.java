package ui;

import logica.Cilindro;
import logica.Circulo;
import logica.ColeccionControlador;
import logica.Cuadrado;
import logica.Cubo;
import logica.Cuerpo;
import logica.Equilatero;
import logica.Esfera;
import logica.Tetraedro;

import java.util.Scanner;

public class OpcionAgregarCuerpo extends Opcion {

    public OpcionAgregarCuerpo(ColeccionControlador controlador, Scanner scanner) {
        super("Agregar cuerpo", controlador, scanner);
    }

    @Override
    public void ejecutar() {
        System.out.println("1. Cubo");
        System.out.println("2. Cilindro");
        System.out.println("3. Tetraedro");
        System.out.println("4. Esfera");
        int tipo = leerOpcion("Elija el cuerpo: ", 1, 4);

        Cuerpo cuerpo = null;
        if (tipo == 1) {
            double arista = leerNumero("Arista: ");
            cuerpo = new Cubo(new Cuadrado(arista));
        } else if (tipo == 2) {
            double radio = leerNumero("Radio de la base: ");
            double altura = leerNumero("Altura: ");
            cuerpo = new Cilindro(new Circulo(radio), altura);
        } else if (tipo == 3) {
            double arista = leerNumero("Arista: ");
            cuerpo = new Tetraedro(new Equilatero(arista));
        } else if (tipo == 4) {
            double radio = leerNumero("Radio: ");
            cuerpo = new Esfera(radio);
        }

        getControlador().agregarCuerpo(cuerpo);
        System.out.println("Se agrego: " + cuerpo);
    }
}
