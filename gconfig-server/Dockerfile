FROM openjdk:17
ADD target/gconfig-server-0.0.1-SNAPSHOT.jar gconfig-server-0.0.1.jar
EXPOSE 8888
ENTRYPOINT [ "java", "-jar", "gconfig-server-0.0.1.jar" ]