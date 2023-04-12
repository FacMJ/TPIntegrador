
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class LectorCSVTest {

    @Test
    public void testGetData(){
        LectorCSV lectorRes = new LectorResultadosCSV("src/main/resources/resultados.csv");
        assertEquals("Argentina", lectorRes.getData(1, "equipo1"));
    }

    @Test
    public void testGetData2(){
        LectorCSV lectorRes = new LectorPronosticosCSV("src/main/resources/pronosticos.csv");
        assertEquals("x", lectorRes.getData(1, "gana1"));
    }
}
