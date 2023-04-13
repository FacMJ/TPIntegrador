import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
		if(numeroPartido<1){
			throw new IndexOutOfBoundsException("El primer argumento debe ser mayor o igual a 1");
		}
		return listaPartidos.get(numeroPartido).get(nombreColumna);
	}

	public int getSize(){
		return listaPartidos.size();
	}

	public Equipo[] getEquipos(int numeroLinea, Set<Equipo> equipos){
		String nombre1 = getData(numeroLinea, "equipo1"),
				nombre2 = getData(numeroLinea, "equipo2");
		Equipo equipo1, equipo2;
		if(equipos.stream().anyMatch(equipo -> equipo.getNombre().equals(nombre1)) && equipos.stream().anyMatch(equipo -> equipo.getNombre().equals(nombre2))){
			equipo1 = equipos.stream().filter(equipo -> equipo.getNombre().equals(nombre1)).findAny().get();
			equipo2 = equipos.stream().filter(equipo -> equipo.getNombre().equals(nombre2)).findAny().get();
		}else{
			throw new RuntimeException("No se encuentra el equipo");
		}
		return new Equipo[]{equipo1, equipo2};
	}

}

class LectorResultadosCSV extends LectorCSV {

	public LectorResultadosCSV(String uri) {
		super(uri);
		for (String linea : lineas) {
			String[] arrayLinea = linea.split(";");
			HashMap<String, String> map = new HashMap<>();
			map.put("ronda", arrayLinea[0]);
			map.put("equipo1", arrayLinea[1]);
			map.put("goles1", arrayLinea[2]);
			map.put("goles2", arrayLinea[3]);
			map.put("equipo2", arrayLinea[4]);
			listaPartidos.add(map);
		}
	}

	public boolean verificarIntegridad(int numeroPartido){
		int goles1 = Integer.parseInt(getData(numeroPartido, "goles1"));
		int goles2 = Integer.parseInt(getData(numeroPartido, "goles2"));
		int ronda = Integer.parseInt(getData(numeroPartido, "ronda"));
		String equipoUno = getData(numeroPartido, "equipo1");
		String equipoDos = getData(numeroPartido, "equipo2");

		return goles1 >= 0 && goles2 >= 0 && ronda >= 0 && !equipoUno.equals(equipoDos);
	}


}

class LectorPronosticosCSV extends LectorCSV {

	public LectorPronosticosCSV(String uri) {
		super(uri);
		for (String linea : lineas) {
			String[] arrayLinea = linea.split(";");
			HashMap<String, String> map = new HashMap<>();
			map.put("persona", arrayLinea[0]);
			map.put("equipo1", arrayLinea[1]);
			map.put("gana1", arrayLinea[2]);
			map.put("empate", arrayLinea[3]);
			map.put("gana2", arrayLinea[4]);
			map.put("equipo2", arrayLinea[5]);
			listaPartidos.add(map);
		}
	
	}
	
	
	public Resultado pronosticoEquipo1(int lineaLectura) {
		if(getData(lineaLectura,"gana1").equals("x")) {
			return Resultado.GANADOR;
		}else if(getData(lineaLectura,"empate").equals("x")) {
			return Resultado.EMPATE;
		}else if(getData(lineaLectura,"gana2").equals("x")) {
			return Resultado.PERDEDOR;
		}
		return null;
	}
	
}
