Laboratorio VI - Creación de APIs REST
Información

Estudiante: Ashly Aquino

Sección: C

Curso: Programación II

Laboratorio: VI - Creación de APIs REST

Descripción

Este proyecto contiene el diseño y desarrollo de APIs REST utilizando Java y Spring Boot.

Las APIs permiten administrar diferentes recursos mediante métodos HTTP y solicitudes en formato JSON.

El laboratorio se divide en ejercicios de diseño y desarrollo de APIs para:

Libros
Cursos
Reservas de hotel

APIs implementadas
Libros - /api/libros

Permite administrar los libros de una biblioteca.

POST   /api/libros
GET    /api/libros
GET    /api/libros/buscar?titulo={titulo}
PUT    /api/libros/{id}
DELETE /api/libros/{id}
Cursos - /api/cursos

Permite administrar cursos universitarios.

POST   /api/cursos
GET    /api/cursos
GET    /api/cursos/buscar?codigo={codigo}
PUT    /api/cursos/{id}
DELETE /api/cursos/{id}
Reservas - /api/reservas

Permite administrar reservas de un hotel.

POST   /api/reservas
GET    /api/reservas
GET    /api/reservas/{id}
PUT    /api/reservas/{id}
PATCH  /api/reservas/{id}/cancelar
Diseño de las APIs

Los primeros ejercicios corresponden al diseño de las APIs utilizando archivos YAML basados en el estándar OpenAPI 3.0.3.

Los archivos de diseño son:

api-libros.yaml
api-cursos.yaml
api-reservas.yaml

Estos archivos contienen la definición de los endpoints, métodos HTTP, parámetros, solicitudes, respuestas y códigos de estado.

Tecnologías utilizadas
Java 21
Spring Boot 4.1.1
Spring Web MVC
Maven
REST API
OpenAPI
Swagger
Postman
Git
GitHub
Visual Studio Code

Estructura del proyecto

laboratorio6-apis/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── laboratorio6_apis/
        │           ├── Laboratorio6ApisApplication.java
        │           ├── controller/
        │           │   ├── LibroController.java
        │           │   ├── CursoController.java
        │           │   └── ReservaController.java
        │           ├── model/
        │           │   ├── Libro.java
        │           │   ├── Curso.java
        │           │   └── Reserva.java
        │           ├── service/
        │           │   ├── LibroService.java
        │           │   ├── CursoService.java
        │           │   └── ReservaService.java
        │           └── yaml/
        │               ├── api_libros.yaml
        │               ├── api_cursos.yaml
        │               └── api_reservas.yaml
        └── resources/
            └── application.properties

Pruebas

Las pruebas de las APIs fueron realizadas utilizando Postman.

Libros
Registrar libro
Consultar libros
Consultar libro por título
Actualizar libro
Eliminar libro
Cursos
Crear curso
Consultar cursos
Consultar curso por código
Actualizar curso
Eliminar curso
Reservas
Crear reserva
Consultar reservas
Consultar reserva por ID
Actualizar reserva
Cancelar reserva
Ejecución del proyecto

Para ejecutar el proyecto se debe tener instalado Java 21.

Desde la terminal, ubicada en la carpeta del proyecto, ejecutar:

.\mvnw.cmd spring-boot:run

La aplicación se ejecutará en:

http://localhost:8080

Swagger

La documentación de las APIs puede consultarse mediante Swagger en:

http://localhost:8080/swagger-ui/index.html

Almacenamiento

Los datos utilizados por las APIs se almacenan temporalmente en memoria mediante listas.

No se utiliza una base de datos, por lo que los datos se reinician al detener o reiniciar la aplicación.

Autor

Ashly Aquino

Ingeniería en Sistemas
