#  CoreBanking Simulator: Motor Transaccional con Persistencia JDBC

##  Descripción del Proyecto
Sistema backend desarrollado en Java que simula el procesamiento y validación de transacciones bancarias. El proyecto evolucionó de una validación lógica en memoria a una **Arquitectura de 3 Capas**, integrando persistencia de datos en una base de datos relacional MySQL contenerizada en Docker.

El objetivo es garantizar la integridad de las cuentas, previniendo sobregiros y registrando cada movimiento aprobado de forma inmutable y segura en el servidor.

##  Funcionalidades Principales
* **Capa de Lógica (Core Banking):** Motor de procesamiento con compuertas condicionales que evalúan liquidez y previenen saldos negativos en transferencias.
* **Auditoría Antifraude:** Algoritmo lineal sobre matrices para aislamiento y detección preventiva de egresos anómalos.
* **Persistencia Segura (Database):** Conexión automatizada mediante JDBC a MySQL. 
* **Prevención de Inyecciones SQL:** Implementación de `PreparedStatement` en las sentencias `INSERT` para sanitizar las entradas y proteger la base de datos contra ataques transaccionales.

##  Stack Tecnológico
* **Lenguaje:** Java (Lógica de negocio y control de flujo).
* **Bases de Datos:** MySQL (Ejecutado en entorno aislado con Docker).
* **Conectividad:** JDBC (Java Database Connectivity).
* **Estructuras:** Matrices bidimensionales y vectores para evaluación de saldos en caliente.

##  Entorno de Ejecución
1. Levantar el contenedor de la base de datos:
   `docker run --name portfolio-mysql -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=portfolio_db -p 3306:3306 -d mysql:8.0`
2. Compilar el código integrando el driver JDBC:
   `javac -cp ".;lib/*" *.java`
3. Ejecutar el motor principal:
   `java -cp ".;lib/*" MainBanco`
