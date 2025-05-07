# Juego de Snake en Consola

## Información General
[Enlace al repositorio de git](https://github.com/Adsa06/JavaGame-AdsaWorld)   
[Enlace al documento de Especificaciones y Analisis](https://1drv.ms/w/c/c48b354083f5dd20/EWm3SnBJsz1MjxlrfQZ7IVQB_qOpL4Cxqa7QVm7hX2AQqg?e=kDD7qM)

| Detalle              | Información       |
|----------------------|-------------------|
| **Autor**            | Aitor de Santos   |
| **Fecha de inicio**  | 07/05/2025        |
| **Última revisión**  | v1 07/05/2025     |

Enlace al repositorio de git: 
## Estructura del Proyecto

El proyecto está dividido en varios archivos Java organizados en:

```plaintext
javagame-adsaworld/
├── README.md                       # Este archivo
├── src/
│   └── main/java/dev/adsa/
│       └── App.java                 # Clase principal del juego
│
└── pom.xml                         # Archivo de configuración de Maven
```

## Requisitos del Sistema

- **Java Development Kit (JDK)** versión 21 o superior.
- **Maven** para la gestión de dependencias.
- Una terminal en el sistema (CMD, PowerShell, etc.).

## Compilación y Ejecución

### Compilación con Maven

1. Abre una terminal y dirigete a la raiz del proyecto `javagame-adsaworld/`.
2. Ejecuta el siguiente comando para compilar el proyecto:
   ```bash
   mvn clean compile
   ```
3. Esto generará los archivos `.class` en la carpeta `target/`.

### Ejecución del Juego

1. Abre una terminal y dirigete a la raiz del proyecto `javagame-adsaworld/`.
2. En la primera terminal, ejecuta la clase principal:
   ```bash
   mvn javafx:run
   ```
   O el siguiente si quieres compilar y ejecutar al mismo tiempo:
   ```bash
   mvn clean javafx:run
   ```

### Creacion del javadoc con maven

1. Abre una terminal  y dirigete a la raiz del proyecto `javagame-adsaworld/`.
2. Ejecuta el siguiente comando para crear la documentacion del proyecto:
   ```bash
   mvn javadoc:javadoc
   ```
3. Esto generará los archivos necesarios en la carpeta `target\reports\apidocs\`.

### Creacion del .jar con VSCode

En el IDE, en el apartado de JAVA PROJECTS hay un boton para exprotar automaticamente como .jar
Estos se te crearan en la raiz del proyecto, para ejecutarlos abra la terminal y ejecute este comando:
   ```bash
   java -jar nombredelarchivo.jar
   ```

## Notas Adicionales

Este proyecto está diseñado para aprender y mejorar en:

- **Modularización**: Descomposición del programa en métodos.
- **Documentación**: Creación de un análisis técnico del software.
- **Uso de herramientas modernas**: Familiarización con Visual Studio Code, JDK 21, Maven y MySQL.