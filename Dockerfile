# Stage 1: Build the Spring Boot WAR file
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Use Tomcat base image and copy WAR
FROM tomcat:9.0-jdk17-temurin
LABEL maintainer="fowobideveloper@gmail.com"

# Remove default apps to keep it lean
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR file from builder stage
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
