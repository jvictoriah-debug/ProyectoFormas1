package logica;

import java.util.Objects;

// El cilindro esta formado por 2 circulos (las bases) y un rectangulo (la cara lateral)
public class Cilindro extends Cuerpo {

    private Circulo baseInferior;
    private Circulo baseSuperior;
    private Rectangulo caraLateral;

    public Cilindro(Circulo base, double altura) {
        super("Cilindro");
        this.baseInferior = new Circulo(base.getRadio());
        this.baseSuperior = new Circulo(base.getRadio());
        // Si se desenrolla la cara lateral queda un rectangulo de base = perimetro del circulo
        this.caraLateral = new Rectangulo(base.calcularPerimetro(), altura);
    }

    public Circulo getBaseInferior() {
        return baseInferior;
    }

    public Circulo getBaseSuperior() {
        return baseSuperior;
    }

    public Rectangulo getCaraLateral() {
        return caraLateral;
    }

    // El radio se saca de la base
    public double getRadio() {
        return baseInferior.getRadio();
    }

    public void setRadio(double radio) {
        baseInferior.setRadio(radio);
        baseSuperior.setRadio(radio);
        caraLateral.setBase(baseInferior.calcularPerimetro());
    }

    // La altura se saca de la cara lateral
    public double getAltura() {
        return caraLateral.getAltura();
    }

    public void setAltura(double altura) {
        caraLateral.setAltura(altura);
    }

    // Perimetro = el borde de las dos bases
    @Override
    public double calcularPerimetro() {
        return baseInferior.calcularPerimetro() + baseSuperior.calcularPerimetro();
    }

    // Area = area de las dos bases + area de la cara lateral
    @Override
    public double calcularArea() {
        return baseInferior.calcularArea() + baseSuperior.calcularArea() + caraLateral.calcularArea();
    }

    // Volumen = area de la base * altura
    @Override
    public double calcularVolumen() {
        return baseInferior.calcularArea() * getAltura();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cilindro cilindro = (Cilindro) o;
        return Objects.equals(baseInferior, cilindro.baseInferior)
                && Objects.equals(caraLateral, cilindro.caraLateral);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseInferior, caraLateral);
    }

    @Override
    public String toString() {
        return "Cilindro{" + "radio=" + getRadio() + ", altura=" + getAltura() + '}';
    }
}
