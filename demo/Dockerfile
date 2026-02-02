# Phase 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Phase 2: Deploy (Su dung lenh ep bien moi truong)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# "Nuclear Option": Truyen truc tiep bien vao lenh java -jar
ENTRYPOINT ["java", "-Xmx256m", "-Djava.net.preferIPv4Stack=true", "-jar", "app.jar", \
"--spring.datasource.url=jdbc:postgresql://db.tfkqymidqreyefkcsbhp.supabase.co:6543/postgres?sslmode=require&prepareThreshold=0", \
"--spring.datasource.username=postgres", \
"--spring.datasource.password=dUiARbpFRUUmPrkc"]