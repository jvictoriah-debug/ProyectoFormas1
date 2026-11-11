package logica;

import java.util.Objects;

// La esfera no tiene figuras planas, solo se define con el radio
public class Esfera extends Cuerpo {

    private double radio;

    public Esfera(double radio) {
        super("Esfera");
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

    // Perimetro = circunferencia maxima = 2 * PI * r
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // Area = 4 * PI * r^2
    @Override
    public double calcularArea() {
        return 4 * Math.PI * radio * radio;
    }

    // Volumen = (4/3) * PI * r^3
    @Override
    public double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * radio * radio * radio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Esfera esfera = (Esfera) o;
        return Double.compare(esfera.radio, radio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radio);
    }

    @Override
    public String toString() {
        return "Esfera{" + "radio=" + radio + '}';
    }
}
