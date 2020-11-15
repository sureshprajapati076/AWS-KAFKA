
FROM openjdk:8-jre-alpine

ADD /target/*.jar /app.jar

EXPOSE 8099


ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]