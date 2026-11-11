package logica;

import java.util.Arrays;

// El tetraedro esta formado por 4 caras que son triangulos equilateros
public class Tetraedro extends Cuerpo {

    private Equilatero[] caras = new Equilatero[4];

    public Tetraedro(Equilatero cara) {
        super("Tetraedro");
        setCaras(cara);
    }

    public Equilatero[] getCaras() {
        return caras;
    }

    // Llena las 4 caras con triangulos del mismo lado
    public void setCaras(Equilatero cara) {
        for (int i = 0; i < caras.length; i++) {
            caras[i] = new Equilatero(cara.getLado());
        }
    }

    // La arista se saca de una de las caras
    public double getArista() {
        return caras[0].getLado();
    }

    // Altura del tetraedro = arista * raiz(2/3)
    public double getAltura() {
        return getArista() * Math.sqrt(2.0 / 3.0);
    }

    // Perimetro = suma de las 6 aristas
    @Override
    public double calcularPerimetro() {
        return 6 * getArista();
    }

    // Area = suma de las areas de las 4 caras
    @Override
    public double calcularArea() {
        double area = 0;
        for (int i = 0; i < caras.length; i++) {
            area = area + caras[i].calcularArea();
        }
        return area;
    }

    // Volumen = (area de la base * altura) / 3
    @Override
    public double calcularVolumen() {
        return (caras[0].calcularArea() * getAltura()) / 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetraedro tetraedro = (Tetraedro) o;
        return Arrays.equals(caras, tetraedro.caras);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(caras);
    }

    @Override
    public String toString() {
        return "Tetraedro{" + "arista=" + getArista() + ", caras=4 triangulos equilateros}";
    }
}
