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

   - Architecture:
      - Singleton
      - Design Patterns
      - MVC
      - Principes(SOLID, KISS, DRY)
   - Gitflow
   - Autres fonctionnalités
      - Du sond lorsque l'application est lancée
      - Du sond quand le boutton en haut à droite est appuyé 

## Fonctionnalités:

### Premier écran:
  - La liste des différentes races du jeu Skyrim  
![Screenshot_20200621-221840_Skyrim_Races_Description](https://raw.githubusercontent.com/Aqualio/AndroidKotlin/master/readme_img/Screenshots_login.PNG)
### Deuxieme écran:
  - Lorsque l'on clique sur une des races, les details et des informations sur celle-ci apparaissent 
![Screenshot_20200621-221857_Skyrim_Races_Description](https://user-images.githubusercontent.com/60584997/85234567-7beea280-b40e-11ea-9d47-3955f13fbf63.jpg)

# Erreur
J'ai un erreur lors du premier lancement de l'application, lorsque le makeapiCall() n'a pas encore été appelé et donc qu'aucune liste n'a été save avec la function savelist.

![image](https://user-images.githubusercontent.com/60584997/85236931-c0843900-b422-11ea-855b-73a1b7f3b98b.png)

La variable jsonSkyrim ne contient pas mon fichier json et lorsqu'elle est assignée à sharedPreference.getString elle est égale à 'jsonString'

![image](https://user-images.githubusercontent.com/60584997/85236984-338daf80-b423-11ea-9894-770e0fcd085e.png)

Ducoup le return de la fonction getDataFromCache engendre une erreur car il ne reconnait pas le fichier json 

![image](https://user-images.githubusercontent.com/60584997/85237020-6b94f280-b423-11ea-9b98-cf5c281cff2d.png)

La seule facon de régler le probleme que j'ai trouvé est de lancer dans un premier temps l'application avec juste un call à l'API pour enregistrer la liste dans le cache 

![image](https://user-images.githubusercontent.com/60584997/85237056-b6af0580-b423-11ea-98c0-3f95fca16300.png)

puis ensuite relancer l'application normalement. Le cache est sauvegardé et celle-ci marche "parfaitement"

![image](https://user-images.githubusercontent.com/60584997/85237083-e8c06780-b423-11ea-9c25-11518ddfb671.png)
