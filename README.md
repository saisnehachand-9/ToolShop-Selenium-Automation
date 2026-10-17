# ToolShop Selenium Automation Framework

## Project Overview
This project automates key user workflows of the Practice Software Testing web application using Selenium WebDriver and Java.

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI for Excel-based data-driven testing
- Page Object Model (POM)
- Extent Reports

## Test Scenarios
- User registration
- Login with valid and invalid test data
- My Account validation
- Product selection
- Adding products to the cart
- Checkout workflow

## Framework Features
- Page Object Model for reusable and maintainable code
- Data-driven login testing using Excel
- TestNG test suites
- Test execution reports and screenshots through a listener

## Project Structure
- `src/test/java/pageObjectClasses` – Page classes and web element interactions
- `src/test/java/testCases` – Test classes
- `src/test/java/Utilities` – Data providers, Excel utilities, and reporting listener
- `test-data` – Excel test data
- `Reports` – Test reports generated during execution
- `screenshots` – Screenshots captured during test execution

## How to Run
1. Clone or download this repository.
2. Import the project into Eclipse as an existing Maven project.
3. Ensure Java and Maven dependencies are configured.
4. Run the required TestNG XML suite.

## Purpose
This project demonstrates practical UI automation, reusable test design, and data-driven testing using Selenium WebDriver and TestNG.