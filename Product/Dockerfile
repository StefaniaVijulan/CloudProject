FROM maven:3.6.3

WORKDIR /app

COPY ./Product/target .

EXPOSE 8090

CMD ["java","-jar","./product-0.0.1-SNAPSHOT.jar"]

