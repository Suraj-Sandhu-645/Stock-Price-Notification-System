# 📈 Stock Price Notification System

A lightweight microservices-based system to monitor real-time stock price feeds and send alerts when prices cross user-defined thresholds.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Apache Kafka
- Docker & Docker Compose
- REST APIs

---

## 🎯 Project Goal

To demonstrate real-time communication between microservices using Kafka by implementing a system that:

- Allows users to register and create a watchlist of stocks
- Consumes live stock price updates via Kafka
- Triggers notifications when stock prices cross upper or lower thresholds set by users

---

## 🧩 Modules Overview

### 1. User Service
- Handles user registration and watchlist management
- Exposes REST APIs to manage user preferences

### 2. Stock Feed Consumer
- Listens to stock price updates from Kafka (`stock-price-feed` topic)
- Compares incoming prices against user thresholds
- Publishes alert events to Kafka (`stock-alert` topic)

### 3. Alert Service
- Consumes alerts from Kafka
- Sends/logs notifications when thresholds are breached

---

## 🔄 Data Flow

User → [User Service] → Stores Watchlist

[Kafka Producer] → stock-price-feed → [Stock Feed Consumer]
↓
Compares prices with thresholds
↓
Publishes to stock-alert

[Alert Service] ← stock-alert → Sends Notification



---

## 📦 Kafka Topics

| Topic Name         | Description                            |
|--------------------|----------------------------------------|
| stock-price-feed   | Incoming stream of stock prices        |
| stock-alert        | Alerts triggered for watchlist users   |

---

## 🔌 API Endpoints – User Service

| Method | Endpoint                                | Description                        |
|--------|------------------------------------------|------------------------------------|
| POST   | /users/register                          | Register a new user                |
| GET    | /users/{userId}                          | Get user details                   |
| POST   | /users/{userId}/watchlist                | Add stock to watchlist             |
| GET    | /users/{userId}/watchlist                | Retrieve user watchlist            |
| DELETE | /users/{userId}/watchlist/{symbol}       | Remove a stock from watchlist      |

---

## 🐳 Running with Docker Compose

1. Clone the repo:

   ```bash
   git clone https://github.com/your-username/stock-alert-system.git
   cd stock-alert-system

2. Start the service:

   ```bash
   docker-compose up --build

3. Test the endpoints using Postman or Swagger UI.


## ✅ Features

- Real-time alert system using Kafka
- Microservice communication via events 
- Containerized with Docker 
- Simple and extendable architecture

