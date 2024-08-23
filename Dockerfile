FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/appgestionstock-0.0.1-SNAPSHOT.jar appgestionstock-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","appgestionstock-0.0.1-SNAPSHOT.jar"]