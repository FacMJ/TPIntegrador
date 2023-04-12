
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<PartidoJugado> listaResultadoPartidos = new ArrayList<PartidoJugado>();

		try {
			for (int i = 1; i < Utilidades.contadorFilas("src/main/resources/resultados.csv"); i++) {

				PartidoJugado partido = new PartidoJugado(i);
				if (partido.isEstadoPartido()) {
					listaResultadoPartidos.add(new PartidoJugado(i));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		PartidoJugado primerPartido = listaResultadoPartidos.get(0);
		System.out.println(primerPartido.getGanador());

		
		
		
		
		
		
		/*
		 * LectorResultadosCSV resultados = new
		 * LectorResultadosCSV("src/main/resources/resultados.csv");
		 * LectorPronosticosCSV pronosticos = new
		 * LectorPronosticosCSV("src/main/resources/pronosticos.csv");
		 * 
		 * String equipoUnoPartidoUno = resultados.getData(1, "equipo1"); Equipo
		 * Argentina = new Equipo(equipoUnoPartidoUno); String input =
		 * resultados.getData(1, "ronda"); int golesUnoPartidoUno =
		 * Integer.parseInt(input); System.out.println(golesUnoPartidoUno);
		 * 
		 * String equipoDosPartidoUno = resultados.getData(1, "equipo2"); Equipo
		 * ArabiaSaudi = new Equipo(equipoDosPartidoUno); input = resultados.getData(1,
		 * "goles2"); int golesDosPartidoUno = Integer.parseInt(input);
		 * 
		 * 
		 * Partido primerPartido = new Partido(Argentina, ArabiaSaudi,
		 * golesUnoPartidoUno , golesDosPartidoUno);
		 * 
		 * 
		 * String equipoUnoPartidoDos = resultados.getData(2, "equipo1"); Equipo Polonia
		 * = new Equipo(equipoUnoPartidoDos); input = resultados.getData(2, "goles1");
		 * int golesUnoPartidoDos = Integer.parseInt(input);
		 * 
		 * String equipoDosPartidoDos = resultados.getData(2, "equipo2"); Equipo Mexico
		 * = new Equipo(equipoDosPartidoDos); input = resultados.getData(2, "goles2");
		 * int golesDosPartidoDos = Integer.parseInt(input);
		 * 
		 * Partido segundoPartido = new Partido(Polonia, Mexico, golesUnoPartidoDos ,
		 * golesDosPartidoDos);
		 * 
		 * 
		 * Pronostico pronostico = new
		 * Pronostico(primerPartido,Argentina,pronosticos.GanaEquipoUno(1)); try {
		 * System.out.println("Equipo que gano el primer partido: " +
		 * primerPartido.getEquipoGanador().getNombre());
		 * 
		 * }catch (NullPointerException e){ System.out.println("Hubo empate"); }
		 * System.out.println("Puntos despues de la primer apuesta: " +
		 * pronostico.puntos());
		 * 
		 * 
		 * pronostico.setPartido(segundoPartido); pronostico.setEquipo(Polonia);
		 * pronostico.setResultadoEsperado(pronosticos.GanaEquipoUno(2));
		 * 
		 * try { System.out.println("Equipo que gano el segundo partido: " +
		 * segundoPartido.getEquipoGanador().getNombre()); }catch (NullPointerException
		 * e){ System.out.println("Hubo empate"); }
		 * System.out.println("Puntos despues del segundo partido: " +
		 * pronostico.puntos());
		 * 
		 */
	}

}
