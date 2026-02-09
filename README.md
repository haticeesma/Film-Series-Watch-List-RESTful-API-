# 🎬 WatchList Backend API

Spring Boot kullanılarak geliştirilmiş, **film / dizi izleme listesi** mantığını temel alan sade bir REST API projesidir. 

---

## 🚀 Özellikler

- 👤 Kullanıcı oluşturma ve listeleme
- 🎞️ Film / dizi ekleme
- 📌 Kullanıcıya özel izleme listesi (WatchList)
- 🔁 İzlenme durumu güncelleme (TO_WATCH / WATCHED)
- ⭐ Puan verme (0–10)
- ❌ Aynı içerik aynı kullanıcıya birden fazla eklenemez

---

## 🧱 Kullanılan Teknolojiler

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

---

## 🏗️ Mimari

Proje **katmanlı mimari** ile geliştirilmiştir:

controller → service → repository → database


## 🗂️ Veri Modeli (Özet)

- **User**: id, username
- **Content**: id, title, type (FILM / SERIES)
- **WatchList**: user, content, title, status, score

User ile Content arasındaki ilişki **WatchList ara tablosu** üzerinden kurulmuştur.

---
