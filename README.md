
# National Park's Resorts Booking


* Project Original Thoughts:


Have you gotten frustrated by booking popular hotel rooms in national parks yet? This application is going to make your booking experience much easier than ever.
After having your expected room type and specific travel date, this application will send you text messages once your expected room is available.


* Project Technical Overview:

This application is developed in Spring Framework by using Spring Boot, Spring Data, Hibernate, Spring RESTful web services, Postman, Maven, PostgresSql, Docker, Amazon SQS, and Amazon S3.


* Project Business Rules:

 1. Object: User, Order, Payment, Room, Resort, Park

 2. Relationships:
 
    One user could have many orders.
    
    One order could have several payments.
    
    One order only can have one room type with one specific date.
    
    One Resort could have many rooms.
    
    One park could have many resorts.
    
* Project Approach:

1. Created User, Order, Payment, Room, Resort, Park domain

2. Used Hibernate to do the database schema migration

3. Used JDBC to connect project with Postgres

4. Configured Spring Security for Authentication

5. Created repository, service and did test

6. Did mock test for AWS S3 Storage service

7. Created Controllers and Restful APIs

8. Integrated third-party application AWS SQS and did Mock test

9. Used Postman to interact with back-end project

10. Package my project into a Docker image

# Configure local environment

```
docker pull postgres

docker run --name ${PostgresContainerName} -e POSTGRES_USER=${username} -e POSTGRES_PASSWORD=${password} -e POSTGRES_DB=${databaseName} -p ${hostport}:${containerport} -d postgres
```
# Environment properity configuration

```
location:./src/main/resources/META-INF/env
   
Template:
database.driverName=${driverName}
database.url=${url}
database.port=${port}
database.name=${name}
database.username=${username}
database.password=${password}
   
mvn compile -Dspring.profiles.active=${env}
```

# Flyway migration

```$xslt
mvn compile flyway:migrate -P unit -Ddb_username=${username} -Ddb_url=localhost:${containerport}/${databasename} -Ddb_password=${password} 
```

# Testing

```$xslt
location:./src/main/resources/META-INF/env

Template:
database.driverName=${driverName}
database.url=${url}
database.port=${port}
database.name=${name}
database.username=${username}
database.password=${password}
app.support.email={email}

mvn compile test -Dspring.profiles.active=${env} -P ${env}
```

# Create war package file
```$xslt
mvn compile package -DoutputDirectory=./target -P dev
```
