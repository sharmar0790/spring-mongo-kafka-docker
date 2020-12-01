## Commands to run the apps in different way  

# 1) Run both kafka and client in local  
  - First download and setup the kafka in local, follow the link https://kafka.apache.org/downloads.  
  - Run the command - 'mvn spring-boot:run' from the root folder of both the apps - flight-booking and emailing-service.  
  - Refer below for application endpoints.  


# 2) Run kafka in docker and client in local host  
  - Run the docker-compose-kafka-zookeeper.yaml file present under the parent folder. This command should launch the zookeeper and kafka container and expose on needed port.  
  - Run the command - 'mvn spring-boot:run' from the root folder of both the apps - flight-booking and emailing-service.  
  - Refer below for application endpoints.   


# 3) Run both kafka and client in docker environment  
  - Run the docker-compose-kafka-zookeeper.yaml file (present under the parent folder). This command should launch the zookeeper and kafka container and expose on needed port.  
  - Follow the steps mentioned in the README.md of flight-booking service.  
  - Follow the steps mentioned in the README.md of emailing-service.  
  - Refer below for application endpoints.      
  
  
## Application Endpoints to test the services:  
 - localhost:8082/api/book-flight  -> To create the entry in database and publish message to kafka topic.  
 - localhost:8082/api/  -> To verify the application status  
 - localhost:8082/api/bookings -> to get the all bookings  
 
## Kafka consumer CLI commands to verify the messages:  
  When kafka running locally
   - kafka-console-consumer --bootstrap-server localhost:9092 --topic booking --group email_id --from-beginning  
 
  When kafka running via docker compose  
   - docker exec kafka kafka-console-consumer --bootstrap-server localhost:29092 --topic booking --group email_id --from-beginning
         
 
 > Here,   
 > [--bootstrap-server]:  is nothing but the kafka server host and port  
 > [--topic]: name of the topic  
 > [--group]: name of the consumer group  
 > [--from-beginning]: is to specify from where(which offsets) consumer should start reading the messages  
 
  
## Extra useful links:
  - https://docs.confluent.io/3.2.2/installation/docker/docs/quickstart.html
  - https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/   
  - https://spring.io/guides/topicals/spring-boot-docker/  