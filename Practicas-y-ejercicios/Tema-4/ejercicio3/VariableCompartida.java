package ejercicio3;

public class VariableCompartida {
    private int numero;
    
    // Basicamente son dos semaforos binarios sin usar Semaphore
    public boolean puedeImprimir;
    public boolean puedeEscribir;
    public boolean acabado; // Variable para evitar bucles infinitos, ya que "escribir" e "imprimir" se van turnando

    /**
     * Al comienzo, puede imprimirse por pantalla para mostrar el primer numero
     * y no puede escribirse en `numero`.
     */
    public VariableCompartida(int numero){
        this.numero = numero;
        puedeImprimir = true;
        puedeEscribir = false;
        acabado = false;
    }

    public int get() {
        return numero;
    }
    
    public void set(int numero) {
        this.numero = numero;
    }

    public void inc(){
        this.numero++;
    }
}
