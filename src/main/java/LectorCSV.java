import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public abstract class LectorCSV {
    
    protected ArrayList<HashMap<String,String>> listaPartidos;
    protected List<String> lineas;

    public LectorCSV(String uri){

        try {
            lineas = Files.readAllLines(Path.of(uri));
            listaPartidos = new ArrayList<>();
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getData(int numeroPartido, String nombreColumna){
        return listaPartidos.get(numeroPartido).get(nombreColumna);
    }

}

class LectorResultadosCSV extends LectorCSV{

    public LectorResultadosCSV(String uri) {
        super(uri);
        for (String linea: lineas){
            String[] arrayLinea = linea.split("\t");
            HashMap<String,String> map = new HashMap<>();
            map.put("equipo1", arrayLinea[0]);
            map.put("goles1", arrayLinea[1]);
            map.put("goles2", arrayLinea[2]);
            map.put("equipo2", arrayLinea[3]);
            listaPartidos.add(map);
        }
    }
}

class LectorPronosticosCSV extends LectorCSV{

    public LectorPronosticosCSV(String uri) {
        super(uri);
        for (String linea: lineas) {
            String[] arrayLinea = linea.split("\t");
            HashMap<String, String> map = new HashMap<>();
            map.put("equipo1", arrayLinea[0]);
            map.put("gana1", arrayLinea[1]);
            map.put("empate", arrayLinea[2]);
            map.put("gana2", arrayLinea[3]);
            map.put("equipo2", arrayLinea[4]);
            listaPartidos.add(map);
        }
    }
}