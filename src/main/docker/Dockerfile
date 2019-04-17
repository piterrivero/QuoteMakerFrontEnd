FROM openjdk

VOLUME /tmp
ADD maven/quoteMakerFrontEnd-0.0.1-SNAPSHOT.jar quoteMakerFrontEnd.jar
RUN sh -c 'touch /quoteMakerFrontEnd.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/quoteMakerFrontEnd.jar"]
