import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){

		LectorResultadosCSV lectorR = new LectorResultadosCSV("src/main/resources/resultados.csv");
		LectorPronosticosCSV lectorP = new LectorPronosticosCSV("src/main/resources/pronosticos.csv");

		Set<Equipo> equipos = new HashSet<>();
		equipos.add(new Equipo("Argentina", "Celeste y blanco"));
		equipos.add(new Equipo("Arabia Saudita", "Verde"));
		equipos.add(new Equipo("Polonia", "Rojo y blanco"));
		equipos.add(new Equipo("Mexico", "Verde, blanco y rojo"));

		ArrayList<Ronda> rondas = new ArrayList<Ronda>();
		ArrayList<Partido> partidos = new ArrayList<>();

		int cantidadRondas = Integer.parseInt(lectorR.getData(lectorR.getSize()-1, "ronda"));
		int cantPartidosPorRonda = 2;

		for(int i=0; i<cantidadRondas; i++){
			Partido[] partidosRonda = new Partido[cantPartidosPorRonda];
			for(int j=0; j<cantPartidosPorRonda; j++){
				int indice = (j+1)+cantPartidosPorRonda*i;
				Equipo equipo1 = lectorR.getEquipos(indice, equipos)[0],
						equipo2 = lectorR.getEquipos(indice, equipos)[1];
				int goles1 = Integer.parseInt(lectorR.getData(indice, "goles1")),
						goles2 = Integer.parseInt(lectorR.getData(indice, "goles2"));

				Partido partido_i = new Partido(equipo1, equipo2, goles1, goles2);
				partidosRonda[j] = partido_i;
				partidos.add(partido_i);

			}
			rondas.add(new Ronda(i+1, partidosRonda));
		}

		HashSet<Persona> personas = new HashSet<>();

		for(int i=1; i<lectorP.getSize(); i++){
			String nombre = lectorP.getData(i, "persona");
			if(personas.stream().noneMatch(p -> p.getNombre().equals(nombre))){
				Persona nuevaPersona = new Persona(nombre);
				personas.add(nuevaPersona);
			}

			Resultado resultadoEsperado_i = lectorP.pronosticoEquipo1(i);
			String n1 = lectorP.getData(i, "equipo1"),
					n2 = lectorP.getData(i, "equipo2");
			Equipo equipo1 = equipos.stream().filter(e -> e.getNombre().equals(n1)).findAny().get(),
					equipo2 = equipos.stream().filter(e -> e.getNombre().equals(n2)).findAny().get();
			Partido partido = partidos.stream().filter(p -> Arrays.equals(p.getEquipos(), new Equipo[]{equipo1, equipo2})).findAny().get();

			Persona persona = personas.stream().filter(p -> p.getNombre().equals(nombre)).findAny().get();
			persona.addPronostico(new Pronostico(partido, equipo1, resultadoEsperado_i));

		}

		System.out.println("Nombre ----- Pronosticos acertados ----- Puntos");

		for(Persona p: personas){
			System.out.println(p.getNombre() + " ------ " + p.pronosticosAcertados() + "/" + p.getPronosticos().size()+ " ------ " + p.puntos());
		}

		System.out.println("\n-----------------------------------\n");

		for(Ronda r: rondas){
			System.out.println("Ronda " + r.getNumero() + ":");
			int contador=1;
			for(Partido p: r.getPartidos()){
				Equipo[] eqps = p.getEquipos();
				System.out.println("\t\t Partido " + contador + " ---> " + eqps[0].getNombre() + " vs " + eqps[1].getNombre() );
				contador++;
			}
		}

    }
}
