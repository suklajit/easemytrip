FROM eclipse-temurin:8-jdk


ENV env_profile=default

RUN mkdir -p /app

COPY ./target/emt-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

# ENTRYPOINT ["java","-jar","/app/app.jar", "--spring.profiles.active=awsmumbai"]

CMD if [ "$env_profile" = "default" ]; then \
    java -jar /app/app.jar --spring.profiles.active=awsmumbai ; \
    else \
    java -jar /app/app.jar --spring.profiles.active=${env_profile} ; \
    fi