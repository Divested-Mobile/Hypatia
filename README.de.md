Hypatia
=======

Übersicht
--------
Hypatia ist der weltweit erste FOSS-Malwarescanner für Android. Er basiert auf Signatur-Datenbanken im Stil von ClamAV.

Funktionen
--------
- Nahezu keine Auswirkungen auf den Akku: Sie werden keinerlei Auswirkungen auf den Akku bemerken
- Extrem schnell: kleine Dateien (1MB) werden in <20ms gescannt, große Dateien (40MB) in 1000ms.
- Speichereffizient: mit den standardmäßig aktivierten Datenbanken verbraucht Hypatia weniger als 120MB.
- Regelmäßiger Scan: erlaubt die Auswahl von /system, internem Speicher, externem Speicher und installierten Apps
- Echtzeit-Scanner: kann Malware in Echtzeit beim Schreiben/Umbenennen im internen Speicher erkennen
- Vollständig offline: Das Internet wird nur zum Herunterladen von Signatur-Datenbanken verwendet, die Dateien verlassen niemals Ihr Gerät
- Persistenz: automatischer Neustart beim Booten/Update
- Winzige Codebasis: mit weniger als 1000 sloc kann sie sogar von jemandem mit grundlegenden Programmierkenntnissen geprüft werden
- Minimale Abhängigkeiten: die App verwendet nur Bibliotheken, wenn es nötig ist
- Signatur-Datenbanken können auf Wunsch des Benutzers aktiviert/deaktiviert werden

Technische Details
------------------
- Signatur-Datenbanken sind in den Formaten ClamAV .hdb (MD5-Hashes) und .hsb (SHA-1/SHA-256)
- Signatur-Datenbanken werden nicht erneut heruntergeladen, wenn sich die Datei auf dem Server nicht geändert hat (Überprüfung mittels HTTP-Code 304 für nicht modifiziert)
- Signaturen werden mit HashMaps für O(1) Lookup gespeichert
- Dateien bekommen ihre MD5/SHA-1/SHA-256-Hashes in einem Durchgang berechnet
- Der Echtzeit-Scanner ist multithreaded und nutzt die Hälfte der Kernanzahl des Geräts für das asynchrone Scannen mehrerer Dateien
- Echtzeit-Scanning wird von einem rekursiven FileObserver unterstützt
- Es werden Netzwerkverbindungen zur Adressen nach dem Folgenden Muster hergestellt: https://divested.dev/MalwareScannerSignatures/*.h*b.gz

Geplante Updates
----------------
- Option zum Scannen beim Zugriff
- Option zur Quarantäne/Löschung bei Erkennung
- Scannen von Dateien über Share Intent
- Scannen neu installierter/aktualisierter Anwendungen
- Bessere GUI
- Übersetzungen
- Scannen des gesamten Systems mit Root (niedrige Priorität)

Ziele
-----
- Schnell sein
- Keine Akku-Lebensdauer verbrauchen
- So wenig Berechtigungen wie möglich verwenden
- Bibliotheken nur bei Bedarf verwenden

Credits (Lizenzen in Klammern)
-------
- ClamAV für die Datenbanken (GPLv2)
- ESET für die zusätzlichen Datenbanken (BSD 2-Clause)
- RecursiveFileObserver.java (GPLv3): Daniel Gultsch, ownCloud Inc. und Bartek Przybylski
- Icons (Apache-2.0): Google/Android/AOSP

Hinweise
-------
- Divested Computing Group ist in keinster Weise mit Cisco oder ESET verbunden
- Hypatia wird nicht von Cisco oder ESET gesponsert oder unterstützt
