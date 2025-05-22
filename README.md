# Grid-List Application

## Overview

This Android application demonstrates a simple UI that displays a list of items in either a grid or a list format. Users can switch between these two views using icon buttons in the `TopAppBar`. The grid view is adaptive, meaning it adjusts the number of columns and item sizes based on the available screen width.

The application is built using Jetpack Compose.

## Project Structure

The project follows a standard Android application structure with key components organized as follows:

-   **`app/src/main/java/com/example/gridlistapp/model/ListItemData.kt`**:
    -   Defines the `ListItemData` data class, which represents the structure for each item displayed in the lists. It typically includes properties like an ID, title, and an image resource.

-   **`app/src/main/java/com/example/gridlistapp/ui/components/`**:
    -   This package contains reusable UI composable functions.
    -   `ListItemView.kt`: A Composable function responsible for rendering a single item. It takes a `ListItemData` object and displays its image and title.
    -   `GridView.kt`: A Composable function that arranges items in a grid. It uses `LazyVerticalGrid` with `GridCells.Adaptive(minSize = 120.dp)` to create a responsive grid where items adapt to the screen size.
    -   `ListView.kt`: A Composable function that arranges items in a vertical list using `LazyColumn`.

-   **`app/src/main/java/com/example/gridlistapp/ui/screens/MainScreen.kt`**:
    -   This file contains the `MainScreen` Composable, which is the primary UI of the application.
    -   It manages the state for the current view type (Grid or List).
    -   It includes a `TopAppBar` with `IconButton`s that allow the user to toggle between `GridView` and `ListView`.
    -   It conditionally renders either `GridView` or `ListView` based on the selected view type.

-   **`app/src/main/java/com/example/gridlistapp/MainActivity.kt`**:
    -   The main entry point for the Android application.
    -   It sets up the Jetpack Compose content and displays the `MainScreen`, providing it with sample data.

## Key Features

-   **View Switching**:
    -   Users can dynamically switch between a grid view and a list view of items using `IconButton`s in the `TopAppBar`.
    -   The application maintains the state of the selected view and updates the UI accordingly.

-   **Adaptive Grid**:
    -   The grid view (`GridView.kt`) is implemented using `GridCells.Adaptive(minSize = 120.dp)`.
    -   This allows the grid to automatically adjust the number of columns and the size of each cell based on the available screen width, ensuring a responsive layout on different device sizes and orientations.

## Testing

-   **Unit Tests**:
    -   Unit tests for the view switching logic in `MainScreen.kt` are located in:
        `app/src/test/java/com/example/gridlistapp/ui/screens/MainScreenTest.kt`.
    -   These tests verify that the `MainScreen` correctly displays the initial view (List) and that the view toggles correctly when the corresponding `IconButton`s are clicked.
    -   Tests are run using Robolectric and the Compose testing library.
