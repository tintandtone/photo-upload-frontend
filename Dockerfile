FROM adoptopenjdk:11-jdk-hotspot

WORKDIR /app
COPY build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]