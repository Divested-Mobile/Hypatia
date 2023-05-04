Hypatia
=======

Vue d'ensemble
--------
Hypatia est le premier scanner de malware FOSS (logiciel libre) au monde pour Android. Il est propulsé par les bases de données de signatures de style ClamAV.

Caractéristiques
--------
- Impact de la batterie proche de zéro: vous ne remarquerez aucun impact sur la batterie
- Extrêmement rapide: il peut scanner les petits fichiers (1MB) en <20ms, et même les gros fichiers (40MB) en 1000ms.
- Mémoire efficace: avec les bases de données activées par défaut, il utilise moins de 120 Mo.
- Analyse régulière: permet de sélectionner le système, le mémoire interne, le mémoire externe et les applications installées
- Scanner en temps réel: peut détecter les malwares en temps réel sur l'écriture ou le renommage dans le mémoire interne
- Complètement hors ligne: l'internet n'est utilisé que pour télécharger des bases de données de signatures, les fichiers ne quitteront jamais votre appareil
- Persistance: redémarre automatiquement au démarrage/mise à jour
- Une base de code minuscule: avec moins de 1000 sloc, elle peut être vérifiée même par une personne ayant une expérience de base en programmation
- Dépendances minimales: l'application n'utilise les bibliothèques que lorsque cela est nécessaire
- Les bases de données de signatures peuvent être activées/désactivées à la demande des utilisateurs

Détails techniques
------------------
- Les bases de données de signatures sont au format ClamAV .hdb (hachages MD5) et .hsb (SHA-1/SHA-256)
- Les bases de données de signatures ne seront pas rechargées si le fichier n'a pas été modifié sur le serveur (code 304 - non modifié)
- Les signatures sont stockées à l'aide de HashMaps pour la recherche O(1)
- Les fichiers ont leurs hachages MD5/SHA-1/SHA-256 calculés en un seul passage
- Le scanner en temps réel est multifilaire et utilisera la moitié du nombre d'éléments de l'appareil pour analyser plusieurs fichiers de manière asynchrone.
- Analyse en temps réel grâce à un FileObserver récursif
- Les connexions au réseau seront effectuées aux adresses de type suivant: https://divested.dev/MalwareScannerSignatures/*.h*b.gz


Mises à jour prévues
----------------
- Possibilité de scanner sur l'accès
- Possibilité de mise en quarantaine ou de suppression en cas de détection
- Scanner des fichiers via l'intention de partage
- Scanner les applications nouvellement installées/mises à jour
- Une meilleure interface graphique
- Traductions
- Analyse de l'ensemble du système à l'aide de root (faible priorité)

Objectifs
-----
- Soyez rapide
- Réduire la consommation de batterie
- Utiliser des autorisations minimales
- N'utiliser les bibliothèques que lorsque c'est nécessaire

Crédits
-------
- ClamAV pour les bases de données (GPLv2)
- ESET pour les bases de données supplémentaires (BSD 2-Clause)
- RecursiveFileObserver.java (GPLv3): Daniel Gultsch, ownCloud Inc, Bartek Przybylski
- Petra Mirelli pour les traductions allemandes et la bannière/le graphique de l'application.
- Symboles: Google/Android/AOSP, Licence: Apache 2.0, https://google.github.io/material-design-icons/

Avis
-------
- Divested Computing Group n'est pas affilié à Cisco ou à ESET
- Hypatia n'est pas sponsorisé ou approuvé par Cisco ou ESET
