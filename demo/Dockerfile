# Giai đoạn 1: Build file JAR từ mã nguồn
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
# Chạy lệnh build trực tiếp trên server Render
RUN mvn clean package -DskipTests

# Giai đoạn 2: Chạy file JAR đã build
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Lấy file jar vừa build ở trên sang (vì target local không được push lên)
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]