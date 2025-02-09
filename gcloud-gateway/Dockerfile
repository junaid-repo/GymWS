FROM openjdk:17
ADD target/gcloud-gateway-0.0.1-SNAPSHOT.jar gcloud-gateway-0.0.1.jar
EXPOSE 8090
ENTRYPOINT [ "java", "-jar", "gcloud-gateway-0.0.1.jar" ]