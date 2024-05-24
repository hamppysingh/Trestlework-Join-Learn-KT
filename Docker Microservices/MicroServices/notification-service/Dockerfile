FROM openjdk:17
WORKDIR /opt
COPY target/*.jar /opt/notification-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar notification-service.jar