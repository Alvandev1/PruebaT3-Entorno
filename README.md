# PruebaT3-Entorno
Este repositorio ha sido creado con el fin de la prueba de recuperación del tercer trimestre de entorno de desarrollo, de parte del alumno Alfonso Ivan Barrios Buaiz
# GestorTurnos - Gestión de Turnos de Pacientes

## Descripción

Esta aplicación en Java permite gestionar los turnos de pacientes en una consulta médica, priorizando los casos según su nivel de urgencia:
- **Prioridad 1**: Alta
- **Prioridad 2**: Media
- **Prioridad 3**: Baja

Entre sus funcionalidades se incluyen:
- **Agregar Pacientes**: Añadir pacientes a una lista de espera con nombre, motivo de consulta y prioridad.
- **Atender Pacientes**: Seleccionar y remover el siguiente paciente a ser atendido, priorizando según el nivel de urgencia.
- **Consultar Pacientes por Prioridad**: Contar cuántos pacientes hay en cada nivel de prioridad.
- **Mostrar el Siguiente Paciente**: Obtener el nombre del paciente que será atendido a continuación.
- **Cancelar Turnos**: Permite cancelar un turno eliminando el paciente correspondiente por su nombre.

El proyecto está estructurado en tres packages principales:
- **Codigo**: Contiene el código original sin refactorizar para tener un mayor orden y ver las diferencias mejor, este contiene las dos clases `GestorTurnos` y `Paciente`.
- **Refactorizado**: Contiene la lógica de la aplicación dentro de las clases `GestorTurnos` y `Paciente`.
- **Test**: Contiene las pruebas unitarias (usando JUnit 5) y pruebas manuales para validar la funcionalidad.


## Requisitos

- **Java JDK 8** o superior.
- **JUnit 5 y eclipse** para la ejecución de pruebas unitarias (útil para integración en IDE o con herramientas de línea de comandos como Maven).

## Instrucciones de Compilación y Ejecución

### Descarga todos los archivos y crea un proyecto en eclipse, una vez creado pega las 3 carpetas y el archivo module-info.java dentro de tu carpeta src e importa la libreria Junit5 al proyecto

1. **Compilar el proyecto**  
   Navega al directorio raíz del proyecto y compila todas las clases. Por ejemplo, si deseas que las clases compiladas

## Plan de Pruebas e Incidencias

### Objetivo
Validar la correcta gestión de turnos de pacientes, asegurando que la prioridad funcione correctamente y los métodos sean robustos.

### Casos de Prueba
- Agregar paciente y verificar que sea listado correctamente.
- Obtener el siguiente paciente de acuerdo a la prioridad.
- Cancelar un turno y confirmar que ya no aparece en la lista.
- Atender pacientes en orden correcto.
- Contar pacientes por prioridad.

### Registro de Errores
| 04/06/2025 | Se eliminaban pacientes incorrectos al atender | Ajustado método `atenderPaciente()`
| 04/06/2025 | `obtenerCantidadPorPrioridad()` devolvía valores incorrectos | Se corrigió lógica de conteo

### Cobertura
Se han probado todos los métodos principales mediante pruebas unitarias y pruebas manuales.
