FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/appgestionstock-0.0.1-SNAPSHOT.jar appgestionstock-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "appgestionstock-0.0.1-SNAPSHOT.jar"]
