FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Ep truc tiep thong so Database va Port vao lenh khoi chay
ENTRYPOINT ["java", "-Xmx256m", "-jar", "app.jar", \
"--server.port=8080", \
"--spring.datasource.url=jdbc:postgresql://db.tfkqymidqreyefkcsbhp.supabase.co:5432/postgres?sslmode=require", \
"--spring.datasource.username=postgres", \
"--spring.datasource.password=dUiARbpFRUUmPrkc"]
