# Splunk

## Steps to run the splunk in a docker environment
  - Execute the command:
    ```sh
    docker-compose -f docker-compose-splunk.yaml up
    ```
  
  - Once you're done access the splunk by using:
      ```sh
      localhost:8000
      ```  
  - You can configure the **volumes** options in compose file to change the path of app log file to read from.
  
  - Then run the application by passing run time external property for LOG FIle location:
    ```sh
    java -jar app.jar -DLOG_FILE=${destination_of_the_log_file_path_with_name}
    ```
    
  - Click on **Data Summary** and then select **splunkforwarder**.    