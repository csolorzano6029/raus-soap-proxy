# Stage 1: Build
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Copy all project files
COPY . .

# Grant permissions and build the project
RUN chmod +x gradlew
RUN ./gradlew clean build -x test

# Stage 2: Final runtime image
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /api

# Environment variables
ENV SPRING_PROFILES_ACTIVE=prod
ENV LANG=C.UTF-8

# Copy the JAR generated in the builder stage
COPY --from=builder /app/raus-services/build/libs/*.jar /api/app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
