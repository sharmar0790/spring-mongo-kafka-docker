## Some of the useful kafka commands:

  - ========Topics Command========  
    - kafka-topics --zookeeper 127.0.0.1:2181 --topic first-topic --create --partitions 3 --replication-factor 1  
    - kafka-topics --zookeeper 127.0.0.1:2181 --list  
    - kafka-topics --zookeeper 127.0.0.1:2181 --topic first-topic --describe  
    - kafka-topics --zookeeper 127.0.0.1:2181 --topic first-topic --delete  

  - ========Producer Command=============  
    - kafka-console-producer --broker-list 127.0.0.1:9092 --topic first-topic  
    - kafka-console-producer --broker-list 127.0.0.1:9092 --topic first-topic --producer-property acks=all    #adding a property  
    - kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic --property parse.key=true --property key.separator=,  


  - ========Consumer Command=============  
    - kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first-topic  
    - kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first-topic --group my-app  
    - kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first-topic --group my-app --from-beginning     #start reading the message from topic from beginning  
    - kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning --property print.key=true --property key.separator=,  


  - ==========consumer groups=============  
    - kafka-consumer-groups --bootstrap-server 127.0.0.1:9092 --list  
    - kafka-consumer-groups --bootstrap-server 127.0.0.1:9092 --describe --group my-app      
    - kafka-consumer-groups --bootstrap-server 127.0.0.1:9092 --describe --group my-app --reset-offsets --to-earliest --execute --topic first_topic  
    
    
    
## Command to start the zookeeper locally  
  - ./zookeeper-server-start.sh  /kafka/config/zookeeper.properties  
  
## Command to start the kafka locally       
  - ./kafka-server-start.sh /kafka/config/server.properties  
  