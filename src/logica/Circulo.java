package logica;

import java.util.Objects;

public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        super("Circulo");
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser mayor que cero");
        }
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser mayor que cero");
        }
        this.radio = radio;
    }

    // Perimetro = 2 * PI * r
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // Area = PI * r^2
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return Double.compare(circulo.radio, radio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radio);
    }

    @Override
    public String toString() {
        return "Circulo{" + "radio=" + radio + '}';
    }
}
