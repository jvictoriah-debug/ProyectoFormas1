package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// DAO que guarda los datos en una base de datos MySQL
// Para que funcione hay que agregar el conector mysql-connector-j al proyecto
public class FormaDAOMySQL implements FormaDAO {

    private String url;
    private String usuario;
    private String clave;

    public FormaDAOMySQL(String url, String usuario, String clave) {
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }

    private Connection getConexion() throws SQLException {
        return DriverManager.getConnection(url, usuario, clave);
    }

    // Prueba la conexion y crea las tablas si no existen
    public boolean conectar() {
        try {
            Connection con = getConexion();
            Statement st = con.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS figuras ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, tipo VARCHAR(20), "
                    + "medida1 DOUBLE, medida2 DOUBLE, medida3 DOUBLE)");
            st.execute("CREATE TABLE IF NOT EXISTS cuerpos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, tipo VARCHAR(20), "
                    + "medida1 DOUBLE, medida2 DOUBLE)");
            st.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a MySQL: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void guardarFigura(Figura figura) {
        String tipo = "";
        double m1 = 0;
        double m2 = 0;
        double m3 = 0;

        if (figura instanceof Cuadrado) {
            tipo = "Cuadrado";
            m1 = ((Cuadrado) figura).getLado();
        } else if (figura instanceof Rectangulo) {
            tipo = "Rectangulo";
            m1 = ((Rectangulo) figura).getBase();
            m2 = ((Rectangulo) figura).getAltura();
        } else if (figura instanceof Circulo) {
            tipo = "Circulo";
            m1 = ((Circulo) figura).getRadio();
        } else if (figura instanceof Rombo) {
            tipo = "Rombo";
            m1 = ((Rombo) figura).getDiagonalMayor();
            m2 = ((Rombo) figura).getDiagonalMenor();
        } else if (figura instanceof Triangulo) {
            tipo = "Triangulo";
            m1 = ((Triangulo) figura).getLadoA();
            m2 = ((Triangulo) figura).getLadoB();
            m3 = ((Triangulo) figura).getLadoC();
        }

        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO figuras (tipo, medida1, medida2, medida3) VALUES (?, ?, ?, ?)");
            ps.setString(1, tipo);
            ps.setDouble(2, m1);
            ps.setDouble(3, m2);
            ps.setDouble(4, m3);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar la figura: " + e.getMessage());
        }
    }

    @Override
    public void guardarCuerpo(Cuerpo cuerpo) {
        String tipo = "";
        double m1 = 0;
        double m2 = 0;

        if (cuerpo instanceof Cubo) {
            tipo = "Cubo";
            m1 = ((Cubo) cuerpo).getArista();
        } else if (cuerpo instanceof Cilindro) {
            tipo = "Cilindro";
            m1 = ((Cilindro) cuerpo).getRadio();
            m2 = ((Cilindro) cuerpo).getAltura();
        } else if (cuerpo instanceof Tetraedro) {
            tipo = "Tetraedro";
            m1 = ((Tetraedro) cuerpo).getArista();
        } else if (cuerpo instanceof Esfera) {
            tipo = "Esfera";
            m1 = ((Esfera) cuerpo).getRadio();
        }

        try {
            Connection con = getConexion();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO cuerpos (tipo, medida1, medida2) VALUES (?, ?, ?)");
            ps.setString(1, tipo);
            ps.setDouble(2, m1);
            ps.setDouble(3, m2);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el cuerpo: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Figura> obtenerFiguras() {
        ArrayList<Figura> lista = new ArrayList<>();
        try {
            Connection con = getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM figuras");
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                double m1 = rs.getDouble("medida1");
                double m2 = rs.getDouble("medida2");
                double m3 = rs.getDouble("medida3");

                if (tipo.equals("Circulo")) {
                    lista.add(new Circulo(m1));
                } else if (tipo.equals("Rectangulo")) {
                    lista.add(new Rectangulo(m1, m2));
                } else if (tipo.equals("Cuadrado")) {
                    lista.add(new Cuadrado(m1));
                } else if (tipo.equals("Rombo")) {
                    lista.add(new Rombo(m1, m2));
                } else if (tipo.equals("Triangulo")) {
                    lista.add(Triangulo.crearTriangulo(m1, m2, m3));
                }
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer las figuras: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public ArrayList<Cuerpo> obtenerCuerpos() {
        ArrayList<Cuerpo> lista = new ArrayList<>();
        try {
            Connection con = getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cuerpos");
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                double m1 = rs.getDouble("medida1");
                double m2 = rs.getDouble("medida2");

                if (tipo.equals("Cubo")) {
                    lista.add(new Cubo(new Cuadrado(m1)));
                } else if (tipo.equals("Cilindro")) {
                    lista.add(new Cilindro(new Circulo(m1), m2));
                } else if (tipo.equals("Tetraedro")) {
                    lista.add(new Tetraedro(new Equilatero(m1)));
                } else if (tipo.equals("Esfera")) {
                    lista.add(new Esfera(m1));
                }
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer los cuerpos: " + e.getMessage());
        }
        return lista;
    }

    // Borra todos los registros de las dos tablas
    @Override
    public void borrarTodo() {
        try {
            Connection con = getConexion();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM figuras");
            st.executeUpdate("DELETE FROM cuerpos");
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar los datos: " + e.getMessage());
        }
    }
}
