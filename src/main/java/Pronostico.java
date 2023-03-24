public class Pronostico {

    private Equipo equipo;
    private Partido partido;
    private Resultado resultadoEsperado;

    public Pronostico(Equipo equipo, Partido partido, Resultado resultadoEsperado){
        this.equipo = equipo;
        this.partido = partido;
        this.resultadoEsperado = resultadoEsperado;
    }

    public int puntos(){
        int puntos = 0;
        if(resultadoEsperado.equals(partido.resultado(equipo))){
            puntos++;
        }
        return puntos;
    }

}
