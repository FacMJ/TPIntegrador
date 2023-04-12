
public class PartidoJugado {
	
	private Integer ronda;
	private String equipoUno;
	private String equipoDos;
	private Integer golesUno;
	private Integer golesDos;
	private String ganador;
	private boolean estadoPartido;
	
	LectorResultadosCSV resultados = new LectorResultadosCSV("src/main/resources/resultados.csv");
	
	
	public PartidoJugado(int numeroPartido) {
		this.ronda = Integer.parseInt(resultados.getData(numeroPartido, "ronda"));
		this.equipoUno = resultados.getData(numeroPartido, "equipo1");
		this.equipoDos = resultados.getData(numeroPartido, "equipo2");
		this.golesUno = Integer.parseInt(resultados.getData(numeroPartido, "goles1"));
		this.golesDos = Integer.parseInt(resultados.getData(numeroPartido, "goles2"));
		this.ganador = ganador(numeroPartido);
		this.estadoPartido = verificarIntegridad(numeroPartido);
	}
	
	
	private String ganador(int numeroPartido) {
		int goles1 = Integer.parseInt(resultados.getData(numeroPartido, "goles1"));
		int goles2 = Integer.parseInt(resultados.getData(numeroPartido, "goles2"));
		
		if (goles1 > goles2) {
			return resultados.getData(numeroPartido, "equipo1");
		}else if(goles1 < goles2) {
			return resultados.getData(numeroPartido, "equipo2");
		}else{
			return "empate";
		}

	}
	
	private boolean verificarIntegridad(int numeroPartido){
		int goles1 = Integer.parseInt(resultados.getData(numeroPartido, "goles1"));
		int goles2 = Integer.parseInt(resultados.getData(numeroPartido, "goles2"));
		Integer ronda = Integer.parseInt(resultados.getData(numeroPartido, "ronda"));
		String equipoUno = resultados.getData(numeroPartido, "equipo1");
		String equipoDos = resultados.getData(numeroPartido, "equipo2");
		
		
		if (goles1 < 0) {
			return false;
		}
		if (goles2 < 0) {
			return false;
		}
		if (ronda < 0) {
			return false;
		}
		if (equipoUno.equals(equipoDos)) {
			return false;
		}
		return true;
	}


	public Integer getRonda() {
		return ronda;
	}


	public String getEquipoUno() {
		return equipoUno;
	}


	public String getEquipoDos() {
		return equipoDos;
	}


	public Integer getGolesUno() {
		return golesUno;
	}


	public Integer getGolesDos() {
		return golesDos;
	}


	public String getGanador() {
		return ganador;
	}


	public boolean isEstadoPartido() {
		return estadoPartido;
	}


	public LectorResultadosCSV getResultados() {
		return resultados;
	}
	
	
	
	
	
	
	

}
