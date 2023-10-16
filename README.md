## TUF-2000M Mobile App

## Product Description
The TUF-2000M Mobile App is designed to provide a user-friendly interface for viewing data from the TUF-2000M ultrasonic energy meter. This app fetches data from the associated REST API and presents it to the user in a readable and intuitive manner.

Gambit has access to one of these meters and it is providing you a live text feed that shows the time of the reading followed by the first 100 register values which look like this:

2017-01-11 19:12
1:7579
2:48988
3:5064
4:48142
5:37967
6:48877
7:63814
8:17575
9:0
10:0
11:24224
12:15965
13:0
14:0
15:0
16:0
17:87
18:0
19:9891
20:16221
21:65480
22:65535
23:39041
24:48994
25:0
26:0
27:0
28:0
29:144
30:0
31:48777
32:16191
33:15568
34:16611
35:28424
36:16534
37:7424
38:15783
39:14592
40:15758
41:5461
42:49087
43:45184
44:15493
45:36608
46:15459
47:29184
48:15516
49:0
50:0
51:0
52:0
53:6432
54:4386
55:5889
56:0
57:0
58:0
59:0
60:255
61:120
62:0
63:0
64:0
65:0
66:4001
67:62500
68:0
69:0
70:3
71:4
72:4
73:3606
74:16800
75:54913
76:48896
77:35706
78:17101
79:44042
80:17099
81:33339
82:16963
83:42500
84:49530
85:33468
86:16963
87:33210
88:16963
89:2885
90:16512
91:0
92:806
93:3501
94:3501
95:0
96:1
97:43137
98:17105
99:3374
100:17839

## Features
- Display parsed data from the TUF-2000M ultrasonic energy meter.
- User-friendly interface for easy data visualization.
- Secure authentication for user access.

## User Manual
Information on the registries, variable names, units, notes, and formats are available on pages 39-42. docs/tuf-2000m.pdf

## Getting Started
Follow these steps to set up the project and run the app locally:

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or a physical device.

## Usage
1. Launch the app.
2. Tap on the Sign-up text to register or use dummy credentials to log in (test@gmail.com / Atea@123#)
3. View the parsed data from the TUF-2000M ultrasonic energy meter in the home view pager screen.

## Technologies Used
- Kotlin
- Android Studio

## Dependencies
- [Retrofit](https://square.github.io/retrofit/) for making HTTP requests.
- [Gson](https://github.com/google/gson) for JSON serialization and deserialization.
- Hilt for dependency injection
- Jetpack components
- Firebase
- -Etc...

## Testing
1. Signed apk distributed link for internal testing:  https://appdistribution.firebase.dev/i/0bde28dffa675f6a
2. Unit and UI tests are yet to be implemented to ensure the app's functionality and user interface work as expected.

## Additional info:
1. Some supporting information in this Google Drive link - https://drive.google.com/drive/folders/1b5gtmzvwHqkAr0e5juCrw9oakHomrRjF
2. https://my-json-server.typicode.com/MinchalaVenkatSunil/demo - "my-json-server.typicode.com", used the restricted sample with limitations to fetch JSON response.

## Additional Thoughts:
	1. **Localization** support based on language ID stored in the registry. Initiated but still needs to be completed fully.
	2. **Offline** support to access previously fetched data and other few timestamps. 
	3. Ask for **user feedback** once on a scheduled basis. 
	4. **Charts, graphs** presentation, maybe on the favorite items for better visualization. 
	5. User settings for font size, **dark mode** support
	6. Add more UI and unit test coverage. 
	7. Support for multiple form factors. 
	8. Extend the support to Apple devices and others using **cross-platform technologies** using React Xamarin forms.
	9. An eye on code quality and best practices.  
	10. Automatically publish to Play or App Store on production repo commit using **CICD pipelines**. Just to let you know, it was started and is in progress. 
	11. Need to utilize **analytics** to analyze user behavior and generate reports for decision-making and UI improvements.
	12. iPasS **serverless triggers** (e.g., logic apps, functions, Azure stream job analytics) for data processing and desired output transformation.
	13. Tokens to keep all the information shared between the app and the server safe and secure.
	14. I believe we can implement some features to the existing list to make a user-friendly UI. 
		a. Sort by category
		b. Sort by Alphabet
		c. Favorites (if the user wants to see specific Readings only)
		d. Search as the list might be big
    e. Grouping the related content

## Backend
[TODO: Once the actual backend is ready in a separate repo we will add more info on how to consume those API's later]

## License
This project is licensed under the [MIT License](LICENSE).
