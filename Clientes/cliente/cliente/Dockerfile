FROM maven:3-openjdk-17 AS maven_build
WORKDIR /app
COPY ./Clientes/cliente/cliente ./
RUN mvn -Dmaven.test.skip clean package

FROM maven:3-openjdk-17
ARG JAR_FILE=/app/target/*.jar
COPY --from=MAVEN_BUILD ${JAR_FILE} app.jar
ENV PORT=8081
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "/app.jar"]