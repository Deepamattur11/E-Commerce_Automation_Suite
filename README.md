# E-Commerce_Automation_Suite
# Selenium-POM-Automation-Framework 🚀

## 📌 Project Overview
A robust, scalable, and maintainable Test Automation Framework built for the **OrangeHRM** application. This project demonstrates the **Page Object Model (POM)** design pattern, separating test logic from UI mapping to ensure long-term stability and ease of maintenance.

## 🛠 Tech Stack
* **Language:** Java 1.8
* **Automation Tool:** Selenium WebDriver (v4.39.0)
* **Testing Framework:** TestNG
* **Build Tool:** Maven
* **Reporting:** ExtentReports
* **Utilities:** JavaFaker (Dynamic Data), Jackson Databind (JSON Data Handling)

## 🏗 Framework Architecture
The framework is structured to follow industry best practices:
* **src/main/java:** Contains Page Objects, Abstract Components (Reusable Utilities), and Resource management.
* **src/test/java:** Contains Test Suites, Base Test configuration, and custom Listeners for failure handling.
* **Data-Driven:** Leverages JSON files and TestNG DataProviders to separate test data from code.

## ✨ Key Features
- **Page Object Model:** Modular design for high maintainability.
- **Synchronization:** Implementation of Explicit Waits to handle asynchronous application behavior.
- **Flaky Test Management:** Integrated **Retry Analyzer** to automatically re-run failed tests.
- **Dynamic Data:** Used **JavaFaker** to generate unique employee records during runtime.
- **Parallel Execution:** Configured via `testng.xml` and Maven Surefire plugin for faster execution.
- **Robust Reporting:** Generates detailed HTML ExtentReports with screenshots captured automatically on test failure.

## 🚀 How to Run
1. Clone the repository: `git clone [Your-Repo-URL]`
2. Navigate to project folder.
3. Run tests via Maven: `mvn test`
4. Or run specific suites: `mvn test -PSubmitOrder`
