# Implementation Plan: Migration UI vers Jetpack Compose

**Branch**: `001-migration-ui-compose` | **Date**: 2025-11-29 | **Spec**: [./spec.md](./spec.md)
**Input**: Feature specification from `/specs/001-migration-ui-compose/spec.md`

**Note**: This template is filled in by the `/speckit.plan` command. See `.specify/templates/commands/plan.md` for the execution workflow.

## Summary

Migration de l'interface utilisateur de l'application Cee-lo depuis les layouts XML et la logique des `Activity` (`LoginActivity`, `MainActivity`, `StatsActivity`) vers une architecture moderne avec Jetpack Compose. La logique de présentation sera extraite des anciennes `Activity` et placée dans des `ViewModels` dédiés, qui réutiliseront la logique métier existante (`services`, `repositories`) de `app-legacy`.

## Technical Context

**Language/Version**: Kotlin 1.9.20
**Primary Dependencies**: Jetpack Compose 1.6.0, Jetpack ViewModel
**Storage**: N/A
**Testing**: JUnit, ComposeTestRule, MockK
**Target Platform**: Android API 34
**Project Type**: Mobile (Android)
**Performance Goals**: Maintenir des animations fluides à 60fps.
**Constraints**: Réutiliser la logique métier existante de `app-legacy/src/main/java/game/ceelo/`
**Scale/Scope**: Migration de 3 écrans et 1 composant, incluant l'extraction de la logique de 3 `Activity`.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

- [x] **I. UI Déclarative**: Does the plan exclusively use Jetpack Compose for new UI?
- [x] **II. Kotlin Unique**: Is all new code, including build scripts, written in Kotlin?
- [x] **III. Architecture MVVM**: Does the design follow MVVM principles, separating state (ViewModel) from UI (Composables)?
- [x] **IV. Prévisualisation/Tests UI**: Does the plan include `@Preview` functions for Composables and UI tests for critical user flows?
- [x] **V. Tests Unitaires**: Is all new business and ViewModel logic covered by unit tests?
- [x] **Dépendances**: Is any new dependency addition justified and approved?
- [x] **Workflow de Migration**: Does the proposed change focus on a single screen or a cohesive set of components?

## Project Structure

### Documentation (this feature)

```text
specs/001-migration-ui-compose/
├── plan.md              # This file
├── spec.md              # Feature specification
└── tasks.md             # Task breakdown (Phase 2)
```

### Source Code (repository root)

```text
app/src/main/java/education/cccp/jetpack/compose/ceelo/
├── ui/
│   ├── theme/          # Existing theme files
│   ├── login/
│   │   ├── LoginScreen.kt
│   │   └── LoginViewModel.kt
│   ├── main/
│   │   ├── MainScreen.kt
│   │   └── MainViewModel.kt
│   └── stats/
│       ├── StatsScreen.kt
│       ├── StatsViewModel.kt
│       └── composables/
│           └── GameRow.kt
└── services/             # Copied/adapted from app-legacy
    └── CeeloService.kt
...
```

**Structure Decision**: La structure suit une organisation par fonctionnalité (`login`, `main`, `stats`) au sein du package `ui`. La logique métier (`services`, `repositories`) sera déplacée de `app-legacy` vers une structure de package appropriée dans le nouveau module `app` pour être injectée dans les `ViewModels`.

## Complexity Tracking

> **Fill ONLY if Constitution Check has violations that must be justified**

| Violation | Why Needed | Simpler Alternative Rejected Because |
|-----------|------------|-------------------------------------|
| -         | -          | -                                   |
