/*
 * Examen Septiembre 2022 PSC - todos los grupos.
 * Comenta las pruebas según necesites, recuerda que sólo se sube el Vagon.c.
 * Así que TODO tu código deberá estar en el Vagon.c.
 */

#include <stdio.h>
#include <assert.h>
#include <string.h>
#include "Tren.h"

int main(){
	// Comenta al gusto para probar, recuerda que el main que se usará será el que se da sin tus modificaciones.

	/* Inicializamos */
	int maximoVagones = 24;

	Vagon tren[maximoVagones];
	inicializarTren(tren, maximoVagones);
	
	printf("Inicializado...\n\n");
	for (int i = 0; i < maximoVagones; i++)
	{
		assert(tren[i] == NULL);
	}
	
	
	/* Entran pasajeros */
	char nombre[30] = "Pepe Perez";
	int res = entraPasajero(tren,0,3,nombre);
	assert(res == 0);
	assert(tren[0] != NULL);
	assert(tren[0]->num == 3);
	assert(strcmp(tren[0]->nombre, nombre) == 0); // Son iguales...
	assert(tren[0]->nombre != nombre);			  // ...y no apuntan al mismo sitio :)
	assert(tren[0]->sig == NULL);	

	strcpy(nombre, "Pepa Roman");
	res = entraPasajero(tren, 0 , 1 ,nombre);
	assert(res == 0);
	assert(tren[0] != NULL);
	assert(tren[0]->num == 1);
	assert(strcmp(tren[0]->nombre, nombre) == 0); // Son iguales...
	assert(tren[0]->nombre != nombre);			  // ...y no apuntan al mismo sitio :)
	assert(tren[0]->sig->num== 3);

	strcpy(nombre, "Adela Gamez");
	res = entraPasajero(tren, 1 ,5,nombre);
	assert(res == 0);
	assert(tren[1] != NULL);
	assert(tren[1]->num == 5);
	assert(strcmp(tren[1]->nombre, nombre) == 0); // Son iguales...
	assert(tren[1]->nombre != nombre);			  // ...y no apuntan al mismo sitio :)
	assert(tren[1]->sig == NULL);	

	strcpy(nombre, "Ambrosio Garcia");
	res = entraPasajero(tren, 1 ,5,nombre); //Mismo asiento que Adela García, no se debe permitir
	assert(res == -1);
	assert(strcmp(tren[1]->nombre, nombre) != 0); // Son iguales...
	

	strcpy(nombre, "Carmen Garcia");
	res = entraPasajero(tren, 1 ,7,nombre);
	assert(res == 0);
	assert(tren[1] != NULL);
	assert(tren[1]->sig != NULL);
	assert(tren[1]->sig->num == 7);
	assert(strcmp(tren[1]->sig->nombre, nombre) == 0); // Son iguales...
	assert(tren[1]->sig->nombre != nombre);			  // ...y no apuntan al mismo sitio :)
	assert(tren[1]->sig->sig == NULL);

	strcpy(nombre, "Raul Garcia");
	res = entraPasajero(tren, 1 ,6,nombre);
	assert(res == 0);
	assert(tren[1] != NULL);
	assert(tren[1]->sig != NULL);
	assert(tren[1]->sig != NULL);
	assert(tren[1]->sig->num == 6);
	assert(strcmp(tren[1]->sig->nombre, nombre) == 0); // Son iguales...
	assert(tren[1]->sig->nombre != nombre);			  // ...y no apuntan al mismo sitio :)
	assert(tren[1]->sig->sig != NULL);

	
	/* Mostrar Tren */
	imprimeTren(tren,maximoVagones);

	/* Salida pasajeros*/
	res = salePasajero(tren, 0, 1);
	assert(res==0);
	assert(tren[0] != NULL);
	assert(tren[0]->num == 3);
	assert(tren[0]->sig == NULL);	

	res = salePasajero(tren, 1, 6);
	assert(res==0);
	assert(tren[1] != NULL);
	assert(tren[1]->num == 5);
	assert(tren[1]->sig != NULL);
	assert(tren[1]->sig->num == 7);
	assert(tren[1]->sig->sig == NULL);

	res = salePasajero(tren, 0, 1);
	assert(res==-1);

	imprimeTren(tren,maximoVagones);

	/* Entran más pasajeros */
	strcpy(nombre, "Josefa Valverde");
	res = entraPasajero(tren, 0 , 2 ,nombre);
	assert(res == 0);
	assert(tren[0] != NULL);
	assert(tren[0]->num == 2);
	assert(strcmp(tren[0]->nombre, nombre) == 0); // Son iguales...
	assert(tren[0]->nombre != nombre);			  // ...y no apuntan al mismo sitio :)
	assert(tren[0]->sig != NULL);
	assert(tren[0]->sig->num == 3);

	imprimeTren(tren,maximoVagones);


	/* Intercambio de pasajeros */
	res = intercambianAsientos(tren,0,2,1,7);
	assert(res == 0);
	assert(tren[0] != NULL);
	assert(tren[0]->num == 2);
	assert(strcmp(tren[0]->nombre, "Carmen Garcia") == 0); 
	assert(tren[1] != NULL);
	assert(tren[1]->sig != NULL);
	assert(tren[1]->sig->num= 7);
	assert(strcmp(tren[1]->sig->nombre, "Josefa Valverde") == 0); 

	res = intercambianAsientos(tren,0,2,1,8);
	assert(res == -1);

	res = intercambianAsientos(tren,0,2,3,7);
	assert(res == -1);

	imprimeTren(tren,maximoVagones);

	/* Se bajan todos los pasajeros del tren */

	ultimaParada(tren,maximoVagones);

	imprimeTren(tren,maximoVagones);

	/* Carga de fichero BINARIO los pasajeros del vagon 0 y 1 */

	importarPasajerosVagon("vagon0.bin",tren,0);
	importarPasajerosVagon("vagon1.bin",tren,1);
	imprimeTren(tren,maximoVagones);

	/* Almacena en fichero de TEXTO (se puede ver el contenido), los pasajeros del tren*/	
	almacenarRegistroPasajeros("RegistroPasajeros.csv",tren,maximoVagones);


	return 0;
}



