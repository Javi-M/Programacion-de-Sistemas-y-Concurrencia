package ejercicio1;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {
	
	/** mutex entre productor y consumidor */
	private Semaphore mutex;
	private Buffer buffer;
	private int consumirNVeces; // Num. elementos a consumir.
	private int vecesConsumido; // Num. elementos consumidos.
	
	public Consumidor(Semaphore mutex, Buffer buffer, int consumirNVeces) {
		this.mutex = mutex;
		this.buffer = buffer;
		this.consumirNVeces = consumirNVeces;
		this.vecesConsumido = 0;
	}
	
	@Override
	public void run() {
		while(vecesConsumido < consumirNVeces) {
			// ESPERA ACTIVA. CS: Si nelems == 0, no puede consumir (espera)
			while(buffer.nelems == 0) {
				Thread.yield();
			}
			try {
				mutex.acquire();
				
				int elemento = buffer.consumir();
				System.out.println("Consume: " + elemento);
				
				vecesConsumido++;
				mutex.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
