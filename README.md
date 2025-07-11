# 🔗 URL Shortener Service

A simple yet powerful **URL shortening API** built using **Java**, **Spring Boot**, and **H2 Database**. It generates compact short URLs for long links, supports redirection, tracks click counts, and is documented with Swagger UI.

---

## 📌 Features

- 🔗 Convert long URLs to short URLs using Base62 encoding
- 🚀 Redirect users from short URL to original URL
- 📊 Track number of times each short URL is clicked
- 🧾 Auto-generated API documentation with Swagger
- 🗃️ In-memory H2 database for fast development and testing

---

## ⚙️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Swagger UI via Springdoc OpenAPI

---

## 🚀 How to Run Locally

### 📦 1. Clone the Repo

```bash
git clone https://github.com/your-username/url-shortener.git
cd url-shortener
./mvnw spring-boot:run
```
## 📂 API Endpoints
🔧 POST /shorten
Generates a short URL for the given long URL.

Request Body:
```json
{
  "longUrl": "https://example.com/very/long/link"
}
```
Response:
```json
{
  "shortUrl": "http://localhost:8080/b",
  "longUrl": "https://example.com/very/long/link",
  "clickCount": 0
}
```
## 🚀 GET /{shortUrl}
```bash
GET http://localhost:8080/b
→ Redirects to: https://example.com/very/long/link
```

## 🔍 Swagger UI
```bash
http://localhost:8080/swagger-ui.html
```
## 🧪 H2 Database Console
```bash
http://localhost:8080/h2-console
```
JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (leave blank)
## 🧱 Project Structure
```swift
src/main/java/com/example/urlshortener/
├── controller/
├── dto/
├── model/
├── repository/
├── service/
└── UrlShortenerApplication.java
```

# URL Shortener Frontend

A responsive React.js frontend for the URL Shortener project. Connects to the Spring Boot backend to shorten long URLs and redirect to original URLs.

---

## ✨ Features

- Input a long URL and get a shortened one
- Responsive UI using Tailwind CSS
- Axios for API requests
- Handles error states cleanly

---

## 📦 Tech Stack

- React.js
- Tailwind CSS
- Axios

---

## 🚀 Getting Started

### 1. Navigate to the frontend folder
```bash
cd frontend
```

### 2. Install dependencies
```bash
npm install
```

### 3. Start the development server
```bash
npm start
```

App will run at: [http://localhost:3000](http://localhost:3000)

> Make sure your backend is running at [http://localhost:8080](http://localhost:8080)

---

## 🔧 API Integration

- POST `/shorten`: Shortens a long URL
- GET `/{shortUrl}`: Redirects to original URL

> These endpoints must be provided by the Spring Boot backend.

---

## 🖼 UI Screenshot (Optional)

Add a screenshot of the app once it’s running:

```md
![URL Shortener Screenshot](./screenshot.png)
```

---

## 📁 Folder Structure
```
frontend/
├── src/
│   ├── App.js
│   ├── index.js
│   └── index.css
├── public/
├── package.json
└── tailwind.config.js
```

---

