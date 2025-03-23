# Enunciado
Un Tren tiene dos vagones. Cada vagón tiene capacidad para N pasajeros.
El Tren tiene un Maquinista que lo pone en marcha solo cuando los dos vagones están llenos.

Comportamiento del Pasajero:
- No puede subirse si el tren está lleno, en marcha o hay pasajeros bajándose del viaje anterior.
    Mientras tanto, _espera_.
- El pasajero busca primero asiento en el primer vagón. Si está lleno se sienta en el segundo.
- El último pasajero en subir avisa al maquinista.
- Cuando el viaje termina, primero se bajan los pasajeros del primer vagón, y luego los pasajeros del segundo.

Comportamiento del Maquinista:
- Sólo pone el tren en marcha cuando está lleno.
- Cuando finaliza el viaje avisa a los pasajeros de que pueden bajarse.
- 

# Se da
- `Maquinista.java`
- `Pasajero.java` (ya implementado)
- `Principal.java` ()
- `Tren.java`

# Se pide
Implementar la clase `Tren` de dos formas:
1. Utilizando semáforos binarios
2. Métodos sincronizados o locks

# Estrategia
Implementar primero el código _ignorando la concurrencia_ (mutex, semáforos, etc.)
Luego, ver dónde hay que poner cada cosa. (Esta sentencia debería ir en mutex con esta otra, etc.)

