# demo
Project for API TEST

## Java 21 (Amazon corretto)
## Spring boot 3.5.0

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
```

## Rest API
- GET: /api/books/{author}
- POST: /api/books/save

## Curl

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
