# Proyecto de Autenticación con Spring Boot 

## Descripción 
Este proyecto es una práctica para implementar autenticación de usuarios utilizando **Spring Boot**. Incluye funcionalidades de inicio de sesión y registro de usuarios, haciendo uso de **Spring Security** y **JWT (JSON Web Tokens)** para gestionar la seguridad y autorización.

---

## Estructura del proyecto 
- Endpoints base:  
  - `/auth/login` — para iniciar sesión  
  - `/auth/register` — para registrar nuevos usuarios  
- Uso de anotaciones como `@Service` y `@Controller` para separar responsabilidades.  
- Empleo de `@Builder` para construir objetos de solicitud (Request).  

---

## Tecnologías y patrones usados 🛠️
- **Java 17+**  
- **Spring Boot**  
- **Spring Security**  
- **JWT (JSON Web Tokens)**  
- **Hibernate** para el mapeo objeto-relacional (ORM)  
- **Patrón Modelo-Vista-Controlador (MVC)**:  
  - Capa Entity  
  - Capa Repository  
  - Capa Service  
  - Capa Controller  

---

## Aprendizajes y detalles importantes 
- Comprendí mejor el uso y la integración de anotaciones (`@Service`, `@Controller`, `@Builder`) para estructurar el código.  
- El manejo de dependencias es fundamental: una versión desactualizada puede generar errores en anotaciones y fallos en compilación, como fue el caso con **Lombok**.  

---

## Uso y ejecución 
1. Clonar repositorio  
2. Configurar base de datos en `application.properties`  
3. Ejecutar con:  
   ```bash
   mvn spring-boot:run

