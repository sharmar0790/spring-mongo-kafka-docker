##  Emailing service

# Commands to build the image of service  
 - Goto the root directory of the flight booking service.  
 - Run the command  
   - docker build .  
 - Execute the below command to run the container and provide the external spring config application.yaml file.    
      - docker run --name es --network rmoff_kafka -v /projects/kafka:/conf --link kafka  {image_id_of_emailing_service} --spring.config.location=/conf/application.yaml  
        