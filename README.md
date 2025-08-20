# Foro Alura - API REST

## Descripción

Este proyecto es una API REST para un sistema de foro, desarrollada como parte del Challenge de Alura Latam y Oracle ONE (Oracle Next Education). La API permite a los usuarios crear, leer, actualizar y eliminar tópicos del foro, siguiendo las mejores prácticas de desarrollo con Spring Boot.

## Funcionalidades

- **Crear un nuevo tópico.**
- **Listar todos los tópicos activos** (con paginación).
- **Mostrar un tópico específico** por su ID.
- **Actualizar un tópico** existente.
- **Eliminar un tópico** (eliminación lógica).

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Maven** como gestor de dependencias.
- **PostgreSQL** como base de datos.
- **Flyway** para migraciones de base de datos.
- **Spring Data JPA** para la persistencia de datos.
- **Spring Web** para la creación de los endpoints REST.
- **Lombok** para reducir código repetitivo.

---

## Preparación del Entorno

Para poder ejecutar este proyecto, necesitarás tener instalado lo siguiente:

1.  **JDK 17 (Java Development Kit 17)**.
2.  **Apache Maven**.
3.  **PostgreSQL**.
4.  Un **IDE** de tu preferencia (ej. IntelliJ IDEA, Eclipse, VS Code).
5.  Un **cliente de API** para probar los endpoints (ej. Insomnia, Postman).

---

## Configuración y Ejecución

Sigue estos pasos para configurar y levantar el proyecto en tu máquina local (las instrucciones son válidas para **Windows, macOS y Linux**).

### 1. Clonar el Repositorio

Clona este repositorio en tu máquina local usando el siguiente comando:
```bash
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_DIRECTORIO>
```
**Nota:** Deberás reemplazar `<URL_DEL_REPOSITORIO>` y `<NOMBRE_DEL_DIRECTORIO>` con los valores correspondientes.

### 2. Configurar la Base de Datos

1.  Abre tu cliente de PostgreSQL y crea una nueva base de datos. Puedes llamarla `foro_alura`.
    ```sql
    CREATE DATABASE foro_alura;
    ```
2.  Abre el archivo `src/main/resources/application.properties`.
3.  Modifica las siguientes líneas con la URL de tu base de datos, tu usuario y tu contraseña:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/foro_alura
    spring.datasource.username=tu_usuario_de_postgres
    spring.datasource.password=tu_contraseña_de_postgres
    ```

### 3. Ejecutar la Aplicación

Puedes ejecutar la aplicación de dos maneras:

**A) Desde tu IDE:**
- Importa el proyecto como un proyecto de Maven.
- Busca la clase `ForoAluraApplication.java` en `src/main/java/com/alura/foro`.
- Haz clic derecho y selecciona "Run" o "Debug".

**B) Desde la línea de comandos (usando Maven):**
- Abre una terminal o consola en la raíz del proyecto.
- Ejecuta el siguiente comando:
  ```bash
  mvn spring-boot:run
  ```
La API se iniciará y estará disponible en `http://localhost:8080`. La primera vez que se ejecute, Flyway creará automáticamente la tabla `topicos` en tu base de datos.

---

## Endpoints de la API

La colección de endpoints se encuentra en la ruta base `/topicos`.

### 1. Registrar un nuevo tópico

- **Método:** `POST`
- **URL:** `/topicos`
- **Body (JSON):**
  ```json
  {
    "titulo": "Duda sobre Spring Security",
    "mensaje": "¿Cómo puedo implementar autenticación JWT?",
    "autor": "Ana",
    "curso": "Spring Boot"
  }
  ```
- **Respuesta exitosa (201 Created):** Devuelve el tópico recién creado.

### 2. Listar tópicos

- **Método:** `GET`
- **URL:** `/topicos`
- **Parámetros de consulta (opcionales):**
  - `size`: Número de elementos por página.
  - `page`: Número de la página a mostrar (empieza en 0).
  - `sort`: Campo por el cual ordenar (ej. `fechaCreacion,desc`).
- **Respuesta exitosa (200 OK):** Devuelve una página con la lista de tópicos activos.

### 3. Ver un tópico específico

- **Método:** `GET`
- **URL:** `/topicos/{id}`
- **Respuesta exitosa (200 OK):** Devuelve los detalles del tópico solicitado.

### 4. Actualizar un tópico

- **Método:** `PUT`
- **URL:** `/topicos/{id}`
- **Body (JSON):** (Solo incluye los campos que deseas modificar)
  ```json
  {
    "titulo": "Duda resuelta sobre Spring Security",
    "mensaje": "Ya entendí cómo implementar autenticación JWT. ¡Gracias!"
  }
  ```
- **Respuesta exitosa (200 OK):** Devuelve el tópico con los datos actualizados.

### 5. Eliminar un tópico

- **Método:** `DELETE`
- **URL:** `/topicos/{id}`
- **Respuesta exitosa (204 No Content):** No devuelve contenido.
