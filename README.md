# Exchange-Rate Android Application

Exchange-Rate is an Android application that allows users to fetch and display real-time currency exchange rates. The application is built using modern Android development practices and libraries to ensure a smooth and efficient user experience.

## Table of Contents

- [Screens](#screens)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Reference](#api-reference)

## Screens

### 1. Choose Currency Screen

- Choose from two currencies for exchange (list with all currencies obtained from the API).
- An input field to add the amount of money.
- A button to continue.

### 2. Conversion Screen

- An input field populated with the input from the previous screen (editable).
- A switch button to change the direction of the currency conversion (e.g., EUR to USD or USD to EUR).
- Display the converted amount.
- A back button to return to the first screen.

## Technologies Used

- [Android Studio](https://developer.android.com/studio): IDE
- [Jetpack Compose](https://developer.android.com/jetpack/compose): For building a modern UI in a declarative manner.
- [Clean Architecture](https://developer.android.com/topic/architecture): For better readability and testability of the code.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): For dependency injection, allowing for easier testing and modularization.
- [Kotlin Flows](https://kotlinlang.org/docs/flow.html): For reactive state management and asynchronous data updates.
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html): For managing background tasks and API calls without blocking the UI.
- [Retrofit](https://square.github.io/retrofit/): HTTP client for making API requests and handling the responses.

## Getting Started

### 1. Prerequisites

* Make sure you have Git installed on your machine. You can download and install it from [Git's official website](https://git-scm.com/downloads).
* Install Android Studio, the official IDE for Android development, from the [Android Studio website](https://developer.android.com/studio).

### 2. Clone This Repository
* Open a terminal for Linux/Mac or Git Bash for Windows.
* Navigate to a directory in which you would want to clone this project.
* Clone the repository, using the following command:
   ```bash
   git clone https://github.com/mitidimitara/Exchange-Rate.git
* The project should be downloaded to your local machine.

### 3. Import the Project into Android Studio and Open It
* Open Android Studio.
* Click on "Open an existing Android Studio project."
* Navigate to the directory where you cloned the project and open it.

### 4. Install The Required Dependencies
* This step is automatic. Android Studio will start syncing and downloading the required dependencies that are specified in the project's `build.gradle` files.
* The process might take a while, depending on your internet connection.

### 5. Configure Emulator or Connect a Physical Device
* In order to run **TheRecipeApp**, you will need either an Android Emulator or a physical Android Device connected to your computer.
* Setup an emulator by going to `Tools -> AVD Manager` and creating a new virtual device. Recommended Android API Version is 33 or Android 13.
* Enable USB Debugging on your physical Android device and connect it to your computer via a USB cable.

### 6. Run The Application
* Once the project is synced, all dependencies are installed and there is either a device or emulator connected, click the `Run` button (usually a green triangle) in the Android Studio's toolbar or the keyboard combination `Shift+F10`.
* If you currently have multiple devices and/or emulators connected at the same time, choose the one you want to run the app on.
* The IDE will build the app and install it on the selected device.

## API Reference
The application interacts with the ExchangeRate-API, which provides up-to-date exchange rate data.

1. The main endpoint used is: https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{baseCurrency}

2. Replace {baseCurrency} with the desired currency code (e.g., USD, EUR) or even implement locale logic.

3. Refer to the ExchangeRate-API documentation for more details on available endpoints and usage.