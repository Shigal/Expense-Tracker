# Expense-Tracker

### Spring boot & Mongodb

#### Testcontainers dependency:
- gives the light weight throwaway instances of services like databases, message queues
- main advantage is we can run the service in a docker container and use the service to test our application

#### Mongodb:
- @Decument() - to get the spring save the class inside database - @Field() - to name a column
@Indexed() - to retrieve data faster

- If we add an object into the database for the first time use insert() or else use save()
- we indexed the expenseName field in Expense class
- we can provide the custom query to spring data in mongodb repository
 # 
```
@Query("{'name': ?0}")
Optional<Expense.> findByName(String name);
```
#
```
@Query("{'name': ?0}, 'amount': ?1}")
Optional<Expense.> findByName(String name, String amount);
```
#
### Sample Requests and Responds

#### Sample POST Request:
localhost:8080/api/expense

#### Payload
```{
"expenseName": "Netflix",
"expenseCategory": "ENTERTAINMENT",
"expenseAmount": 500
}
```

#### Response:
201 Created
# 
#### Sample GET request:
localhost:8080/api/expense


#### Response:
```[
{
"id": "63a97e0665374f6d5cd7fc79",
"expenseName": "Netflix",
"expenseCategory": "ENTERTAINMENT",
"expenseAmount": 500
}
]
```

#
#### Sample PUT request:
localhost:8080/api/expense

#### Payload:
```{
"id": "63a97e0665374f6d5cd7fc79",
"expenseName": "Netflix",
"expenseCategory": "ENTERTAINMENT",
"expenseAmount": 600
}
```

#### Response:
200 OK
#
#### Test Expense by name
#### Sample GET Request:
localhost:8080/api/expense/Netflix

#### Response:
```{
"id": "63a97e0665374f6d5cd7fc79",
"expenseName": "Netflix",
"expenseCategory": "ENTERTAINMENT",
"expenseAmount": 600
}
```

#
#### Sample DELETE request:
localhost:8080/api/expense/63a97e0665374f6d5cd7fc79

#### Response:
204 No Content

## Mongock  - Handle database migrations

- To automate the application
  * one reason is applications are usually deployed in multiple environments
  * other reason is it is hard to manage database changes(add new fields, update existing fields, update records inside collection)
- like Mongock we have Flyway and Liquibase for relational databases


## Mongock Quick start

- add mongock's bom to your pom file (which manages versions of all mongo projects) to dependency management

```<!-- https://mvnrepository.com/artifact/com.github.cloudyrock.mongock/mongock-bom -->
<dependency>
    <groupId>com.github.cloudyrock.mongock</groupId>
    <artifactId>mongock-bom</artifactId>
    <version>4.3.7</version>
    <type>pom</type>
</dependency>

```
- also add the driver
```
<dependency>
    <groupId>com.github.cloudyrock.mongock</groupId>
    <artifactId>mongock-spring-v5</artifactId>
    <version>4.3.8</version>
</dependency>  
  
```
- for runner

```
<dependency>
    <groupId>com.github.cloudyrock.mongock</groupId>
    <artifactId>mongodb-springdata-v3-driver</artifactId>
    <version>4.1.13</version>
</dependency>



```

- next enable mongock, open springboot application class and add the annotation @EnableMongock
- tell mongock where to find the database related codes
config / DatabaseChangeLog
  

[follow this tutorial](https://programmingtechie.com/2021/01/06/spring-data-mongodb-tutorial/)

