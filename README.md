# Programación de Sistemas y Concurrencia
Repositorio para la asignatura. Esta asignatura utiliza los lenguajes C y Java.

Importa el repositorio como un proyecto Maven existente para que detecte
bien los archivos fuente. Si modificas cualquier cosa, ten en cuenta que 
probablemente tengas que modificar el `pom.xml` también. 

Cualquier carpeta que añadas que quieras que se comporte como "un paquete Java",
añádelo en `<sources>`.

Por ejemplo: `<source>Practicas-y-ejercicios/Tema-4/ejercicio2</source>` quiere
decir que `ejercicio2` es un paquete con código fuente (source).

Esta estructura me parece más legible a la hora de estudiar los contenidos, 
aunque no sea la que se elegiría para un proyecto de verdad.

Para C, compila a manita con `gcc`.

# Exámenes C
[Examenes-C](Examenes-C)

| Fecha         | Contenidos    | Estado |
|---------------|---------------|--------|
| [Abril de 2012](Examenes-C/Abril-2012) | Árbol binario | ✅ Implementado |
| [Septiembre de 2022](Examenes-C/Septiembre-2022) |  Array de punteros <br> Listas enlazadas <br> Lectura/escritura de archivos binarios | 🛠️ En progreso |


# Exámenes Java
| Fecha | Contenidos | Estado |
|-------|------------|--------|
| Septiembre-2022 |            | 🛠️ En progreso |

# Prácticas y Ejercicios
| Práctica | Ejercicios | Contenidos | Estado |
|----------|------------|------------|--------|
| [Práctica 4][p4] | [Ejercicio 1][p4] |Crear hebra implementado | ✅ Implementado |
|                  | [Ejercicio 2][p4e2] | Crear hebra | ✅ Implementado |
|                  | [Ejercicio 3][p4e3] | Sincronización | ✅ Implementado |
|                  | [Ejercicio 4][p4e4] | Sincronización <br> Recursividad | 🛠️ En progreso |

[p4]:     Practicas-y-ejercicios/Tema-4/
[p4e2]:   Practicas-y-ejercicios/Tema-4/ejercicio2
[p4e3]:   Practicas-y-ejercicios/Tema-4/ejercicio3
[p4e4]:   Practicas-y-ejercicios/Tema-4/ejercicio3

# Conceptos clave
<dl> 
   	<dt>Región crítica
   	<dd>... 
   	<dt>Exclusión mutua 
   	<dd>...
    <dt>Condición de sincronización
    <dd>Restricción de algo que puede pasar o no al mismo tiempo. Ej., al mismo
        tiempo no se puede producir y consumir. Debe ocurrir en exclusión mutua.
        Suele indicar que un proceso debe <b>esperar</b> hasta que ocurra algo.
    <dt>Espera activa
    <dd>El proceso intenta una y otra vez tomar una acción, comprobando si se
        cumple una condición de sincronización, hasta que puede avanzar. Por 
        ejemplo en un bucle: <code>while(!SC) Thread.yield();</code> -> cuando 
        <code>SC</code> es <code>true</code>, continúa.
</dl>