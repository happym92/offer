FROM openjdk:11

EXPOSE 8090

ADD build/libs/test-0.0.2.jar test-0.0.2.jar

ENTRYPOINT ["java","-jar","test-0.0.2.jar"]