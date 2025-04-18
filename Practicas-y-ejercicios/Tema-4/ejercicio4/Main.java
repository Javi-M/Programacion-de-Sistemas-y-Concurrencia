package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// 1. Crear lista de numeros List<Integer>
		int tamaño = 10; // Cambia el tamaño si quieres
        int maxValor = 100; // Máximo valor aleatorio (de 0 a rangoMax-1)

        List<Integer> lista = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < tamaño; i++) {
            lista.add(rand.nextInt(maxValor)); // número entre 0 y maxValor - 1
        }
        
        System.out.println("Lista aleatoria:");
        for (int num : lista) {
            System.out.print(num + " ");
        }
        
        // 2. Crear nodo raiz y llamar para ordenar `lista`
        Nodo raiz = new Nodo(lista);
        raiz.start();
        
        try {
			raiz.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("\nLista ordenada:");
        for (int num : lista) {
            System.out.print(num + " ");
        }
	}

}
