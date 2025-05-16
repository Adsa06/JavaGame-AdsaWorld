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
2. **Asegúrate de que la base de datos MySQL esté creada y configurada antes de ejecutar el juego** (ver apartado "Base de Datos" más abajo).
3. Ejecuta la clase principal con el siguiente comando:
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

## Base de Datos

Este proyecto utiliza **MySQL** como sistema de gestión de base de datos para almacenar los usuarios y sus credenciales.

### Pasos para configurar la base de datos:

1. **Instala MySQL** si aún no lo tienes en tu sistema.
2. Abre tu cliente de MySQL (puede ser MySQL Workbench, consola, DBeaver, etc.).
3. Ejecuta el script SQL que se encuentra en la raíz del proyecto:  
   [`adsaworldDB.sql`](./adsaworldDB.sql)
   ```sql
   -- Ejemplo de ejecución desde la terminal de MySQL:
   SOURCE /ruta/a/tu/proyecto/javagame-adsaworld/adsaworldDB.sql;
   ```
4. El script creará la base de datos `adsaworldDB` y la tabla `usuarios` necesaria para el funcionamiento del juego.
5. Si necesitas cambiar el usuario, contraseña o el nombre de la base de datos, edita el archivo `config.properties` en la carpeta resources para que coincidan con tu configuración local.

> **Nota:**  
> El juego no funcionará correctamente si la base de datos no está creada o las credenciales no son correctas.

## Licencia

Este proyecto está licenciado bajo la licencia MIT.  
Consulta el archivo [`LICENSE`](./LICENSE) para más detalles.

```
MIT License

Copyright (c) 2025 Adsa06

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```