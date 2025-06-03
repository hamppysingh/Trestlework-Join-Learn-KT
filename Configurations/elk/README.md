# ELK - Readme 

## Table of Contents
- [Introduction](#introduction)
- [Dependencies](#dependencies)
- [LogBack Configuration](#logback-configuration)
- [File Permission Configuration](#file-permission-configuration)
- [Run](#run)
- [License](#license)
- [Acknowledgments](#acknowledgments)

---

## Introduction
Welcome to the ELK (Elasticsearch, Logstash, Kibana) for a Spring Boot application and Docker.

---

## Dependencies
In your Spring Boot pom.xml, add the Logback JSON encoder dependency to format logs as JSON:

```
 <dependency> 
 <groupId>net.logstash.logback</groupId>
  <artifactId>logstash-logback-encoder</artifactId>
  <version>6.6</version> 
 </dependency>
```

---

## Logback Configuration
In you Spring boot `logback.xml` add logstash configuration as given below:

```
<appender name="STASH" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <file>${DEV_HOME}/logstash/${APP_NAME}.log</file>
    <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <!-- rollover daily -->
        <fileNamePattern>${DEV_HOME}/logstash/archived/${APP_NAME}-log.%d{yyyy-MM-dd}.%i.log
        </fileNamePattern>
        <timeBasedFileNamingAndTriggeringPolicy
                class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
            <maxFileSize>10MB</maxFileSize>
        </timeBasedFileNamingAndTriggeringPolicy>
    </rollingPolicy>
    <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
</appender>
<logger name="com.microservices.demo" level="info" additivity="false">
    <appender-ref ref="FILE"/>
    <appender-ref ref="STDOUT"/>
    <appender-ref ref="STASH"/>
</logger>

<root level="info">
    <appender-ref ref="STASH"/>
</root>
```

---

## File Permission Configuration
In your elk directory add this configuration as given below:

```
sudo chmod go-w ./filebeat/filebeat.docker.yml
```
```
sudo chown root ./filebeat/filebeat.docker.yml
```

---

## Run
To run ELK project, use the following command:

```
docker-compose up
```

---

## License
The ELK project is licensed under the [Trestlework License](LICENSE).

---

## Acknowledgments
We would like to express our gratitude to the following individuals and organizations whose contributions and support have made this project possible:
- [] ()

Please enter an issue in the repo for any questions or problems.
Alternatively, please contact us at [support@trestlework.tech](support@trestlework.tech)
---
