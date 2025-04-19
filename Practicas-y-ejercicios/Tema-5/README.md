> **Nota**: La abreviación "CS" significa "Condición de Sincronización".

# Ejercicio 1
## Enunciado
Implementar el problema del productor-consumidor con un buffer circular de N
posiciones.
- Existe una única hebra representando al productor que irá produciendo 
    elementos de tipo entero consecutivos.
- Existe un buffer circular acotado compartido por el productor y el consumidor 
    para producir y consumir los elementos donde se tendrán los siguientes 
    atributos:
   - `elementos`: array con los elementos del buffer.
   - `p`: indica la posición por la que se va produciendo.
   - `c`: indica la posición por la que se va consumiendo.
   - `nelems`: número de elementos válidos contenidos en el buffer.
 - Existe un único consumidor que irá mostrando por pantalla los elementos 
    depositados en el buffer.

## Interpretación
En un problema "productor-consumidor", normalmente cada recurso producido puede
consumirse una única vez.

En este caso el **buffer** es la variable compartida: una lista/array en la que
el productor escribe y de la que el consumidro lee.

- CS: El consumidor no puede consumir si `nelems = 0` (no hay elementos).
- CS: El productor no puede producir si `nelems = N` (está lleno)
- CS (mutex): como no se establece en el enunciado, lo más sencillo es suponer 
    que al mismo tiempo no se puede leer/escribir en el buffer.

