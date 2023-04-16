Hypatia
=======

Przegląd
--------
Hypatia to pierwszy w świecie FOSS skaner złośliwego oprogramowania na Androida. Jest oparty o bazy danych sygnatur w stylu ClamAV.

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
     alt="Pobierz w F-Droid"
     height="80">](https://f-droid.org/packages/us.spotco.malwarescanner/)

Funcje
--------
- Prawie zerowy wpływ na baterię – nigdy nie zauważysz wpływu na zużycie baterii
- Ekstremalnie szybki – może skanować małe pliki files (1MB) w 20ms, a nawet większe pliki (40MB) w 1000ms.
- Oszczędny dla pamięci – z domyślnymi bazami danych wykorzystuje mniej niż 120MB.
- Zwykłe skanowanie – pozwala wybrać /system, pamięć wewnętrzną, zewnętrzną i zainstalowane aplikacje
- Skaner w czasie rzeczywistym – może wykrywać złośliwe oprogramowanie podczas nadpisywania/zmian nazw w pamięci wewnętrznej
- Całkowicie offline – Internet wykorzystywany jest jedynie do pobierania baz danych sygnatur, pliki nigdy nie opuszczą Twojego urządzenia
- Trwałość – automatycznie restartuje się po uruchomieniu/aktualizacji
- Niewielki kod – zawiera mniej niż 1000 linii kodu, może zostać zaudytowany nawet przez osobę z podstawową wiedzą o programowaniu
- Minimalne zależności – aplikacja wykorzystuje biblioteki jedynie gdy są potrzebne
- Bazy danych sygnatur mogą być włączone/wyłączone na życzenie użytkownika

Technical Details
------------------
- Sygnatury bazy danych używają formatu ClamAV .hdb (MD5 hashes) i .hsb (SHA-1/SHA-256)
- Sygnatury bazy danych nie będą pobierane, jeżeli plik nie został zmieniony na serwerze (304 not modified)
- Sygnatury są przechowywane z wyorzystaniem HashMap dla wyszukiwania o złożoności O(1)
- Hashe MD5/SHA-1/SHA-256 plików są obliczane jednocześnie
- Skaner w czasie rzeczywistym używa wielu wątków i wykorzystuje połowę rdzeni urządzenia dla skanowania wielu plików asynchronicznie
- Skaner w czasie rzeczywistym wykorzystuje rekurencyjny FileObserver
- Połączenia z internetem są dokonywane z adresem https://divested.dev/MalwareScannerSignatures/*.h*b.gz

Planowane aktualizacje
----------------
- Opcja skanowania przy dostępie
- Opcja usunięcia/kwarantanny po wykryciu
- Skanowanie plików przez opcję udostępnienia
- Skanowanie nowo zainstalowanych/aktualizowanych aplikacji
- Możlwiość wywołania skanowania przez aplikacje trzecie
- Obsługa niestandardowych baz danych
- Automatyczne aktualizacje baz danych
- Automatyczne generowanie baz danych
- Generowanie baz danych przez klienta
- Kontrola poprawności baz danych
- Testy
- Lepsze GUI
- Tłumaczenia
- Skanowanie całego systemu z wykorzystaniem roota (niski priorytet)

Cele
-----
- Szybkokść
- Oszczędność baterii
- Wykorzystywanie możliwie niewielu uprawnień
- Wykorzystywanie bibliotek tylko gdy konieczne

Uznania
-------
- ClamAV za bazy danych (GPLv2)
- ESET za dodatkowe bazy danych (BSD 2-Clause)
- Nex (@botherder) za dodatkowe bazy danych (CC BY-SA 4.0)
- RecursiveFileObserver.java (GPLv3): Daniel Gultsch, ownCloud Inc., Bartek Przybylski
- Petra Mirelli za tłumaczenia w języku niemieckim, hiszpańskim i włoskim, baner aplikacji/grafikę z funkcjami i różne usprawnienia.
- Jean-Luc Tibaux and Petra Mirelli za tłumaczenia w języku francusim.
- @srccrow za tłumaczenia w języku włoskim.
- @inkhorn za tłumaczenia w języku portugalskim.
- @jontaix za tłumaczenia w języku portugalskim.
- @q1011 za tłumaczenia w języku rosyjskim.
- Oswald van Ginkel za tłumaczenia w języku afrykanerskim.
- huuhaa za tłumaczenia w języku fińskim.
- Ikony: Google/Android/AOSP, Licencja: Apache 2.0, https://google.github.io/material-design-icons/

Uwagi
-------
- Divested Computing Group nie jest powiązana z Cisco i ESET
- Hypatia nie jest sponsorowana ani zalecana przez Cisco i ESET

Wesprzyj
-------
- https://divested.dev/donate
