public class Ronda {
    private final int numero;
    private final Partido[] partidos;
    public Ronda(int numero, Partido[] partidos){
        this.partidos = partidos;
        this.numero = numero;
    }

    public Partido[] getPartidos(){
        return partidos;
    }

    public int getNumero(){
        return numero;
    }

}
