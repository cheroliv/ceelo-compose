# Feature Specification: Migration UI vers Jetpack Compose

**Feature Branch**: `001-migration-ui-compose`  
**Created**: 2025-11-29
**Status**: Draft  
**Input**: User description: "il faut reprendre la UI dans le dossier @app-legacy/src/main/res/layout et passer du format xml vers jetpack-compose dans le dossier @app/src/main/java/ceelo, le code source qui complete le layout par le data model les logique metier est dans le dossier @app-legacy/src/main/java/game/ceelo/"

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Migration de l'écran de Login (Priority: P1)

En tant qu'utilisateur, je veux voir l'écran de connexion construit avec Jetpack Compose, en conservant la logique de `LoginActivity.kt`.

**Why this priority**: C'est le premier point d'entrée de l'application.

**Independent Test**: L'application se lance, l'écran de connexion s'affiche, la logique de connexion est fonctionnelle.

**Acceptance Scenarios**:

1. **Given** L'application est lancée, **When** l'écran de connexion s'affiche, **Then** je vois les champs de saisie et le bouton de connexion.
2. **Given** J'ai saisi mes identifiants, **When** je clique sur le bouton "Login", **Then** la logique de `LoginActivity.kt` est exécutée.

---

### User Story 2 - Migration de l'écran principal (Priority: P2)

En tant qu'utilisateur, je veux que l'écran principal du jeu soit en Jetpack Compose, en utilisant la logique de `MainActivity.kt` et des services associés (`CeeloService.kt`).

**Why this priority**: C'est la fonctionnalité principale de l'application.

**Independent Test**: L'écran principal s'affiche et la mécanique de jeu (lancer de dés, affichage des scores) fonctionne comme avant.

**Acceptance Scenarios**:

1. **Given** Je suis sur l'écran principal, **When** j'appuie sur le bouton pour lancer les dés, **Then** la logique de `MainActivity.kt` est exécutée pour générer un résultat.
2. **Given** un résultat de lancer est généré, **Then** l'interface est mise à jour pour afficher les dés et le score.

---

### User Story 3 - Migration de l'écran des statistiques (Priority: P3)

En tant qu'utilisateur, je veux un écran de statistiques en Jetpack Compose, en migrant la logique de `StatsActivity.kt`.

**Why this priority**: Complète l'expérience utilisateur en fournissant l'historique des parties.

**Independent Test**: L'écran des statistiques affiche la liste des parties passées.

**Acceptance Scenarios**:

1. **Given** J'ai joué plusieurs parties, **When** j'ouvre l'écran des statistiques, **Then** la logique de `StatsActivity.kt` est utilisée pour récupérer et afficher la liste des parties.

---

### User Story 4 - Migration du composant `game_row` (Priority: P1)

En tant que développeur, je veux que le layout `game_row.xml` soit migré vers un Composable réutilisable pour l'utiliser dans la nouvelle `StatsScreen`.

**Why this priority**: C'est un bloc de construction essentiel pour l'écran des statistiques.

**Independent Test**: Le Composable `GameRow` peut être prévisualisé et affiche correctement les données d'une partie.

**Acceptance Scenarios**:

1. **Given** les données d'une partie, **When** le composant `GameRow` est utilisé, **Then** il affiche les informations de manière identique à l'ancien layout.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: Remplacer `activity_login.xml` par un `@Composable fun LoginScreen()` et migrer la logique de `LoginActivity.kt` dans un `LoginViewModel`.
- **FR-002**: Remplacer `activity_main.xml` par un `@Composable fun MainScreen()` et migrer la logique de `MainActivity.kt` dans un `MainViewModel`.
- **FR-003**: Remplacer `activity_stats.xml` par un `@Composable fun StatsScreen()` et migrer la logique de `StatsActivity.kt` dans un `StatsViewModel`.
- **FR-004**: Remplacer `game_row.xml` par un `@Composable fun GameRow()`.
- **FR-005**: La logique métier existante dans `app-legacy/src/main/java/game/ceelo/` (services, repositories, etc.) DOIT être réutilisée par les nouveaux ViewModels.
- **FR-006**: Les anciennes `Activity` (`LoginActivity`, `MainActivity`, `StatsActivity`) et les fichiers XML DOIVENT être supprimés après la migration.
- **FR-007**: La navigation entre les écrans DOIT être mise à jour pour utiliser Jetpack Navigation avec les nouveaux écrans Composables.
- **FR-008**: Des tests unitaires DOIVENT être écrits pour les nouveaux ViewModels.
- **FR-009**: Des tests d'interface utilisateur (UI tests) DOIVENT être écrits pour les écrans Composables critiques.
- **FR-010**: Des prévisualisations (`@Preview`) DOIVENT être créées pour les composants Composables significatifs.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: 100% des layouts XML dans `app-legacy/src/main/res/layout` sont supprimés.
- **SC-002**: 100% des `Activity` listées (`LoginActivity`, `MainActivity`, `StatsActivity`) sont supprimées.
- **SC-003**: La couverture de tests unitaires pour les nouveaux ViewModels est > 80%.
- **SC-004**: Toutes les fonctionnalités de l'application sont préservées et fonctionnelles après la migration.