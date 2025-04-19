package ejercicio1;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Buffer {
	
	/** Como es una constante, es seguro */
	public final int N; // Tam. máximo de la lista
	private int c;
	private int p;
	private int[] elementos;
	
	/** 
	 * Semaforo para garantizar que no se ejecuta al mismo tiempo.
	 * En realidad se maneja desde fuera, en Productor y Consumidor compartiendo un semaforo,
	 * pero así se garantiza que de todas formas no se pueda "mal usar".
	 * {@code consumir} y {@code producir} 
	 */
	private Semaphore mutex;
	
	/** 
	 * Elementos validos contenidos en el buffer (num. elems. por leer por el 
	 * consumidor)
	 */
	public volatile int nelems; 
	
	public Buffer(int N) {
		this.N = N;
		this.elementos = new int[N];
		this.nelems = 0; // Inicialmente no hay elementos producidos que se puedan consumir.
		this.mutex = new Semaphore(1);
	}
	
	/**
	 * 
	 * @return Un elemento del buffer.
	 * @throws InterruptedException
	 */
	public int consumir() throws InterruptedException {
		mutex.acquire();
		
		if (nelems == 0) {
			// Si nelems == 0, productor y consumidor no se han sincronizado correctamente
			throw new IllegalStateException("No se puede consumir si no hay elementos.");
		}
		
		int elemento = elementos[c];
		c++;
		if (c == N) {
			c = 0; // Volver al principio. (Array circular)
		}
		nelems--;
		
		mutex.release();
		
		return elemento;
	}
	
	/**
	 * 
	 * @param elemento Elemento que el productor quiere incluir en el buffer
	 * @throws InterruptedException
	 */
	public void producir(int elemento) throws InterruptedException {
		mutex.acquire();
		
		if (nelems == N) {
			// Se ha intentado producir cuando el buffer está lleno
			throw new IllegalStateException("No se puede producir si el buffer esta lleno.");
		}
		
		elementos[p] = elemento;
		p++;
		if (p == N) {
			p = 0; // Volver al principio. (Array circular)
		}
		nelems++;

		mutex.release();
	}
}
