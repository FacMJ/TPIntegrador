import java.util.*;
import java.sql.*;
public class Main {
    public static void main(String[] args){

        ResultSet RSPersonas, RSPronosticos, RSResultados;

        int CANTIDAD_FASES = 5;
        int CANTIDAD_RONDAS = 3;

        System.out.println("Seleccionar puntaje por pronostico acertado --> ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/control_de_apuestas","root", "root");

            //USO LA BASE DE DATOS

            Statement st = con.createStatement();
















            RSPersonas = st.executeQuery("SELECT * FROM apostadores");
            while(RSPersonas.next()){
                int id = RSPersonas.getInt(1);
                String nombre = RSPersonas.getString(2);
                String apellido = RSPersonas.getString(3);
                Persona persona = new Persona(id, nombre + apellido);

                PreparedStatement ps = con.prepareStatement("SELECT * FROM apuestas WHERE ApostadorID=?;");
                ps.setString(1, String.valueOf(id));
                RSPronosticos = ps.executeQuery();
                while (RSPronosticos.next()){
                    int idPartido = RSPronosticos.getInt(3);
                    ps = con.prepareStatement("SELECT * FROM resultados WHERE PartidoID=?");
                    ps.setString(1, String.valueOf(idPartido));
                    RSResultados = ps.executeQuery(); //En este caso un solo partido (una sola fila)

                    while(RSResultados.next()){
                        String equipo1 = RSResultados.getString(2);
                        String equipo2 = RSResultados.getString(3);
                        int goles1 = RSResultados.getInt(4);
                        int goles2 = RSResultados.getInt(5);
                        int ronda = RSResultados.getInt(6);
                        int fase = RSResultados.getInt(7);
                        Partido partido = new Partido(idPartido, equipo1, equipo2, goles1, goles2, ronda, fase);

                        String resultadoEsperado = RSPronosticos.getString(4);

                        Pronostico pronostico = new Pronostico(partido, resultadoEsperado, k);
                        persona.addPronostico(pronostico);
                    }

                }

                ps = con.prepareStatement("UPDATE apostadores SET Puntos=? WHERE ApostadorID=?");
                ps.setInt(1, persona.puntos());
                ps.setInt(2, id);
                ps.executeUpdate();



            }

            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
