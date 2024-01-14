FROM amazoncorretto:11-alpine-jdk
ARG WAR_FILE=target/*.war 
ARG PROFILES
ARG ENV
COPY ${WAR_FILE} app.war 
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "-jar", "app.war"]