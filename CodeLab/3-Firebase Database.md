# Firebase Database(Realtime Database)
## Requirements
This section requires you to own a Google account .

## Android Studio Plugin: Firebase Assistant
> As of Android Studio 2.2, there is a Firebase Plugin integrated with the IDE. Most of the basic integration are done for you. If you have older version of Android Studio, read the "Accessing the Firebase Console" section instead.

1. At the top of the Android Studio, look for **Tools** > **Firebase**
  ![Firebase Plugin](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/3-FirebaseDB-1.jpg)

2. The Assistant window will open up on the right side.

 3. Click on *Realtime Database* and then *Save and retrieve Data*
  ![Firebase Plugin](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/3-FirebaseDB-2.jpg)

4. You will then be presented with Steps to perform. For this exercise, you will only need to do Step 1 and 2.
  - Connect your app to Firebase (Just click on the button)
  - Add the Realtime Database to your app (just click the button)

5. You maybe asked to login to your Google account in order to proceed.

6. In the Dialog, give it a Project Name and select Malaysia as your Country/Region and create your project. There will be a progress dialog at the bottom of Android Studio.
  ![Firebase Plugin](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/3-FirebaseDB-3.jpg)

7. Next click on "Add the Realtime Database to your app" button, accept the dialog changes and wait for it do complete.

## Read/Write  Access of the Database

1. Go to https://console.firebase.google.com

2. Login to your Google account and you will be able to see your Project.
  ![Firebase Plugin](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/3-FirebaseDB-4.jpg)

3. On the side menu, click on **Database**
  ![Firebase Plugin](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/3-FirebaseDB-5.jpg)

4. Click on the menu (3 dots) on the right side.

5. Select *Import JSON* and import this file.
//todolist.json

6. Click on the **Rules** tab and change the rules. This allow anyone to read and  change your data.

  ```json
  {
    "rules": {
      ".read": true,
      ".write": true
    }
  }
  ```
7.  Click on **Publish** to apply your new rules.

  ![Firebase Plugin](https://github.com/AgmoStudioSdnBhd/ToDoApp/raw/master/art/3-FirebaseDB-6.jpg)
