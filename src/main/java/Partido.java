
public class Partido {
    private final String equipo1;
    private final String equipo2;
    private final int goles1, goles2, id, ronda, fase;
    public Partido (int id, String E1, String E2, int GolesEquipo1, int GolesEquipo2, int ronda, int fase){
        this.id = id;
        this.ronda = ronda;
        this.fase = fase;
        equipo1 = E1;
        equipo2 = E2;
        goles1 = GolesEquipo1;
        goles2 = GolesEquipo2;
    }

    public int getRonda() {
        return ronda;
    }

    public int getFase() {
        return fase;
    }

    public String getResultado(){
        String resultado = "empate";
        if(goles1>goles2){
            resultado = equipo1;
        }else if(goles1<goles2){
            resultado = equipo2;
        }
        return resultado;
    }


}
