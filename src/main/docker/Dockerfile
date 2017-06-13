FROM java:8
ADD sip-file.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 7001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]