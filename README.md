# Juego de Snake en Consola

## Información General
[Enlace al repositorio de Git](https://github.com/Adsa06/JavaGame-AdsaWorld)  
[Enlace al documento de Especificaciones y Análisis](https://1drv.ms/w/c/c48b354083f5dd20/EWm3SnBJsz1MjxlrfQZ7IVQB_qOpL4Cxqa7QVm7hX2AQqg?e=kDD7qM)

| Detalle              | Información       |
|----------------------|-------------------|
| **Autor**            | Aitor de Santos   |
| **Fecha de inicio**  | 07/05/2025        |
| **Última revisión**  | v1 07/05/2025     |

## Estructura del Proyecto

El proyecto está dividido en varios archivos Java organizados de la siguiente manera:

```plaintext
javagame-adsaworld/
├── README.md                       # Este archivo
├── src/main/
│        ├── java/dev/adsa/
│        │   ├── Main.java               # Clase principal de la aplicación
│        │   ├── controlador/
│        │   │   └── Contador.java       # Lógica del contador
│        │   ├── modelo/
│        │   │   └── MainController.java # Controlador principal
│        │   ├── utils/
│        │   │   └── GestorIdioma.java   # Gestión de idiomas
│        │   └── vista/
│        │       └── MainView.java       # Vista principal
│        └── resources/
│            ├── estilos/
│            │   └── estilo.css          # Estilos CSS
│            └── i18n/
│                ├── messages_en.properties # Textos en inglés
│                └── messages_es.properties # Textos en español
└── pom.xml                         # Archivo de configuración de Maven
```

## Requisitos del Sistema

- **Java Development Kit (JDK)** versión 21 o superior.
- **Maven** para la gestión de dependencias.
- Una terminal en el sistema (CMD, PowerShell, etc.).

## Compilación y Ejecución

### Compilación con Maven

1. Abre una terminal y dirígete a la raíz del proyecto `javagame-adsaworld/`.
2. Ejecuta el siguiente comando para compilar el proyecto:
   ```bash
   mvn clean compile
   ```
3. Esto generará los archivos `.class` en la carpeta `target/`.

### Ejecución del Juego

1. Abre una terminal y dirígete a la raíz del proyecto `javagame-adsaworld/`.
2. Ejecuta la clase principal con el siguiente comando:
   ```bash
   mvn javafx:run
   ```
   O, si deseas compilar y ejecutar al mismo tiempo:
   ```bash
   mvn clean javafx:run
   ```

### Creación del Javadoc con Maven

1. Abre una terminal y dirígete a la raíz del proyecto `javagame-adsaworld/`.
2. Ejecuta el siguiente comando para generar la documentación del proyecto:
   ```bash
   mvn javadoc:javadoc
   ```
3. Esto generará los archivos necesarios en la carpeta `target/reports/apidocs/`.

### Creación del .jar con VSCode

En el IDE, en el apartado de **JAVA PROJECTS**, hay un botón para exportar automáticamente como `.jar`.  
Estos archivos se crearán en la raíz del proyecto. Para ejecutarlos, abre la terminal y ejecuta este comando:
   ```bash
   java -jar nombredelarchivo.jar
   ```

## Notas Adicionales

Este proyecto está diseñado para aprender y mejorar en:

- **Modularización**: Descomposición del programa en métodos.
- **Documentación**: Creación de un análisis técnico del software.
- **Uso de herramientas modernas**: Familiarización con Visual Studio Code, JDK 21, Maven, MySQL y JavaFX.