# Práctica 1. Persistencia Relacional
Implementar la capa de persistencia para una aplicación que gestiona información
sobre [Investigadores](README.md#investigador) universitarios. En particular, se llevará un registro de universidades,
[Investigadores](README.md#investigador), [Becas](README.md#beca) y [Congresos](README.md#congreso).

    Java 17
    Spring Data (SpringBoot 2.6)
    MySql 8

## Entidades

### Universidad
||
|:-------------|
| Nombre |
| Ciudad |
| Pais   |

### Investigador
||
|:-------------|
| Nombre      |
| Apellidos   |
| Universidad |

- Un [Investigador](README.md#investigador) puede ser `Doctor`. 
- Si es `Doctor` debe contener el `Título de la Tesis`, la `Fecha de Defensa` y la `Calificación` final (String).
- Si no es `Doctor` debe contener el `Título del Doctorado` matriculado.

### Beca
||
|:-------------|
| Nombre   |
| Cantidad |

**Relación N-N con Investigador**

- Un [Investigador](README.md#investigador) puede recibir varias [Becas](README.md#beca).
- Una [Beca](README.md#beca) puede ser percibida por varios [Investigadores](README.md#investigador).
- Una [Beca](README.md#beca) no puede ser percibida por Doctores.

### Congreso
| |
|:-------------|
| Nombre       |
| Ciudad       |
| Pais         |
| FechaInicio  |
| FechaFin     |

**Relación N-N con Investigador**

- Un [Congreso](README.md#congreso) puede ser visitador por varios [Investigadores](README.md#investigador).
- Un [Investigador](README.md#investigador) puede visitar varios [Congresos](README.md#congreso).

## Apartado 1: estructura (40%)
1. **Crear las entidades** que modelen este escenario
2. **Insertar datos de prueba** 
3. Proporcionar un **código que muestre el correcto almacenamiento**
de la información utilizando una clase similar al _DataLoader_ de los ejemplos del curso.


## Apartado 2: consultas
**Implementar** las siguientes **consultas**, mostrando sus
resultados a través del _DataLoader_. Además, es necesario que todas las consultas
devuelvan algún resultado:

###1. (10%) 
Listado con `nombre`, `apellidos` y `universidad` de todos los [Investigadores](README.md#investigador), ordenados por `universidad`, indicando si son `doctores` o no.

> Ej. de salida:
> 
>| Investigadores ordenados por universidad |
>|:-------------|
>|Harvard University - John Snow (Doctor)|
>|Universidad Complutense de Madrid - Iñaki Hidalgo (Doctor)|
>|Universidad Rey Juan Carlos - Juan Pérez (NO Doctor)|

### 2. (15%)
Dado el nombre de un [Congreso](README.md#congreso), `nombre` y `apellidos` de sus asistentes.

### 3. (15%) 
Dado el nombre de un [Congreso](README.md#congreso), número de asistentes por cada `universidad`, ordenados por nombre de universidad.

> Ej salida:
> 
> | Asistentes por universidad al congreso ICVNS |
> |-------------|
> | Harvard University: 1 |
> | Universidad Complutense de Madrid: 1 |
> | Universidad Rey Juan Carlos: 2 |

### 4.(20%)
Para cada [Investigador]() no `doctor`, mostrar su nombre y apellidos junto con el
   número de becas que ha percibido y la suma de dinero percibida. Ojo, los que no
   tienen beca deben aparecer. Una manera de resolverlo es usando una unión. 

> Ej. de salida:
>
> | Becario | Becas | Dinero |
> |---------|:-------:|--------:|
> |Juan Pérez   | 6 | 75000.0 |
> |Lucas Cavero | 0 | 0.0 |

```
Importante: todas las consultas se pueden implementar cargando la información en
memoria y luego filtrando/agrupando en Java. Por tanto, se valorará más que el
procesamiento de la información se haga en la consulta SQL.
```