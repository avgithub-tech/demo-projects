Spring Cloud Config Server:
Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server, you have a central place to manage external properties for applications across all environments.
The default implementation of the server storage backend uses git, so it easily supports labelled versions of configuration environments as well as being accessible to a wide range of tooling for managing the content. It is easy to add alternative implementations and plug them in with Spring configuration.

Here we have,
employee-config-server
  This points to configuration repository and refers to application.properties residing in repo. This config file refers to service/rest api exposed by employee-service.
  
employee-service
  This is employee service provider runs on a specific port.
  
employee-client
  This exposes rest api for various empoyee operations. Internally it interacts with employee-config-server and while calling any employee srevice rest api, it just refers to property name inside config server that points to that specific employee service api.
