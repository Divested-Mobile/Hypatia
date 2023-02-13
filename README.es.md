![Banner](https://divestos.org/images/featureGraphics/Hypatia.png)

Hypatia
=======

Resumen
--------
Hypatia es el primer escáner de malware FOSS del mundo para Android. Funciona con bases de datos de firmas al estilo de ClamAV.

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
     alt="Get it on F-Droid"
     height="80">](https://f-droid.org/packages/us.spotco.malwarescanner/)

Características
---------------
- Impacto casi nulo en la batería: no notará prácticamente ningún impacto en la batería
- Extremadamente rápido: puede escanear archivos pequeños (1MB) en <20ms, e incluso archivos grandes (40MB) en 1000ms.
- Memoria eficiente: con las bases de datos activadas por defecto utiliza menos de 120 MB.
- Análisis periódicos: permite seleccionar /sistema, almacenamiento interno, almacenamiento externo y aplicaciones instaladas
- Escáner en tiempo real: puede detectar el malware en tiempo real al escribir/renombrar en el almacenamiento interno
- Completamente offline: Internet sólo se utiliza para descargar las bases de datos de firmas, los archivos nunca saldrán de su dispositivo
- Persistencia: se reiniciará automáticamente al arrancar/actualizar
- Código base minúsculo: con menos de 1.000 sloc, puede ser auditado incluso por alguien con experiencia básica en programación
- Dependencias mínimas: la aplicación sólo utiliza librerías cuando es necesario
- Las bases de datos de firmas pueden activarse o desactivarse a petición del usuario

Detalles técnicos
-----------------
- Las bases de datos de firmas tienen formato ClamAV .hdb (hashes MD5) y .hsb (SHA-1/SHA-256)
- Las bases de datos de firmas no se volverán a descargar si el archivo no ha cambiado en el servidor (304 no modificado)
- Las firmas se almacenan utilizando HashMaps para O(1) su consulta
- Los hashes MD5/SHA-1/SHA-256 de los archivos se calculan de una sola vez
- El escáner en tiempo real es multihilo y utilizará la mitad del número de núcleos del dispositivo para escanear múltiples archivos de forma asíncrona
- El escaneo en tiempo real es impulsado por un FileObserver recursivo
- Se realizarán conexiones de red a la siguiente dirección: https://divested.dev/MalwareScannerSignatures/*.h*b.gz

Actualizaciones previstas
-------------------------
- Opción de escanear al acceder
- Opción de cuarentena/eliminación en caso de detección
- Escanear archivos al intentar compartirlos
- Escanear aplicaciones recién instaladas/actualizadas
- Opción de permitir que aplicaciones de terceros invoquen escaneos
- Soporte de bases de datos personalizadas
- Actualización automática de bases de datos
- Generación automática de bases de datos
- Generación de bases de datos en el lado del cliente
- Verificación de la firma de las bases de datos
- Comprobación de la integridad de la base de datos
- Pruebas
- Mejorar la GUI
- Traducciones
- Escaneo de todo el sistema usando root (prioridad baja)

Objetivos
-----
- Que sea rápido
- No gastar mucha batería
- Utilizar permisos mínimos
- Utilizar librerías sólo cuando sea necesario

Créditos
--------
- ClamAV por las bases de datos (GPLv2)
- ESET por las bases de datos extra (BSD 2-Clause)
- Nex (@botherder) por las bases de datos adicionales (CC BY-SA 4.0)
- Amnistía Internacional por las bases de datos adicionale (CC BY 2.0)
- RecursiveFileObserver.java (GPLv3): Daniel Gultsch, ownCloud Inc., Bartek Przybylski
- Petra Mirelli por las traducciones al alemán/español/italiano, el gráfico del banner/característica de la aplicación y varios retoques.
- Jean-Luc Tibaux y Petra Mirelli por las traducciones al francés.
- @srccrow por las traducciones al italiano.
- @inkhorn por las traducciones al portugués.
- @jontaix por las traducciones al portugués.
- @q1011 por las traducciones al ruso.
- Oswald van Ginkel por las traducciones al afrikaans.
- huuhaa por las traducciones al finé.
- Marcin Mikołajczak por las traducciones al polaco.
- Manuel-Senpai por las traducciones al español.
- Iconos: Google/Android/AOSP, Licencia: Apache 2.0, https://google.github.io/material-design-icons/

Notas
-----
- Divested Computing Group no está afiliado a Cisco ni a ESET
- Hypatia no está patrocinado ni respaldado por Cisco o ESET

Donar
-----
- https://divested.dev/donate
