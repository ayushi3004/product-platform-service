**About**


This is a sample REST API exposing product and comment information for an e-commerce platform. It has a validation service to moderate/validate the comment text to prevent customers from posting objectionable content. It takes a piece of text as an input and responds with feedback regarding objectionable content. It can be wired up to use any hate speech detector/ML model and serve as response accordingly.

**Features**

The API has the following REST endpoints:
```
GET     /products
POST    /products
GET     /products/{id}
GET     /products/{id}/comments
POST    /products/{id}/comments
GET     /products/{id}/comments/{id}
```

It internally uses a `CommentValidationService` to validate comments posted.

**Tech/framework used**

- The API is built in `Java using Spring Boot framework`. The build tool used is `Gradle`.
- It internally uses `PostgreSQL` for storing data.
- The API is exposed using `Swagger` endpoints and has a `Swagger UI` for convenience.
- The entire service has been containerized using `Docker`.

**Build**

Clone this repo. Then follow these steps:
```
$ docker-compose build   #Build the image
$ docker-compose up -d   #Build the images(if not present) and start the containers in detached mode
$ docker-compose down    #Stop the containers when done
```
Access the API on `http://localhost:8080/swagger-ui.html#/`

**Project structure**

![Project structure](images/ps.png)

**Design**

Postgres db schema: `schema.sql`

Models(Exposed Bean): `Swagger UI -> Models`

**Screenshots**

![Models](images/models.png)

![API](images/API.png)


**Further scope**
- Expose more endpoints - PUT/DELETE
- Have more stringent validation on model fields
- Allow pagination in results
- Allow database migration and version control - Eg: Flyway


**References/Useful resources**

Profanity list - https://www.cs.cmu.edu/~biglou/resources/bad-words.txt

For classification model - https://www.kaggle.com/kmader/from-hate-speech-to-russian-bot-tweets/data
