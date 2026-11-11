package logica;

import java.util.ArrayList;

// Patron DAO: metodos para guardar y leer las formas
public interface FormaDAO {

    void guardarFigura(Figura figura);

    void guardarCuerpo(Cuerpo cuerpo);

    ArrayList<Figura> obtenerFiguras();

    ArrayList<Cuerpo> obtenerCuerpos();

    void borrarTodo();
}
