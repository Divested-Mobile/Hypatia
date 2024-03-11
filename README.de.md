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
- Manueller Scan: erlaubt die Auswahl von /system, internem Speicher, externem Speicher und installierten Apps
- Echtzeit-Scanner: kann Malware direkt bei neugeschriebenen oder unbenannten Dateien im internen Speicher erkennen
- Vollständig offline: Das Internet wird nur zum Herunterladen von Signaturdatenbanken verwendet, die Dateien verlassen niemals Ihr Gerät
- Persistenz: automatischer Neustart beim Booten/Update
- Winzige Codebasis: mit weniger als 1000 Sloc kann sie sogar von jemandem mit grundlegenden Programmierkenntnissen geprüft werden
- Minimale Abhängigkeiten: die App verwendet nur Bibliotheken, wenn es nötig ist
- Signaturdatenbanken können auf Wunsch des Benutzers aktiviert/deaktiviert werden

Technische Details
------------------
- Signaturdatenbanken sind im seriellem Guava-BloomFilter Objektformat
- Signaturdatenbanken werden nicht erneut heruntergeladen, wenn sich die Datei auf dem Server nicht geändert hat (HTTP-Code 304 -> nicht modifiziert)
- Signaturen werden mit BloomFilters für O(k) Lookup gespeichert
- Dateien haben ihre MD5/SHA-1/SHA-256-Hashes in einem Durchgang berechnet
- Der Echtzeit-Scanner ist multithreaded und nutzt die Hälfte der Kernanzahl des Geräts für das asynchrone Scannen mehrerer Dateien
- Echtzeit-Scanning mittels rekursivem FileObserver (Datei-Beobachter)
- Netzwerkverbindungen werden zu Adressen nach dem Folgendem Muster hergestellt: https://divested.dev/MalwareScannerSignatures/hypatia-*-bloom.bin{,.sig}
- Statistiken und generierte Zusammenfassung der aktuellen Datenbank zu finden auf https://divested.dev/MalwareScannerSignatures/

Geplante Updates
----------------
- Option zum Scannen beim Zugriff
- Scannen von Dateien über Share Intent
- Scannen neu installierter/aktualisierter Anwendungen
- Option zum Anstoßen von Scans durch Drittanbieter-Apps
- Automatische Datenbank-Updates
- Automatische Datenbankerstellung
- Datenbank-Sanity-Tests
- Prüfung
- Bessere Benutzeroberfläche (GUI)
- Übersetzungen
- Scannen des gesamten Systems mittels root Zugriff (niedrige Priorität)

Ziele
-----
- Schnelle Performance
- Minimaler Akkuverbrauch
- Das nötige Minimum an Berechtigungen verwenden
- Bibliotheken nur bei Bedarf verwenden

Credits
-------
- ClamAV für die Datenbanken (GPLv2)
- ESET für die zusätzlichen Datenbanken (BSD 2-Clause)
- Nex (@botherder) für extra Datenbanken (CC BY-SA 4.0)
- Amnesty International für extra Datenbanken (CC BY 2.0)
- Echap für extra Datenbanken (CC BY 4.0)
- MalwareBazaar für extra Datenbanken (CC0)
- RecursiveFileObserver.java (GPLv3): Daniel Gultsch, ownCloud Inc. und Bartek Przybylski
- GPGDetachedSignatureVerifier.java (GPL-2.0-or-later): Federico Fissore, Arduino LLC
- Petra Mirelli (@iNtEgraIR2021) für die deutsche/spanische/italienische Übersetzung, das App-Banner/Feature-Grafik und verschiedene Optimierungen.
- Jean-Luc Tibaux und Petra Mirelli (@iNtEgraIR2021) für die französischen Übersetzungen.
- @srccrow für die italienischen Übersetzungen.
- @inkhorn für die portugiesischen Übersetzungen.
- @jontaix für die portugiesischen Übersetzungen.
- @q1011 für die russischen Übersetzungen.
- Oswald van Ginkel für die afrikanischen Übersetzungen.
- huuhaa für die finnischen Übersetzungen.
- Marcin Mikołajczak für die polnischen Übersetzungen.
- @Manuel-Senpai für die spanischen Übersetzungen.
- @Balthazar1234 für die deutschen Übersetzungen.
- @Sdarfeesh für die vereinfachte Chinesische übersetzungen.
- @cardpuncher für die französischen und türkischen Übersetzungen.
- Tommaso Fonda für die italienischen Übersetzungen.
- @thereisnoanderson für die deutschen Übersetzungen.
- Dimitris Vagiakakos für die griechischen Übersetzungen.
- @gallegonovato für die spanischen Übersetzungen.
- @Fjuro für die tchechischen Übersetzungen.

- Icons: Google/Android/AOSP, Lizenz: Apache 2.0, https://google.github.io/material-design-icons/

Hinweise
-------
- Divested Computing Group ist nicht mit Cisco oder ESET verbunden
- Hypatia wird nicht von Cisco oder ESET gesponsert oder unterstützt

Spenden
-------
-------
- https://divested.dev/donate
