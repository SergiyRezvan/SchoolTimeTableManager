FROM adoptopenjdk/openjdk11:jre-11.0.4_11
COPY build/libs/bootApplication-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
EXPOSE 8686
