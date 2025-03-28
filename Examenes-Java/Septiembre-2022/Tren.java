import java.util.concurrent.Semaphore;

public class Tren {
	// Opcion mas bruta: dos arrays de semaforos. Uno por asiento.
	// ¿Hay que modelar los asientos de alguna forma? (Por ejemplo, un array
	// de asientos usados). SEGURAMENTE SÍ, por el "output propuesto" en el enunciado

	/** Capacidad de cada vagon  */
	private final int N = 10; // 10, me lo invento. Capacidad de cada vagon
	
	/** A usar en mutex */
	private int pasajerosSubidosVagon1 = 0;
	private int pasajerosSubidosVagon2 = 0;

	/** Solo puede subir uno cada momento. Semaforo para modificar/leer "pasajeros subidos" */
	private Semaphore subir = new Semaphore(1);

	/** Semaforo para secciones criticas */
	private Semaphore mutex = new Semaphore(1);

	/**
	 * Función llamada por el pasajero indicado por su {@code id}
	 * cuando se quiere montar.
	 * @param id
	 * @throws InterruptedException
	 */
	public void viaje(int id) throws InterruptedException {
		// 1. ¿Se puede montar en el tren?
		// Se intenta montar en el vagon uno
		// Si no, se intenta montar en el vagon dos
		subir.acquire(); // Solo puede subir uno al mismo tiempo.
		if (pasajerosSubidosVagon1 < N) {
			pasajerosSubidosVagon1++;
			System.out.println("pasajero " + Integer.toString(id) + " ha subido al vagón 1");
		} else if (pasajerosSubidosVagon2 < N) {
			pasajerosSubidosVagon2++;
			System.out.println("pasajero " + Integer.toString(id) + " ha subido al vagón 2");
		}
		subir.release();
	}

	public void empiezaViaje() throws InterruptedException {
		subir.acquire();
		if (pasajerosSubidosVagon1 + pasajerosSubidosVagon2 < 2*N) {
		}
		subir.release();
		System.out.println("Maquinista:  empieza el viaje");
	}

	public void finViaje() throws InterruptedException  {
		subir.acquire();

		System.out.println("Maquinista:  fin del viaje");
	}
}
