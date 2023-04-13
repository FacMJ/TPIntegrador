import java.util.HashSet;
import java.util.Set;

public class Persona {
    private final String nombre;
    private Set<Pronostico> pronosticos;
    public Persona(String nombre){
        this.nombre = nombre;
        pronosticos = new HashSet<>();
    }

    public String getNombre(){
        return nombre;
    }
    public Set<Pronostico> getPronosticos(){
        return pronosticos;
    }

    public void addPronostico(Pronostico pronostico){
        pronosticos.add(pronostico);
    }

    public int pronosticosAcertados(){
        int acertados = 0;
        for(Pronostico p: pronosticos){
            if(p.puntos()>0){
                acertados++;
            }
        }
        return acertados;
    }

    public int puntos(){
        int suma = 0;
        for(Pronostico p: pronosticos){
            suma = suma + p.puntos();
        }
        return suma;
    }

}
