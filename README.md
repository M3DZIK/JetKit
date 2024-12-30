# JetKit

*Work on this library is still in progress, new things are constantly being added.*

A Jetpack Compose Utilities Library for Developing Applications.

<img src="screenshots/preview-1.webp" height="720px" alt="preview" />
<img src="screenshots/preview-2.webp" height="720px" alt="preview" />

## Add to your project

Add the jitpack repository to your settings.gradle.kts file:

```kotlin
dependencyResolutionManagement {
    repositories {
        // ...
        maven("https://jitpack.io")
    }
}
```

Next, Add the library as a dependency to your project:

```kotlin
dependencies {
    // https://jitpack.io/#dev.medzik/jetkit
    implementation("dev.medzik.jetkit:jetkit:<version>") // commit sha or main-SNAPSHOT
}
```
