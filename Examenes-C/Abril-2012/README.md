# Enunciado
Un árbol de búsqueda binario es aquel en el que, para cualquier nodo, 
el subárbol izquierdo contiene valores menores que el de dicho nodo; y el subárbol derecho
contiene valores mayores.

_No se espeficia el caso de que un valor sea igual. Probablemente a criterio del estudiante._

<b style="background: yellow; color: black"> En las funciones, he cambiado el nombre de los argumentos </b>

# Se da
Las interfaces de las funciones a implementar y su descripción.
- `void CrearABB (TArbol *arb)`
- `void InsertarEnABB (TArbol *arb, int elem)` 
- `void RecorrerABB (TArbol arb)`: imprimir todos los elementos de menor a mayor.
- `void DestruirABB(TArbol *arb)`: liberar toda la memoria correspondiente.

# Se pide
Implementar el cuerpo de las funciones.