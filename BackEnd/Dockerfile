FROM openjdk:21
LABEL authors="mirkhan"
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} BackEnd_20240530.jar
ENTRYPOINT ["java", "-jar", "BackEnd_20240530.jar"]