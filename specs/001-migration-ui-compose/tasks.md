# Tasks: Migration UI vers Jetpack Compose

**Input**: Design documents from `/specs/001-migration-ui-compose/`
**Prerequisites**: plan.md (required), spec.md (required)

**Tests**: Per the constitution, tests are NON-NEGOTIABLE.

**Organization**: Tasks are grouped by phase, following the user story priorities.

## Path Conventions

- **Nouveau Code Source**: `app/src/main/java/education/cccp/jetpack/compose/ceelo/`
- **Ancien Code Source**: `app-legacy/src/main/java/game/ceelo/`
- **Tests Unitaires**: `app/src/test/java/education/cccp/jetpack/compose/ceelo/`
- **Tests UI**: `app/src/androidTest/java/education/cccp/jetpack/compose/ceelo/`

---

## Phase 1: Migration de la Logique Métier (Prérequis)

**Goal**: Rendre la logique métier de `app-legacy` disponible pour le nouveau module `app`.

- [ ] T001 [P] Copier les services (`CeeloService.kt`, etc.) de `app-legacy/src/main/java/game/ceelo/service/` vers `app/src/main/java/education/cccp/jetpack/compose/ceelo/domain/service/`.
- [ ] T002 [P] Copier les repositories de `app-legacy/src/main/java/game/ceelo/repository/` vers `app/src/main/java/education/cccp/jetpack/compose/ceelo/domain/repository/`.
- [ ] T003 [P] Copier les autres fichiers de logique (`Constants.kt`, `Utils.kt`) et les adapter si nécessaire.
- [ ] T004 Résoudre les dépendances et s'assurer que le code métier copié compile dans le module `app`.

---

## Phase 2: User Story 4 - Composant `GameRow` (Priority: P1)

**Goal**: Migrer `game_row.xml` vers un Composable réutilisable.

### Tests for User Story 4 ⚠️
- [ ] T005 [US4] Écrire le test d'UI pour `GameRow` dans `app/src/androidTest/.../ui/stats/composables/GameRowTest.kt`.

### Implementation for User Story 4
- [ ] T006 [US4] Créer `GameRow.kt` dans `app/src/main/.../ui/stats/composables/`.
- [ ] T007 [US4] Implémenter le Composable `@Composable fun GameRow()` en se basant sur `game_row.xml`.
- [ ] T008 [US4] Ajouter un `@Preview` pour `GameRow`.

---

## Phase 3: User Story 1 - Écran de Login (Priority: P1)

**Goal**: Migrer `activity_login.xml` et `LoginActivity.kt`.

### Tests for User Story 1 ⚠️
- [ ] T009 [US1] Écrire les tests unitaires pour `LoginViewModel` dans `app/src/test/.../ui/login/LoginViewModelTest.kt`.
- [ ] T010 [US1] Écrire les tests d'UI pour `LoginScreen` dans `app/src/androidTest/.../ui/login/LoginScreenTest.kt`.

### Implementation for User Story 1
- [ ] T011 [US1] Créer `LoginViewModel.kt` dans `app/src/main/.../ui/login/`.
- [ ] T012 [US1] Migrer la logique de `LoginActivity.kt` dans `LoginViewModel`.
- [ ] T013 [US1] Créer `LoginScreen.kt` et implémenter l'UI de `activity_login.xml`.
- [ ] T014 [US1] Ajouter un `@Preview` pour `LoginScreen`.
- [ ] T015 [US1] Intégrer `LoginViewModel` avec `LoginScreen`.
- [ ] T016 [US1] Mettre à jour la navigation pour afficher `LoginScreen` au démarrage.
- [ ] T017 [US1] Supprimer `activity_login.xml` et `LoginActivity.kt`.

---

## Phase 4: User Story 2 - Écran Principal (Priority: P2)

**Goal**: Migrer `activity_main.xml` et `MainActivity.kt`.

### Tests for User Story 2 ⚠️
- [ ] T018 [US2] Écrire les tests unitaires pour `MainViewModel`.
- [ ] T019 [US2] Écrire les tests d'UI pour `MainScreen`.

### Implementation for User Story 2
- [ ] T020 [US2] Créer `MainViewModel.kt`, en réutilisant `CeeloService`.
- [ ] T021 [US2] Migrer la logique de `MainActivity.kt` dans `MainViewModel`.
- [ ] T022 [US2] Créer `MainScreen.kt` et implémenter l'UI de `activity_main.xml`.
- [ ] T023 [US2] Ajouter un `@Preview` pour `MainScreen`.
- [ ] T024 [US2] Intégrer `MainViewModel` avec `MainScreen`.
- [ ] T025 [US2] Mettre à jour la navigation depuis `LoginScreen` vers `MainScreen`.
- [ ] T026 [US2] Supprimer `activity_main.xml` et `MainActivity.kt`.

---

## Phase 5: User Story 3 - Écran des Statistiques (Priority: P3)

**Goal**: Migrer `activity_stats.xml` et `StatsActivity.kt`.

### Tests for User Story 3 ⚠️
- [ ] T027 [US3] Écrire les tests unitaires pour `StatsViewModel`.
- [ ] T028 [US3] Écrire les tests d'UI pour `StatsScreen`.

### Implementation for User Story 3
- [ ] T029 [US3] Créer `StatsViewModel.kt`.
- [ ] T030 [US3] Migrer la logique de `StatsActivity.kt` dans `StatsViewModel`.
- [ ] T031 [US3] Créer `StatsScreen.kt` et implémenter l'UI en utilisant le composant `GameRow`.
- [ ] T032 [US3] Ajouter un `@Preview` pour `StatsScreen`.
- [ ] T033 [US3] Intégrer `StatsViewModel` avec `StatsScreen`.
- [ ] T034 [US3] Mettre à jour la navigation pour accéder à `StatsScreen`.
- [ ] T035 [US3] Supprimer `activity_stats.xml` et `StatsActivity.kt`.

---
## Phase 6: Nettoyage Final
- [ ] T036 Supprimer le module `app-legacy` du projet.
- [ ] T037 Mettre à jour le `README.adoc` pour refléter la fin de la migration.