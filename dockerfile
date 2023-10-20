    FROM maven:3.8.3-openjdk-17 AS build
    COPY src /home/app/src
    RUN mkdir target
    COPY pom.xml /home/app
    RUN mvn -f /home/app/pom.xml clean package -DskipTests
    ENTRYPOINT ["java","-jar","/home/app/target/grocery-0.0.1-SNAPSHOT.jar"]