FROM openjdk:17
WORKDIR /opt
ENV PORT 8081
EXPOSE 8081
COPY target/*.jar /opt/order-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar order-service.jar