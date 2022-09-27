![Banner](https://divestos.org/images/featureGraphics/Hypatia.png)

Hypatia
=======

Overview
--------
Hypatia is the world's first FOSS malware scanner for Android. It is powered by ClamAV style signature databases.

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
     alt="Get it on F-Droid"
     height="80">](https://f-droid.org/packages/us.spotco.malwarescanner/)

Features
--------
- Near zero battery impact: you'll never notice any impact on battery at all
- Extremely fast: it can scan small files (1MB) in <20ms, and even large files (40MB) in 1000ms.
- Memory efficient: with the default databases enabled it uses under 120MB.
- Regular scan: allowing selection of /system, internal storage, external storage, and installed apps
- Realtime scanner: can detect malware in realtime on write/rename in internal storage
- Completely offline: Internet is only used to download signature databases, files will never ever leave your device
- Persistence: will automatically restart on boot/update
- Tiny codebase: coming in at under 1000 sloc, it can be audited by even someone with basic programming experience
- Minimal dependencies: the app only uses libraries when necessary
- Signature databases can be enabled/disabled at the users demand

Technical Details
------------------
- Signature databases are ClamAV .hdb (MD5 hashes) and .hsb (SHA-1/SHA-256) format
- Signature databases will not be redownloaded if the file hasn't changed on the server (304 not modified)
- Signatures are stored using HashMaps for O(1) lookup
- Files have their MD5/SHA-1/SHA-256 hashes calculated in one pass
- Realtime scanner is multithreaded and will use half of the device's core count for scanning multiple files asynchronously
- Realtime scanning powered by a recursive FileObserver
- Network connections will be made to the following: https://divested.dev/MalwareScannerSignatures/*.h*b.gz

Planned Updates
----------------
- Option to scan on access
- Option to quarantine/delete on detection
- Scan files via share intent
- Scan newly installed/updated apps
- Option to let 3rd-party apps invoke scans
- Custom database support
- Automatic database updates
- Automatic database generation
- Client side database generation
- Database signature verification
- Database sanity checks
- Testing
- Better GUI
- Translations
- Scanning entire system using root (low priority)

Goals
-----
- Be fast
- Don't eat batteries
- Use minimal permissions
- Use libraries only when necessary

Credits
-------
- ClamAV for the databases (GPLv2)
- ESET for extra databases (BSD 2-Clause)
- Nex (@botherder) for extra databases (CC BY-SA 4.0)
- RecursiveFileObserver.java (GPLv3): Daniel Gultsch, ownCloud Inc., Bartek Przybylski
- Petra Mirelli for the German/Spanish/Italian translations, the app banner/feature graphic, and various tweaks.
- Jean-Luc Tibaux and Petra Mirelli for the French translations.
- @srccrow for the Italian translations.
- @inkhorn for the Portuguese translations.
- @jontaix for Portuguese translations.
- @q1011 for the Russian translations.
- Oswald van Ginkel for the Afrikaans translations.
- huuhaa for the Finnish translations.
- Marcin Mikołajczak for Polish translations.
- Icons: Google/Android/AOSP, License: Apache 2.0, https://google.github.io/material-design-icons/

Notices
-------
- Divested Computing Group is not affiliated with Cisco or ESET
- Hypatia is not sponsored or endorsed by Cisco or ESET

Donate
-------
- https://divested.dev/donate
