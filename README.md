# UCE Génie Logiciel Avancé : Techniques de tests



# Projet CERI M1 - Techniques de Test

**Nom :** Nadjim AIT MEDDOUR  
**Groupe :** CERI-M1 IA 

---

## Badges

![CircleCI](https://circleci.com/gh/NadjimAITMEDDOUR/ceri-m1-techniques-de-test.svg?style=shield)  
![Coverage](https://codecov.io/gh/NadjimAITMEDDOUR/ceri-m1-techniques-de-test/branch/master/graph/badge.svg)
![CheckStyle Badge](badges/checkstyle-badge.svg)

---

## Description

Ce projet illustre l'application des techniques de tests à un projet logiciel. Il inclut la mise en place d'une API simulant les fonctionnalités d'un Pokedex. 

### Choix techniques d’implémentation

1. **Tests unitaires et d'intégration** : Utilisation de JUnit 5 pour assurer la fiabilité du code.
2. **Mocking** : Employé pour simuler des dépendances complexes et tester en isolation.
3. **Intégration continue** : CircleCI est configuré pour exécuter automatiquement les builds et les tests.
4. **Analyse de couverture** : Codecov est utilisé pour mesurer et visualiser la couverture de tests.

---

## Fonctionnalités principales

- **Gestion de Pokedex** : Ajout, tri et récupération de Pokémon.
- **Support pour les entraîneurs** : Création et gestion de profils d'entraîneurs Pokémon.
- **Structure modulaire** : Le projet est structuré pour une extensibilité et une maintenance aisée.

---

## Instructions

1. Clonez le projet :  
   ```bash
   git clone https://github.com/NadjimAITMEDDOUR/ceri-m1-techniques-de-test.git


























## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
