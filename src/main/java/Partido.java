
public class Partido {
    Equipo Equipo1;
    Equipo Equipo2;
    int GolesEquipo1;
    int GolesEquipo2;
    public Partido (Equipo E1, Equipo E2, int GolesEquipo1, int GolesEquipo2){
        Equipo1 = E1;
        Equipo2 = E2;
        this.GolesEquipo1 = GolesEquipo1;
        this.GolesEquipo2 = GolesEquipo2;

    }
    public Equipo getEquipo () {
        if (GolesEquipo1 < GolesEquipo2)
            return Equipo2;
        else if (GolesEquipo1 > GolesEquipo2) {
            return Equipo1;
        } else {
            return null;

        }
    }
    }