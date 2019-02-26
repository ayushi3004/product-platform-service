FROM ubuntu:16.04
RUN apt-get clean && apt-get update --fix-missing
RUN apt-get install -y openjdk-8-jdk

COPY . /apps/product-platform-service
RUN cd /apps/product-platform-service && ./gradlew clean build

ENTRYPOINT ["java", "-jar", "/apps/product-platform-service/build/libs/product-platform-service-1.0-SNAPSHOT.jar"]