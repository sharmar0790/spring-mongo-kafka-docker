# Mongo


## Setting up mongo  
  - ### Mongo Locally
    -  Follow the link, choose your operating system and follow the steps accordingly - https://docs.mongodb.com/manual/installation/#mongodb-community-edition-installation-tutorials.  
    -  Once done, you can use the either of the below commands to run the mongo  
      - $ mongod --dbpath {db_path} --logpath {log_file_path} Ex: mongod --dbpath /projects/mongodb/mongo/db/ --logpath /mongodb/mongo/logs/mongo.log  
      - $ mongodb --config {config_file_path} Ex: mongod --config /projects/spring-kafka/mongo/mongod.conf    
    - Now to run the mongo shell, open another terminal and run the command **mongo**. You will see the output like below.  
    
    ```sh
     $ mongo
      MongoDB shell version v4.4.2
      connecting to: mongodb://127.0.0.1:27017/?compressors=disabled&gssapiServiceName=mongodb
      Implicit session: session { "id" : UUID("aa0eb0fa-a21b-464b-8c52-9cf43973ec99") }
      MongoDB server version: 4.4.2
      ---
      The server generated these startup warnings when booting: 
              2020-12-01T12:53:06.846+00:00: Access control is not enabled for the database. Read and write access to data and configuration is unrestricted
              2020-12-01T12:53:06.846+00:00: You are running this process as the root user, which is not recommended
              2020-12-01T12:53:06.886+00:00: Soft rlimits too low
              2020-12-01T12:53:06.886+00:00:         currentValue: 256
              2020-12-01T12:53:06.886+00:00:         recommendedMinimum: 64000
      ---
      ---
              Enable MongoDB's free cloud-based monitoring service, which will then receive and display
              metrics about your deployment (disk utilization, CPU, operation statistics, etc).
      
              The monitoring data will be available on a MongoDB website with a unique URL accessible to you
              and anyone you share the URL with. MongoDB may use this information to make product
              improvements and to suggest MongoDB products and deployment options to you.
      
              To enable free monitoring, run the following command: db.enableFreeMonitoring()
              To permanently disable this reminder, run the following command: db.disableFreeMonitoring()
      ---
      > show databases;
      admin           0.000GB
      config          0.000GB
      flight-booking  0.000GB
      local           0.000GB
      > 
    >
    ```
    - Use below properties in client's application.yaml file to connect to mongo  
      ```
      #mongo db configuration
      spring:
        data:
          mongodb:
            host: localhost
            port: 27017
            database: flight-booking
            username: root
            password: root
            authentication-database: admin
        ```
 
  - ### Mongo in a Docker Container and client locally
    - Execute the below commands to run the mongo in a containerized way
     - docker-compose -f docker-mongo-stack.yaml up
     - docker-compose -f docker-mongo-stack.yaml up -d # in detached mode
       
       ```
       $ docker-compose -f docker-mongo-stack.yaml up -d
       Starting mongo_mongo_1         ... done
       Starting mongo_mongo-express_1 ... done
       ```
     - docker-compose -f docker-mongo-stack.yaml stop # to sop the running mongo service
       
       ```
       $ docker-compose -f docker-mongo-stack.yaml stop
       Stopping mongo_mongo-express_1 ... done
       Stopping mongo_mongo_1         ... done
       ```
     - No changes needs to be done in client if you are running client locally.    
     
  - ### Mongo and Client both running in Docker container
    - Follow the above mentioned steps to run the mongo in docker.
    - Follow the steps mentioned in the README.md of flight-booking service.  
    - Follow the steps mentioned in the README.md of emailing-service.
      
## How to view the data visually.
  - We will be using the below approaches to visualize the data:    
    * **mongo-express**
      - If you see docker-mongo-stack.yaml we are also deploying the mongo-express on port 8081.  
      - Access it by using - https://{docker_hots_ip}:8081. Ex: https://localhost:8081          
      - Once you hit the URL in browser, you will see the mongo-express page. 
        - You can maintain your collections from UI itself.
        - Check the status of the server.
        - Check or play with all collections.
        - Monitor mongo server and much more.
    
## Other useful links
  - https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html
  - https://www.mongodb.com/nosql-explained
  - https://www.mongodb.com/products/compass
  - https://docs.mongodb.com/manual/reference/configuration-options/ 
  - Installation https://docs.mongodb.com/manual/installation/
      
4) docker compose file to run kafka and mongo together
5) see for mongo atlas