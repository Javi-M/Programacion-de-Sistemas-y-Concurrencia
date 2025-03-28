[Índice](README.md)

(Conceptos claves previos):
- "Región crítica"
- "Bloqueo" o "deadlock"

Conceptos clave:
- "Espera activa"
- "Exclusión mutua"
- "Condiciones de sincronización"
- "Entidad activa" (hebra)
- "Entidad pasiva" o "recurso"
    - ¿Es compartido? (Ejemplo típico: un contador).
    - ¿Puede accederse sin problema en cualquier momento?

> **TODO**: Explicar problemas con la estructura:
> - Problema
> - Análisis de los elementos de concurrencia en él
>   - ¿Entidades activas? ¿Recursos? ¿Exclusiones mutuas? ¿Recursos compartidos a los que hay que
>                                                            controlar el acceso?
> - Solución posible: con semáforos binarios y con monitores-locks.

# Problema de los Jardines

# Problema del Productor/Consumidor

# Problema de los Lectores/Escritores
- Recurso compartido: base de datos, **BD**. (En general: cualquier variable a modificar/leer).
- Entidades activas:
    - Lectores: quieren acceder a la **BD** (para leer).
    - Escritores: quieren acceder a la **BD** (para modificarla).
- Condiciones de sincronización:
    - Un escritor accede a la **BD** en exclusión mutua con cualquier otra entidad activa.
    - Cualquier número de lectores pueden acceder simultáneamente a la **BD**.