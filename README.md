# == Spring Boot - Samples - CXF Rest Web Services 

[源码地址 jaxws_spring_boot](https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples/jaxws_spring_boot)

This sample project demonstrates how to use CXF JAX-RS services
with Spring Boot and Spring Actuator. This demo has two JAX-RS class resources being deployed 
in a single JAX-RS endpoint.  

## Starting the server =

The sample uses Maven. It can be built and run from the command line using Maven, Java or Docker:

> ---- With Maven ----
```shell
$ mvn -Pserver
```

> ---- With Java ----
```shell
$ java -jar target/spring-boot-sample-rs-cxf.jar
```

> ---- With Docker ----

Install Docker, create the demo image:
```shell
$ mvn dockerfile:build
```


Optional step, push the image. 
Create a DockerHub id, for example, make this id set to your current ${username}
```shell
$ docker login
$ mvn dockerfile:push
```

Run the container:
```shell
docker run -p 8080:8080 -t ${username}/apachecxf:spring-boot-sample-rs
```

## = Testing the server =

> ---- From the browser ----

http://localhost:8080/services/helloservice/sayHello/ApacheCxfUser

will display "Hello ApacheCxfUser, Welcome to CXF RS Spring Boot World!!!"

http://localhost:8080/services/helloservice/sayHello2/ApacheCxfUser

will display "Hello2 ApacheCxfUser, Welcome to CXF RS Spring Boot World!!!"

http://localhost:8080/services/helloservice/openapi.json will return a Swagger JSON
description of services.

To view the OpenAPI document using Swagger-UI, use your browser to
open the Swagger-UI page at

  http://localhost:8080/services/helloservice/api-docs?url=/services/helloservice/openapi.json

or access it from the CXF Services page:

  http://localhost:8080/services/helloservice/services
  and follow a Swagger link.

To view the exposed metrics:
  http://localhost:8080/actuator/metrics

The Apache CXF specific metrics are available under:
  http://localhost:8080/actuator/metrics/cxf.server.requests

---- From the command line ----
```shell
$ mvn -Pclient
```
