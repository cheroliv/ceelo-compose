---

description: "Task list template for feature implementation"
---

# Tasks: [FEATURE NAME]

**Input**: Design documents from `/specs/[###-feature-name]/`
**Prerequisites**: plan.md (required), spec.md (required for user stories)

**Tests**: Per the constitution, tests are NON-NEGOTIABLE. Each feature must be accompanied by relevant unit and UI tests.

**Organization**: Tasks are grouped by user story (typically a screen or feature migration) to enable independent implementation and testing.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: Which user story this task belongs to (e.g., US1, US2)
- Include exact file paths in descriptions

## Path Conventions

- **Source Code**: `app/src/main/java/education/cccp/jetpack/compose/ceelo/`
- **Unit Tests**: `app/src/test/java/education/cccp/jetpack/compose/ceelo/`
- **UI Tests**: `app/src/androidTest/java/education/cccp/jetpack/compose/ceelo/`
- Paths shown below are examples - adjust based on plan.md structure.

<!-- 
  ============================================================================
  IMPORTANT: The tasks below are SAMPLE TASKS for illustration purposes only.
  
  The /speckit.tasks command MUST replace these with actual tasks based on:
  - User stories from spec.md (with their priorities P1, P2, P3...)
  - Feature requirements from plan.md
  
  Tasks MUST be organized by user story so each story can be:
  - Implemented independently
  - Tested independently
  - Delivered as an MVP increment
  
  DO NOT keep these sample tasks in the generated tasks.md file.
  ============================================================================
-->

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Project configuration and basic structure for the feature.

- [ ] T001 [P] Add any new dependencies to `build.gradle.kts` and `libs.versions.toml`.
- [ ] T002 [P] Create directory structure for the new feature/screen under `app/src/main/.../ceelo/[feature]`.
- [ ] T003 [P] Define navigation route for the new screen if applicable.

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Core infrastructure that MUST be complete before ANY user story can be implemented.

- [ ] T004 Define Color, Theme, and Type in `ui/theme/` if new styles are required.
- [ ] T005 Create shared/reusable Composables in `ui/composables/` that this feature depends on.
- [ ] T006 [P] Add any required string resources to `res/values/strings.xml`.

**Checkpoint**: Foundation ready - screen/feature implementation can now begin.

---

## Phase 3: User Story 1 - [Screen/Feature Title] (Priority: P1) 🎯 MVP

**Goal**: [Brief description of what this story delivers, e.g., "Migrate the Login screen to Jetpack Compose"]

**Independent Test**: [How to verify this story works on its own, e.g., "Launch the app and navigate to the new Login screen; all UI elements are present and functional."]

### Tests for User Story 1 (NON-NEGOTIABLE) ⚠️

> **NOTE: Write these tests FIRST, ensure they FAIL before implementation (Red-Green-Refactor)**

- [ ] T007 [US1] Write unit tests for `[Screen]ViewModel` in `app/src/test/.../[screen]/[Screen]ViewModelTest.kt`.
- [ ] T008 [US1] Write UI tests for `[Screen]Screen` Composable in `app/src/androidTest/.../[screen]/[Screen]ScreenTest.kt`.

### Implementation for User Story 1

- [ ] T009 [US1] Implement `[Screen]ViewModel` to manage state and logic in `app/src/main/.../[screen]/[Screen]ViewModel.kt`.
- [ ] T010 [US1] Create the `[Screen]Screen` Composable, displaying state from the ViewModel, in `app/src/main/.../[screen]/[Screen]Screen.kt`.
- [ ] T011 [P] [US1] Create necessary sub-composables for the screen in `app/src/main/.../[screen]/composables/`.
- [ ] T012 [P] [US1] Add `@Preview` functions for all key Composables to allow for design-time visualization.
- [ ] T013 [US1] Integrate the ViewModel with the Composable screen.
- [ ] T014 [US1] Remove the old XML layout file (`[screen].xml`) and update navigation to point to the new Composable screen.

**Checkpoint**: At this point, User Story 1 should be fully functional and all tests should pass.

---

## Phase 4: User Story 2 - [Screen/Feature Title] (Priority: P2)

**Goal**: [Brief description of what this story delivers]

**Independent Test**: [How to verify this story works on its own]

### Tests for User Story 2 (NON-NEGOTIABLE) ⚠️

- [ ] T015 [US2] Write unit tests for `[Screen]ViewModel` in `app/src/test/.../[screen]/[Screen]ViewModelTest.kt`.
- [ ] T016 [US2] Write UI tests for `[Screen]Screen` Composable in `app/src/androidTest/.../[screen]/[Screen]ScreenTest.kt`.

### Implementation for User Story 2

- [ ] T017 [US2] Implement `[Screen]ViewModel` in `app/src/main/.../[screen]/[Screen]ViewModel.kt`.
- [ ] T018 [US2] Create the `[Screen]Screen` Composable in `app/src/main/.../[screen]/[Screen]Screen.kt`.
- [ ] T019 [US2] Remove the corresponding legacy XML layout.

**Checkpoint**: At this point, User Stories 1 AND 2 should both work and be fully tested.

---

[Add more user story phases as needed, following the same pattern]

---

## Phase N: Polish & Cross-Cutting Concerns

**Purpose**: Improvements that affect multiple user stories

- [ ] TXXX [P] Update `README.adoc` with any new instructions.
- [ ] TXXX Code cleanup and refactoring across migrated screens.
- [ ] TXXX Performance optimization (e.g., using `remember`, checking recomposition counts).
- [ ] TXXX [P] Ensure consistent theming and styling.

---

## Dependencies & Execution Order

### Phase Dependencies

- **Setup (Phase 1)**: Can start immediately.
- **Foundational (Phase 2)**: Depends on Setup. Blocks user story implementation.
- **User Stories (Phase 3+)**: Depend on Foundational phase. Can proceed in parallel if independent.

### Within Each User Story

- Tests MUST be written and FAIL before implementation.
- ViewModel (logic) before Composable (UI).
- Core screen implementation before removing old XML.
- Story complete and tests passing before moving to the next.
