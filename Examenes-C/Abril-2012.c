/*
En este examen se pide:
Implementar un árbol de búsqueda binario. 
- Crear 
- Insertar
- Recorrer (imprimir nodos)
- Destruir

(Las interfaces de las funciones ya vienen dadas, y se pide su implementación).

Más abajo hay una explicación del uso de (*arbol)
*/

#include <stdlib.h>
#include <stdio.h>

typedef struct Nodo* TArbol;
struct Nodo {
    int num;    
    TArbol izq; // Subárbol izquierdo
    TArbol der; // Subárbol derecho
};

// En esta función, como se nos da sin argumento `num`, podemos
// presuponer que hay que crear un árbol vacío
void crearAB(TArbol *arbol){
    *arbol = NULL; // Sí, no hace falta más
}

/*
La notación variable->elemento, se utiliza cuando `variable` es un puntero a un struct.
Si tenemos "un puntero a un puntero a un struct", como TArbol *arbol, 
hay que hacer (*arbol)->num.
*/
void insertarEnABB(TArbol *arbol, int elem) {
    if (*arbol == NULL) {
        *arbol = (TArbol)malloc(sizeof(struct Nodo));
        (*arbol)->num = elem;
        (*arbol)->izq = NULL;
        (*arbol)->der = NULL;
    } else if (elem < (*arbol)->num) {
        insertarEnABB(&((*arbol)->izq), elem);
    } else {
        insertarEnABB(&((*arbol)->der), elem);
    }
}

void recorrerABBHelper(TArbol arbol, int *primeroImpreso) {
    if (arbol != NULL) {
        recorrerABBHelper(arbol->izq, primeroImpreso);
        // Si el hijo izquierdo no ha sido NULL, primeroImpreso se habrá
        // puesto a 1.
        if (!(*primeroImpreso)) { 
            printf("%d", arbol->num);
            *primeroImpreso = 1; // Ya se ha impreso. Usar comas            
        } else {
            printf(", %d", arbol->num);
        }
        recorrerABBHelper(arbol->der, primeroImpreso);
    }
}

void recorrerABB(TArbol arbol) {
    int impreso = 0; // Variable para guardar si ya hemos impreso el primero
    recorrerABBHelper(arbol, &impreso);
}

void destruirABB(TArbol *arbol) {
    if (*arbol != NULL) {
        destruirABB(&((*arbol)->izq));
        destruirABB(&((*arbol)->der));
        free(*arbol);
        *arbol = NULL;
    }
}


int main() {
    TArbol arbol;

    crearAB(&arbol);
    
    insertarEnABB(&arbol, 5);
    insertarEnABB(&arbol, 3);
    insertarEnABB(&arbol, 10);
    insertarEnABB(&arbol, 10);
    insertarEnABB(&arbol, 2);
    insertarEnABB(&arbol, 20);
    insertarEnABB(&arbol, 2);
    insertarEnABB(&arbol, 2);
    
    recorrerABB(arbol);
    printf("\n");

    // Borremos la parte izquierda. Deberíamos ver solo los mayores iguales
    // que la raíz 5:
    destruirABB(&(arbol->izq));
    recorrerABB(arbol);
    printf("\n");
}









/*
Imaginemos que no usamos TArbol *arbol en el argumento de la función, sino:

```
void crearAB(TArbol arbol){
    arbol = NULL;
}
```

Luego al usarla no tendrá el efecto esperado:

```
TArbol miArbol;
void crearAB(TArbol miArbol);
```

Esto no funcionará como esperamos, y no modificará la variable `miArbol`; no la
pondrá a NULL. ¿Por qué? Porque se hace una copia del puntero, una copia de la 
dirección. La función no modifica la dirección (puntero) original.

*/


