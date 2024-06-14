# MovieSeries-Spring-Boot-App-Partie-Back-end

# MovieSeriesTV Application Backend

## Contexte du Projet
La chaîne de télévision internationale **MovieSeriesTV** a sollicité la startup **OroJacksonTech**, où vous travaillez, pour développer une application web permettant à son audience de visionner les films et séries produits par la chaîne. Le Product Owner vous a confié cette mission de créer une application backend bien structurée et fonctionnelle. L'application devra être évolutive et facile à maintenir.

## Utilisateurs et User Stories

### Consultation de Contenu

#### Afficher la Liste des Films
En tant qu'utilisateur, je veux voir une liste de tous les films disponibles avec leurs titres, dates de sortie, genres, réalisateurs et notes, afin de trouver rapidement un film à consulter ou à regarder.

#### Afficher la Liste des Séries
En tant qu'utilisateur, je veux voir une liste de toutes les séries disponibles avec leurs titres, dates de début et de fin, genres, créateurs et notes, afin de trouver rapidement une série à consulter ou à regarder.

### Gestion des Favoris

#### Ajouter un Film ou une Série aux Favoris
En tant qu'utilisateur, je veux pouvoir ajouter un film ou une série à mes favoris, afin de les retrouver facilement plus tard.

*Critères d'acceptation :*
- Un bouton "Ajouter aux favoris" est disponible sur la page de chaque film ou série.
- Le film ou la série est ajouté à une liste de favoris personnelle après clic.

#### Voir la Liste des Favoris
En tant qu'utilisateur, je veux voir une liste de tous les films et séries disponibles avec leurs titres, dates de sortie, genres, réalisateurs et notes, afin de trouver rapidement un film ou une série à consulter ou à regarder.

*Critères d'acceptation :*
- La liste affiche tous les films et séries avec les détails mentionnés.
- Les films et séries peuvent être triés par différents critères (titre, date de sortie, note).

#### Voir les Détails d'un Film ou d'une Série
En tant qu'utilisateur, je veux pouvoir cliquer sur un film ou une série pour voir ses détails complets, y compris la liste des acteurs et une bande-annonce (si disponible), afin d'obtenir des informations plus approfondies sur le contenu.

*Critères d'acceptation :*
- Un clic sur un film ou une série affiche une page de détails avec toutes les informations pertinentes.
- Les acteurs et la bande-annonce (si disponible) sont inclus dans les détails.

## Travail à Faire

### Initialisation du Projet
1. Créer un nouveau projet Spring Boot en utilisant Spring Initializr avec les dépendances nécessaires : Spring Web, Spring Data JPA, Lombok, MySQL/PostgreSQL.
2. Configurer le fichier `application.properties` pour se connecter à la base de données (choisir entre MySQL et PostgreSQL).

### Définition des Composants

1. **Définition des Modèles (Model)**
2. **Création des DAO/Repositories**
3. **Définition des DTO (Data Transfer Object)**
4. **Implémentation des Services**
5. **Création des Contrôleurs REST (REST Controller)**
