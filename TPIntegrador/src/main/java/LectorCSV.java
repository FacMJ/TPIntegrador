import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
 
DESCRIPCION:
    - Hay 3 clases: LectorCSV (abstracta), LectorResultadosCSV y LectorPronosticosCSV. Las dos ultimas heredan de la primera.
    - Para leer el archivo resultados.csv hay que usar LectorResultadosCSV y para leer el archivo pronosticos.csv hay que usar LectorPronosticosCSV.
    - El parametro de entrada de los constructores es la ubicacion del archivo correspondiente (String).
    - Tienen un metodo llamado getData que necesita 2 entradas:
        1) numeroPartido (int): El numero del partido en donde esta la informacion que se necesita. Por ejemplo: si es el primer partido, entonces numeroPartido=1
        2) nombreColumna (String): El nombre de la columna en donde esta la informacion que se necesita. Para la clase LectorResultadosCSV, las entradas pueden ser: equipo1, goles1, goles2 o equipo2. Para la clase LectorPronosticosCSV, las entradas pueden ser: equipo1, gana1, empate, gana2 o equipo2.

*/

public abstract class LectorCSV {

	protected ArrayList<HashMap<String, String>> listaPartidos;
	protected List<String> lineas;

	public LectorCSV(String uri) {

		try {
			lineas = Files.readAllLines(Path.of(uri));
			listaPartidos = new ArrayList<>();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public String getData(int numeroPartido, String nombreColumna) {
		return listaPartidos.get(numeroPartido).get(nombreColumna);
	}

}

class LectorResultadosCSV extends LectorCSV {

	public LectorResultadosCSV(String uri) {
		super(uri);
		for (String linea : lineas) {
			String[] arrayLinea = linea.split("\t");
			HashMap<String, String> map = new HashMap<>();
			map.put("equipo1", arrayLinea[0]);
			map.put("goles1", arrayLinea[1]);
			map.put("goles2", arrayLinea[2]);
			map.put("equipo2", arrayLinea[3]);
			listaPartidos.add(map);
		}
	}
}

class LectorPronosticosCSV extends LectorCSV {

	public LectorPronosticosCSV(String uri) {
		super(uri);
		for (String linea : lineas) {
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
	
	
	public Resultado GanaEquipoUno(int lineaLectura) {
		LectorPronosticosCSV apuesta = new LectorPronosticosCSV("src/main/resources/pronosticos.csv");

		if(apuesta.getData(lineaLectura,"gana1").equals("x")) {
			return Resultado.GANADOR;
		}else if(apuesta.getData(lineaLectura,"empate").equals("x")) {
			return Resultado.EMPATE;
		}else if(apuesta.getData(lineaLectura,"gana2").equals("x")) {
			return Resultado.PERDEDOR;
		}
		return null;
	}
	
	
	public String Apuesta(int lineaLectura) {
		LectorPronosticosCSV apuesta = new LectorPronosticosCSV("src/main/resources/pronosticos.csv");

		if(apuesta.getData(lineaLectura,"gana1").equals("x")) {
			return "gana1";
		}else if(apuesta.getData(lineaLectura,"empate").equals("x")) {
			return "empate";
		}else if(apuesta.getData(lineaLectura,"gana2").equals("x")) {
			return "gana2";
		}
		return null;
	}
	
}
