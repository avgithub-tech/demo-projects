- Spring Cloud Stream is a framework for building highly scalable event-driven microservices connected with shared messaging systems.

- Spring cloud stream supports variety of binder implplementations,
    - RabbitMQ
    - Apache Kakfka
    - Amazon Kenesis
    - Google PubSub
    etc..

- It helps removing tight coupling with any messaging service

- We only need to add messaging queue'e binder dependencies

-------------------------------------------------------------------------------------------

spring-cloud-stream-producer
    - cloud stream
    - kakfka
    - web

spring-cloud-stream-consumer
    - cloud stream
    - kafka
--------------------------------------------------------------------------------------------
Steps to run:
1. Start zookeeper server

2. Start kafka server

3. Create a topic called employee-stream

4. Run spring-cloud-stream-producer

5. Run spring-cloud-stream-consumer

6. Using postman, post an employee object to producer

7. Check consumer log, it should have recived the same object
