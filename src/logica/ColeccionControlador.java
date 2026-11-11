package logica;

import java.util.ArrayList;

// Controlador del patron MVC: une el menu (vista) con la coleccion (modelo) y el DAO
public class ColeccionControlador {

    private Coleccion coleccion;
    private FormaDAO dao;

    public ColeccionControlador(Coleccion coleccion, FormaDAO dao) {
        this.coleccion = coleccion;
        this.dao = dao;

        // Al iniciar se cargan las formas que ya estaban guardadas
        for (Figura f : dao.obtenerFiguras()) {
            coleccion.agregarFigura(f);
        }
        for (Cuerpo c : dao.obtenerCuerpos()) {
            coleccion.agregarCuerpo(c);
        }
    }

    public void agregarFigura(Figura figura) {
        coleccion.agregarFigura(figura);
        dao.guardarFigura(figura);
    }

    public void agregarCuerpo(Cuerpo cuerpo) {
        coleccion.agregarCuerpo(cuerpo);
        dao.guardarCuerpo(cuerpo);
    }

    // Limpia la coleccion y los datos guardados para hacer una consulta nueva
    public void limpiar() {
        coleccion.limpiar();
        dao.borrarTodo();
    }

    public ArrayList<Figura> getFiguras() {
        return coleccion.getFiguras();
    }

    public ArrayList<Cuerpo> getCuerpos() {
        return coleccion.getCuerpos();
    }

    public double getAreaTotal() {
        return coleccion.calcularAreaTotal();
    }

    public double getPerimetroTotal() {
        return coleccion.calcularPerimetroTotal();
    }

    public double getVolumenTotal() {
        return coleccion.calcularVolumenTotal();
    }
}
