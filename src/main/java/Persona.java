
import java.util.ArrayList;
public class Persona {
    private final String nombre;
    private final int id, bonus=100;
    private ArrayList<Pronostico> pronosticos;
    public Persona(int id, String nombre){
        this.nombre = nombre;
        this.id = id;
        pronosticos = new ArrayList<>();

    }

    public String getNombre(){
        return nombre;
    }
    public ArrayList<Pronostico> getPronosticos(){
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
        return suma + bonusRondaTotal() + bonusFaseTotal();
    }

    private int bonusRondaTotal(){
        int bonusTotal = 0;
        int minRonda = pronosticos.get(0).getRonda();
        int maxRonda = pronosticos.get(pronosticos.size()-1).getRonda();
        int i = minRonda;
        while(i<=maxRonda){
            bonusTotal = bonusTotal + bonusRonda(i);
            i++;
        }
        return bonusTotal;
    }

    private int bonusFaseTotal(){
        int bonusTotal = 0;
        int minFase = pronosticos.get(0).getFase();
        int maxFase = pronosticos.get(pronosticos.size()-1).getFase();

        for(int i=minFase; i<=maxFase; i++){
            bonusTotal = bonusTotal + bonusFase(i);
        }
        return bonusTotal;
    }

    private int bonusRonda(int numero){
        int res = bonus;
        for(Pronostico p: pronosticos){
            if(p.getRonda()==numero && p.puntos()==0){
                res = 0;
            }
        }
        return res;
    }

    private int bonusFase(int numero){
        int res = bonus;
        for(Pronostico p: pronosticos){
            if(p.getFase()==numero && p.puntos()==0){
                res = 0;
            }
        }
        return res;
    }

}
