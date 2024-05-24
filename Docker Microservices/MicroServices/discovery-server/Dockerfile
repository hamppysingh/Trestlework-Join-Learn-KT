FROM openjdk:17
WORKDIR /opt
ENV PORT 8761
EXPOSE 8761
COPY target/*.jar /opt/discovery-server.jar
ENTRYPOINT exec java $JAVA_OPTS -jar discovery-server.jar