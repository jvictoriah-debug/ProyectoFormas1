package logica;

import java.util.Objects;

// Clase padre de todos los cuerpos solidos
public abstract class Cuerpo implements Forma {

    private String nombre;

    public Cuerpo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Los cuerpos ademas calculan su volumen
    public abstract double calcularVolumen();

    // Imprime los datos del cuerpo con su perimetro, area y volumen
    @Override
    public void imprimirInformacion() {
        System.out.println(toString());
        System.out.println("   Perimetro: " + String.format("%.2f", calcularPerimetro()));
        System.out.println("   Area: " + String.format("%.2f", calcularArea()));
        System.out.println("   Volumen: " + String.format("%.2f", calcularVolumen()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuerpo cuerpo = (Cuerpo) o;
        return Objects.equals(nombre, cuerpo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Cuerpo{" + "nombre='" + nombre + '\'' + '}';
    }
}
