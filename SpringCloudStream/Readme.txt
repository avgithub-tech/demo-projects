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
For Kafka:
spring-cloud-stream-producer
    - cloud stream
    - kakfka
    - web

spring-cloud-stream-consumer
    - cloud stream
    - kafka
    
For RabbitMq:
spring-cloud-stream-producer
    - cloud stream
    - Rabbitmq
    - web

spring-cloud-stream-consumer
    - cloud stream
    - Rabbitmq
--------------------------------------------------------------------------------------------
Steps to run (Kafka):
1. Start zookeeper server

2. Start kafka server

3. Create a topic called employee-stream

4. Run spring-cloud-stream-producer

5. Run spring-cloud-stream-consumer

6. Using postman, post an employee object to producer

7. Check consumer log, it should have recived the same object
--------------------------------------------------------------------------------------------
Steps to run (RabbitMq):
1. Start rabbitmq server

4. Run spring-cloud-stream-producer

5. Run spring-cloud-stream-consumer

6. Check RabbitMq manager, there will be an exchange employee-stream and an queue on it with 1 consumer

6. Using postman, post an employee object to producer

7. Check consumer log, it should have recived the same object
