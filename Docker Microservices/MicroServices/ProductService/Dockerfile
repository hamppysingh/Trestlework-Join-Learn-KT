FROM openjdk:17
WORKDIR /opt
COPY target/*.jar /opt/product-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar product-service.jar