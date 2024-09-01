
## Easy Sale Meta Fetcher

### Overview

Easy Sale Meta Fetcher is an Android application that demonstrates the ability to work with RESTful APIs, local databases, and user interface components. The app allows users to view a list of users fetched from an API, perform CRUD operations (Create, Read, Update, Delete) on the user data, and store it locally using the Room persistence library.

### Features

- Fetches user data from the ReqRes API using Retrofit.
- Stores user data locally using the Room persistence library.
- Displays user data in a RecyclerView with a card-based UI.
- Allows adding, updating, and deleting users.
- Follows the MVVM (Model-View-ViewModel) architectural pattern.

### Assumptions and Challenges

#### Assumptions:

- The user data structure from the ReqRes API was assumed to include basic information such as first name, last name, email, and avatar URL.
- The app assumes that the local Room database schema aligns with the user data fetched from the API.
- The app's functionality assumes that the user has a stable internet connection to fetch data from the API.

#### Challenges:

- Implementing the MVVM architecture was crucial to maintaining a clean separation of concerns, but it required careful coordination between the ViewModel, Repository, and DAO layers.
- Handling potential null values and ensuring that all operations on the ViewModel and Repository were performed safely to prevent crashes was a challenge.
- Ensuring smooth UI/UX with Glide for image loading and handling RecyclerView updates efficiently.

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Android Studio (version 4.0 or later)
- Java Development Kit (JDK 8 or later)
- Internet connection for fetching data from the API

### Installation

1. **Clone the Repository:**

   ```sh
   git clone https://github.com/your-username/easysalemetafetcher.git
   cd easysalemetafetcher
   ```

2. **Open the Project in Android Studio:**
   - Launch Android Studio and select "Open an existing Android Studio project."
   - Navigate to the cloned repository folder and open it.

3. **Build the Project:**
   - Wait for Android Studio to sync the project and download all dependencies.
   - Click on "Build > Rebuild Project" to ensure that the project is properly configured.

4. **Run the Application:**
   - Connect an Android device or start an emulator.
   - Click on "Run > Run 'app'" or press `Shift + F10` to install and run the application.

### Usage

- **Viewing Users:** The app will fetch user data from the ReqRes API and display it in a RecyclerView.
- **Adding Users:** Click the floating action button to add a new user. Fill in the details in the dialog that appears.
- **Updating Users:** Tap on a user in the list to edit their details. Save the changes to update the user information.
- **Deleting Users:** Click the delete icon on a user card to remove the user from the list.

### Code Quality and Best Practices

- **Architecture:** The app follows the MVVM (Model-View-ViewModel) architectural pattern, ensuring a clear separation of concerns.
- **Code Organization:** The code is organized into packages based on functionality (e.g., `database`, `viewmodel`, `repository`, `adapter`).
- **Error Handling:** The app includes error handling for network requests and database operations to prevent crashes.
- **Dependency Management:** The app uses Gradle for dependency management, ensuring that all libraries are up-to-date.

### Building the APK

1. **Generate Signed APK:**
   - In Android Studio, click on "Build > Generate Signed Bundle / APK..."
   - Select "APK" and follow the prompts to generate a signed APK.

2. **Locate the APK:**
   - The APK will be saved in the `app/release/` directory of your project folder.

### Submission

1. **Upload the APK:**
   - Upload the generated APK file to the required platform.

2. **Submit the Repository Link:**
   - Ensure your GitHub repository is public.
   - Submit the link to your GitHub repository where the project is hosted.

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
