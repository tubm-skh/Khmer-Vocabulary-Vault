FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Su dung dau ngoac kep de tranh loi doc bien
ENTRYPOINT ["java", "-Xmx256m", "-Djava.net.preferIPv4Stack=true", "-jar", "app.jar"]