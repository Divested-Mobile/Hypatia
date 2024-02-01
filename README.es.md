![Banner](https://divestos.org/images/featureGraphics/Hypatia.png)

Hypatia
=======

Visión general
--------
Hypatia es el primer escáner de código malicioso FOSS del mundo para Android. Funciona con bases de datos de firmas al estilo ClamAV.

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
     alt="Get it on F-Droid"
     height="80">](https://f-droid.org/packages/us.spotco.malwarescanner/)

Características
--------------
- Impacto casi nulo en la batería: no notará en absoluto ningún impacto en la batería.
- Extremadamente rápido: puede escanear archivos pequeños (1MB) en <20ms, e incluso archivos grandes (40MB) en 1000ms.
- Memoria eficiente: con las bases de datos activadas por defecto utiliza menos de 120MB.
- Escaneo regular: permite seleccionar /system, almacenamiento interno, almacenamiento externo y aplicaciones instaladas.
- Escaneo en tiempo real: puede detectar malware en tiempo real al escribir/renombrar en el almacenamiento interno.
- Completamente offline: Internet sólo se utiliza para descargar bases de datos de firmas, los archivos nunca saldrán de su dispositivo.
- Persistencia: se reiniciará automáticamente al arrancar/actualizar.
- Código base minúsculo: con menos de 1000 slocs, puede ser auditado incluso por alguien con experiencia básica en programación.
- Dependencias mínimas: la aplicación sólo utiliza bibliotecas cuando es necesario.
- Las bases de datos de firmas pueden activarse o desactivarse a petición del usuario.


Datos técnicos
--------------
- Las bases de datos de las firmas están en formato ClamAV .hdb (hashes MD5) y .hsb (SHA-1/SHA-256)
- Las bases de datos de las firmas no se volverán a descargar si el archivo no ha cambiado en el servidor (304 no modificado)
- Las firmas se almacenan utilizando BloomFilters para búsquedas O(k)
- Los hashes MD5/SHA-1/SHA-256 de los archivos se calculan en una sola pasada.
- El escáner en tiempo real es multihilo y utilizará la mitad del número de núcleos del dispositivo para escanear varios archivos de forma asíncrona.
- Escaneo en tiempo real impulsado por un FileObserver recursivo
- Se establecerán conexiones de red a: https://divested. dev/MalwareScannerSignatures/*. h*b. gz

Actualizaciones previstas
-----------------------
- Opción de escanear al acceder a la aplicación
- Escanear archivos a través de la intención de compartir
- Escanear aplicaciones recién instaladas/actualizadas
- Opción de permitir que aplicaciones de terceros invoquen escaneos
- Actualización automática de la base de datos
- Generación automática de bases de datos
- Comprobaciones de integridad de la base de datos
- Pruebas
- Mejor GUI
- Traducciones
- Escaneo de todo el sistema mediante root (prioridad baja)

Objetivos
---------
- Que sea rápido
- No consumir mucha batería
- Usar permisos mínimos
- Utilizar las bibliotecas sólo cuando sea necesario

Créditos
---------
- ClamAV por las bases de datos (GPLv2)
- ESET para las bases de datos extra (BSD 2-Clause)
- Nex (@botherder) para las bases de datos adicionales (CC BY-SA 4.0)
- Amnistía Internacional para las bases de datos adicionales (CC BY 2.0)
- Echap para las bases de datos adicionales (CC BY 4.0)
- MalwareBazaar para bases de datos adicionales (CC0)
- RecursiveFileObserver.java (GPL-3.0 o posterior): Daniel Gultsch, ownCloud Inc., Bartek Przybylski
- GPGDetachedSignatureVerifier.java (GPL-2.0-o-later): Federico Fissore, Arduino LLC
- Petra Mirelli por las traducciones alemán/español/italiano, el gráfico del banner/característica de la aplicación y varios retoques.
- Jean-Luc Tibaux y Petra Mirelli por las traducciones al francés.
- @srccrow por las traducciones al italiano.
- @inkhorn por las traducciones al portugués.
- @jontaix por las traducciones al portugués.
- @q1011 por las traducciones al ruso.
- Oswald van Ginkel por las traducciones al afrikaans.
- huuhaa por las traducciones al finés.
- Marcin Mikołajczak por las traducciones al polaco.
- @Manuel-Senpai por las traducciones al español.
- @Balthazar1234 por las traducciones al alemán.
- @Sdarfeesh para las traducciones al chino simplificado.
- @cardpuncher por las traducciones al francés y al turco.
- Tommaso Fonda por las traducciones al italiano.
- Dimitris Vagiakakos por las traducciones al griego.
- Iconos: Google/Android/AOSP, con licencia: Apache 2.0, https://google.github.io/material-design-icons/

Avisos
-------
- Divested Computing Group no está afiliado a Cisco ni a ESET
- Hypatia no está patrocinado ni respaldado por Cisco o ESET

Donar
-------
- https://divested.dev/donate
