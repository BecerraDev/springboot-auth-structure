Hola comunidad de GitHub!

Este es un proyecto simple que desarrollé para practicar autenticación en Spring Boot. 
Incluye funcionalidades de inicio de sesión y registro de usuarios, utilizando Spring Security y JWT (JSON Web Tokens).

La estructura base que seguí fue -> auth/login y auth/register

Tuve una mejor comprensión de cómo implementar el login usando anotaciones como 
@Service y @Controller, y utilicé @Builder para construir los objetos de las solicitudes (Request).

También comprendí mejor el manejo de las dependencias. Si una dependencia está desactualizada, puede generar errores y hacer que las anotaciones dejen de funcionar correctamente. Esto fue lo que me ocurrió con Lombok.
ChatGPT no fue tan útil en términos de código, solo ayudó para entender los conceptos. El código proporcionado generaba muchos errores, principalmente debido a la base de datos de la IA, código desactualizado, errores en las anotaciones y varias cosas redundantes.

Siguiente termino, Utilicé el patrón Modelo-Vista-Controlador (MVC), separando el código en las capas correspondientes: Entity, Repositorio, Service y Controller. 
La base de datos se creó a través de tablas Entity, utilizando Hibernate para el mapeo objeto-relacional. En el proceso, asigné campos específicos como llaves primarias e índices
