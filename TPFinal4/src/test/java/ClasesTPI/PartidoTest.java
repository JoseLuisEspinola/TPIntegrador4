package ClasesTPI;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import ClasesTPI.Partido;

public class PartidoTest {

	@Test
    public void testGetGanador() {
        Partido partido = new Partido(1, 1, "Equipo 1", "Equipo 2", 3, 2);
        String[] resultadoEsperado = new String[] {"", "", "", "Equipo 1", "x", "-", "-", "Equipo 2"};
        assertArrayEquals(resultadoEsperado, partido.getGanador());

        partido = new Partido(1, 1, "Equipo 1", "Equipo 2", 2, 3);
        resultadoEsperado = new String[] {"", "", "", "Equipo 1", "-", "-", "x", "Equipo 2"};
        assertArrayEquals(resultadoEsperado, partido.getGanador());

        partido = new Partido(1, 1, "Equipo 1", "Equipo 2", 2, 2);
        resultadoEsperado = new String[] {"", "", "", "Equipo 1", "-", "x", "-", "Equipo 2"};
        assertArrayEquals(resultadoEsperado, partido.getGanador());
    }
	
}
