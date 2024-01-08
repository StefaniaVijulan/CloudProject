FROM maven:3.6.3

WORKDIR /app

COPY ./order/target .

EXPOSE 8080

CMD ["java","-jar","./order-0.0.1-SNAPSHOT.jar"]


