## * Requirement document
### `src/main/resources/document/Altech - Java Backend Technical Assessment_2025.pdf`

## * What I have done
### `src/main/resources/document/Done-check-list.txt`

## 1. How to start this application with docker-compose:
### 1.1 Step 1: Build this project with Gradle:
### `./gradlew clean build -x test`

### 1.2 Step 2: Start this application with docker-compose:
### `docker-compose up --build`

## * You can test all API with Postman api collections I attached
### `src/main/resources/document/postman-api`

## * You can use these default users:
1. users (name, username, role) values ("Trinh Pham", "trinh.pham", "trinh.pham1234", UserRole.ADMIN);
2. users (name, username, role) values ("Ngoc Tran", "ngoc.tran", "ngoc.tran1234", UserRole.USER);
3. users (name, username, role) values ("Lan Nguyen", "lan.nguyen", "lan.nguyen1234", UserRole.USER);
4. users (name, username, role) values ("Han Pham", "han.pham", "han.pham1234", UserRole.USER);

### * Access to h2 database (you can get URL, username and password in application.yml):
### `http://localhost:8080/h2-console`

### * Run the tests:
### `./gradlew test`