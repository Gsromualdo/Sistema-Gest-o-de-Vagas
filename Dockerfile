# Estágio de Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio de Runtime (Otimizado)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# CORREÇÃO: O caminho agora reflete o WORKDIR /app do estágio anterior
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Limita o uso de memória para evitar o OOM-kill na sua instância de 1GB
ENTRYPOINT ["java", "-Xmx512M", "-jar", "app.jar"]