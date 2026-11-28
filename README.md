1. Título del proyecto
Sistema de Gestión para Clínica Oftálmica

2. Descripción

Aplicación de consola desarrollada en Java diseñada para administrar las operaciones diarias de una clínica oftálmica aplicando estructuras de datos fundamentales. El sistema permite:

-Gestionar el personal administrativo y doctores (registro, búsqueda, eliminación por ID, filtrado por especialidad y consulta de disponibilidad).

-Registrar pacientes con nivel de prioridad y administrar tanto la fila de espera regular (FIFO mediante Queue / LinkedList) como la fila de emergencias (atención por prioridad mediante PriorityQueue).

-Concertar y cancelar citas, evitar choques de horario entre un mismo doctor o paciente, consultar las citas del día y asignar pacientes a doctores.

-Registrar visitas médicas (signos vitales y notas), consultar el historial clínico por paciente y revisar las citas completadas más recientes (LIFO mediante Stack).

3. Instalación

Paso 1: 
Asegúrate de tener instalado el Java Development Kit (JDK) (JDK 11 o superior recomendado) y de que los comandos javac y java estén configurados en el PATH del sistema.

Paso 2: Clona o descarga el repositorio:
git clone <https://github.com/Orang3lis/Sistema-Oftalmico-DS.git>

Paso 3: Verifica la estructura de archivos:
Sistema-Oftalmico-DS/
├── src/
│   ├── Main.java
│   ├── methods/
│   │   └── ClinicManager.java
│   └── objects/
│       ├── Cita.java
│       ├── Doctor.java
│       ├── Empleado.java
│       └── Paciente.java
├── .gitignore
└── README.md

Paso 4: Compila el proyecto desde la carpeta main(Sistema-Oftalmico-DS) enviando los archivos compilados a bin:
javac -d bin src\objects\*.java src\methods\*.java src\Main.java

Paso 5: 
Ejecuta la clase principal desde la terminal para abrir el menú interactivo de 21 opciones:
java -cp bin Main


4. Uso
Ejecuta Main.java desde VS Code o desde la terminal.

Ejemplo de flujo interactivo en consola:

================================
=== Clínica Oftálmica ===
================================
1. Registrar empleado
2. Buscar empleado
3. Agregar doctor
...
10. Agregar paciente a fila de espera
11. Ver fila de espera
12. Atender siguiente paciente
13. Agregar paciente a emergencias
14. Atender emergencia
15. Concertar cita
...
20. Ver historial clinico
21. Ver citas completadas recientes
0. Salir
================================
Seleccione una opción:

-Escribe el número de la opción deseada y presiona Enter para responder a cada solicitud de Scanner.


5. Configuración
-Consola interactiva en VS Code (integratedTerminal): Este programa lee entradas por teclado usando Scanner(System.in). Si ejecutas el código desde VS Code con el botón de Run/Debug, configura la consola integrada para poder escribir datos por teclado (en lugar de usar la pestaña Output, que es de solo lectura): "java.debug.settings.console": "integratedTerminal"

-Archivos ignorados en Git (.gitignore): Se recomienda mantener ignorados los archivos compilados (.class y la carpeta bin/) para no subir artefactos de compilación al repositorio: *.class
bin/

-Variables de entorno: Requiere que JAVA_HOME apunte a tu instalación del JDK y que %JAVA_HOME%\bin (o $JAVA_HOME/bin) esté incluido en la variable PATH.

6. Autores y agradecimientos

Autores: Anelis M. Mounier Lorenzo, Xoralys Moll Magriz y Dereck Y. Hernandez Ramirez.

Agradecimientos: Al equipo del proyecto y al curso por la guía en el diseño e implementación de las estructuras de datos. Se utiliza únicamente la biblioteca estándar de Java (java.util.* y java.time.LocalDate), sin librerías externas de terceros.
