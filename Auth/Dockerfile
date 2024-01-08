FROM maven:3.6.3

WORKDIR /app

COPY ./auth/target .

EXPOSE 8070

CMD ["java","-jar","./auth-0.0.1-SNAPSHOT.jar"]
