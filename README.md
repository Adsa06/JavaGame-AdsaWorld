# JavaGame-AdsaWorld

Este juego esta diseñado para aprender sobre implementacion y uso de librerias, actualmente solo se esta utilizando JavaFX

| Detalle               | Información       |
|-----------------------|-------------------|
| **Autor**             | Aitor             |
| **Fecha de inicio**   | 13/01/2025        |
| **Última revisión**   | 20/01/2025        |

## Contenido del Proyecto

- **Versión 1 (`App.java`)**: Actualmente solo esta implementado las funciones de moverse en una cierta area limitada


## Estructura del Proyecto

```plaintext
JavaGame-AdsaWorld_Proyect/
    JavaGame-AdsaWorld_src/
        README.md          # Este archivo
        Sprites/           # Carpeta donde estan todas las imagenes
        src/               # Carpeta con el código fuente
            App.java        # Inicializacion del videojuego
            Interfaz.java   # Archivo principal del videojuego
            Clases/         # Carpeta en la que estan las clases del programa
                Player.java # Clase para inicializar el personaje

Archivos no subidos a GitHub
        .vscode             # Configuracion del proyecto para el IDE (launch y settings)
        lib/                # Librerias requeridas (JavaFX 21.0.6)
        bin/                # Carpeta donde se compila el programa
```

## Requisitos del Sistema

- **Java Development Kit (JDK)** versión 21 o superior.
- Entorno de desarrollo integrado (IDE) recomendado: Visual Studio Code.

## Instrucciones de Ejecución

1. Abre el proyecto en **Visual Studio Code**.
2. Asegúrate de que JDK 21 esté correctamente configurado.
3. Ve a la carpeta `src/` y selecciona el archivo que deseas ejecutar (`TresEnRayav1.java` o `TresEnRayav2.java`).
4. Compila y ejecuta el programa:


## Funcionalidades Principales

- **Tablero dinámico**: Se muestra un tablero actualizado después de cada turno.
- **Validaciones**: Impide movimientos inválidos (casillas ocupadas o fuera de rango).
- **Condiciones de victoria**: Verifica automáticamente si un jugador ha ganado.
- **Empate**: Detecta si el tablero se llena sin un ganador.
- **Colores**: Diferencia los símbolos `X` y `O` mediante colores (rojo y azul).

## Notas Adicionales

Este proyecto está diseñado para que los estudiantes aprendan:

- **Modularización**: Descomposición del programa en métodos.
- **Documentación**: Creación de un análisis técnico del software.
- **Uso de herramientas modernas**: Familiarización con Visual Studio Code y JDK 21.
