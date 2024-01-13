[Banner](https://divestos.org/images/featureGraphics/Hypatia.png)

Hypatia
=======

Genel Bakış
--------
Hypatia, Android için dünyanın ilk özgür yazılım kötücül yazılım tarayıcısıdır. ClamAV tarzı imzalardan güç alır.

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
     alt="Get it on F-Droid"
     height="80">](https://f-droid.org/packages/us.spotco.malwarescanner/)

Özellikleri
--------
- Pile neredeyse sıfır etki: pil üzerinde hiçbir etki dikkatinizi asla çekmeyecektir
- Son derece hızlı: küçük dosyaları (1MB) <20 ms gibi bir sürede tarar, büyük dosyaları bile (40 MB) 1000 ms gibi bir sürede tarayabilir.
- Verimli bellek kullanımı: varsayılan veri tabanları etkinleştirildiğinde 120 Megabayt altı kullanır.
- Düzenli tarama: /system, dahili depolama, harici depolama ve kurulu uygulamalar arasında seçim sunar
- Gerçek zamanlı tarayıcı: kötücülleri gerçek zamanlı olarak dahili depolamaya yazma/yeniden adlandırma esnasında tespit eder
- Tamamen çevrim dışı: İnternet, sadece imza veri tabanlarını indirmek için kullanılır, dosyalar asla cihazınızdan çıkmaz
- Kalıcılık: başlama veya güncelleme durumunda kendiliğinden yeniden başlayacaktır
- Küçük kod tabanı: 1000 sloc değerinden düşüktür, temel programlama tecrübesi olan biri tarafından bile kontrol edilebilir
- Asgari bağımlılık: uygulama kütüphaneleri sadece gerektiğinde kullanır
- İmza veri tabanları kullanıcının isteğine göre etkinleştirilebilir/devre dışı bırakılabilir

Teknik Ayrıntılar
------------------
- İmza veri tabanları ClamAV .hdb (MD5 karma değerleri) ve .hsb (SHA-1/SHA-256) biçiminden oluşur
- İmza veri tabanları dosya sunucuda değişmediyse tekrar indirilmeyecektir (304 not modified)
- İmzalar BloomFilters kullanılarak depolanır
- Dosyaların MD5/SHA-1/SHA-256 karma değerleri tek geçişte hesaplanır
- Gerçek zamanlı tarayıcı çoklu izlek kullanır ve birçok dosyayı eşzamansız olarak taramak için cihazın çekirdek sayısının yarısını kullanacaktır
- Gerçek zamanlı tarama özyinelemeli bir FileObserver (DosyaGözlemcisi) tarafından desteklenmektedir
- Şebeke bağlantıları şu adreslere yapılır: https://divested.dev/MalwareScannerSignatures/*.h*b.gz

Planlanan Güncellemeler
----------------
- Erişim esnasında tarama için seçenek
- Paylaşılma niyeti olan dosyaları tarama
- Yeni kurulan/güncellenen uygulamaları tarama
- Üçüncü taraf uygulamaların tarama isteği yapmalarına imkân sağlama
- Otomatik veri tabanı güncellemeleri
- Otomatik veri tabanı oluşturma
- Veri tabanı tutarlılık kontrolleri
- Denemeler
- Daha iyi bir grafik arayüz
- Tercümeler
- root kullanılarak tüm sistemi tarama (düşük öncelik)

Hedefler
-----
- Hızlı olmak
- Pilden çok yememek
- Asgari izin kullanmak
- Kütüphaneleri sadece gerektiğinde kullanmak

Katkıda Bulunanlar
-------
- Veri tabanları için ClamAV (GPLv2)
- İlave veri tabanları için ESET (2 koşullu BSD)
- İlave veri tabalnları için Nex (@botherder) (CC BY-SA 4.0)
- İlave veri tabanları için Amnesty International (CC BY 2.0)
- İlave veri tabanları için Echap (CC BY 4.0)
- İlave veri tabanları için MalwareBazaar (CC0)
- RecursiveFileObserver.java (GPL-3.0-veya-sonraki): Daniel Gultsch, ownCloud Inc., Bartek Przybylski
- GPGDetachedSignatureVerifier.java (GPL-2.0-veya-sonraki): Federico Fissore, Arduino LLC
- Almanca, İspanyolca, İtalyanca tercümeler, uygulama afişi/işlev grafiği ve çeşitli ayarlar için Petra Mirelli.
- Fransızca tercüme için Jean-Luc Tibaux ve Petra Mirelli.
- İtalyanca tercüme için @srccrow.
- Portekizce tercüme için @inkhorn.
- Portekizce tercüme için @jontaix.
- Rusça tercüme için @q1011.
- Afrikaanca tercüme için Oswald van Ginkel.
- Fince tercüme için huuhaa.
- Lehçe tercüme için Marcin Mikołajczak.
- İspanyolca tercüme için @Manuel-Senpai.
- Almanca tercüme için @Balthazar1234.
- Basitleştirilmiş Çince tercüme için @Sdarfeesh.
- Fransızca ve Türkçe tercüme için @cardpuncher.
- İtalyanca tercüme için Tommaso Fonda.
- Yunanca tercüme için Dimitris Vagiakakos.
- İkonlar: Google/Android/AOSP, Lisans: Apache 2.0, https://google.github.io/material-design-icons/

Bildirimler
-------
- Divested Computing Group, Cisco veya ESET ile bağlı değildir
- Hypatia, Cisco veya ESET tarafından desteklenmiş veya onaylanmış değildir

Bağış Yapın
-------
- https://divested.dev/donate
[Banner](https://divestos.org/images/featureGraphics/Hypatia.png)



