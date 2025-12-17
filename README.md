# Online-Shopping-Cart-System

# Project Description
The Online Shopping System is a console-based Java application developed using Object-Oriented Programming (OOPS) principles.
The system provides role-based access for Admin and Customer, simulating the core functionalities of a real-world e-commerce platform such as product management, cart handling, discounts, and billing. This project is designed as a moderate-level mini project suitable for college OOPS labs, practical exams, and viva presentations.

# Objectives 
To understand and apply OOPS concepts in Java
To design a menu-driven application
To implement role-based functionality
To simulate online shopping operations

# User Roles
1. Admin
- Secure login using username and password
- Add new products
- Update existing products:
- Rename product
- Change category
- Update price
- Update discount percentage
- Remove products
- View all products

2. Customer
- View available products
- Add multiple products to cart
- Automatically update quantity if product already exists in cart
- Remove products from cart
- View cart
- Checkout with detailed bill:
- Actual amount
- Discount amount
- Final payable amount

# OOPS Concepts Used
1. Encapsulation
-Private data members in classes like Product, Cart, Shop
-Public getter and setter methods for controlled access

2. Abstraction
- Internal logic hidden inside classes such as AdminAuth and Shop
- Users interact only through method calls

3️. Inheritance (Conceptual)
- The Product class is designed to be extended into specialized product types
- Supports scalability and real-world modeling

4️. Polymorphism
- Same methods behave differently for different products
- Example: Discount calculation varies per product

# Class Structure
- Product
- CartItem
- Cart
- Shop
- AdminAuth
- OnlineShoppingSystem (Main Class)

# Admin Credentials
(Hard-coded for demo purposes)
Username: admin
Password: admin123
Note: In real-world applications, credentials should be stored securely in a database with encryption.

# Sample Menu Structure
======= ONLINE SHOPPING SYSTEM =======
1. Admin
2. Customer
3. Exit

Admin Menu
----- ADMIN MENU -----
1. Add Product
2. Update Product
3. Remove Product
4. View Products
5. Back

Customer Menu
----- CUSTOMER MENU -----
1. View Products
2. Add to Cart
3. Remove from Cart
4. View Cart
5. Checkout
6. Back

# Technologies Used
- Programming Language: Java
- Concepts: OOPS
- Interface: Console (CLI)
- Collections: ArrayList

# How to Run the Project
1. Save the file as: OnlineShoppingSystem.java
2. Compile the program: javac OnlineShoppingSystem.java
3. Run the program: java OnlineShoppingSystem

# Sample Output (Checkout)
Actual Amount: ₹65000
Discount: ₹7000
Total Payable: ₹58000

# Future Enhancements
- Database integration (MySQL)
- Customer login system
- Password encryption
- GUI using JavaFX or Swing
- Web version using Spring Boot
- Invoice generation (PDF)

# Conclusion
This project demonstrates the practical implementation of core OOPS principles in Java while simulating a real-world online shopping system.
It is modular, extensible, and exam-ready, making it ideal for academic evaluation and learning purposes.
