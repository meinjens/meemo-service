FROM openjdk:11-jdk

RUN addgroup --system spring && adduser --system spring

USER spring
EXPOSE 8080

ARG JAR_FILE=build/libs/meemo-service-*.jar
ADD ${JAR_FILE} /app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]