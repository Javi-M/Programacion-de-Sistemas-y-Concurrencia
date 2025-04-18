package ejercicio4;

import java.util.ArrayList;
import java.util.List;

/**
 * Comportamiento del nodo:
 * 1. Se le pasa una lista de numeros (por el constructor).
 * 2. Si tiene 0 o 1 elementos, acaba.
 *		En otro caso, crea dos hebras y le pasa a cada una una mitad de la lista.
 */
public class Nodo extends Thread {
	
	private List<Integer> lista;
	
	public Nodo(List<Integer> lista) {
		this.lista = lista;
	}
	
	/**
	 * Crea una sublista de {@code lista}.
	 * Elemento {@code desde} incluido, elemento {@code hasta} no incluido.
	 * @param lista
	 * @param desde
	 * @param hasta
	 */
	public void añade(List<Integer> subLista, int desde, int hasta) {
		for(int i = desde; i < hasta; i++) {
			subLista.add(lista.get(i));
		}
	}
	
	/**
	 * Mezcla en {@code lista} las listas {@code lista1, lista2}
	 * @param lista1 Lista izquierda
	 * @param lista2 Lista derecha
	 */
	public void mezcla(List<Integer> lista1, List<Integer> lista2) {
		int i = 0; // Indice para la lista izquierda 
		int j = 0; // Indice para la lista derecha, lista2
		int k = 0; // Indice para la lista global, lista
		
		while (i < lista1.size() && j < lista2.size()) {
			if (lista1.get(i) <= lista2.get(j)) {
				// Asignar elemento de la izquierda e incrementar contadores	
				lista.set(k, lista1.get(i));
				i++;
			} else {
				lista.set(k,  lista2.get(j));
				j++;
			}
			k++;
		}
		
		// Copiar los elementos restantes de lista1 (si hay)
        while (i < lista1.size()) {
            lista.set(k, lista1.get(i));
            i++;
            k++;
        }

        // Copiar los elementos restantes de lista2 (si hay)
        while (j < lista2.size()) {
            lista.set(k, lista2.get(j));
            j++;
            k++;
        }
		
	}
	
	@Override
	public void run() {
		// Caso 1: 0 o 1 elemento. No hacer nada.
		
		/* Caso 2: mas de 1 elemento. 
		 * Crear 2 hebras y a cada una pasarle la mitad.
		 * Esperar a que acaben.
		 * Merge ambas partes.
		 */
		if (lista.size() > 1) {
			List<Integer> subListaIzquierda = new ArrayList<Integer>();
			List<Integer> subListaDerecha = new ArrayList<Integer>();
			
			int m = lista.size()/2;
			
			this.añade(subListaIzquierda, 0, m);
			this.añade(subListaDerecha, m, lista.size());
			
			Nodo nodoIzquierdo = new Nodo(subListaIzquierda);
			Nodo nodoDerecho   = new Nodo(subListaDerecha);
			
			nodoIzquierdo.start();
			nodoDerecho.start();
			
			try {
				nodoIzquierdo.join();
				nodoDerecho.join();
				this.mezcla(subListaIzquierda, subListaDerecha);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
