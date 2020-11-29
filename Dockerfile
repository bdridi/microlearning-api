FROM openjdk:11-jre-slim
WORKDIR /application
COPY target/*.jar microlearing-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","microlearing-api.jar"]