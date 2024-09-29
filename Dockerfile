FROM openjdk:21

WORKDIR /app

# Copier le fichier JAR depuis le dossier target (vérifiez le nom du fichier)
COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
