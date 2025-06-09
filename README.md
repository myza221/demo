# demo
Project for API TEST

## Java 21 (Amazon corretto)
## Spring boot 3.5.0
## Git: https://github.com/myza221/demo.git

## DB script
```
CREATE DATABASE `demo` ;

CREATE TABLE book
( 
    ID  INT NOT NULL AUTO_INCREMENT, 
    TITLE VARCHAR(100) NOT NULL,
    AUTHOR  VARCHAR(100) NOT NULL,
    PUBLISHED_DATE date,
    PRIMARY KEY (ID)
);

CREATE INDEX idx_book_id ON book (ID);
CREATE INDEX idx_book_author ON book (AUTHOR);
```

## Rest API
- GET: /api/books/{author}
- POST: /api/books/save

## cUrl
- Import cUrl to Postman

curl --location 'http://localhost:8080/api/books/my' \
--header 'accept: */*'

curl --location 'http://localhost:8080/api/books/save' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--data '{
  "title": "title",
  "author": "my",
  "publishedDate": "2568-06-09"
}'

## How to run project
## Run by IDE
- Open on Intellij IDEA
- - run class main
  - run test (class test controller, service)
## Build jar and run
- open terminal
- cd to project
- mvn clean install
- java -jar target/demo-0.0.1-SNAPSHOT.jar
- mvn test (only unit test)
