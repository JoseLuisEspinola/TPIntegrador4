package ClasesTPI;

import org.junit.Test;
import ClasesTPI.Partido;
import static org.junit.Assert.*;

public class TestGanador {
	@Test
    public void testGetGanador() {
        Partido partido = new Partido(1, 1, "Equipo1", "Equipo2", 3, 2);
        String[] resultado = partido.getGanador();
        assertEquals("Equipo1", resultado[3]);
        assertEquals("x", resultado[4]);
        assertEquals("-", resultado[5]);
        assertEquals("-", resultado[6]);
        assertEquals("Equipo2", resultado[7]);

        partido = new Partido(1, 1, "Equipo1", "Equipo2", 2, 2);
        resultado = partido.getGanador();
        assertEquals("Equipo1", resultado[3]);
        assertEquals("-", resultado[4]);
        assertEquals("x", resultado[5]);
        assertEquals("-", resultado[6]);
        assertEquals("Equipo2", resultado[7]);

        partido = new Partido(1, 1, "Equipo1", "Equipo2", 2, 3);
        resultado = partido.getGanador();
        assertEquals("Equipo1", resultado[3]);
        assertEquals("-", resultado[4]);
        assertEquals("-", resultado[5]);
        assertEquals("x", resultado[6]);
        assertEquals("Equipo2", resultado[7]);
    }
	
	
	
}
