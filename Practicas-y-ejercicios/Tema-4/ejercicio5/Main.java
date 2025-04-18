package ejercicio5;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int n = 10;
		
		VariableCompartida v = new VariableCompartida();
		HebraFibonacci fibonacci = new HebraFibonacci(n, v);
		
		fibonacci.start();
		fibonacci.join();
		
		System.out.println(v.get());		
	}

}
