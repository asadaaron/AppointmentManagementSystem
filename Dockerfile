FROM openjdk:19-jdk-slim
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/ams-backend.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/ams-backend.jar
