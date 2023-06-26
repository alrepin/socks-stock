FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.19_7
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "/dockerimage.jar"]
ENTRYPOINT ["java","-jar","/app.jar"]