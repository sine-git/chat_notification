# Étape 1: Build de l'application
# Utilise une image Maven pour construire l'application
FROM maven:3.8.6-openjdk-17 AS build

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers du projet dans le conteneur
COPY pom.xml .
COPY src ./src

# Compile et package l'application
RUN mvn clean package -DskipTests

# Étape 2: Crée l'image finale
# Utilise une image OpenJDK 17 JRE pour exécuter l'application
FROM openjdk:17-jdk-slim

# Crée un utilisateur pour exécuter l'application de manière sécurisée
RUN useradd -m -s /bin/bash springuser

# Définit le répertoire de travail
WORKDIR /app

# Copie le JAR compilé depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar

# Change le propriétaire des fichiers copiés
RUN chown -R springuser:springuser /app

# Change l'utilisateur pour éviter d'exécuter l'application en tant que root
USER springuser

# Expose le port sur lequel l'application s'exécute
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
