public class Pronostico {
	private int puntos;
    private Equipo equipo;
    private Partido partido;
    private Resultado resultadoEsperado;

    public Pronostico(Partido partido, Equipo equipo, Resultado resultadoEsperado){
        this.equipo = equipo;
        this.partido = partido;
        this.resultadoEsperado = resultadoEsperado;
    }

    private Resultado getResultado(Equipo equipo){
        Resultado res;
        if(equipo.equals(partido.getEquipoGanador())){
            res = Resultado.GANADOR;
            
        }else if(partido.getEquipoGanador()==null){
            res = Resultado.EMPATE;
            
        }else{
            res = Resultado.PERDEDOR;
        }
        return res;
    }
    
    public int puntos(){
        if(resultadoEsperado.equals(getResultado(equipo))){
            this.puntos++;
        }
        return this.puntos;
    }

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public void setResultadoEsperado(Resultado resultadoEsperado) {
		this.resultadoEsperado = resultadoEsperado;
	}
    
    

}
