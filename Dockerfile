# Use base image with Java
FROM openjdk:17-jdk-slim


#Set the working directory
WORKDIR /app

#Copy the jar file
COPY target/ToDo-app.jar app.jar

#EXPOSE the port
EXPOSE 8080

#Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]