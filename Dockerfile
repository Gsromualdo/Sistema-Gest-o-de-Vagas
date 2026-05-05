# Estágio de Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio de Runtime (Otimizado)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia apenas o JAR final do estágio de build
COPY --from=build /target/*.jar app.jar

EXPOSE 8080

# Adicionamos flags de memória para ajudar o Java a respeitar o limite do container
ENTRYPOINT ["java", "-Xmx512M", "-jar", "app.jar"]