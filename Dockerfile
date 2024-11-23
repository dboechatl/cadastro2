## Primeiro estágio de build
#FROM maven:latest AS build
#WORKDIR /cadastro
#COPY pom.xml /cadastro/pom.xml
#COPY src /cadastro/src
#RUN mvn clean package -DskipTests
#
## Segundo estágio para a imagem final
#FROM openjdk:17-jdk-alpine
#WORKDIR /app
#COPY --from=build /cadastro/target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]
#EXPOSE 3000

# Etapa 1: Escolha a imagem base do Maven para compilar o código Java
FROM maven:latest AS build

# Defina o diretório de trabalho para /app
WORKDIR /cadastro

# Copie o arquivo pom.xml e a pasta src para o contêiner
COPY pom.xml .
COPY src ./src

# Execute o comando para compilar e gerar o .jar
RUN mvn clean package -DskipTests

# Etapa 2: Escolha a imagem base do JDK para rodar a aplicação
FROM openjdk:20-jdk-slim

# Defina o diretório de trabalho para /app
WORKDIR /cadastro

# Copie o arquivo .jar gerado na etapa de build para a imagem final
COPY --from=build /cadastro/target/*.jar cadastro.jar

# Exponha a porta que a aplicação vai usar
EXPOSE 3000

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "cadastro.jar"]