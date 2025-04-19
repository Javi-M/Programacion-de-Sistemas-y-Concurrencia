package ejercicio1;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		/** Semaforo binario para la exclusión mutua productor y consumidor */
		// Al mismo tiempo: o el productor escribe, o el consumidor consume.
		Semaphore mutex = new Semaphore(1);
		int N = 10;
		Buffer buffer = new Buffer(N);
		
		int numElementosProducirConsumir = 20;
		
		Productor productor = new Productor(mutex, buffer, numElementosProducirConsumir);
		Consumidor consumidor = new Consumidor(mutex, buffer, numElementosProducirConsumir);
		
		productor.start();
		consumidor.start();
		
		try {
			productor.join();
			consumidor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
