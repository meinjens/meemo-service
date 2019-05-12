FROM adoptopenjdk/openjdk11:jdk-11.0.3_7-alpine

ADD ["target/meemo-service.jar", "/app/app.jar"]

ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"

EXPOSE 8080
EXPOSE 8787

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar" ]
