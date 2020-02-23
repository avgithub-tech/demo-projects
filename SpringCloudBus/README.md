# Spring Cloud Bus
- It broadcasts configuration changes to clients
- Eliminates needs for clients polling
- Running based on messaging technolongy
- Clients become subscribers to configuration changes.

# Broadcasting changes
- Make changes to your config files and check-in into git.
- Since config server does not poll for changes, we need to hit POST /bus/refresh to config server.
- Broker ensures message delivery to clients.
- Clients recieve message and refresh themselves.
