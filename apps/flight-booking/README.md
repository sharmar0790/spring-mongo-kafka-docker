#  Flight-booking service

## Commands to build the image of service
###1) Build and run locally
  - mvn spring-boot:run
  
###2) Build and run in docker container  
  - Goto the root directory of the flight booking service.  
  - Execute the command  
    - docker build .  
  - Execute the below command to run the container and provide the external spring config application.yaml file.
    - docker run -p 8081:8081 --name fbs --network rmoff_services -v /projects/kafka:/conf --link kafka  {image_id_of_flight_booking_service} --spring.config.location=/conf/application.yaml
   
    
   > In this command we are exposing this container on port 8081. Launching this in network rmoff_services (which will be creating at the time of launching kafka).
   > Then we are overriding the config file by mounting the host volume to the container volume and then referring the file. This way we can deploy this image wherever we want just by overring the config file as per the environment.
     
        