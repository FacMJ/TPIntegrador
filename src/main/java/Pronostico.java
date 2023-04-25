public class Pronostico {
	private final int puntos;
    private final int k;
    private final Partido partido;

    public Pronostico(Partido partido, String resultadoEsperado, int k){
        this.partido = partido;
        this.k = k;
        if(resultadoEsperado.equals(partido.getResultado())){
            puntos=k;
        }else{
            puntos=0;
        }
    }

    public int getRonda(){
        return partido.getRonda();
    }

    public int getFase(){
        return partido.getFase();
    }
    
    public int puntos(){
        return puntos;
    }

}
