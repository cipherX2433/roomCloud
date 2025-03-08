# 🌍 roomCloud - Hotel Booking API  

## 📌 Overview  
roomCloud is a **hotel booking system API** that allows users to book hotels, manage their profiles, and handle payments securely. The API is designed to integrate into hotel management platforms and supports functionalities for both **users** and **admins**.  

### 🔥 Features  
✅ **User Authentication** (Spring Security & JWT)  
✅ **Hotel Management** (CRUD operations for hotels & reports)  
✅ **Booking System** (Booking initialization, guest management, and payments)  
✅ **Room Management** (CRUD operations for rooms)  
✅ **Stripe Integration** (Secure payment processing for bookings)  
✅ **Dynamic Pricing** (Surge pricing, holiday pricing, occupancy-based pricing)  
✅ **Reports & Analytics** (Hotel booking reports, financial summaries)  

---  

## 🛠️ Technologies Used  

| Technology       | Purpose                                        |
|-----------------|----------------------------------------------|
| **Spring Boot**  | Backend framework for RESTful API          |
| **Spring Security** | Authentication & role-based access control (JWT) |
| **Stripe**      | Payment processing for bookings            |
| **JPA (Hibernate)** | Database interaction using ORM           |
| **PostgreSQL**  | Relational database for storing hotel data  |
| **Swagger/OpenAPI** | API documentation                        |
| **Lombok**      | Reduces boilerplate code (e.g., getters/setters) |

---  

## 🚀 API Endpoints  

### 🔑 Authentication  

| Method | Endpoint        | Description                                      | Request Body          | Response            |
|--------|----------------|--------------------------------------------------|----------------------|--------------------|
| **POST** | `/auth/signup`  | Register a new user                              | `SignUpRequestDto`   | `UserDto`         |
| **POST** | `/auth/login`   | Authenticate user, return JWT access & refresh tokens | `LoginDto` | `LoginResponseDto` |
| **POST** | `/auth/refresh` | Refresh access token using refresh token (cookie) | - | `LoginResponseDto` |

### 🏨 Hotel Operations (Admin)  

| Method | Endpoint | Description | Request Body | Response |
|--------|---------|-------------|--------------|----------|
| **POST** | `/admin/hotels` | Create a new hotel | `HotelDto` | `HotelDto` |
| **GET** | `/admin/hotels/{hotelId}` | Get hotel details by ID | - | `HotelDto` |
| **PUT** | `/admin/hotels/{hotelId}` | Update hotel details | `HotelDto` | `HotelDto` |
| **DELETE** | `/admin/hotels/{hotelId}` | Delete a hotel by ID | - | `Void` |
| **GET** | `/admin/hotels/{hotelId}/reports` | Generate hotel booking report (date range) | `startDate`, `endDate` | `HotelReportDto` |

### 🛎️ Booking Operations  

| Method | Endpoint | Description | Request Body | Response |
|--------|---------|-------------|--------------|----------|
| **POST** | `/bookings/init` | Initialize a new booking | `BookingRequest` | `BookingDto` |
| **POST** | `/bookings/{bookingId}/addGuests` | Add guests to a booking | `List<Long>` | `BookingDto` |
| **POST** | `/bookings/{bookingId}/payments` | Initiate Stripe payment for a booking | - | `BookingPaymentInitResponseDto` |
| **GET** | `/bookings/{bookingId}/status` | Retrieve booking status | - | `BookingStatusResponseDto` |

### 🏠 Room Operations (Admin)  

| Method | Endpoint | Description | Request Body | Response |
|--------|---------|-------------|--------------|----------|
| **POST** | `/admin/hotels/{hotelId}/rooms` | Create a new room | `RoomDto` | `RoomDto` |
| **GET** | `/admin/hotels/{hotelId}/rooms` | Retrieve all rooms in a hotel | - | `List<RoomDto>` |
| **GET** | `/admin/hotels/{hotelId}/rooms/{roomId}` | Retrieve a specific room | - | `RoomDto` |
| **DELETE** | `/admin/hotels/{hotelId}/rooms/{roomId}` | Delete a room by ID | - | `Void` |

### 💰 Pricing Operations  

| Method | Endpoint | Description | Request Body | Response |
|--------|---------|-------------|--------------|----------|
| **GET** | `/pricing` | Calculate dynamic pricing for rooms | - | `DynamicPricingResponseDto` |

### 👤 User Operations  

| Method | Endpoint | Description | Request Body | Response |
|--------|---------|-------------|--------------|----------|
| **PATCH** | `/users/profile` | Update user profile | `ProfileUpdateRequestDto` | `Void` |
| **GET** | `/users/myBookings` | Retrieve current user's bookings | - | `List<BookingDto>` |
| **GET** | `/users/profile` | Retrieve user profile | - | `UserDto` |

---  

## 🔐 JWT Authentication Flow  

1. **User Signs Up/Login** → Receives an **Access Token** & **Refresh Token**  
2. **Access Token Expiry** → Use **Refresh Token** to get a new Access Token  
3. **Tokens stored securely** in **cookies** for session management  
4. **Admin routes protected** with role-based access control (`HOTEL_MANAGER`)  

---  

## 💳 Stripe Payment Integration  

1. **User initiates booking** → `/bookings/init`  
2. **System calculates total cost**  
3. **User proceeds to payment** → `/bookings/{bookingId}/payments`  
4. **Redirects to Stripe Checkout**  
5. **Payment confirmation received** → Booking marked as **Paid**  

---  

## 📜 Installation & Setup  

### 🏗 Prerequisites  
- **Java 17+**  
- **PostgreSQL** installed & running  
- **Maven** or **Gradle** installed  

### 🚀 Running Locally  

```bash
# Clone the repository
git clone https://github.com/your-username/roomCloud.git
cd roomCloud

# Update database & Stripe credentials in `.env`

# Build & run the project
./mvnw spring-boot:run
```

### 🔍 API Documentation  

- Swagger UI: `http://localhost:8080/swagger-ui.html`  

---  

