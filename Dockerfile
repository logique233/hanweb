FROM java:8
ADD ./target/*.jar app.jar
EXPOSE 8080
CMD java -jar app.jar --spring.profiles.active=prod
