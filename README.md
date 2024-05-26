# BookDBCodeTest

BookDBCodeTest is an Android application for searching and saving books.

## Features
- Fetches data from the provided API endpoint: [API Endpoint](https://www.dbooks.org/api/search/{query})
- **Search Books**: Users can search for books using a search bar. The results are fetched from a remote API using Retrofit.
- **Display Books**: Search results are displayed in a RecyclerView with a custom adapter.
- **Favorite Books**: Users can mark books as favorites, which are then stored in a local database using Room.
- **ViewModel and LiveData**: The project uses Android's ViewModel and LiveData components to handle UI-related data in a lifecycle-conscious way.

## Screenshots
<img src="https://github.com/MyaThanHtet/BookDBCodeTest/assets/50415966/8f34ec07-9f21-477a-9fa2-6dae91dc179b" width="30%"  alt="Screenshot 1">
<img src="https://github.com/MyaThanHtet/BookDBCodeTest/assets/50415966/98a9cc87-3690-4723-b5d1-5a1ada0b1add" width="30%"  alt="Screenshot 2">
<img src="https://github.com/MyaThanHtet/BookDBCodeTest/assets/50415966/65dd69b0-e1b2-4461-932a-fcc65ae2ea5c" width="30%"  alt="Screenshot 3">
<img src="https://github.com/MyaThanHtet/BookDBCodeTest/assets/50415966/e3950c34-0c88-49dc-bc98-dbbdb17bb8a2" width="30%"  alt="Screenshot 4">
<img src="https://github.com/MyaThanHtet/BookDBCodeTest/assets/50415966/b14d8dd8-d7c4-4180-9e70-18fe413cb4fb" width="30%"  alt="Screenshot 5">
<img src="https://github.com/MyaThanHtet/BookDBCodeTest/assets/50415966/f954c4ec-249d-4660-bffc-7b1021b8657b" width="30%"  alt="Screenshot 6">

## Screen Recording Video
[![Watch the screen recording video](https://img.youtube.com/vi/YYckKhM7hlI/0.jpg)](https://youtu.be/YYckKhM7hlI)

## Download APK
https://drive.google.com/file/d/1k8t55_adLA1qSNLZmZyq-v8bmCHV-QOD/view?usp=sharing

## Technologies Used

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Dependency Injection**: Dagger Hilt
- **Database**: Room
- **Networking**: Retrofit
- **Asynchronous Programming**: Kotlin Coroutines
- **Image Loading**: Glide
- **UI Components**: Android Jetpack (RecyclerView, ConstraintLayout, etc.)
- **Testing**: JUnit, Mockito, Espresso
- **Navigation**: Jetpack Navigation Components
- **Data Binding**: Android Data Binding
- **Version Control**: Git

## Dependencies
The project makes use of several libraries and tools. Below is a list of key dependencies:

- **AndroidX Libraries**: Core libraries for Android development.
- **Dagger-Hilt**: For dependency injection.
- **Retrofit**: For network requests.
- **Room**: For local database management.
- **Glide**: For image loading.
- **JUnit & Mockito**: For unit testing.
- **CircularImageView**: For circular image view.


## Project Structure
The project follows the MVVM (Model-View-ViewModel) architecture. Here is a high-level overview of the structure:

- **data**: Contains data models, DAO interfaces, database classes, and repository classes.
- **ui**: Contains the UI-related classes, including fragments, activities, and adapters.
- **viewmodel**: Contains ViewModel classes.
- **di**: Contains Dagger-Hilt modules for dependency injection.
  

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository: `git clone <https://github.com/MyaThanHtet/BookDBCodeTest.git>`
2. Open the project in Android Studio.
3. Build and run the application on an emulator or physical device.

## Folder Structure

The project follows a standard Android project structure:

|-- app
| |-- src
| |-- main
| |-- java/com/mya/bookdbcodetest
| |-- data # Data layer: repositories, data sources, models
| |-- di # Dependency Injection modules
| |-- model # Data models
| |-- ui # User Interface: fragments, activities, adapters
| |-- utils # Utility classes
| |-- res # Resources: layouts, drawables, strings, etc.
| |-- test # Unit tests
| |-- androidTest # Instrumented tests
|-- build.gradle # Project-level Gradle build file
|-- settings.gradle # Gradle settings file
|-- README.md # Project documentation

## Conclusion
This project demonstrates the integration of multiple Android development best practices,
including MVVM architecture, dependency injection, and local data storage.
This documentation provides a comprehensive guide to understanding, setting up, and testing the project.

