Hypatia
=======

Übersicht
--------
Hypatia ist der weltweit erste FOSS-Malwarescanner für Android. Er basiert auf Signaturdatenbanken im Stil von ClamAV.

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
     alt="Hypatia im F-Droid open source app store"
     height="80">](https://f-droid.org/packages/us.spotco.malwarescanner/)

Funktionen
--------
- Nahezu keine Auswirkungen auf den Akku: Sie werden keinerlei Auswirkungen auf den Akku bemerken
- Extrem schnell: kleine Dateien (1MB) werden in <20ms gescannt, große Dateien (40MB) in 1000ms.
- Speichereffizient: mit den standardmäßig aktivierten Datenbanken verbraucht es weniger als 120MB.
- Regelmäßiger Scan: erlaubt die Auswahl von /system, internem Speicher, externem Speicher und installierten Apps
- Echtzeit-Scanner: kann Malware in Echtzeit beim Schreiben/Umbenennen im internen Speicher erkennen
- Vollständig offline: Das Internet wird nur zum Herunterladen von Signaturdatenbanken verwendet, die Dateien verlassen niemals Ihr Gerät
- Persistenz: automatischer Neustart beim Booten/Update
- Winzige Codebasis: mit weniger als 1000 Sloc kann sie sogar von jemandem mit grundlegenden Programmierkenntnissen geprüft werden
- Minimale Abhängigkeiten: die App verwendet nur Bibliotheken, wenn es nötig ist
- Signaturdatenbanken können auf Wunsch des Benutzers aktiviert/deaktiviert werden

Technische Details
------------------
- Signaturdatenbanken sind ClamAV .hdb (MD5-Hashes) und .hsb (SHA-1/SHA-256) Format
- Signaturdatenbanken werden nicht erneut heruntergeladen, wenn sich die Datei auf dem Server nicht geändert hat (HTTP-Code 304 -> nicht modifiziert)
- Signaturen werden mit HashMaps für O(1) Lookup gespeichert
- Dateien haben ihre MD5/SHA-1/SHA-256-Hashes in einem Durchgang berechnet
- Der Echtzeit-Scanner ist multithreaded und nutzt die Hälfte der Kernanzahl des Geräts für das asynchrone Scannen mehrerer Dateien
- Echtzeit-Scanning wird von einem rekursiven FileObserver unterstützt
- Netzwerkverbindungen werden zu Adressen nach dem Folgendem Muster hergestellt: https://divested.dev/MalwareScannerSignatures/*.h*b.gz

Geplante Updates
----------------
- Option zum Scannen beim Zugriff
- Option zur Quarantäne/Löschung bei Erkennung
- Scannen von Dateien über Share Intent
- Scannen neu installierter/aktualisierter Anwendungen
- Option zum Aufrufen von Scans durch Drittanbieter-Apps
- Unterstützung für benutzerdefinierte Datenbanken
- Automatische Datenbank-Updates
- Automatische Datenbankerstellung
- Client-seitige Datenbank-Generierung
- Datenbank-Sanity-Checks
- Prüfung
- Bessere GUI
- Übersetzungen
- Scannen des gesamten Systems mit root (niedrige Priorität)

Ziele
-----
- Schnell sein
- Minimaler Akkuverbrauch
- Das nötige Minimum an Berechtigungen verwenden
- Bibliotheken nur bei Bedarf verwenden

Credits
-------
- ClamAV für die Datenbanken (GPLv2)
- ESET für die zusätzlichen Datenbanken (BSD 2-Clause)
- RecursiveFileObserver.java (GPLv3): Daniel Gultsch, ownCloud Inc. und Bartek Przybylski
- Petra Mirelli (@iNtEgraIR2021) für die deutsche/spanische/italienische Übersetzung, das App-Banner/Feature-Grafik und verschiedene Optimierungen.
- Jean-Luc Tibaux und Petra Mirelli (@iNtEgraIR2021) für die französischen Übersetzungen.
- @srccrow für die italienischen Übersetzungen.
- @inkhorn für die portugiesischen Übersetzungen.
- @q1011 für die russischen Übersetzungen.
- Icons: Google/Android/AOSP, Lizenz: Apache 2.0, https://google.github.io/material-design-icons/

Hinweise
-------
- Divested Computing Group ist nicht mit Cisco oder ESET verbunden
- Hypatia wird nicht von Cisco oder ESET gesponsert oder unterstützt

Spenden
-------
-------
- https://divested.dev/donate
