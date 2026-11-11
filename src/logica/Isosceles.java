package logica;

// Triangulo con dos lados iguales y uno diferente (la base)
public class Isosceles extends Triangulo {

    public Isosceles(double ladoIgual, double base) {
        super("Isosceles", ladoIgual, ladoIgual, base);
    }

    public double getLadoIgual() {
        return getLadoA();
    }

    public double getBase() {
        return getLadoC();
    }

    public void setMedidas(double ladoIgual, double base) {
        setLados(ladoIgual, ladoIgual, base);
    }
}
