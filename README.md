# Application 4A Skyrim Information Races MVVM avec Login menu
## Présentation:

Projet de programmetion mobile en 4eme année d'école d'ingenieur. Application affichant un écran d'indentification ainsi qu'une liste de données récupérée depuis une API 

Cette application affiche un écrande login pour se connecter et/ou créer un comtpe. Une fois identifié, l'utilisateur à ensuite accès à la liste des différentes races jouable du jeu vidéo The Elder Scrolls V: Skyrim.

## Prérequis
  - Télécharger et installer Android Studio.
  - Récupérer la branche master sur Android Studio:
```
https://github.com/Aqualio/AndroidKotlin
```
## Consignes Respectées:

  - Language Kotlin
  - Architecture MVVM
  - Clean Architecture
  - Utilisation d’une réelle BDD
  - Utilisation Api REST
  - Affichage d’une liste
  - Design

## Consignes Supplémentaires:

  - Gitflow

## Fonctionnalités:

### Premier écran:
  - L'affichage de l'interface de connexion
  
![image](https://raw.githubusercontent.com/Aqualio/AndroidKotlin/master/readme_img/Screenshots_login.PNG)
### Premier écran (erreur Login):
  - Lorsque l'utilisateur veut se connecter avec des identifiants mais que ceux-ci ne sont pas dans la base donnée, cette erreur sort:
  
![image](https://github.com/Aqualio/AndroidKotlin/blob/master/readme_img/Screenshots_login_error.PNG)

### Premier écran (erreur Creation Compte):
  - Lorsque l'utilisateur veut créer un compte avec des indentifiants mais que ceux-ci existent déja dans dans la base donnée, cette erreur sort:
  
![image](https://github.com/Aqualio/AndroidKotlin/blob/master/readme_img/Screenshots_account_creation_error.PNG)
