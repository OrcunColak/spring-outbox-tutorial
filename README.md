# Read Me First

The original idea is from here   
https://dip-mazumder.medium.com/consistency-in-microservices-transactional-outbox-pattern-bcd9d3b08676

This project demonstrates outbox pattern usage.

When BookOrder controller gets a post request, the BookOrderService inserts a new OutboxEvent to database.  
The OutboxPoller polls the database in regular intervals and publishes new records to Kafka  
There are two Kafka Listeners that process the message

An alternative to poller could be using CDC to capture database events

# RabbitMq Example

There is another example that uses RabbitMq instead of Kafka here
https://medium.com/@omernaci/transactional-outbox-pattern-72ba980514bc

# NoSQL Outbox Pattern

For NoSQL databases sometimes we lose the luxury of transactions.
...
The solution, though, is surprisingly straightforward: we denormalize the data.
Since we can’t rely on sequential writes, denormalizing the data allows us to condense everything into a single write
operation.
https://readmedium.com/interview-so-how-do-you-do-a-transaction-with-nosql-databases-c3d80bc7d314

# Swagger

Go to  
http://localhost:8080/swagger-ui/index.html

for Open API YAML go to  
http://localhost:8080/v3/api-docs.yaml