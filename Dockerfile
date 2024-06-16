FROM openjdk:17
EXPOSE 8080
ARG JAR_FILE
ARG APP_CONFIG

COPY ${JAR_FILE} app.jar
COPY ${APP_CONFIG} /application.yml

ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.location=/application.yml"]