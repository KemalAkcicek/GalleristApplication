# Gallerist Application

Gallerist Application, kullanıcıların galeri üzerinden araba satın almasına olanak tanıyan bir uygulamadır. Kullanıcılar sisteme kayıt olur ve sahip oldukları bütçeye göre araç satın alabilirler.

## 📌 Kullanılan Teknolojiler

- **Backend:** Java with Spring Boot  
- **Database:** MySQL  
- **Security:** JWT (JSON Web Token) for authentication  

## 📌 Sistemdeki Modeller (Entities)

Uygulamada aşağıdaki 9 ana model bulunmaktadır:

1. **Customer**
2. **Account**
3. **Address**
4. **Gallerist**
5. **Saled Car**
6. **Gallerist Car**
7. **Car**
8. **Refresh Token**
9. **User**

## 📌 Modeller Arasındaki İlişki (Entity Relationship)

Aşağıda uygulamanın entity relationship diyagramını görebilirsiniz:

![Entity Relationship Diagram](https://github.com/user-attachments/assets/a05728ab-af38-4001-a0a7-b1d75c635f4f)

## 🔐 Kimlik Doğrulama ve Güvenlik

Uygulama, güvenli kimlik doğrulama ve yetkilendirme için **JWT (JSON Web Token)** kullanmaktadır.

- **Kullanıcı Girişi:**  
  Kullanıcılar, kimlik bilgilerini (**username** ve **password**) girerek sisteme giriş yapabilir. Başarılı giriş sonrası JWT token oluşturulur ve istemciye döndürülür.

- **Token Kullanımı:**  
  - **Access Token:** Geçerlilik süresi **2 saat**  
  - **Refresh Token:** Geçerlilik süresi **4 saat**  
  - Kullanıcı, 4 saati aşmadığı sürece sistemde kalır. Süre aşılırsa **logout** işlemi gerçekleşir.

- **Korumalı Endpoint'ler:**  
  JWT kimlik doğrulaması gerektiren endpoint'ler, token doğrulandıktan sonra işlenir.

---

## 🚀 Nasıl Çalıştırılır?

### 1️⃣ Projeyi Klonlayın:
```bash
git clone https://github.com/kullaniciadi/gallerist-app.git
cd gallerist-app
