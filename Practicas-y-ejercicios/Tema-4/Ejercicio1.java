public class Ejercicio1 {

    /**
     * La clase MiHebra es `static` para no tener que instanciar
     * la clase Ejercicio1
     */
    private static class MiHebra extends Thread { 
        private char letra;
        public MiHebra(char letra) {
            this.letra = letra;
        }
        public void run() {
            for(int i=0; i<1000; i++){
                System.out.println(letra);
            }
        }
    }

    public static void main(String[] args) {
        MiHebra hebra1 = new MiHebra('A');
        MiHebra hebra2 = new MiHebra('B');
        MiHebra hebra3 = new MiHebra('C');

        hebra1.start();
        hebra2.start();
        hebra3.start();
    }
    
}
