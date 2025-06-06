FROM eclipse-temurin:21-jammy AS builder

ARG REPO_NAME="."
WORKDIR /app

COPY $REPO_NAME/.mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install -DskipTests


FROM eclipse-temurin:21-jre-jammy
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
