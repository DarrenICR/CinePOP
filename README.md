# Application CinePOP

# Réalisé par:

Darren ICHIRANTE REMOUNE

ESIEA - CFA 3A Paris

# Objectif:

Développer individuellement une application mobile Android

# Présentation:

Cette application affiche une liste des films populaires du moment et utilise l'API de "TMDb" dédiée au cinéma/séries.

https://developers.themoviedb.org/3

# Prérequis:

- Installation d'Android Studio

- Créer un  compte TMDb et récupérer une clé d'API

# Consignes respectées:

- Un premier écran avec une liste 

- Un deuxième écran avec un détail de l’item

- Animation entre écrans

- Appel WebService à une API Rest

- Stockage des données en cache

- Clean Architecture (MVC)

- Gitflow (2 branches min)

- Autre fonctionalité : Mode hors connexion

# Fonctionnalités:

## Écran de la liste de films

- Affichage de la liste des films populaires du moment (affiche, titre, date de sortie, note). 

- MAJ de la liste à chaque ouverture de l'application.

Design du logo qui communique parfaitement avec l’essence même de l'application... 

..."Une invitation au cinéma"

![alt text](https://user-images.githubusercontent.com/49784324/59020223-d475f080-8849-11e9-8178-25487f8eb675.gif)

## Écran du détail d'un film

- Affichage du résumé du film ("Aladin" dans cette capture)

![alt text](https://user-images.githubusercontent.com/49784324/59019155-c3c47b00-8847-11e9-8cb4-968521a834d8.jpg)

## Animation entre écrans

- Animation de type glissement gauche-droite entres les 2 écrans

![alt text](https://user-images.githubusercontent.com/49784324/59013127-83f69700-8839-11e9-9f9c-d6836b712ff4.gif)

## Mode hors connexion

- Si l'utilisateur n'a plus accès à internet, l'application charge les dernières données enregistreés.
