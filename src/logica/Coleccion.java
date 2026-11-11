package logica;

import java.util.ArrayList;
import java.util.Objects;

// Clase principal donde se guardan todas las figuras y cuerpos del programa
public class Coleccion {

    private ArrayList<Figura> figuras;
    private ArrayList<Cuerpo> cuerpos;

    public Coleccion() {
        figuras = new ArrayList<>();
        cuerpos = new ArrayList<>();
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public void setFiguras(ArrayList<Figura> figuras) {
        this.figuras = figuras;
    }

    public ArrayList<Cuerpo> getCuerpos() {
        return cuerpos;
    }

    public void setCuerpos(ArrayList<Cuerpo> cuerpos) {
        this.cuerpos = cuerpos;
    }

    public void agregarFigura(Figura figura) {
        figuras.add(figura);
    }

    public void agregarCuerpo(Cuerpo cuerpo) {
        cuerpos.add(cuerpo);
    }

    // Borra todas las figuras y cuerpos para empezar una consulta nueva
    public void limpiar() {
        figuras.clear();
        cuerpos.clear();
    }

    // Suma el area de todas las figuras y todos los cuerpos
    public double calcularAreaTotal() {
        double total = 0;
        for (Figura f : figuras) {
            total = total + f.calcularArea();
        }
        for (Cuerpo c : cuerpos) {
            total = total + c.calcularArea();
        }
        return total;
    }

    // Suma el perimetro de todas las figuras y todos los cuerpos
    public double calcularPerimetroTotal() {
        double total = 0;
        for (Figura f : figuras) {
            total = total + f.calcularPerimetro();
        }
        for (Cuerpo c : cuerpos) {
            total = total + c.calcularPerimetro();
        }
        return total;
    }

    // Suma el volumen de todos los cuerpos (las figuras planas no tienen volumen)
    public double calcularVolumenTotal() {
        double total = 0;
        for (Cuerpo c : cuerpos) {
            total = total + c.calcularVolumen();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coleccion coleccion = (Coleccion) o;
        return Objects.equals(figuras, coleccion.figuras) && Objects.equals(cuerpos, coleccion.cuerpos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figuras, cuerpos);
    }

    @Override
    public String toString() {
        return "Coleccion{" + "figuras=" + figuras.size() + ", cuerpos=" + cuerpos.size() + '}';
    }
}
