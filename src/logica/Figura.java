package logica;

import java.util.Objects;

// Clase padre de todas las figuras planas
public abstract class Figura implements Forma {

    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Imprime los datos de la figura con su perimetro y su area
    @Override
    public void imprimirInformacion() {
        System.out.println(toString());
        System.out.println("   Perimetro: " + String.format("%.2f", calcularPerimetro()));
        System.out.println("   Area: " + String.format("%.2f", calcularArea()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figura figura = (Figura) o;
        return Objects.equals(nombre, figura.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Figura{" + "nombre='" + nombre + '\'' + '}';
    }
}
