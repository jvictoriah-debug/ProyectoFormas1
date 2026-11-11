package logica;

import java.util.Objects;

public class Rombo extends Figura {

    private double diagonalMayor;
    private double diagonalMenor;

    public Rombo(double diagonalMayor, double diagonalMenor) {
        super("Rombo");
        if (diagonalMayor <= 0 || diagonalMenor <= 0) {
            throw new IllegalArgumentException("Las diagonales deben ser mayores que cero");
        }
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public void setDiagonalMayor(double diagonalMayor) {
        this.diagonalMayor = diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    public void setDiagonalMenor(double diagonalMenor) {
        this.diagonalMenor = diagonalMenor;
    }

    // El lado se saca con Pitagoras usando la mitad de cada diagonal
    public double getLado() {
        double a = diagonalMayor / 2;
        double b = diagonalMenor / 2;
        return Math.sqrt(a * a + b * b);
    }

    // Perimetro = 4 * lado
    @Override
    public double calcularPerimetro() {
        return 4 * getLado();
    }

    // Area = (D * d) / 2
    @Override
    public double calcularArea() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rombo rombo = (Rombo) o;
        return Double.compare(rombo.diagonalMayor, diagonalMayor) == 0
                && Double.compare(rombo.diagonalMenor, diagonalMenor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagonalMayor, diagonalMenor);
    }

    @Override
    public String toString() {
        return "Rombo{" + "diagonalMayor=" + diagonalMayor + ", diagonalMenor=" + diagonalMenor + '}';
    }
}
