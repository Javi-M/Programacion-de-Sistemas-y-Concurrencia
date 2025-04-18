package ejercicio5;

/**
 * Calcula el n-ésimo valor de la sucesión de Fibonacci.
 * Utiliza variables compartidas para el output, imitando ejercicios anteriores.
 * 
 */
public class HebraFibonacci extends Thread{
	private int n;
	private VariableCompartida salida;
	
	public HebraFibonacci(int n, VariableCompartida salida) {
		this.n = n;
		this.salida = salida;
	}

	@Override
	public void run() {
		// Los términos 0 y 1, que son los primeros y segundos (n=1, n=2)
		// serán casos base (no recursivos).
		if (n > 2) {
			VariableCompartida v1 = new VariableCompartida();
			VariableCompartida v2 = new VariableCompartida();
			
			HebraFibonacci h1 = new HebraFibonacci(n-1, v1);
			HebraFibonacci h2 = new HebraFibonacci(n-2, v2);
			
			h1.start();
			h2.start();
			
			try {
				h1.join();
				h2.join();
				this.salida.set(v1.get() + v2.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			// El primer término (n=1) es 0, el segundo término (n=2) es 1:
			this.salida.set(n-1);
		}
	}
}
