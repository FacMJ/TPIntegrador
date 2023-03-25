import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PronosticoTest {

    @Test
    public void testPuntos(){
        LectorCSV lectorRes = new LectorResultadosCSV("src/main/resources/resultados.csv");
        LectorCSV lectorPro = new LectorPronosticosCSV("src/main/resources/pronosticos.csv");
        Equipo equipo1 = new Equipo("Boca", "asjdakfa");
        Equipo equipo2 = new Equipo("River", "asjnsdfs");
        Partido partido = new Partido(equipo1, equipo2, 0, 0);
        Pronostico pronostico = new Pronostico(partido, equipo1, Resultado.EMPATE);
        assertEquals(1, pronostico.puntos());
    }

}
