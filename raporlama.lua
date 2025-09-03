def analiz_raporu_olustur(notlar):
    """
    Sistemdeki notlar üzerinde detaylı bir analiz raporu oluşturur.
    """
    if not notlar:
        print("Analiz için yeterli veri bulunmamaktadır.")
        return

    print("\n--- ANALİZ RAPORU ---")

    # Genel not ortalaması
    toplam_not = 0
    toplam_ders = 0
    for ogrenci in notlar:
        for not_degeri in notlar[ogrenci].values():
            toplam_not += not_degeri
            toplam_ders += 1
    
    if toplam_ders > 0:
        genel_ortalama = toplam_not / toplam_ders
        print(f"Sistemdeki tüm notların genel ortalaması: {genel_ortalama:.2f}")
    else:
        print("Sistemde henüz ders notu bulunmamaktadır.")

    # En yüksek ve en düşük notu olan öğrenci
    if toplam_ders > 0:
        en_yuksek_not = -1
        en_yuksek_not_sahibi = ""
        en_dusuk_not = 101
        en_dusuk_not_sahibi = ""

        for ogrenci, dersler in notlar.items():
            for ders, not_degeri in dersler.items():
                if not_degeri > en_yuksek_not:
                    en_yuksek_not = not_degeri
                    en_yuksek_not_sahibi = f"{ogrenci} ({ders} dersi)"
                if not_degeri < en_dusuk_not:
                    en_dusuk_not = not_degeri
                    en_dusuk_not_sahibi = f"{ogrenci} ({ders} dersi)"
        
        print(f"En Yüksek Not: {en_yuksek_not} (Sahibi: {en_yuksek_not_sahibi})")
        print(f"En Düşük Not: {en_dusuk_not} (Sahibi: {en_dusuk_not_sahibi})")

    # Öğrenci bazlı ortalamalar
    print("\n--- Öğrenci Not Ortalamaları ---")
    for ogrenci, dersler in notlar.items():
        if dersler:
            ortalama = sum(dersler.values()) / len(dersler)
            print(f"{ogrenci}: {ortalama:.2f}")
        else:
            print(f"{ogrenci}: Not ortalaması hesaplanamadı (notu yok).")
