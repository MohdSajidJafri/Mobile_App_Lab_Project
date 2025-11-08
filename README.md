# Todo App - Mobile App Development Lab Project

A simple Android Todo List application demonstrating Kotlin and Java interoperability, built for Mobile App Development lab coursework.

## Features

- ✅ Add new todo items
- ✅ Mark todos as complete/incomplete
- ✅ Delete todo items
- ✅ Persistent storage using SharedPreferences
- ✅ Modern Material Design UI
- ✅ Kotlin + Java interoperability demonstration

## Technologies Used

- **Kotlin** - Modern Android development language
- **Java** - Traditional Android development language
- **Android SDK** - Android development framework
- **Material Design Components** - Modern UI components
- **RecyclerView** - Efficient list rendering
- **SharedPreferences** - Data persistence
- **Gson** - JSON serialization/deserialization

## Project Structure

```
app/
├── src/main/
│   ├── java/com/example/todoapp/
│   │   ├── MainActivity.kt          # Main activity (Kotlin)
│   │   ├── TodoAdapter.kt            # RecyclerView adapter (Kotlin)
│   │   ├── TodoItem.java             # Data model (Java)
│   │   └── TodoManager.java          # Data management (Java)
│   ├── res/
│   │   ├── layout/                   # XML layout files
│   │   └── values/                   # Strings, colors, themes
│   └── AndroidManifest.xml
└── build.gradle                      # App dependencies
```

## Key Concepts Demonstrated

1. **Kotlin-Java Interoperability**
   - Kotlin `MainActivity` using Java `TodoManager` and `TodoItem` classes
   - Seamless data exchange between Kotlin and Java code

2. **Android Components**
   - Activities and Views
   - RecyclerView for efficient list display
   - ViewBinding for type-safe view access

3. **Data Persistence**
   - SharedPreferences for local storage
   - JSON serialization with Gson

4. **Material Design**
   - Modern UI components
   - CardView for item display
   - Material buttons and text fields

5. **MVVM-like Architecture**
   - Separation of concerns (UI, Data, Business Logic)
   - Adapter pattern for RecyclerView

## Requirements

- Android Studio Hedgehog (2023.1.1) or later
- Android SDK 24 (Android 7.0) or higher
- JDK 8 or higher

## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/MohdSajidJafri/Mobile_App_Lab_Project.git
cd Mobile_App_Lab_Project
```

2. Open the project in Android Studio

3. Sync Gradle files (Android Studio will prompt automatically)

4. Run the app on an emulator or physical device

## Building the Project

1. Open Android Studio
2. Click "File" → "Open" and select the project directory
3. Wait for Gradle sync to complete
4. Click "Run" → "Run 'app'" or press Shift+F10

## Usage

1. Enter a todo item in the text field
2. Click "Add Todo" to add it to the list
3. Click "Mark Complete" to mark a todo as done
4. Click "Delete" to remove a todo item
5. Todos are automatically saved and persist between app sessions

## Code Highlights

### Kotlin Code (MainActivity.kt)
- Uses lambda expressions for callbacks
- Late initialization with `lateinit`
- Extension functions and null safety
- ViewBinding for type-safe view access

### Java Code (TodoManager.java, TodoItem.java)
- Traditional Java class structure
- Getters and setters
- SharedPreferences for data persistence
- Gson for JSON serialization

## Author

Created for Mobile App Development Lab coursework.

## License

This project is created for educational purposes.
