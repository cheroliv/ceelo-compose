# Cee-lo Jetpack Compose Migration Constitution

<!-- 
Sync Impact Report:
- Version change: None -> 0.0.1
- Added sections: All sections are new as this is the first version.
- Templates requiring updates:
  - .specify/templates/plan-template.md (pending)
  - .specify/templates/spec-template.md (pending)
  - .specify/templates/tasks-template.md (pending)
  - README.adoc (pending)
-->

## Core Principles

### I. UI Déclarative avec Jetpack Compose
Toute nouvelle interface utilisateur DOIT être implémentée en utilisant Jetpack Compose. L'utilisation de layouts XML traditionnels est proscrite pour les nouveaux écrans et doit être progressivement éliminée des écrans existants lors des refactorings.

### II. Kotlin Comme Langage Unique
Le projet est 100% Kotlin. Tout nouveau code, y compris les scripts de build (build.gradle.kts), DOIT être écrit en Kotlin.

### III. Architecture MVVM
L'architecture Model-View-ViewModel (MVVM) est la norme. La logique de présentation et l'état de l'UI DOIVENT être gérés dans des ViewModels, séparés des Composables qui ne sont responsables que de l'affichage de l'état.

### IV. Prévisualisation et Tests d'UI
Chaque Composable réutilisable ou complexe DOIT être accompagné d'une fonction de prévisualisation (`@Preview`). Les fonctionnalités critiques de l'interface utilisateur DOIVENT être couvertes par des tests d'interface utilisateur utilisant `ComposeTestRule`.

### V. Tests Unitaires pour la Logique
Toute la logique métier et la logique de ViewModel DOIT être couverte par des tests unitaires.

## Contraintes de Dépendances

Les dépendances externes doivent être minimisées. L'ajout de toute nouvelle bibliothèque nécessite une justification et une approbation. Utiliser la convention de catalogage de versions de Gradle (`libs.versions.toml`).

## Workflow de Migration

La migration se fait écran par écran. Chaque PR de migration doit concerner un seul écran ou un ensemble de composants étroitement liés. La PR doit inclure la suppression des anciens layouts XML.

## Governance

Cette constitution est le document de référence pour le projet de migration. Toute déviation doit être discutée et approuvée par l'équipe. Les revues de code (PR) sont le principal mécanisme de contrôle de la conformité.

**Version**: 0.0.1 | **Ratified**: 2025-11-29 | **Last Amended**: 2025-11-29