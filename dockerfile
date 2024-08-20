# Usar uma imagem 
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o JAR compilado para dentro do contêiner
COPY . .

# Comando de entrada para executar o aplicativo
CMD ["java", "-jar", "app/projeto-0.0.1-SNAPSHOT.jar"]