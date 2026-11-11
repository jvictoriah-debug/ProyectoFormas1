package logica;

import java.util.ArrayList;

// DAO que guarda los datos en memoria (se usa si no hay conexion a MySQL)
public class FormaDAOMemoria implements FormaDAO {

    private ArrayList<Figura> figuras = new ArrayList<>();
    private ArrayList<Cuerpo> cuerpos = new ArrayList<>();

    @Override
    public void guardarFigura(Figura figura) {
        figuras.add(figura);
    }

    @Override
    public void guardarCuerpo(Cuerpo cuerpo) {
        cuerpos.add(cuerpo);
    }

    @Override
    public ArrayList<Figura> obtenerFiguras() {
        return new ArrayList<>(figuras);
    }

    @Override
    public ArrayList<Cuerpo> obtenerCuerpos() {
        return new ArrayList<>(cuerpos);
    }

    @Override
    public void borrarTodo() {
        figuras.clear();
        cuerpos.clear();
    }
}
