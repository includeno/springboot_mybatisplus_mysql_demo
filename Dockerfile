FROM openjdk:11.0.13-jdk

EXPOSE 8080
WORKDIR /app

ENV app_name="mybatisdemo"

#add jar file
ADD target/mybatisdemo-1.0-SNAPSHOT.jar /app/application.jar
#ENTRYPOINT ["java","-jar","/app/application.jar","--server.port=${server_port}"]
CMD java -jar /app/application.jar --spring.application.name=${app_name}