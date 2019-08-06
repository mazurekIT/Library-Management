# Getting Started

### Building
To build the project use following command:

'mvn package'


### Running
After building the application run following command to start it:

'java -jar target/cognifide-0.0.1-SNAPSHOT.jar'

starting port: http://localhost:8080/ 


### Access Endpoints available

- Book by ISBN url: /api/book/{isbn}
- Books by category url: /api/category/{categoryName}/books
- Books by query url: /api/api/search?q={phrase}
- Authors rating url: /api/rating


### Access to File 

It is possible to change file path by attribute 'bookFilePath' located in 'application.properties'  