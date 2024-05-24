FROM openjdk:17
WORKDIR /opt
COPY target/*.jar /opt/inventory-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar inventory-service.jar