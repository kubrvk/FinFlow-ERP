# FinFlow ERP 💼
> **Kurumsal Finans & E-Fatura Terminali • SAP / NetSuite Mimarili Finansal Mizan Portalı**

[![Canlı Demo](https://img.shields.io/badge/Canl%C4%B1_Demo-finflow--erp.web.app-059669?style=for-the-badge&logo=google-chrome&logoColor=white)](https://finflow-erp.web.app)
[![Lisans](https://img.shields.io/badge/Lisans-MIT-blue.svg?style=for-the-badge)](LICENSE)
[![Teknoloji](https://img.shields.io/badge/Teknoloji-Vanilla_ES6%2B_No_Framework-yellow?style=for-the-badge&logo=javascript)](https://developer.mozilla.org)
[![Arayüz](https://img.shields.io/badge/Tasar%C4%B1m-ERP_Sidebar_Terminal-0f172a?style=for-the-badge&logo=css3)](https://developer.mozilla.org)
[![Dil](https://img.shields.io/badge/Dil-T%C3%BCrk%C3%A7e_%7C_English-green?style=for-the-badge)](https://finflow-erp.web.app)

---

## 📸 Canlı Önizleme (Previews)

### 1. ERP Muhasebe & E-Dönüşüm Terminali
Sol sabit navigasyon menüsü, üst sabit metrik şeridi (TCMB canlı kurları, KDV matrahı, ciro), fatura kuyruğu ve **Fatura Satırı Silme** butonları:
![FinFlow ERP Terminal Önizleme](docs/preview-dashboard.png)

### 2. Wall Street İki Panelli Kurumsal Giriş Portalı (Two-Panel Split Portal)
Sol panelde derin lacivert ACME Holding güven mührü, canlı TCMB döviz kurları (`USD/TRY 34.18 | EUR/TRY 37.92`), GİB v2.4 rozeti; sağ panelde temiz kurumsal muhasebe giriş formu:
![FinFlow ERP Login Önizleme](docs/preview-login.png)

---

## 🌟 Öne Çıkan Özellikler

### 1. Sektöre Özgü ERP & Kurumsal Muhasebe Mimarisi
- **SAP / NetSuite Tarzı Sol Navigasyon (`.erp-sidebar`)**: ACME Holding firma seçici, modül sekmeleri (Giden Faturalar, Yevmiye Defteri, Cari Hesaplar, Mizan Raporu, GİB Kuyruğu) ve kullanıcı profili.
- **Üst Sabit Finansal Metrik Şeridi (`.erp-metrics-bar`)**: Toplam faturalanan ciro (TRY), hesaplanan KDV toplamı, iletilen e-fatura sayısı ve genel mizan farkı.
- **Tabular Sayısal Tipografi**: Muhasebe tutarlarının basamak hizalaması için monospace/tabular sayı fontu entegrasyonu.

### 2. Çift Katmanlı Veri Silme & Mizan Yeniden Hesaplaması
- **Giden Faturayı Sil (`promptDeleteOutbox`)**: Her fatura satırında doğrudan fark edilebilir kırmızı çöp kutusu butonu yer alır. Silindiğinde fatura kuyruğu güncellenir, toplam ciro ve KDV matrahı anında dinamik olarak yeniden toplanır.
- **Yevmiye Kaydını Sil (`promptDeleteLedger`)**: Çift taraflı muhasebe kaydı (Borç / Alacak) silindiğinde, genel mizan toplamı ve denge farkı anında otomatik olarak yeniden hesaplanır.
- **Kalıcı `localStorage`**: Silinen faturalar tarayıcı hafızasına (`ff_outbox_v2`, `ff_ledger_v2`) işlenir, sayfa yenilense de silinen veriler geri gelmez.

### 3. Oturum Kalıcılığı (Session Persistence) & Zero-Flicker Başlangıç
- **Sayfa Yenilemelerinde Oturumu Hatırla**: Başarılı oturum açılışında `localStorage.setItem('ff_logged_in', 'true')` kaydı atılır.
- **Sıfır Titreme (Zero-Flicker)**: Sayfa yenilendiğinde (F5) inline script kontrolü sayesinde giriş ekranı hiç açılmadan doğrudan ERP terminali yüklenir.
- **Güvenli Çıkış**: Sol alt kullanıcı alanındaki kırmızı **"Çıkış"** butonuna basıldığında oturum sonlandırılır.
- **Hazır Demo Bilgileri**: Giriş ekranında kurumsal e-posta ve şifre hazır girili gelir; altındaki hızlı rol butonlarıyla (`Finans Müdürü (CFO)`, `Mali Müşavir (YMM)`, `Müşteri`, `Kullanıcı`) anında rol değiştirilebilir.

### 4. Çift Dilli Tam Destek (TR | EN)
- Dil seçici (`[ TR | EN ]`) ile tüm e-fatura terimleri, vergi kimlik numaraları (VKN), borç/alacak hesap planları ve mizan başlıkları İngilizce/Türkçe arasında anında dönüştürülür.
- Başlangıç varsayılan dili **Türkçe**'dir.

---

## 🛠️ Teknoloji Yığını (Tech Stack)

| Bileşen | Teknoloji | Amaç |
| :--- | :--- | :--- |
| **Arayüz (UI)** | HTML5, Modern CSS3 | Koyu lacivert kurumsal ERP teması, responsive iki panelli modal |
| **İş Mantığı** | Vanilla ES6+ JavaScript | Dinamik KDV/ciro matrah hesaplama, cari bakiye dengelemesi |
| **İkonlar** | Bootstrap Icons v1.11.3 | Muhasebe ve finans sembolleri |
| **Kalıcılık** | HTML5 `localStorage` | Fatura kuyruğu, yevmiye kayıtları, oturum durumu |
| **Dağıtım** | Firebase Hosting | Yüksek performanslı SSL korumalı barındırma |

---

## 📁 Proje Dizin Yapısı

```
FinFlow-ERP/
├── index.html              # ERP terminali ve split login portalı
├── docs/                   # Dokümantasyon ve ekran görüntüleri
│   ├── preview-dashboard.png # Muhasebe terminali yüksek çözünürlüklü önizleme
│   └── preview-login.png     # Two-Panel split giriş ekranı önizleme
└── README.md               # Proje dokümantasyonu
```

---

## ⚡ Hızlı Başlangıç (Local Setup)

1. Depoyu klonlayın:
   ```bash
   git clone https://github.com/kubrvk/FinFlow-ERP.git
   cd FinFlow-ERP
   ```
2. `index.html` dosyasını tarayıcınızda açın:
   ```bash
   start index.html
   ```
3. Alternatif yerel HTTP sunucusu ile çalıştırmak için:
   ```bash
   npx serve .
   ```
4. Tarayıcınızda açılan adrese gidin.
   - *Giriş ekranını atlayıp doğrudan ERP terminalini açmak için:* `http://localhost:3000/?demo=1`

---

## 🌐 Canlı Sistem

- **Canlı URL**: [https://finflow-erp.web.app](https://finflow-erp.web.app)
- **Doğrudan Demo Bağlantısı**: [https://finflow-erp.web.app/?demo=1](https://finflow-erp.web.app/?demo=1)

---

## 👤 Geliştirici

**Developed by Beraat Yetkin**
- GitHub: [@kubrvk](https://github.com/kubrvk)
- Proje Deposu: [FinFlow-ERP](https://github.com/kubrvk/FinFlow-ERP)
- Portfolyo: [Beraat Yetkin Portfolio](https://github.com/kubrvk/portfolio)
