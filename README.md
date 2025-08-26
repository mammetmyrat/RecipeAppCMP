# 🍽️ RecipeAppCMP

![RecipeAppCMP Banner](https://via.placeholder.com/800x200.png?text=RecipeAppCMP+Banner) <!-- Replace with your banner image -->

**A cross-platform recipe app built with Kotlin Multiplatform and Compose Multiplatform**

![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue.svg) ![Compose Multiplatform](https://img.shields.io/badge/Compose-Multiplatform-orange.svg) ![Platforms](https://img.shields.io/badge/Platforms-Android%20|%20iOS%20|%20Web%20|%20Desktop-green.svg)

---

## 📋 Overview

RecipeAppCMP is a modern, cross-platform application designed to help users discover, save, and share culinary recipes. Built with **Kotlin Multiplatform** and **Compose Multiplatform**, it seamlessly runs on **Android**, **iOS**, **Web**, and **Desktop**, sharing a single codebase and UI. The app fetches recipe data from the free **TheMealDB API**, providing a rich database of meals and ingredients.

---

## ✨ Features

- 🖥️ **Unified UI**: Beautiful, responsive interfaces powered by Compose Multiplatform.
- 📱 **Cross-Platform**: Runs on Android, iOS, Web, and Desktop with shared logic.
- 🍲 **Recipe Management**: Browse, search, and save your favorite recipes.
- 🔍 **Search & Filter**: Find recipes by name, category, ingredient, or region using TheMealDB API.
- 🌐 **Web Support**: Powered by Kotlin/Wasm for a smooth web experience.

---

## 🛠️ Technologies

| Technology                | Purpose                     |
|---------------------------|-----------------------------|
| **Kotlin Multiplatform**  | Cross-platform code sharing |
| **Compose Multiplatform** | Unified UI across platforms |
| **Kotlin/Wasm**           | Web application support     |
| **TheMealDB API**         | Recipe and meal data        |
| **Gradle**                | Build automation            |

---

## 🌐 API Integration

This project uses the **TheMealDB API**, a free and public recipe API providing access to a global database of meals, ingredients, and categories. Key endpoints include:

- **Search by Name**: `https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata`
- **Filter by Ingredient**: `https://www.themealdb.com/api/json/v1/1/filter.php?i=chicken_breast`
- **List Categories**: `https://www.themealdb.com/api/json/v1/1/categories.php`
- **Random Meal**: `https://www.themealdb.com/api/json/v1/1/random.php`

**API Key**: Use the test key `"1"` for development. For production, consider supporting TheMealDB to access premium features like multi-ingredient filtering. [Learn more](https://www.themealdb.com/).[](https://www.themealdb.com/api.php)

**Example API Call (Kotlin)**:
```kotlin
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

val client = HttpClient()
val response: String = client.get("https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata")
println(response)
client.close()
```

---

## 📦 Requirements

- **JDK**: 17 or higher
- **Android**: Android Studio (latest), Android SDK 21+
- **iOS**: Xcode 14+ (for iOS builds)
- **Web**: Browser with WebAssembly support (e.g., Chrome, Firefox)
- **Desktop**: JVM 17+
- **Dependencies**: Ktor (for API calls), TheMealDB API (free test key: `"1"`)

---

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/mammetmyrat/RecipeAppCMP.git
cd RecipeAppCMP
```

### 2. Platform-Specific Setup

#### 📱 Android
1. Open the project in **Android Studio**.
2. Sync with Gradle.
3. Run on an emulator or device:
   ```bash
   ./gradlew :composeApp:androidApp:run
   ```

#### 🍎 iOS
1. Open the `iosApp` folder in **Xcode**.
2. Configure signing with your Apple ID.
3. Build and run on a simulator or iOS device.

#### 🌐 Web
1. Launch the web app:
   ```bash
   ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
   ```
2. Open `http://localhost:8080` in a WebAssembly-supported browser.

#### 💻 Desktop
1. Run the desktop app:
   ```bash
   ./gradlew :composeApp:run
   ```

---

## 📂 Project Structure

- **`/composeApp`**: Shared code and UI
  - `commonMain`: Shared logic and Compose UI
  - `androidMain`, `iosMain`, `wasmJsMain`, `desktopMain`: Platform-specific code
- **`/iosApp`**: iOS app entry point (includes SwiftUI if needed)

---

## 🥗 Usage

1. Launch the app on your preferred platform.
2. Explore recipes fetched from TheMealDB API.
3. Use search and filters to find recipes by name, ingredient, or category.

**Example Compose UI**:
```kotlin
@Composable
fun RecipeScreen() {
    Column {
        Text("Welcome to RecipeAppCMP! 🍽️", style = MaterialTheme.typography.h4)
        // Fetch and display recipes from TheMealDB API
    }
}
```

---

## 🤝 Contributing

We’d love your contributions! Follow these steps:
1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/your-feature`.
3. Commit your changes: `git commit -m 'Add new feature'`.
4. Push to the branch: `git push origin feature/your-feature`.
5. Open a Pull Request.

---

## 💬 Feedback

Have questions or ideas? Join the discussion in the [#compose-web](https://kotlinlang.slack.com/archives/compose-web) Slack channel or open an issue on GitHub.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## 📞 Contact

- **Author**: [mammetmyrat](https://github.com/mammetmyrat)
- **Email**: [mammetmyrat20020709@gmail.com]
- **Linkedin**: [https://www.linkedin.com/in/mammet-mammetmyradov-a5a247236/]

---

⭐ **Star this repository** if you find it useful! ⭐
