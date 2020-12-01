#  Emailing service

## Commands to build the image of service
###1) Build and run locally
  - mvn spring-boot:run
  
###2) Build and run in docker container   
 - Goto the root directory of the flight booking service.  
 - Run the command  
   - docker build .  
 - Execute the below command to run the container and provide the external spring config application.yaml file.    
      - docker run --name es --network rmoff_services -v /projects/kafka:/conf --link kafka  {image_id_of_emailing_service} --spring.config.location=/conf/application.yaml
      
      
   > Here, if you see the startup logs there you won't see any tomcat related stuff as we are not using the tomcat. 
   > In this app we are only consuming the messages from broker, so, no need to have any application server.
   

### Ways to remove the application server ability (i.e. tomcat) from spring boot.
  * Add below properties in application.yaml file
    ```
    spring:
      main:
        web-application-type: none
    ```
  * Exclude **spring-boot-starter-web** dependency from your module. 
    ```
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```		
  * Change your main method implementation as mentioned below
    ```
    @SpringBootApplication
    public class EmailingServiceApplication {
    	public static void main(String[] args) {
    		SpringApplication app = new SpringApplication(EmailingServiceApplication.class);
  	  	    app.setWebApplicationType(WebApplicationType.NONE);
  	    	app.run(args);
  	  }
    }
    ```
  
  > I'd suggest to use the first approach that way we will have the control in our hand whether to use the application server or not.  
  > We can configure that at run time by providing the external config file.   
    
          
        