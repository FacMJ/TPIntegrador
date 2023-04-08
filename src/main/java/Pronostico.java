public class Pronostico {
	private final int puntos;
    private final Partido partido;

    public Pronostico(Partido partido, Equipo equipo, Resultado resultadoEsperado){
        this.partido = partido;
        if(resultadoEsperado.equals(getResultado(equipo))){
            puntos=1;
        }else{
            puntos=0;
        }
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
        return puntos;
    }

}
