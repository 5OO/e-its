# E-ITS Catalog

## Project Description

This Spring Boot application fetches data from the E-ITS catalog version 2024 and displays it in a web application. The data is fetched from a JSON API and presented in a table format.

## Project Structure

- **index.html**: Thymeleaf template for displaying the data in a table.
- **Article.java**: Model class representing an article.
- **ArticleService.java**: Service class responsible for fetching and processing the data.
- **ArticleController.java**: Controller class for handling HTTP GET requests.

## Setup Instructions

### Prerequisites

- Java 17 or later
- Maven 3.6.3 or later

### How to Run

1. **Clone the repository**

   ```sh
   git clone https://github.com/yourusername/yourrepository.git
   cd yourrepository
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