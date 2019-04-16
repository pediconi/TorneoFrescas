#TP1


Que es maven?
Maven es una herramienta de software para la gestión y construcción de proyectos Java creada por Jason van Zyl, de Sonatype, en 2002. Es similar en funcionalidad a Apache Ant (y en menor medida a PEAR de PHP y CPAN de Perl), pero tiene un modelo de configuración de construcción más simple, basado en un formato XML. Estuvo integrado inicialmente dentro del proyecto Jakarta pero ahora ya es un proyecto de nivel superior de la Apache Software Foundation.

POM que significa y para que sirve?
POM significa modelo de origen de proyecto
Permite la creacion de librerias o archivos de configuracion XML que podran ser reutilizados por distintos proyectos.

Diferencia entre archetype y artifactid
Archetype es un conjunto de herramientas de maquetación de proyectos de Maven. Es un patron original a partir del cual se hacen todos los objetos del mismo tipo.
ArtifcactID hace referencia al nombre del jar que no tiene version. Si usamos esto, podemos elegir el nombre que queramos con letras minusculas y no simbolos raros.

Goals:
  -Clean : permite limpiar y borrar archivos que hayan quedado de un "build" anterior.
  -package : paquete de codigo fuente compilado en el formato distribuible (.jar war)
  -install: instalacion del paquete en un repositorio local
  -compile : compilacion el codigo fuente.
 
Scopes:
  -compile: es el scope por defecto cuando no se definio otro scope. Las dependencias con este alcance están disponibles en la ruta de clase del proyecto.
  -provide: Este scope es usado para marcar dependencias que deberian ser proporcionadas en tiempo de ejecucion por JDK o un contenedor.
  -runtime: 
Las dependencias con este scope son necesarias en tiempo de ejecución, pero no son necesarias para la compilación del código del proyecto
  -test: 
Este alcance se usa para indicar que la dependencia no es necesaria en el tiempo de ejecución estándar de la aplicación, pero se usa solo para fines de prueba
  -system: El alcance del sistema es muy similar al alcance proporcionado. 
La principal diferencia entre estos dos scopes es que el sistema nos obliga a apuntar directamente a un jar específico en el sistema.




