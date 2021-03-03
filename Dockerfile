FROM java:8-jdk-alpine
WORKDIR /apps
COPY ./target/crimedataservices-0.0.1.jar /apps
ENTRYPOINT ["java","-jar","crimedataservices-0.0.1.jar"]