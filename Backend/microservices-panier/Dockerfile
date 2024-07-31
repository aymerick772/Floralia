#FROM ubuntu:latest
#LABEL authors="aymer"
#
#ENTRYPOINT ["top", "-b"]
#
## Utiliser une image de base avec Java
#FROM openjdk:17-jdk-slim
#
## Ajouter l'application jar dans l'image
#COPY target/redisapp.jar /usr/app/
#
## Spécifier le répertoire de travail
#WORKDIR /usr/app
#
## Exposer le port sur lequel l'application sera disponible
#EXPOSE 8080
#
## Définir la commande pour exécuter l'application
#CMD ["java", "-jar", "redisapp.jar"]