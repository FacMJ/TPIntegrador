
public class Partido {
    private final Equipo Equipo1;
    private final Equipo Equipo2;
    private final int GolesEquipo1;
    private final int GolesEquipo2;
    public Partido (Equipo E1, Equipo E2, int GolesEquipo1, int GolesEquipo2){
        Equipo1 = E1;
        Equipo2 = E2;
        this.GolesEquipo1 = GolesEquipo1;
        this.GolesEquipo2 = GolesEquipo2;

    }
    public Equipo getEquipoGanador() {
        if (GolesEquipo1 < GolesEquipo2) {
            return Equipo2;
        }else if (GolesEquipo1 > GolesEquipo2) {
            return Equipo1;
        }else{
            return null;
        }
    }

    public Equipo[] getEquipos(){
        return new Equipo[]{Equipo1, Equipo2};
    }

}
