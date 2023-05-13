package ClasesTPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import ClasesTPI.Colores;

public class Principal {

	public static void main(String[] args) {
		String rutaArchivoResultado = "carpetaresultado/resultados.csv"; // en distintas carpetas como SE PEDIA.
		String rutaArchivoPronostico = "carpetapronostico/pronosticos.csv"; // en distintas carpetas como SE PEDIA.

		HashMap<String, Integer> participan = new HashMap<String, Integer>(); // guarda los nombres de los participantes
																				// y sus respectivos puntajes
		HashMap<String, Partido> mapPartidos = new HashMap<String, Partido>();

		ArrayList<Pronostico> arrayPronosticos = new ArrayList<Pronostico>();

		// Guardo datos de RESULTADO - deberia ser una clase
		try {
			// leo archivo RESULTADO
			List<String> listaResultado = Files.readAllLines(Paths.get(rutaArchivoResultado));

			// leo archivo PRONOSTICO
			List<String> listaPronostico = Files.readAllLines(Paths.get(rutaArchivoPronostico));

			// Muestro cada renglon del archivo RESULTADO
/*			ArrayList<String> archivoResultado = new ArrayList<>(listaResultado);
			for (int i = 0; i < archivoResultado.size(); i++) {
				System.out.println(archivoResultado.get(i));
			}

			System.out.println(); // renglon que separa los RESULTADOS de los PRONOSTICOS
*/
			// Muestro cada renglon del archivo PRONOSTICO, unicamente para guardar los participantes en el HashMap
			ArrayList<String> archivoPronostico = new ArrayList<>(listaPronostico);
			for (int i = 0; i < archivoPronostico.size(); i++) {
				//System.out.println(archivoPronostico.get(i));

				// aqui guardo los nombre de los participantes en el HashMap "participan"
				String[] nombre = listaPronostico.get(i).split(",");
				if (i > 0) {
					if (!participan.containsKey(nombre[0])) { // pregunta sin NO EXISTE el nombre ya en el HashMap
						participan.put(nombre[0], 0); // graba en el HashMap los nombre, mientras que los puntos AHORA son 0
					}
				}
			}

			// ============================================================================
			// Guardo los partidos en un hashmap
			// HashMap<Integer, Partido> mapPartidos = new HashMap<Integer, Partido>();
			Partido p;
			// variables para instanciar un partido
			String clave;
			int idPartido;
			int idRonda;
			String equipo1;
			String equipo2;
			int golesEquipo1;
			int golesEquipo2;
			
					
			// recorro la lista de resultado - empiezo de 1 porque la
			// linea 0 estan los datos de cabecera
			for (int i = 0; i < listaResultado.size(); i++) {
				// guardo en las variables los datos de una linea de partido

				String[] equipoResultado = listaResultado.get(i).split(",");
				
				if(i > 0) {
				idPartido = Integer.parseInt(equipoResultado[0]);
				idRonda = Integer.parseInt(equipoResultado[1]);
				clave = String.valueOf(idRonda) + String.valueOf(idPartido);
				equipo1 = equipoResultado[2];
				equipo2 = equipoResultado[5];
				golesEquipo1 = Integer.parseInt(equipoResultado[3]);
				golesEquipo2 = Integer.parseInt(equipoResultado[4]);

									// instancio un Partido
				p = new Partido(idPartido, idRonda, equipo1, equipo2, golesEquipo1, golesEquipo2);
				
				// esto que imprimo, es UNICAMENTE para ver en pantalla
				System.out.println("   " + idPartido + "       " + idRonda + "    " + (equipo1 + String.format("%" + (22 - equipo1.length())  + "s", "")) + golesEquipo1 + "               " + golesEquipo2 + "       " + equipo2);
					
				// lo agrego al hashmap key --> idPartido
				mapPartidos.put(clave, p);
				
				} else {
					System.out.println(Colores.ANSI_GREEN + equipoResultado[0] + "  " + equipoResultado[1] + "  " + equipoResultado[2] + "          " + equipoResultado[3] + "     " + equipoResultado[4] + "  " + equipoResultado[5] + Colores.ANSI_RESET);  // Encabezado de partido
				}

			}
			
			System.out.println("\n");
			
			// ============================================================================
			// Guardo los pronosticos en un arrayList
			// ArrayList<Pronostico> arrayPronosticos = new ArrayList<Pronostico>();
			// ============================================================================
			Pronostico pro;
			// variables para instanciar un pronostico
			String participante;
			int nroPartidoPronostico;
			int nroRondaPronostico;
			String equipo1p;
			String gana1;
			String empate;
			String gana2;
			String equipo2p;
			
			for (int i = 0; i < listaPronostico.size(); i++) {

				String[] equipoPronostico = listaPronostico.get(i).split(",");
				
				if(i > 0) {
					participante = equipoPronostico[0];
					nroPartidoPronostico = Integer.parseInt(equipoPronostico[1]);
					nroRondaPronostico = Integer.parseInt(equipoPronostico[2]);
					equipo1p = equipoPronostico[3];
					gana1 = equipoPronostico[4];
					empate = equipoPronostico[5];
					gana2 = equipoPronostico[6];
					equipo2p = equipoPronostico[7];

					pro = new Pronostico(participante, nroPartidoPronostico, nroRondaPronostico, equipo1p, gana1, empate, gana2, equipo2p);

					arrayPronosticos.add(pro);
					
			    } else {
			    	System.out.println(Colores.ANSI_CYAN +  equipoPronostico[0] + "      " + equipoPronostico[1] + "  " + equipoPronostico[2] + "  " + equipoPronostico[3] + "           " + equipoPronostico[4] + "  " + equipoPronostico[5] + "  " + equipoPronostico[6] + "  " + equipoPronostico[7] + Colores.ANSI_RESET);  // Encabezado de pronostico
	    	    }
				
			}

			for(int i = 0; i < arrayPronosticos.size(); i++) {
				System.out.println((arrayPronosticos.get(i).getParticipante() + String.format("%" + (16 - arrayPronosticos.get(i).getParticipante().length())  + "s", "")) + "     "
								  + arrayPronosticos.get(i).getNroPartidoPronostico() + "       " + arrayPronosticos.get(i).getNroRondaPronostico() + "    " 
								  + (arrayPronosticos.get(i).getEquipo1() + String.format("%" + (20 - arrayPronosticos.get(i).getEquipo1().length()) + "s", "")) 
				                  + arrayPronosticos.get(i).getGana1() + "       " + arrayPronosticos.get(i).getEmpate() + "      " + arrayPronosticos.get(i).getGana2() + "    " + arrayPronosticos.get(i).getEquipo2());
			}
			
			
			
			// ============================================================================
			// Recorro comparando los pronosticos con los resultados
			Partido partido;
			Integer valor;
			// por cada pronostico busco en partidos por idPartido
			// ============================================================================
			for (Pronostico pronostico : arrayPronosticos) {
		
				partido = mapPartidos.get(pronostico.getClave());
				String[] resulPartido1 = partido.getGanador();
				
				if (resulPartido1[4].equalsIgnoreCase("x")) {
					if (Objects.equals(resulPartido1[4], pronostico.getGana1())) {
						if (participan.containsKey(pronostico.getParticipante())) {
							valor = participan.get(pronostico.getParticipante()) + 1;
							participan.put(pronostico.getParticipante(), (valor));
						}
					}
				}

				if (resulPartido1[5].equalsIgnoreCase("x")) {
					if (Objects.equals(resulPartido1[5], pronostico.getEmpate())) {
						if (participan.containsKey(pronostico.getParticipante())) {
							valor = participan.get(pronostico.getParticipante()) + 1;
							participan.put(pronostico.getParticipante(), (valor));
						}
					}
				}


				if (resulPartido1[6].equalsIgnoreCase("x")) {
					if (Objects.equals(resulPartido1[6], pronostico.getGana2())) {
						if (participan.containsKey(pronostico.getParticipante())) {
							valor = participan.get(pronostico.getParticipante()) + 1;
							participan.put(pronostico.getParticipante(), (valor));
						}
					}
				}
				
			} // termina el forich

			
			// ==================================== FIN =================================================
			// Imprimo los los puntos
			System.out.println("\n");

			for (HashMap.Entry<String, Integer> entry : participan.entrySet()) {
				System.out.printf(Colores.ANSI_YELLOW + "El participante: %s... Sumo: %d\n", entry.getKey(), entry.getValue());
			}
			

		} catch (IOException e) { // comienza la excepcion
			System.out.println("Hubo un error en la operacion...");
			System.out.println(e.getMessage());
			System.exit(1);
		}

	} // termina main

} // termina principal
