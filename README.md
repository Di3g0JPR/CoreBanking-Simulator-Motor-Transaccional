##  Descripción del Proyecto
Sistema backend desarrollado en Java que simula el procesamiento por lotes (batch processing) de un motor bancario tradicional. El proyecto está enfocado en la validación de reglas de negocio financieras, conciliación de saldos y aplicación de protocolos de seguridad transaccional sobre estructuras de datos multidimensionales.

El objetivo principal de esta herramienta es garantizar la integridad de las cuentas de los clientes, previniendo sobregiros (saldos negativos) y alertando sobre comportamientos anómalos.

##  Funcionalidades Principales
* **Auditoría Antifraude (Security Alert):** Implementación de un algoritmo de búsqueda lineal sobre la matriz de transacciones para aislar y detectar el movimiento de egreso más extremo (mínimo absoluto), emitiendo una alerta preventiva de bloqueo de cuenta.
* **Conciliación de Saldos y Overdraft Protection:** Motor de procesamiento que cruza los saldos base (Array 1D) con los movimientos semanales (Array 2D). Incorpora compuertas lógicas condicionales (`if/else`) que rechazan y revierten automáticamente cualquier transacción que vulnere el límite de saldo cero.
* **Módulo de Transferencias Seguras:** Interfaz transaccional protegida por validación estricta de estado (`while` loop). El sistema evalúa dos vectores de riesgo en simultáneo: prohíbe la transferencia de montos negativos/nulos y valida la liquidez suficiente en la cuenta de origen antes de ejecutar el débito.

##  Tecnologías y Conceptos Aplicados
* **Lenguaje:** Java
* **Estructuras de Datos:** Vectores Paralelos y Matrices (Arrays 1D y 2D).
* **Lógica Algorítmica:** Reducción de datos, contadores condicionales y búsqueda de valores críticos.
* **Seguridad (Defensive Programming):** Control de flujo estricto para mitigar errores de usuario y asegurar la consistencia financiera.

##  Cómo ejecutar el proyecto
1. Clonar el repositorio en el entorno local.
2. Compilar los archivos ejecutando el comando:
   `javac MainBanco.java LogicaBancaria.java`
3. Ejecutar el motor de procesamiento nocturno:
   `java MainBanco`# CoreBanking-Simulator-Motor-Transaccional
