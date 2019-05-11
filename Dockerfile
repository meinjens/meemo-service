FROM adoptopenjdk/openjdk11:jdk-11.0.3_7-alpine

#ARG DEPENDENCY=target/dependency

#ADD ${DEPENDENCY}/BOOT-INF/lib /app/lib
#ADD ${DEPENDENCY}/META-INF /app/META-INF
#ADD ${DEPENDENCY}/BOOT-INF/classes /app
ADD ["target/meemo.jar", "/app/app.jar"]

# ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"

EXPOSE 8080
EXPOSE 8787

#RUN sh -c 'touch /app/app.jar'

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar" ]
