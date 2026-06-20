# --- Stage 1: Build the Spring Boot Application ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Compile and package the application into a JAR file
RUN mvn clean package -DskipTests

# --- Stage 2: Run the Application ---
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the compiled JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 and run the application
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]git add .
git commit -m "Deployment: Fix Dockerfile to use a multi-stage Maven build"
git push origin master:main