FROM openjdk:17-jdk-alpine
WORKDIR /electronic-store
COPY build/libs/electronic-store-0.0.1-SNAPSHOT.jar electronic-store.jar
ENTRYPOINT ["java", "-jar", "electronic-store.jar"]