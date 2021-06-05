# Micro warehouse server

## prerequisite

you have installed :
git
java 8+
maven 3.6.x

## Start the application

Clone or download this project. Then in the root run the applcation by using the command below

```Shell
mvn spring-boot:run
```

if you have not installed maven 3.6.x

```Shell
.\mvnw.cmd spring-boot:run
```

This will run the server on port 8080
Products and inventory will be loaded on start. To reload for test purposes you need to restart the server

# build and package the application

```Shell
.\mvnw.cmd clean install
```

This will build the application and run the unit tests. After a succesful build you will find the warehouse.jar in the ./target folder.

## run jar

```Shell
java -jar warehous-2.5.0.jar
```

The application should now start.

# Load Articles

```Shell
curl -X POST \
  http://localhost:8080/articles \
  -H ': ' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 00afb66f-01da-42eb-b4fe-2a22bf06c266' \
  -H 'cache-control: no-cache'
```

# Load Products

```Shell
curl -X POST \
  http://localhost:8080/products \
  -H ': ' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 00afb66f-01da-42eb-b4fe-2a22bf06c266' \
  -H 'cache-control: no-cache'
```

# List all availble products

```Shell
  curl -X GET \
  http://localhost:8080/products \
  -H 'Postman-Token: e7c044aa-1ad8-4749-bf03-c21fb89513b0' \
  -H 'cache-control: no-cache'
```

# Get all article stocks

```Shell
  curl -X GET \
  http://localhost:8080/articleStock \
  -H 'Postman-Token: d617a62b-f43f-480a-bc6e-c2e7806cb01a' \
  -H 'cache-control: no-cache'
```

# Check product datails

```Shell
  curl -X POST \
  http://localhost:8080/searchProduct \
  -H ': ' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 00afb66f-01da-42eb-b4fe-2a22bf06c266' \
  -H 'cache-control: no-cache'
```

# Sell / Buy Product

```Shell
  curl -X POST \
  http://localhost:8080/sellProduct \
  -H ': ' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 00afb66f-01da-42eb-b4fe-2a22bf06c266' \
  -H 'cache-control: no-cache'
```
