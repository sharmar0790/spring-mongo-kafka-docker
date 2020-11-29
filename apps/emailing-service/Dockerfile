# Step : Test and package
FROM maven:3.6.3-openjdk-11-slim as target
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package -DskipTests=true #remove -DskipTests=true to run the tests while building image

# Step : Package image
FROM openjdk:11-jdk-slim
COPY --from=target /build/target/*.jar /app/app.jar
#CMD exec java $JAVA_OPTS -jar /app/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app/app.jar" ]