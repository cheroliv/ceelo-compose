# Implementation Plan: [FEATURE]

**Branch**: `[###-feature-name]` | **Date**: [DATE] | **Spec**: [link]
**Input**: Feature specification from `/specs/[###-feature-name]/spec.md`

**Note**: This template is filled in by the `/speckit.plan` command. See `.specify/templates/commands/plan.md` for the execution workflow.

## Summary

[Extract from feature spec: primary requirement + technical approach from research]

## Technical Context

<!--
  ACTION REQUIRED: Replace the content in this section with the technical details
  for the project. The structure here is presented in advisory capacity to guide
  the iteration process.
-->

**Language/Version**: Kotlin [e.g., 1.9.20 or NEEDS CLARIFICATION]
**Primary Dependencies**: Jetpack Compose [e.g., 1.6.0 or NEEDS CLARIFICATION]
**Storage**: [if applicable, e.g., Room, DataStore or N/A]
**Testing**: JUnit, ComposeTestRule, Mockito/MockK or NEEDS CLARIFICATION
**Target Platform**: Android API [e.g., 34 or NEEDS CLARIFICATION]
**Project Type**: Mobile (Android)
**Performance Goals**: [e.g., Maintain 60fps animations, <500ms screen load or NEEDS CLARIFICATION]
**Constraints**: [e.g., APK size limit, offline-first or NEEDS CLARIFICATION]
**Scale/Scope**: [e.g., Migration of ~X screens, ~Y legacy XML layouts or NEEDS CLARIFICATION]

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

- [ ] **I. UI Déclarative**: Does the plan exclusively use Jetpack Compose for new UI?
- [ ] **II. Kotlin Unique**: Is all new code, including build scripts, written in Kotlin?
- [ ] **III. Architecture MVVM**: Does the design follow MVVM principles, separating state (ViewModel) from UI (Composables)?
- [ ] **IV. Prévisualisation/Tests UI**: Does the plan include `@Preview` functions for Composables and UI tests for critical user flows?
- [ ] **V. Tests Unitaires**: Is all new business and ViewModel logic covered by unit tests?
- [ ] **Dépendances**: Is any new dependency addition justified and approved?
- [ ] **Workflow de Migration**: Does the proposed change focus on a single screen or a cohesive set of components?

## Project Structure

### Documentation (this feature)

```text
specs/[###-feature]/
├── plan.md              # This file (/speckit.plan command output)
├── research.md          # Phase 0 output (/speckit.plan command)
├── data-model.md        # Phase 1 output (/speckit.plan command)
├── quickstart.md        # Phase 1 output (/speckit.plan command)
├── contracts/           # Phase 1 output (/speckit.plan command)
└── tasks.md             # Phase 2 output (/speckit.tasks command - NOT created by /speckit.plan)
```

### Source Code (repository root)
<!--
  ACTION REQUIRED: Replace the placeholder tree below with the concrete layout
  for this feature. Delete unused options and expand the chosen structure with
  real paths (e.g., apps/admin, packages/something). The delivered plan must
  not include Option labels.
-->

```text
# [REMOVE IF UNUSED] Option 1: Single project (DEFAULT)
src/
├── models/
├── services/
├── cli/
└── lib/

tests/
├── contract/
├── integration/
└── unit/

# [REMOVE IF UNUSED] Option 2: Web application (when "frontend" + "backend" detected)
backend/
├── src/
│   ├── models/
│   ├── services/
│   └── api/
└── tests/

frontend/
├── src/
│   ├── components/
│   ├── pages/
│   └── services/
└── tests/

# [REMOVE IF UNUSED] Option 3: Mobile + API (when "iOS/Android" detected)
api/
└── [same as backend above]

ios/ or android/
└── [platform-specific structure: feature modules, UI flows, platform tests]
```

**Structure Decision**: [Document the selected structure and reference the real
directories captured above]

## Complexity Tracking

> **Fill ONLY if Constitution Check has violations that must be justified**

| Violation | Why Needed | Simpler Alternative Rejected Because |
|-----------|------------|-------------------------------------|
| [e.g., 4th project] | [current need] | [why 3 projects insufficient] |
| [e.g., Repository pattern] | [specific problem] | [why direct DB access insufficient] |
