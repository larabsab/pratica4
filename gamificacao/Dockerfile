FROM openjdk:17

# Set the working directory in the container
WORKDIR /ac2_ca

# Copy the JAR file into the container at /educacaoGamificada
COPY target/gamificacao-0.0.1-SNAPSHOT.jar /app/gamificacao.jar

# Expose the port that your application will run on
EXPOSE 8585

# Specify the command to run on container start
CMD ["java", "-jar", "gamificacao.jar"]