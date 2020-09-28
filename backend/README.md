# Employee Registry - Backend

This is a helper project that implements different version of the EmployeeRegistry backend service to help implement the Employees Web and Mobile Assignments. 
After you complete this section you will have a running backend ready to be consumed.

### Contents

   1. `Employees`: Contains the source code of our backend service EmployeeRegistry.
   2. `Employees-noAuth`: Contains the source code of the EmployeeRegistry without **Spring Security**.
   3. `registry.jar`: Pre-Built jar of the `Employees` project.
   4. `registry-noAuth.jar`: Pre-Built jar of the `Employees-noAuth` project.
   5. `registry-db.sql`: EmployeeRegistry database create script.
   6. `registry-data.sql`: EmployeeRegistry database data dump file.

### Getting Started
   
   1. Before you begin you need to have MySQL Server installed with an empty database Schema named : `employees_registry`. 
       Steps to create an empty database:
       * Open MySQL Workbech.
       * Choose a Connection ( default: `Local Instance MySQLxx`)
       * Choose: `file > Open SQL script...` then choose the `registry-db.sql` file.
   
   2. Runnning the project

       Both pre-built jars use the MySQL `root` user to connect ot the database. If your environment is aligned with the course the password should be `admin123`. 
       If the credentials are the same skip the following steps. If **not** you need to provide your user's passowrd and build your own jars.

       Follow the steps bellow:
          * Open the `Employees` and `Employees-noAuth` projects with Intellij.
          * Open the `application.properties` file located in `src/main/resources` folder of each project.
          * Change the following lines and provide your credentials:
              ```Java Properties
              spring.datasource.username=root
              spring.datasource.password=admin123
              ```
          * Run the Maven `package` task to build your own jar. The built jar file will be localted in the `target` folder.

       You can either run your project through intellij or using the command `java -jar ./registry-0.0.1-SNAPSHOT.jar` from any cli.

       For the cli to work your working path needs to be the folder where the jar is located. 
          * If you are using powershell, navigate to the folder through the explorer, press `SHIFT + Right Click` and choose `Open Power Shell Window here`. In the Window that opens paste the java command.
          * If you are using Git Bash navigate to the folder through the Windows explorer and press `Right Click`, then choose `Git Bash here` and paste the java command.
   
       After you run the application you should see something Like this in the console:
            INFO 10592 --- [           main] DeferredRepositoryInitializationListener : Spring Data repositories initialized!
            INFO 10592 --- [           main] g.h.e.registry.RegistryApplication       : Started RegistryApplication in 4.949 seconds (JVM running for 8.704)
   
       If you see an exit code, something is not properly configured, you need to retrace your steps.
       Make sure you provided valid credentials for the database and that the empty schema `employees_registry` exists.
   
   3. Mock Data
       **This step requires the successful completion of the previous section!**

       After the application has successfully started, make sure your schema is populated with the required tables:
          * `Company`
          * `Department`
          * `Employee`

       In order for our backend to work properly we need some data entry:
          * Open MySQL Workbech.
          * Choose a Connection ( default: `Local Instance MySQLxx`).
          * Choose: `file > Open SQL script...` then choose the `registry-data.sql` file.
          * Execute the script (press the `Thunder` icon on the top of the editer) to populate the tables with Mock Data.

### The Application
   
   Inorder to see a full specification of the API, execute the jar and visit: http://localhost:8080/registry/swagger-ui.html 

   You will see a List of all the supported HTTP methods and URIs. By clicking on a method you will see all the required Request parameters or objects and their Responses.

   In the Schemas section there is a list of all the DTOs ( Data Transfer Objects ) used in the api.

   As mentioned above there are two versions of the backend-service `Employees` ( pre-built: `registry.jar`) and `Employees-noAuth` ( pre-built: `registry-noAuth.jar`).
   
   1. The `Employees-noAuth` project and jar, ommit the **Spring Security** framework, meaning you can make any request to the api without Authorization.

   2. The `Employees` project and jar, include the **Spring Security** framework and with the exception of `/login` and `POST /employees`(register) endpoints, all other request need to be authenticated or an error response will be sent. 


        * Authorization in our project follows the [Basic Authentication](https://swagger.io/docs/specification/authentication/basic-authentication/#:~:text=Basic%20authentication%20is%20a%20simple,55w0rd%20the%20client%20would%20send) flow. 
        
            Basic authentication is a simple authentication scheme built into the HTTP protocol. The client sends HTTP requests with the Authorization header that contains the word Basic word followed by a space and a base64-encoded string username:password. For example, to authorize as demo / p@55w0rd the client would send
            
            ```
            Authorization: Basic ZGVtbzpwQDU1dzByZA==
            ```

            The above string is the Base64 encoded version of `demo:p@55w0rd`.


        * Because the `login` endpoint is an auto-generated endpoint fro the **Spring Security** framework, its specification is shown here:

            **Request:**

            POST http://localhost:8080/registry/login
            ```JSON
            {
                "username": "string",
                "password": "string"
            }
            ```

            **Response:**

            Headers: Authorization: Basic c3RyaW5nOnN0cmluZw==
            ```JSON
            
            ```

        **Note!:** The Authorization Header is included in the Response after a successful login only, and only for **convinience**. This practice should not be followed in a real-world senario. 
        
        After acquiring the Authorization header you can make all other requests to the api by including it to every request you send.