package logica;

import java.util.Arrays;

// El cubo esta formado por 6 caras cuadradas
public class Cubo extends Cuerpo {

    private Cuadrado[] caras = new Cuadrado[6];

    public Cubo(Cuadrado cara) {
        super("Cubo");
        setCaras(cara);
    }

    public Cuadrado[] getCaras() {
        return caras;
    }

    // Llena las 6 caras con cuadrados del mismo lado
    public void setCaras(Cuadrado cara) {
        for (int i = 0; i < caras.length; i++) {
            caras[i] = new Cuadrado(cara.getLado());
        }
    }

    // La arista se saca de una de las caras
    public double getArista() {
        return caras[0].getLado();
    }

    // Perimetro = suma de las 12 aristas
    @Override
    public double calcularPerimetro() {
        return 12 * getArista();
    }

    // Area = suma de las areas de las 6 caras
    @Override
    public double calcularArea() {
        double area = 0;
        for (int i = 0; i < caras.length; i++) {
            area = area + caras[i].calcularArea();
        }
        return area;
    }

    // Volumen = area de una cara * arista
    @Override
    public double calcularVolumen() {
        return caras[0].calcularArea() * getArista();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cubo cubo = (Cubo) o;
        return Arrays.equals(caras, cubo.caras);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(caras);
    }

    @Override
    public String toString() {
        return "Cubo{" + "arista=" + getArista() + ", caras=6 cuadrados}";
    }
}
