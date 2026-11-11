package logica;

// Triangulo con los tres lados iguales
public class Equilatero extends Triangulo {

    public Equilatero(double lado) {
        super("Equilatero", lado, lado, lado);
    }

    public double getLado() {
        return getLadoA();
    }

    public void setLado(double lado) {
        setLados(lado, lado, lado);
    }
}
