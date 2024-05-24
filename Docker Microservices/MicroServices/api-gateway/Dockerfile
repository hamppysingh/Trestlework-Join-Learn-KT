FROM openjdk:17
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/api-gateway.jar
ENTRYPOINT exec java $JAVA_OPTS -jar api-gateway.jar