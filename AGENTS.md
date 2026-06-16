# AGENTS.md

Guidance for AI agents working in this repository.

## Project type

A small **Java + Maven** educational workshop ("Virtual Zoo") that teaches the four OOP pillars
(encapsulation, abstraction, inheritance, polymorphism). It is **intentionally incomplete**:
students fill in `// TODO:` markers.

## Critical: This is starter code, do not "fix" it

The repository ships **deliberately broken / missing** code. Each `// TODO:` is a graded student
task. Do **not**:
- Add `extends Animal` to `Lion`/`Parrot` (Task 3 / 5)
- Implement the missing constructors or `makeSound()` overrides (Tasks 4 / 6)
- Change `Animal.name`/`Animal.age` from `public` to `private` (Task 1)
- Convert `Animal.makeSound()` into an abstract method (Task 2)
- Make `Animal` itself abstract (Task 7)
- Complete the iteration loop in `Zoo.main` (Task 8)

If asked to "implement the workshop", that is the one exception — follow the per-task `// TODO:`
instructions and the README. Otherwise treat the missing pieces as intentional.

## Build / run

Maven, Java **22** toolchain (see `pom.xml` `maven.compiler.source/target`). No Maven wrapper is
committed despite the `.gitignore` reference — use a system `mvn`.

```bash
mvn compile                 # compile main sources
mvn exec:java -Dexec.mainClass=com.codecool.Zoo   # run the morning routine
mvn package                 # build jar (also runs tests if any exist)
```

Entry point: `com.codecool.Zoo#main` (`src/main/java/com/codecool/Zoo.java`). When all TODOs are
implemented it prints the zoo's morning routine with each animal's sound.

## Tests

JUnit 5 (`junit-jupiter` 5.8.1) is declared in `pom.xml` as a test dependency, but **no
`src/test` directory exists yet**. `mvn test` will succeed trivially. If adding tests, follow the
Maven standard layout: `src/test/java/com/codecool/...`.

## Code organization

```
src/main/java/com/codecool/
├── Zoo.java                 # main() entry point; demonstrates polymorphism via a List<Animal>
└── animal/
    ├── Animal.java          # base class (will become abstract)
    ├── Lion.java            # subclass (does not yet extend Animal in starter)
    └── Parrot.java          # subclass (does not yet extend Animal in starter)
```

- `Zoo` lives in `com.codecool`; animals live in `com.codecool.animal`. `Zoo` uses a **wildcard
  import** (`import com.codecool.animal.*;`). Keep this in mind when adding new animal classes —
  they will be picked up automatically.
- Package layout mirrors the conceptual hierarchy: base concept in `animal/`, runner at the top
  level.

## Task map (for reference when implementing or reviewing)

| Task | File                | OOP pillar          | What the student must do                                |
|------|---------------------|---------------------|---------------------------------------------------------|
| 1    | `Animal.java`       | Encapsulation       | Make `name`/`age` private; add `getName()` getter        |
| 2    | `Animal.java`       | Abstraction         | Declare `makeSound()` (no body / abstract)               |
| 3    | `Lion.java`         | Inheritance         | `extends Animal`; `super(...)` in constructor            |
| 4    | `Lion.java`         | Polymorphism        | Override `makeSound()` → roar                            |
| 5    | `Parrot.java`       | Inheritance         | `extends Animal`; `super(...)` in constructor            |
| 6    | `Parrot.java`       | Polymorphism        | Override `makeSound()` → squawk                          |
| 7    | `Animal.java`       | Abstraction         | Mark `Animal` `abstract` (never instantiated directly)   |
| 8    | `Zoo.java`          | Polymorphism        | Loop over `List<Animal>`, print name + `makeSound()`     |

## Gotchas

- **Java 22 required.** Older JDKs (8–17) will fail `mvn compile` because of
  `maven.compiler.source=22`.
- The `Parrot.java` TODO comment has a stray trailing `M` (`"...Animal. M"`) — that is a typo in
  the original starter, not something to "correct" as part of a student task.
- `Animal.makeSound()` currently has a concrete body printing `"Animal sound"`. Task 2 expects this
  to become abstract; once it does, all subclasses are *forced* to override it (which is the point).
- The `List<Animal>` in `Zoo` is the polymorphism demonstration site — adding new animal types
  requires no changes to that loop once the TODO is implemented.

## Conventions

- 4-space indentation, standard Java brace style (K&R).
- `// --- Task N` header above each `// TODO:` block — preserve this numbering if editing TODOs.
- Constructor parameters shadow fields (`name`, `age`) and use `this.` to assign.
