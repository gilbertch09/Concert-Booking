# Concert-Booking
---

## 📘 Concert Booking API Documentation

### 🌐 Base URL

```
http://localhost:8080
```

---

### 🎫 CONCERT ENDPOINTS

#### 🔹 `GET /concerts`

**Description:** Get a list of all concerts.

**Optional Query Parameter:**

| Name | Type   | Description                                       |
| ---- | ------ | ------------------------------------------------- |
| name | String | Search by concert name keyword (case-insensitive) |

**Example:**

```
GET http://localhost:8080/concerts?name=taylor
```

**Response:**

```json
[
  {
    "id": 1,
    "name": "Taylor Swift Concert",
    "location": "Jakarta",
    "concertTime": "2025-09-15T19:00:00",
    "bookingStart": "2025-07-10T00:00:00",
    "bookingEnd": "2025-09-14T23:59:59",
    "maxTickets": 100
  }
]
```

---

#### 🔹 `GET /concerts/available`

**Description:** Get concerts that are currently bookable (based on date and ticket availability).

**Logic:**

* `currentDate BETWEEN bookingStart AND bookingEnd`
* `maxTickets > 0`

**Example:**

```
GET http://localhost:8080/concerts/available
```

**Response:** Same as `/concerts`, but filtered.

---

### 🧾 BOOKING ENDPOINTS

#### 🔹 `POST /bookings/book`

**Description:** Book a ticket for a specific concert.

**Request Parameters:**

| Name      | Type   | Description                   |
| --------- | ------ | ----------------------------- |
| concertId | Long   | ID of the concert to book     |
| email     | String | Email address for the booking |

**Example:**

```
POST http://localhost:8080/bookings/book?concertId=1&email=user@example.com
```

**Success Response:**

```
Booking confirmed for user@example.com
```

**Error Responses:**

* `Concert not found`
* `Tickets sold out`
* `Booking time is outside allowed range`

---

### 🚫 ERROR HANDLING FORMAT

**Standard Error JSON:**

```json
{
  "timestamp": "2025-07-14T14:32:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Tickets sold out",
  "path": "/bookings/book"
}
```

---


