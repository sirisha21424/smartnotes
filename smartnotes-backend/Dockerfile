# Step 1: Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the build artifact from the target folder into the container
COPY target/*.jar app.jar

# Step 4: Run the spring boot application
ENTRYPOINT ["java", "-jar", "app.jar"]