Ipazia
=======

Panoramica
--------
Hypatia è il primo scanner di malware FOSS per Android. È alimentato da database di firme in stile ClamAV.

Caratteristiche
--------
- Impatto della batteria quasi nullo: non noterai mai alcun impatto sulla batteria
- Estremamente veloce: può scansionare file piccoli (1MB) in <20ms, e anche file grandi (40MB) in 1000ms.
- Efficiente in termini di memoria: con i database di default abilitati utilizza meno di 120MB.
- Scansione regolare: permette di selezionare /sistema, memoria interna, memoria esterna e applicazioni installate.
- Scansione in tempo reale: può rilevare malware in tempo reale su scrittura/rinominazione nello storage interno
- Completamente offline: Internet viene utilizzato solo per scaricare i database delle firme, i file non lasceranno mai il tuo dispositivo
- Persistenza: si riavvia automaticamente all'avvio/aggiornamento
- Codebase minuscolo: arrivando a meno di 1000 sloc, può essere controllato anche da qualcuno con esperienza di programmazione di base
- Dipendenze minime: l'app usa le librerie solo quando necessario
- I database delle firme possono essere abilitati/disabilitati su richiesta dell'utente

Dettagli tecnici
------------------
- I database delle firme sono in formato ClamAV .hdb (hash MD5) e .hsb (SHA-1/SHA-256)
- I database delle firme non saranno riscaricati se il file non è cambiato sul server (304 non modificato)
- Le firme sono memorizzate usando HashMaps per una ricerca O(1)
- I file hanno i loro hash MD5/SHA-1/SHA-256 calcolati in un solo passaggio
- Lo scanner in tempo reale è multithreaded e utilizzerà metà del numero di core del dispositivo per la scansione di più file in modo asincrono
- Scansione in tempo reale alimentata da un FileObserver ricorsivo
- Le connessioni di rete saranno effettuate su: https://divested.dev/MalwareScannerSignatures/*.h*b.gz

Aggiornamenti pianificati
----------------
- Opzione di scansione all'accesso
- Opzione per mettere in quarantena/eliminare al rilevamento
- Scansione dei file tramite intento di condivisione
- Scansione delle app appena installate/aggiornate
- Migliore interfaccia grafica
- Traduzioni
- Scansione dell'intero sistema usando root (bassa priorità)

Obiettivi
-----
- Essere veloce
- Non consumare le batterie
- Usare permessi minimi
- Usare le librerie solo se necessario

Crediti
-------
- ClamAV per i database (GPLv2)
- ESET per i database extra (BSD 2-Clause)
- RecursiveFileObserver.java (GPLv3): Daniel Gultsch, ownCloud Inc, Bartek Przybylski
- Petra Mirelli per le traduzioni in tedesco, il banner/grafica dell'app e varie modifiche.
- Jean-Luc Tibaux e Petra Mirelli per le traduzioni in francese.
- @srccrow per le traduzioni italiane.
- Icone: Google/Android/AOSP, Licenza: Apache 2.0, https://google.github.io/material-design-icons/

Avvisi
-------
- Divested Computing Group non è affiliato con Cisco o ESET
- Hypatia non è sponsorizzata o appoggiata da Cisco o ESET
