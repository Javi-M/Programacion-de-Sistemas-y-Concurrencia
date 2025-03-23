public class Principal {

	public static void main(String[] args) {
		Tren tren = new Tren();
		Maquinista maquinista = new Maquinista(tren);
		Pasajero[] pasajeros = new Pasajero[20];

		// Crear pasajeros con sus ids
		for (int i=0; i<pasajeros.length; i++) {
			pasajeros[i] = new Pasajero(tren, i);
		}	

		maquinista.start();
		
		for (int i=0; i<pasajeros.length; i++) {
			pasajeros[i].start();
		}
	}
}
