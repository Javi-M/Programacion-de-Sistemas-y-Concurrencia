# Enunciados

## Ejercicio 1
> Realizar un programa en Java con 3 hebras, cada una de las cuales escribe por
> pantalla varias veces (valor pasado como parámetro en el constructor) el 
> carácter que se le indique (también indicado como parámetro). ¿Se mezclan las 
> letras? Justifica el comportamiento observado.

Aunque el código sea secuencial, las hebras funcionan concurrentemente sin 
sincronización: cada una "imprime cuando puede" (cuando el _scheduler_ del 
sistema operativo "dice que es su turno").

Laz letras se mezclan, pero no demasiado. Tiene sentido, ya que el _scheduler_ 
no va a cambiar cada dos por tres la hebra.

## Ejercicio 2
> Disponemos de una clase denominada `VariableCompartida` que encapsula el
> valor de una variable `v` de tipo `int`. La clase `VariableCompartida` contiene
> métodos para establecer (método `set`), obtener (método `get`) o incrementar
> (método `inc`) el valor de `v`. Realizar un programa en Java que cree 2 hebras
> compartiendo una instancia de la clase `VariableCompartida` e incrementen
> cada una de ella 10 veces el valor de `v`. Mostrar desde la hebra del programa
> principal el valor final de `v`. ¿Se obtienen los resultados esperados? Aumenta
> progresivamente el número de incrementos hasta observar algún
> comportamiento "extraño". Justifica los resultados obtenidos.

Si dos hebras leen el mismo valor antes de que alguna lo actualice, una 
actualización puede sobrescribir la otra. (Se dan **condiciones de carrera**).

## Ejercicio 3
> Utilizando la clase `VariableCompartida` del ejercicio anterior y una 
> instancia compartida de dicha clase, realizar un programa en Java donde 
> disponemos de una hebra que modifica los valores de la instancia de 
> `VariableCompartida` desde 0 a 99 utilizando el método `set`. Disponemos 
> también de otra hebra, que utilizando el método `get` debe mostrar por 
> pantalla todos los cambios que se van produciendo en la instancia de 
> `VariableCompartida` (sabiendo que se van a generar 100 valores). ¿Se recogen
> todos los valores? ¿Qué ocurre? Intenta solucionar los problemas detectados.

## Ejercicio 4
> Realizar un programa en Java con 3 hebras, cada una de las cuales escribe por
> pantalla varias veces (valor pasado como parámetro en el constructor) el 
> carácter que se le indique (también indicado como parámetro). ¿Se mezclan las
> letras? Justifica el comportamiento observado.