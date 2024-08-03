# Exchange-Rate Android Application

Exchange-Rate is an Android application that allows users to fetch and display real-time currency exchange rates. The application is built using modern Android development practices and libraries to ensure a smooth and efficient user experience.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Reference](#api-reference)
- [Contributing](#contributing)
- [License](#license)

## Features

- Real-time currency exchange rates
- User-friendly interface built with Jetpack Compose
- Dependency Injection with Hilt
- State management using Kotlin Flows
- Asynchronous API calls using Coroutines
- Networking handled by Retrofit

## Technologies Used

- [Jetpack Compose](https://developer.android.com/jetpack/compose): For building a modern UI in a declarative manner.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): For dependency injection, allowing for easier testing and modularization.
- [Kotlin Flows](https://kotlinlang.org/docs/flow.html): For reactive state management and asynchronous data updates.
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html): For managing background tasks and API calls without blocking the UI.
- [Retrofit](https://square.github.io/retrofit/): For making network requests to the ExchangeRate-API.

## Getting Started

### Prerequisites

- Android Studio (preferably the latest version)
- Basic knowledge of Kotlin and Android development

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/mitidimitara/Exchange-Rate.git

2. Open the project in Android Studio.

3. Sync the project with Gradle files.

4. Obtain an API key from ExchangeRate-API and add it to your project (see the next section for details).

5. Go to NetworkModule file and replace the constant API_KEY with your own unique one.

## Usage
Once the setup is complete, you can run the application on an emulator or a physical device. The app provides a simple interface to select currencies and view their exchange rates.

1. Launch the app.

2. Select the base currency and the target currency.

3. Tap the "Get Rate" button to fetch the latest exchange rate.

## API Reference
The application interacts with the ExchangeRate-API, which provides up-to-date exchange rate data.

1. The main endpoint used is: https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{baseCurrency}

2. Replace {baseCurrency} with the desired currency code (e.g., USD, EUR) or even implement locale logic.

3. Refer to the ExchangeRate-API documentation for more details on available endpoints and usage.