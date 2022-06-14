# Car Management API


description...

### Cloning the Repository
1. Go to your preferred directory
2. Open your terminal and execute `git@github.com:golamrabbiazad/cardatabase-springboot.git`
3. Import the project, using your preferred IDE
4. Wait for Maven to load dependencies
5. Before running, ensure that in `src/main/resources/application.properties`:
    - You are using your preferred database URL in `spring.datasource.url`
    - You are using your correct driver in `spring.datasource.driver-class-name`
6. Go to `src/main/java/CardatabaseApplication.java`, then press `SHIFT + F10` to run the application
7. Open your browser, and go see [`https://localhost:8080/api`](https://localhost:8080/api)

before running the app, run the database via docker.
```bash
# only once this network created
$ docker network create postgres-net

# postgres container initializing and running
$ docker run -d --rm --network postgres-net --name postgres-cardb \
  -e POSTGRES_ROOT_PASSWORD=passoword -p 5432:5432 postgres:latest
```
### Detailed
`POSTGRES_ROOT_PASSWORD` could be anything (ex. JFKDSJKDFJ##@#&*24, no-password, Caps@!#$323232@)

`POSTGRESS_ROOT_USERNAME` is by default to set `postgres`. It also can be changeable by using the is env variable name.

### Create the Database

```postgresql
DROP DATABASE IF EXISTS cardb;

CREATE DATABASE cardb;
```

### Configure the Database & JPA

```properties
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/cardb
spring.datasource.username=postgres
spring.datasource.password=what-ever-you-set
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create-drop

spring.data.rest.base-path=/api
```
