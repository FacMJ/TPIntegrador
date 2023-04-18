
public class Partido {
    private final Equipo equipo1;
    private final Equipo equipo2;
    private final int goles1;
    private final int goles2;
    public Partido (Equipo E1, Equipo E2, int GolesEquipo1, int GolesEquipo2){
        if(verificarIntegridad(E1, E2, GolesEquipo1, GolesEquipo2)){
            equipo1 = E1;
            equipo2 = E2;
            goles1 = GolesEquipo1;
            goles2 = GolesEquipo2;
        }else{
            throw new IllegalArgumentException("Datos del partido incorrectos");
        }


    }

    private boolean verificarIntegridad(Equipo E1, Equipo E2, int goles1, int goles2){
        return goles1 >= 0 && goles2 >= 0 && !E1.equals(E2);
    }

    public Equipo getEquipoGanador() {
        if (goles1 < goles2) {
            return equipo2;
        }else if (goles1 > goles2) {
            return equipo1;
        }else{
            return null;
        }
    }

    public Equipo[] getEquipos(){
        return new Equipo[]{equipo1, equipo2};
    }

}
