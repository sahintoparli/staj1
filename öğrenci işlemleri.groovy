def ogrenci_notu_ekle(notlar):
    """Yeni öğrenci ve/veya ders notu ekler."""
    ad = input("Öğrenci adını girin: ")
    if ad not in notlar:
        notlar[ad] = {}
        print(f"{ad} adlı öğrenci başarıyla eklendi.")
    
    ders = input("Ders adını girin: ")
    try:
        not_degeri = float(input(f"{ders} dersi için notu girin: "))
        notlar[ad][ders] = not_degeri
        print(f"{ad} adlı öğrencinin {ders} dersine {not_degeri} notu eklendi.")
    except ValueError:
        print("Geçersiz not girişi. Lütfen sayısal bir değer girin.")

def ogrenci_veya_not_sil(notlar):
    """Öğrenci veya ders notu siler."""
    secim = input("1. Öğrenci Sil\n2. Ders Notu Sil\nSeçiminizi yapın (1/2): ")
    if secim == "1":
        ad = input("Silinecek öğrenci adını girin: ")
        if ad in notlar:
            onay = input(f"{ad} adlı öğrenciyi ve tüm notlarını silmek istediğinize emin misiniz? (E/H): ")
            if onay.lower() == 'e':
                del notlar[ad]
                print(f"{ad} adlı öğrenci başarıyla silindi.")
            else:
                print("Silme işlemi iptal edildi.")
        else:
            print("Öğrenci bulunamadı.")
    elif secim == "2":
        ad = input("Ders notu silinecek öğrenci adını girin: ")
        if ad in notlar:
            ders = input("Silinecek ders adını girin: ")
            if ders in notlar[ad]:
                del notlar[ad][ders]
                print(f"{ad} adlı öğrencinin {ders} ders notu başarıyla silindi.")
            else:
                print("Ders bulunamadı.")
        else:
            print("Öğrenci bulunamadı.")
    else:
        print("Geçersiz seçim.")

def notlari_listele(notlar):
    """Tüm öğrencilerin notlarını veya belirli bir öğrencinin notlarını listeler."""
    if not notlar:
        print("Sistemde kayıtlı öğrenci bulunmamaktadır.")
        return

    secim = input("1. Tüm notları listele\n2. Belirli bir öğrencinin notlarını listele\nSeçiminizi yapın (1/2): ")
    if secim == "1":
        print("\n--- Öğrenci Not Listesi ---")
        for ogrenci, ders_notlar in notlar.items():
            print(f"\nÖğrenci: {ogrenci}")
            if ders_notlar:
                for ders, not_degeri in ders_notlar.items():
                    print(f"  - Ders: {ders}, Not: {not_degeri}")
            else:
                print("  Bu öğrencinin henüz notu yok.")
    elif secim == "2":
        ad = input("Notlarını görmek istediğiniz öğrenci adını girin: ")
        if ad in notlar:
            print(f"\n--- {ad} adlı öğrencinin Notları ---")
            if notlar[ad]:
                for ders, not_degeri in notlar[ad].items():
                    print(f"  - Ders: {ders}, Not: {not_degeri}")
            else:
                print("Bu öğrencinin henüz notu yok.")
        else:
            print("Öğrenci bulunamadı.")
    else:
        print("Geçersiz seçim.")

def not_guncelle(notlar):
    """Mevcut bir notu günceller."""
    ad = input("Notu güncellenecek öğrenci adını girin: ")
    if ad in notlar:
        ders = input("Güncellenecek ders adını girin: ")
        if ders in notlar[ad]:
            try:
                yeni_not = float(input(f"{ders} için yeni notu girin: "))
                notlar[ad][ders] = yeni_not
                print(f"{ad} adlı öğrencinin {ders} notu {yeni_not} olarak güncellendi.")
            except ValueError:
                print("Geçersiz not girişi. Lütfen sayısal bir değer girin.")
        else:
            print("Ders bulunamadı.")
    else:
        print("Öğrenci bulunamadı.")
