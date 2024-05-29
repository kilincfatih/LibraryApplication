# Kütüphane Uygulaması

Bu kütüphane uygulaması, "Üye İşlemleri, Kitap İşlemleri, Ödünç İşlemleri" gibi birçok işlevin (CRUD işlemleri) gerçekleştirilmesine olanak sağlar. Hata mesajları alanı geliştirilmeye devam edilmektedir.
</br>

## Özellikler

- **Üye İşlemleri**: Üye ekleme, silme, güncelleme ve listeleme.
- **Kitap İşlemleri**: Kitap ekleme, silme, güncelleme ve listeleme.
- **Ödünç İşlemleri**: Kitap ödünç alma ve geri verme işlemleri.
- **Hata Yönetimi**: Kullanıcı dostu hata mesajları ve uyarılar.
- **NOT**: Hata mesajları şu anda geliştirilmeye devam edilmektedir !
</br>

## Kullanılan Teknolojiler

- **Spring Boot**: Uygulama geliştirme çatısı.
- **Java 17**: Programlama dili.
- **PostgreSQL**: Veritabanı yönetim sistemi.
</br>

## Bağımlılıklar

- **Spring Boot Starter Data JPA**: Veri erişimi için.
- **Spring Boot Starter Web**: Web uygulamaları geliştirme için.
- **Spring Boot DevTools**: Geliştirme araçları.
- **PostgreSQL**: PostgreSQL veritabanı sürücüsü.
- **Lombok**: Kod yazımını kolaylaştıran araç.
- **Spring Boot Starter Test**: Test yazımı için.
- **Spring Security Test**: Güvenlik testleri için.
 </br>

## Kurulum

1. Projeyi klonlayın:
    ```sh
    git clone https://github.com/kilincfatih/LibraryApplication.git
    ```
2. Proje dizinine gidin:
    ```sh
    cd LibraryApplication
    ```
3. Gerekli bağımlılıkları yükleyin ve projeyi çalıştırın:
    ```sh
    ./mvnw spring-boot:run
    ```
