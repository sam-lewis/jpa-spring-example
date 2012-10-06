JPA Spring Example
==================

Basic example of Spring and JPA integration with an embedded database and CXF Web Service.

Clone and Build:
----------------
* `git clone https://github.com/sam-lewis/jpa-spring-example.git`
* `cd jpa-spring-example`
* `mvn package`

Run Integration Tests
---------------------
* `mvn integration-test`

Manually Test web service
--------------------------
* `mvn package jetty:run`
* Using SOAPUI, create a project from http://localhost:8080/service/user?wsdl

Schema Generation
-----------------
During the build, schema files are written to `target/hibernate3/sql`