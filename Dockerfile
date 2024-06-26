FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/*.jar pricetaglist.jar

EXPOSE 8888

ENTRYPOINT ["java","-jar","pricetaglist.jar"]