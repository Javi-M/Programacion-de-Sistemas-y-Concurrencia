[Índice](README.md)

Una hebra se puede encontrar:
- En ejecución
- Esperando CPU
- Bloqueada
- Terminada

Creación de una hebra, mediante dos métodos: 
- heredando de `Thread` e implementando `run()` (mucho, mucho más común en exámenes)
- implementando una clase con la interfaz `Runnable`, y usar el constructor de `Thread`

Métodos (de instancia) relevantes de la clase `Thread`. Sea `h1` un objeto de clase `Thread`:
- `h1.start()`: 
- `h1.join()`: la hebra donde esta sentencia se ejecuta espera a que `h1` termine para continuar.

Métodos (de clase) de `Thread`:
- `Thread.sleep(int x)`: la hebra donde esta sentencia se ejecuta para su ejecución un determinado tiempo. Luego continúa por el mismo sitio.
- `Thread.yield()`: la hebra donde esta sentencia se ejecuta indica que está dispuesta a ceder el uso de CPU.
- 