FROM openjdk:17
ADD target/gservice-registry-0.0.1-SNAPSHOT.jar gservice-registry-0.0.1.jar
EXPOSE 8761
ENTRYPOINT [ "java", "-jar", "gservice-registry-0.0.1.jar" ]