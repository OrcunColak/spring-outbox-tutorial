# Read Me First
The original idea is from here   
https://dip-mazumder.medium.com/consistency-in-microservices-transactional-outbox-pattern-bcd9d3b08676

This project demonstrates outbox pattern usage. 

When BookOrder controller gets a post request, the BookOrderService inserts a new OutboxEvent to database.  
The OutboxPoller polls the database in regular intervals and publishes new records to Kafka  
There are two Kafka Listeners that process the message 

An alternative to poller could be using CDC to capture database events

# Swagger
Go to  
http://localhost:8080/swagger-ui/index.html

for Open API YAML go to  
http://localhost:8080/v3/api-docs.yaml