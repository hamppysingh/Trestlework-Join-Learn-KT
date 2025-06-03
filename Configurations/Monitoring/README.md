# Monitoring - Readme 

## Table of Contents
- [Introduction](#introduction)
- [Dependencies](#dependencies)
- [Application YML Configuration](#application-yml-configuration)
- [File Permission Configuration](#file-permission-configuration)
- [Run](#run)
- [License](#license)
- [Acknowledgments](#acknowledgments)

---

## Introduction
Welcome to the Prometheus Grafana Monitoring for a Spring Boot application and Docker.

---

## Dependencies
In your Spring Boot pom.xml, add the prometheus and actuator dependency :

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

---

## Application YML Configuration
In your application yml add this configuration as given below:

```
management:
  endpoints:
    web:
      base-path: /actuator
      exposure.include: health, prometheus
      path-mapping.prometheus: metrics
  endpoint:
    health:
      show-details: always
    prometheus:
      cache.time-to-live: 1ms
```

---

## File Permission Configuration
In your directory add this configuration as given below:

```
chmod -R 755 prometheus
```
```
1321  sudo chown prometheus:prometheus /prometheus
```
```
1322  sudo chmod 600 /prometheus/queries.active
```
```
1323  sudo chmod -R a+w grafana/
```
```
1324  sudo chmod -R a+w prometheus/
```

---

## Run
To run Prometheus Grafana Monitoring project, use the following command:

```
docker-compose -f monitoring.yml up
```

---

## License
The Prometheus Grafana Monitoring project is licensed under the [Trestlework License](LICENSE).

---

## Acknowledgments
We would like to express our gratitude to the following individuals and organizations whose contributions and support have made this project possible:
- [] ()

Please enter an issue in the repo for any questions or problems.
Alternatively, please contact us at [support@trestlework.tech](support@trestlework.tech)
---
