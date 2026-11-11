package logica;

// Un cuadrado es un rectangulo que tiene la base y la altura iguales
public class Cuadrado extends Rectangulo {

    public Cuadrado(double lado) {
        super(lado, lado);
        setNombre("Cuadrado");
    }

    public double getLado() {
        return getBase();
    }

    public void setLado(double lado) {
        super.setBase(lado);
        super.setAltura(lado);
    }

    // Si cambian la base o la altura, se cambian los dos lados para que siga siendo cuadrado
    @Override
    public void setBase(double base) {
        setLado(base);
    }

    @Override
    public void setAltura(double altura) {
        setLado(altura);
    }

    @Override
    public String toString() {
        return "Cuadrado{" + "lado=" + getLado() + '}';
    }
}
