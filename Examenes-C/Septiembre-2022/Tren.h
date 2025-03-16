/*
 * Examen Septiembre 2022 PSC - todos los grupos.
 * Cabecera Tren.h
*/

#ifndef TREN_H_
#define TREN_H_

typedef struct Asiento * Vagon;
struct Asiento{
	unsigned num;
	char nombre[30];
	Vagon sig;
};

/// @brief Inicializa el tren creado en el Principal que tiene maximoVagones (Vagon *tren) con todos los vagones vacío. 
/// @param tren Array que representa el tren. 
/// @param maximoVagones Número de vagones que tiene el tren (tamaño del array). 
/// 0.25 pts 
void inicializarTren(Vagon * tren, int maximoVagones); 


/// @brief Inserta los datos de un nuevo pasajero. Sí el asiento está libre se lo asigna y si está ocupado ignora la petición. 
/// @param tren Array con los vagones y pasajeros que tiene el tren actualmente, en el que se debe insertar. 
/// @param numeroVagon Vagón en el que se quiere sentar el pasajero. 
/// @param numeroAsiento Asiento dentro del vagón en el que se quiere sentar el pasajero. 
/// @param nombre Nombre del pasajero. 
/// @return Si el asiento ya está ocupado, devuelve -1, si no, devuelve 0. 
/// 1.75 pts 
int entraPasajero(Vagon * tren, unsigned numeroVagon, unsigned numeroAsiento, char * nombre); 
 
/// @brief Muestra por pantalla los vagones ocupados mostrando en cada línea los datos de un pasajero. Por ejemplo: 
/* 
Vagon 0:  
Asiento 2, Carlos García 
Asiento 4, Ismael Canario 
Vagon 2: 
Asiento 1, Macarena Sol 
*/ 
/// @param tren Array con los vagones y pasajeros que tiene el tren actualmente. 
/// @param maximoVagones Máximo de vagones que tiene el tren. 
/// 0.75 pt 
void imprimeTren(Vagon * tren, unsigned maximoVagones); 
 
/// @brief El pasajero abandona el tren (es eliminado de la estructura).  
/// @param tren Array con los vagones y pasajeros que tiene el tren actualmente. 
/// @param numeroVagon Vagón en el que se está el pasajero que abandona el tren. 
/// @param numeroAsiento Asiento en el que se está el pasajero que abandona el tren. 
/// @return Devuelve 0 si el pasajero abandona el tren y -1 si no había pasajero en el vagón y asiento indicados. 
/// 1.5 pts 
int salePasajero(Vagon * tren, unsigned numeroVagon, unsigned numeroAsiento); 
 
/// @brief Intercambia dos pasajeros. Para ello es suficiente intercambiar el NOMBRE del viajero que está en el asiento \p numeroAsiento1 del vagón\p numeroVagon1, con el del viajero que está en el asiento \p numeroAsiento2 del vagón \p numeroVagon2. 
/// @param tren Array con los vagones y pasajeros que tiene el tren actualmente. 
/// @param numeroVagon1 Vagón en el que se está el pasajero 1 que quiere cambiarse de sitio. 
/// @param numeroAsiento1 Asiento en el que se está el pasajero 1 que quiere cambiarse de sitio. 
/// @param numeroVagon2 Vagón en el que se está el pasajero 2 que quiere cambiarse de sitio. 
/// @param numeroAsiento2 Asiento en el que se está el pasajero 2 que quiere cambiarse de sitio. 
/// @return Si algún asiento no está ocupado, devuelve -1. Si se puede realizar el cambio, devuelve 0. 
/// 1.75 pts 
int intercambianAsientos(Vagon * tren, unsigned numeroVagon1, unsigned numeroAsiento1,unsigned numeroVagon2, unsigned numeroAsiento2); 
 
/// @brief El tren llega a la última parada y bajan todos los pasajeros del tren. El tren debe quedar vacío. 
/// @param tren Array con los vagones y pasajeros que tiene el tren actualmente. 
/// @param maximoVagones Maximo de vagones que tiene el tren. 
/// 1 pt 
void ultimaParada(Vagon * tren, unsigned maximoVagones); 
 
/// @brief Guarda en fichero de TEXTO los datos de los pasajeros en el tren. El formato del fichero de texto será el siguiente, una primera línea con el siguiente texto: 
// Vagon;Asiento;Nombre 
// Tras esta línea, incluirá una línea por cada pasajero, ordenados por vagón primero y luego por número de asiento.  
// 0;2;Carmen Garcia 
// 0;3;Pepe Perez 
// 1;5;Adela Gamez 
// 1;7;Josefa Valverde 
/// @param filename Nombre del fichero en el que se van a almacenar los datos de los pasajeros del tren. 
/// @param tren Array con los vagones y pasajeros que tiene el tren actualmente. 
/// @param maximoVagones Máximo de vagones que tiene el tren. 
/// 1.5 pts 
void almacenarRegistroPasajeros(char *filename, Vagon * tren, unsigned maximoVagones); 
 
/// @brief Algunas estaciones están automatizadas y proporcionan un fichero con los pasajeros que van a entrar en un vagón en su parada. 
// Esta función carga los pasajeros que están en el fichero BINARIO filename en el  
// vagón numeroVagon. Se asume que los pasajeros almacenados en el fichero no van a  
// sentarse en asientos previamente ocupados.  
// El fichero binario almacena la información de cada pasajero con la siguiente  
// estructura:  
// - Un entero con el número de asiento. 
// - La cadena de caracteres con el nombre. 
/// @param filename Nombre del fichero que contiene los datos de los pasajeros del vagon. 
/// @param tren Array con los vagones y pasajeros que tiene el tren actualmente. 
/// @param numeroVagon Vagon del que se van a importar los pasajeros.  
/// 1.5 pts 
void importarPasajerosVagon(char *filename, Vagon * tren,unsigned numeroVagon); 
#endif /* TREN_H_ */
