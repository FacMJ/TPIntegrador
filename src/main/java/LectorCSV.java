import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LectorCSV {
    
    private ArrayList<HashMap<String,String>> listaPartidos;
    public static int archivoResultados = 0;
    public static int archivoPronosticos = 1;


    public LectorCSV(URI uri, int archivo){

        try {
            List<String> lineas = Files.readAllLines(Paths.get(uri));
            listaPartidos = new ArrayList<>();

            if(archivo==LectorCSV.archivoResultados){
                for (String linea: lineas){
                    String[] arrayLinea = linea.split("\t");
                    HashMap<String,String> map = new HashMap<>();
                    map.put("equipo1", arrayLinea[0]);
                    map.put("goles1", arrayLinea[1]);
                    map.put("goles2", arrayLinea[2]);
                    map.put("equipo2", arrayLinea[3]);
                    listaPartidos.add(map);
                }
            }else if(archivo==LectorCSV.archivoPronosticos){
                for (String linea: lineas){
                    String[] arrayLinea = linea.split("\t");
                    HashMap<String,String> map = new HashMap<>();
                    map.put("equipo1", arrayLinea[0]);
                    map.put("gana1", arrayLinea[1]);
                    map.put("empate", arrayLinea[2]);
                    map.put("gana2", arrayLinea[3]);
                    map.put("equipo2", arrayLinea[4]);
                    listaPartidos.add(map);
                }
            }else{
                System.out.println("Error: El parámetro \"archivo\" de entrada es incorrecto");
            }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getData(int numeroPartido, String nombreColumna){
        return listaPartidos.get(numeroPartido).get(nombreColumna);
    }

}
