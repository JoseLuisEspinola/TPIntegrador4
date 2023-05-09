package ClasesTPI;

import java.util.ArrayList;

	public class Ronda {
		private int idRonda;
		private int idPartido;
		private ArrayList<Partido> partido;

	
		public Ronda(int idRonda, int idPartido, ArrayList<Partido> partido) {
			this.idRonda = idRonda;
			this.idPartido = idPartido;
			this.partido = partido;
		}


		public int getIdRonda() {
			return idRonda;
		}


		public void setIdRonda(int idRonda) {
			this.idRonda = idRonda;
		}


		public int getIdPartido() {
			return idPartido;
		}


		public void setIdPartido(int idPartido) {
			this.idPartido = idPartido;
		}


		public ArrayList<Partido> getPartido() {
			return partido;
		}


		public void setPartido(ArrayList<Partido> partido) {
			this.partido = partido;
		}
	
	
}
