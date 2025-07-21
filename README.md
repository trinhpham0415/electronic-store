## Requirement document
### `src/main/resources/document/Altech - Java Backend Technical Assessment_2025.pdf`

## What I have done
### `src/main/resources/document/Done-check-list.txt`

## 1. How to start this application with docker-compose:
### 1.1 Step 1: Build this project with Gradle:
### `./gradlew clean build -x test`

### 1.2 Step 2: Start this application with docker-compose:
### `docker-compose up --build`

## You can test all API with Postman api collections I attached
### `src/main/resources/document/postman-api`

### Access to h2 database (you can get URL, username and password in application.yml):
### `http://localhost:8080/h2-console`

### Run the tests:
### `./gradlew test`