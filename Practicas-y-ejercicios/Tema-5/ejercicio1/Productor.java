package ejercicio1;

import java.util.concurrent.Semaphore;

public class Productor extends Thread {

	private Semaphore mutex;
	private Buffer buffer;
	private int producirNVeces; // Num. elementos a producir
	private int vecesProducido; // Num. elementos ya producidos
	
	public Productor(Semaphore mutex, Buffer buffer, int producirNVeces) {
		this.mutex = mutex;
		this.buffer = buffer;
		this.producirNVeces = producirNVeces;
		this.vecesProducido = 0;
	}
	
	// Produce un número aleatorio
	// int randomNum = (int)(Math.random() * 101); // 0 to 100
	
	@Override
	public void run() {
		while(vecesProducido < producirNVeces) {
			// ESPERA ACTIVA. CS: Si nelems >= tam. buffer, espera.
			while(buffer.nelems >= buffer.N) {
				Thread.yield();			
			}
			
			try {
				mutex.acquire();
				
				int randomElem = (int)(Math.random() * 101); // 0 hasta 100
				buffer.producir(randomElem); // Insertar elemento en buffer
				System.out.println("Produce: " + randomElem);
				vecesProducido++;
				
				mutex.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		
	}
}
