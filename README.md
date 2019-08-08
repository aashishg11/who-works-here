# Who works here Android app

The app displays a list of employees in a list. I have used MVVM with RxJava and dagger to inject dependencies. I am using 
retrofit to make api calls. The small images are lazy loaded and cached on the device. The app handles errors such as no internet connectivity, empty json, exception in making the call,malformed json and time out gracefully.

<h2>Testing</h2> 
I have added unit test to test the viewmodel and some UI test with a mock web server to ensure that the app handles different
responses gracefully. I have tested the app on a Pixel 2 XL emulator.
