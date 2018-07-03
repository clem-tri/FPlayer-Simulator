# FPlayer-Simulator

Prérequis : Java 9 / Intellij IDEA 

Un fichier .jar de l'application est fourni à la racine au cas où le projet ne s'éxecute pas sur les autres IDE

Jeu Point-and-click réalisé dans le cadre de la Licence Projet Web à l'UPMC.

![alt text](https://i.gyazo.com/78a93d418760c6c959fab09c8e7507e8.png)

## Le jeu

Créez et incarnez un footballeur, afin de vivre son quotidien.

Vous pouvez vous entrainer afin de gagner des points dans plusieurs compétences et gérer l'état de votre personnage (fatigue/faim).

## Technologies utilisées

* Afin de créer, lire et stocker des sauvergardes de jeu au format JSON, nous avons utilisé la dépendance google/gson. 
* Pour l'interface utilisateur, la conception des fenêtres a été gérée grâce au format GUI Form propre à l'IDE Intellij IDEA. 
Ce format est composé d'un fichier XML généré au fur et à mesure de la conception de la fenêtre via Intellij IDEA et d'une classe Java, tous deux ayant le même nom (voir image ci dessous)


![alt text](https://www.zupimages.net/up/18/27/3kgt.png)

## Fonctionnalités

### Les classes importantes :
#### Interfaces utilisateur :
* Fplayer.java
    * Permet de lancer le jeu en crééant une instance de la form MenuUI grâce à sa fonction `main()`
    
* MenuUI
    * Fenêtre proposant de créer une partie, charger une partie ou quitter le jeu. 
       
* CreateGameUI
  * Formulaire et classe permettant de créer et stocker une nouvelle partie, en renseignant les informations sur son personnage.
  
* LoadGameUI
    * Formulaire listant toutes les sauvegardes de jeu et permettant de charger la partie de son choix
    
* HomeUI
    * Une fois la partie chargée/créée, on se retrouve sur cette fenêtre nous laissant le choix de l'exercice que l'on veut faire pratiquer à son personnage ou de gérer son état physique. On peut également retourner sur la fenêtre MenuUI
    
* ShootTrainingUI :
    * Exercice permettant à l'utilisateur de tirer aux cages 10 fois, et de faire remporter à son personnage des points dans l'attribut "Tirs" en fonction du nombre de tirs réussis.
    
* RunTrainingUI :
    * Exercice demandant à l'utilisateur d'appuyer successivement sur les touches fléchées gauche et droite du clavier dans un temps imparti de 10 secondes. Le personnage gagne un nombre de point dans l'attribut "Vitesse" en fonction du nombre de fois où ces touches ont été pressées.
    
#### Classes métier :

* Character
    * C'est la classe qui représente le personnage, à noter que les attributs `mood, hunger, energy` voient leur valeur être modifiée lorsque un exercice est effectué.
* Attribute
    * Cette classe est utilisée pour ajouter à l'utilisateur ses attributs (Vitesse, Physique, Tir...) 
    
#### Classes Utilitaires :
* JsonSaveManager
    * Classe permettant de gérer les sauvegardes des parties
* SavesRenderer
    * Classe permettant de personnaliser le rendu visuel de la liste des sauvegardes dans LoadGameUI
    
    
## Améliorations

Les fonctionnalités supplémentaires qui auraient pu/du voir le jour :
* Un exercice de passes pour le personnage
* Un exercice pour la condition physique du personnage
* Permettre au personnage de rejoindre un Club
* Jouer un match avec son personnage

## Bilan

La version finale de ce projet ne comprend pas tout ce que l'on avait prévu au départ, par faute de temps.

La découverte de GUI Form nous a aidé à simplifier la création et la personnalisation des JFrame, bien qu'au début la prise en main n'était pas très intuitive.        

Cependant ce projet nous a permis de construire une application avec une structure plutôt cohérente et des principes/fonctionnalités vus en cours.

 
 