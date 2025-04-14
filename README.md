# 🐾 PokeDexify Android App

PokeDexify is a sleek and modern Android application crafted for Pokémon enthusiasts. Built with clean architecture and modular principles, it offers a smooth and responsive experience for browsing and exploring Pokémon data. Designed with Kotlin and Jetpack Compose, PokeDexify focuses on scalability, maintainability, and performance — all wrapped in a fun and intuitive interface.
---

## 🚀 Tech Stack

- **Kotlin** – Modern, concise, and safe programming language for Android development.
- **Coroutines** – Asynchronous programming for smooth, non-blocking operations.
- **Jetpack Compose** – Declarative UI toolkit for native Android interfaces.
- **SqLite** – SQLite abstraction layer for local persistence.
- **Proto DataStore** – Typed and efficient data storage solution, replacing SharedPreferences.
- **Coil** – Fast, lightweight image loading for Android.
- **Custom Build Logic** – Convention-based Gradle plugins for simplified project setup.

---

## 🧱 Project Structure

- `core/`  
  Shared modules across features. Contains business logic, data sources, and utility layers.

    - `data/` - Repository implementations and interfaces
    - `datastore/` - Proto DataStore configuration and usage
    - `domain/` - UseCases and domain models
    - `extension/` - Kotlin extension functions
    - `network/` - API configuration, service interfaces

- `build-logic/`  
  Contains custom Gradle convention plugins to standardize module configurations (e.g., Compose setup, Kotlin config, testing setup).

- `build.gradle.kts`, `settings.gradle.kts`  
  Root-level Gradle configuration files.

---

## 📦 Module Overview

Each module is designed to be loosely coupled and independently testable. The project applies clean architecture principles with the following layers:

- **App Layer** – Handles navigation and root Compose scaffolding.
- **Core Layer** – Contains reusable and shared code like networking, data handling, and extensions.
- **Feature Layer** – Self-contained features for modular UI and logic.
- **Build Logic** – Convention plugins that reduce duplication and keep Gradle setup clean.

---

## Video
