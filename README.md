# Article 01 - Sample CRUD API

## Running the Application

### Docker

To run the application in your machine, run the following commands in the root folder:

`$ mvn clean install -DskipTests`

This will generate the Spring's fat jar file that will be copied in the build of the container. And then:

`$ docker compose up --build`

This command builds the images and run all required containers.

To stop all containers and remove volumes created by up:

`$ docker-compose down --volumes`

### Database (PostgreSQL)

To connect into local PostgreSQL using CLI:

`$ psql -h <hostname or ip address> -p <port number of remote machine> -d <database name which you want to connect> -U <username of the database server>`