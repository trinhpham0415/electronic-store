

## 1. How to start this application with docker-compose:
### 1.1 Step 1: Build this project without tests:
### `./gradlew clean build -x test`

### 1.2 Step 2: Start this application with docker-compose:
### `docker-compose up --build`

## Run the tests:
### `./gradlew test`

## Access to h2 database (you can get URL, username and password in application.yml):
### `http://localhost:8080/h2-console`



