# Renault Garage Service

Une application Spring Boot conçue pour la gestion des garages, des véhicules et des accessoires, avec une architecture modulaire et une intégration événementielle robuste via Apache Kafka.

---

## Table des matières

- [Principales Caractéristiques](#Principales-Caractéristiques)
- [Stack Technique](#Stack-Technique)
- [Structure du projet](#Structure-du-projet)
- [Démarrage](#démarrage)
- [Documentation API](#documentation-api)
- [Tests](#tests)
- [Architecture Evenementielle](#Architecture-Evenementielle)

---

## Principales Caractéristiques

- Gestion des **Garages** : 
  - CRUD complet avec pagination et filtrage par critères (nom, ville)
  - Règles métier : capacité maximale de véhicules par garage
- Gestion des **Véhicules** : 
  - CRUD avec association au garage
  - Recherche avancée par modèle
  - Validation stricte des données
- Gestion des **Accessoires** : 
  - CRUD avec association aux véhicules
- Architecture Événementielle :
  - Publication et consommation d’événements via Kafka
- Documentation API avec **Swagger** pour tests rapides

---

## Stack Technique

- **Langage & Framework** : Java 21, Spring Boot 3
- **Persistence** : Spring Data JPA (Hibernate), DB configurable (PostgreSQL)
- **Messaging** : Apache Kafka
- **Swagger/OpenAPI 3**
- **JUnit 5 & Mockito** pour les tests unitaires
- **API** : RESTful
- **Maven** comme outil de build

---

## Structure du projet

```text
com.renault.mobility.garage
├── config           # Configuration OpenApi & Kafka
├── domain           # Entités JPA
├── dto              # Data Transfer Objects
├── exception        # Exceptions personnalisées
├── handler          # Gestion des erreurs globales
├── mapper           # Classes Mapper (Entity <-> DTO)
├── repository       # Interfaces JPA
├── service          # Logique métier
└── util             # Classes utilitaires
└── web              # Contrôleurs REST
```

## Configurer application.yml :


```yaml
spring:
  application:
    name: Renault Garage Service
  datasource:
    url: jdbc:postgresql://localhost:5432/garage-service
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: create
    database: postgresql

  liquibase:
    enabled: true
    change-log: classpath:/db/db.changelog-master.xml

  cloud:
    function:
      definition: createVehicle;vehicleConsumer
    stream:
      bindings:
        createVehicle-out-0:
          destination: vehicle-topic
          content-type: application/json
        vehicleConsumer-in-0:
          destination: vehicle-topic
          content-type: application/json
      kafka:
        binder:
          brokers: localhost:9092
garage:
  capacity:
    max: 50

```

## Démarrage:
```bash
  mvn clean install
  mvn spring-boot:run
```

L’application sera disponible sur : http://localhost:8080

##  Documentation API

Swagger UI est disponible à :

http://localhost:8080/swagger-ui.html

##  Tests

Exécuter les tests unitaires :
```bash
    mvn test
```

Les tests couvrent les services avec des repositories mockés et les mappers.

## Architecture Evenementielle

L’application adopte une architecture orientée événements pour garantir découplage, scalabilité et résilience.
Elle s’appuie sur Spring Cloud Stream pour la gestion des bindings entre les canaux logiques et les topics Kafka, et sur Spring Cloud Function pour implémenter la logique métier sous forme de fonctions (Supplier, Function, Consumer).

- Publication et consommation d’événements via Kafka, abstraite par Spring Cloud Stream
- Fonctions métier déclaratives pour la production et la consommation d’événements

Cette approche permet une programmation fonctionnelle, une portabilité multi-broker et une intégration simplifiée avec des environnements cloud ou serverless.


Exemple avec Docker :

Placez-vous d’abord dans le répertoire du projet:
```
  cd garage-service
  docker compose up -d
```