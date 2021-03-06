# Java Order Microservice

## Class Diagram
![](img/class-diagram.png)

## Build & Run with Docker Compose
### Build & Run:
```sh
docker-compose up --build -d && docker-compose logs -f
```

### Build & Run (using **Docker BuildKit**)
> Unix version
```sh
COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose up --build -d && docker-compose logs -f
```

> Windows version
```sh
set "COMPOSE_DOCKER_CLI_BUILD=1" & set "DOCKER_BUILDKIT=1" & docker-compose up --build -d && docker-compose logs -f
```

## Build & Run with Docker
### Datasource:
> Launch PostgreSQL in a Docker container with:
```sh
docker run --name order-postgresql -p 5434:5432 -e POSTGRES_DB=order -e POSTGRES_PASSWORD=pass postgres:12-alpine
```

### Build:
> Unix version
```sh
DOCKER_BUILDKIT=1 docker build --tag order:test --build-arg APP_NAME=order --build-arg APP_VERSION=0.0.1 --rm=true .
```

> Windows version
```sh
set "DOCKER_BUILDKIT=1" & docker build --tag order:test --build-arg APP_NAME=order --build-arg APP_VERSION=0.0.1 --rm=true .
```

### Run:
```sh
docker run -it --name order --publish=8090:8090 order:test
```

## Build & Run with Docker + Gradle Wrapper
### Datasource:
> Launch PostgreSQL in a Docker container with:
```sh
docker run --name order-postgresql -p 5434:5432 -e POSTGRES_DB=order -e POSTGRES_PASSWORD=pass postgres:12-alpine
```

### Build:
```sh
gradlew build
```

### Run:
```sh
java -jar build\libs\java-order-0.0.1.jar
```

## Access

- Actuator: http://localhost:8091/actuator/health
- Swagger: http://localhost:8091/swagger-ui.html
- Database: jdbc:postgresql://localhost:5434/order
  - User: postgres
  - Password: pass

## Dataset

### Passed_order table:

| id                                   | city             | country | number | street        | email                 | name     | surname     | date                       |
| :----------------------------------- | :--------------- | :------ | :----- | :------------ | :-------------------- | :------- | :---------- | :------------------------- |
| c5a659c3-5ba1-42bb-b1fb-b35d4f589f34 | Clermont-Ferrand | France  | 19     | Boussingault  | bernard@gmail.com     | Vaillant | Bernard     | 2017-03-12 14:18:58.000000 |
| ae4bfe14-b889-4c49-b35f-e89e39f9c31c | Paris            | France  | 46     | Saint Antoine | jean-michel@gmail.com | Dupont   | Jean-Michel | 2019-10-20 14:18:58.000000 |

### Line_order table:

| id                                   | number | product      | parent_order_id                      |
| :----------------------------------- | :----- | :----------- | :----------------------------------- |
| ad5a7b50-8885-4311-bbb4-815e0251f344 | 1      | Bike         | c5a659c3-5ba1-42bb-b1fb-b35d4f589f34 |
| e819b7f9-87aa-4420-bf8e-01b24897cd53 | 1      | Bag          | c5a659c3-5ba1-42bb-b1fb-b35d4f589f34 |
| dc2ec561-0828-4be4-b650-ac105e3a9017 | 2      | Tyre         | c5a659c3-5ba1-42bb-b1fb-b35d4f589f34 |
| 3b2daa22-000b-4ea6-9594-19820d4a2723 | 10     | Beer         | c5a659c3-5ba1-42bb-b1fb-b35d4f589f34 |
| f1d121c9-7d57-42cd-8dc5-7ce20cdd8ee3 | 2      | Cheeseburger | ae4bfe14-b889-4c49-b35f-e89e39f9c31c |
| e45e7dab-280a-4955-85ca-f37e1ccc1150 | 1      | Soda         | ae4bfe14-b889-4c49-b35f-e89e39f9c31c |
| 7d99e1bc-46bf-4937-b5cd-c660b47cb68a | 1      | French fries | ae4bfe14-b889-4c49-b35f-e89e39f9c31c |
