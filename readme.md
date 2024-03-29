## User's Guide: Product Pricing Application
This guide provides instructions for developers on how to set up and run the product pricing application, as well as how to interact with the API through Swagger.
### 1. Herramientas de Desarrollo

- **IDE:**Use IntelliJ for project development.
- **Java version:** Make sure you have Java version 17 installed.
- **Unit Management:** Maven.

### 2. Project Architecture

The project has been developed using the hexagonal architecture with Application, Domain and Infrastructure layers, divided into different modules in order to make the layers independent. This architecture allows a better separation of concerns and facilitates the maintenance and scalability of the code.

- **Application Layer (Application):** Contains the application logic and user interfaces. User requests are handled here and communicate with the domain layer.
- **Domain Layer (Domain):** It contains the business logic and domain rules. Entities, services and repositories that represent the core of the application are defined here.
- **Infrastructure Layer (Infrastructure):** It contains concrete implementations of the technical details, such as the database, external services and APIs. This layer is responsible for interacting with external technologies.

### 3. Application Configuration and Execution

1. **Clone the Repository and navigate to the Project Directory:**
- git clone [URL] && cd name

2. **Compile and Execute the Application:**
- Make sure that port 8080 is free on your system.
- Open a terminal in the project directory and execute the following commands:
  ```
  mvn clean install
  cd infraestructure
  mvn exec:java -Dexec.mainClass="com.msprices.DiegoApplication"
  ```
- The application will run on: [http://localhost:8080/](http://localhost:8080/)

### 4. Access Swagger

To test and document the API, Swagger, an interactive interface, is used.

- **Url Swagger:** [http://localhost:8080/v1/api/swagger-ui/index.html#/](http://localhost:8080/v1/api/swagger-ui/index.html#/)

#### Example of Request using CURL

```bash
curl -X POST "http://localhost:8080/v1/api/price" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"date\": \"2020-06-16-21.00.00\", \"idBrand\": 1, \"idProduct\": 35455}"

