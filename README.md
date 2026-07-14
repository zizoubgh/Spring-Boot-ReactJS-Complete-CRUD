# Spring Boot & ReactJS Complete CRUD Application
<img width="1360" height="768" alt="image" src="https://github.com/user-attachments/assets/ecfbe70a-805a-40ea-92f3-b00af6d47db5" />

A full-stack CRUD (Create, Read, Update, Delete) application built with Java Spring Boot for the backend and ReactJS for the frontend.

---

## 🛠️ Prerequisites  

Before running the project, make sure you have the following installed:
* **Java JDK 17** or higher
* **Node.js** (v18 or higher) & **npm**
* **Maven** (optional, if you want to run via CLI)
* Your preferred IDE (e.g., IntelliJ IDEA, VS Code, Eclipse)

---

## 🚀 Getting Started  

Follow these steps to set up and run the application locally.
1.  backend Setup (spring boot)
 cd backend
Configure your database settings in src/main/resources/application.properties (e.g., update your MySQL/PostgreSQL username and password):

Properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
Run the Spring Boot application:

Using Maven CLI:

Bash
mvn clean install
mvn spring-boot:run

2. rontend Setup (ReactJS)
Open a new terminal and navigate to the frontend directory:

Bash
cd frontend
Install the required dependencies:

Bash
npm install
Start the React development server:

Bash
npm start
