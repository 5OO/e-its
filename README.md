# E-ITS Catalog

## Project Description

This Spring Boot application fetches data from the E-ITS catalog version 2024 and displays it in a web application. The data is fetched from a JSON API and presented in a table format.
![Screenshot 2024-06-12 at 15 52 13](https://github.com/5OO/e-its/assets/27925052/f7578a0a-81ae-46d0-938d-f1d6b388597f)

## Project Structure

- **index.html**: Thymeleaf template for displaying the data in a table.
- **Article.java**: Model class representing an article.
- **ArticleService.java**: Service class responsible for fetching and processing the data.
- **ArticleController.java**: Controller class for handling HTTP GET requests.
![Screenshot 2024-06-12 at 15 52 54](https://github.com/5OO/e-its/assets/27925052/278957a9-b5fd-4831-86fb-683286e15aab)
 
## Setup Instructions

### Prerequisites

- Java 17 or later
- Maven 3.6.3 or later

### How to Run

1. **Clone the repository**

   ```sh
   git clone https://github.com/5OO/e-its.git
   cd e-its
2. **Build the project**

    ```sh
    mvn clean install
    ```
3. **Run the application**

    ```sh
    mvn spring-boot:run
    ```
4. **Access the application**

    Open a web browser and navigate to:

    ```sh
    http://localhost:8080
    ```
