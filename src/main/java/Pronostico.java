public class Pronostico {

    private final Equipo equipo;
    private final Partido partido;
    private final Resultado resultadoEsperado;

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
        int puntos = 0;
        if(resultadoEsperado.equals(getResultado(equipo))){
            puntos++;
        }
        return puntos;
    }

}
