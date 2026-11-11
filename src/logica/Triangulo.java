package logica;

import java.util.Objects;

// Clase padre de Equilatero, Isosceles y Escaleno
public abstract class Triangulo extends Figura {

    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(String nombre, double ladoA, double ladoB, double ladoC) {
        super(nombre);
        if (!esValido(ladoA, ladoB, ladoC)) {
            throw new IllegalArgumentException("Con esos lados no se puede formar un triangulo");
        }
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    // Revisa que los lados sean positivos y cumplan la desigualdad triangular
    public static boolean esValido(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return a + b > c && a + c > b && b + c > a;
    }

    // Crea el tipo de triangulo correcto segun las medidas de los lados
    public static Triangulo crearTriangulo(double a, double b, double c) {
        if (a == b && b == c) {
            return new Equilatero(a);
        } else if (a == b) {
            return new Isosceles(a, c);
        } else if (a == c) {
            return new Isosceles(a, b);
        } else if (b == c) {
            return new Isosceles(b, a);
        } else {
            return new Escaleno(a, b, c);
        }
    }

    public double getLadoA() {
        return ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    // Se cambian los tres lados juntos para no dejar un triangulo invalido
    public void setLados(double ladoA, double ladoB, double ladoC) {
        if (!esValido(ladoA, ladoB, ladoC)) {
            throw new IllegalArgumentException("Con esos lados no se puede formar un triangulo");
        }
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    // Perimetro = suma de los tres lados
    @Override
    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }

    // Area con la formula de Heron
    @Override
    public double calcularArea() {
        double s = calcularPerimetro() / 2;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangulo triangulo = (Triangulo) o;
        return Double.compare(triangulo.ladoA, ladoA) == 0
                && Double.compare(triangulo.ladoB, ladoB) == 0
                && Double.compare(triangulo.ladoC, ladoC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladoA, ladoB, ladoC);
    }

    @Override
    public String toString() {
        return getNombre() + "{" + "ladoA=" + ladoA + ", ladoB=" + ladoB + ", ladoC=" + ladoC + '}';
    }
}
