import logica.Coleccion;
import logica.ColeccionControlador;
import logica.FormaDAO;
import logica.FormaDAOMemoria;
import logica.FormaDAOMySQL;
import ui.Menu;

public class Main {

    public static void main(String[] args) {
        // Datos de la base de datos MySQL (cambiar usuario y clave segun su equipo)
        String url = "jdbc:mysql://localhost:3306/proyecto_formas?createDatabaseIfNotExist=true";
        String usuario = "root";
        String clave = "1234";

        FormaDAO dao;
        FormaDAOMySQL daoMySQL = new FormaDAOMySQL(url, usuario, clave);

        // Si se puede conectar a MySQL se usa la base de datos, si no se usa memoria
        if (daoMySQL.conectar()) {
            System.out.println("Conectado a MySQL.");
            dao = daoMySQL;
        } else {
            System.out.println("Se usara la memoria para guardar los datos.");
            dao = new FormaDAOMemoria();
        }

        Coleccion coleccion = new Coleccion();
        ColeccionControlador controlador = new ColeccionControlador(coleccion, dao);
        Menu menu = new Menu(controlador);
        menu.mostrar();
    }
}
