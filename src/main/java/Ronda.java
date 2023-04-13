public class Ronda {
    private final int numero;
    private final Partido[] partidos;
    public Ronda(int numero, Partido[] partidos){
        if(numero>0){
            this.partidos = partidos;
            this.numero = numero;
        }else{
            throw new IllegalArgumentException("Datos de la ronda incorrectos");
        }

    }

    public Partido[] getPartidos(){
        return partidos;
    }

    public int getNumero(){
        return numero;
    }

}
