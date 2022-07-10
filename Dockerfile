FROM openjdk:11

EXPOSE 8085

ADD build/libs/offer-0.0.1-SNAPSHOT.jar offer-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","offer-0.0.1-SNAPSHOT.jar"]