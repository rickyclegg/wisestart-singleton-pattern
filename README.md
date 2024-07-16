# WiseStart Singleton Pattern

### Did someone say Typescript?
For the first time ever you can checkout the branch `typescript` to see the same exercise implemented in Typescript.

### Setup
* Run `npm install` to install the necessary dependencies.
* Run `npm test` to run the tests.

#### Objective:
Implement a Singleton class `Configuration Manager` in Java and run JUnit tests to verify its behavior.

#### Requirements:
1. Singleton Implementation
   - Implement a ConfigurationManager class using the Singleton Design Pattern.
   - Ensure only one instance of the class is created, even when accessed by multiple threads.
   - Include methods to set and get configuration settings (e.g., database URL, API key).
2. JUnit Testing
   - Run JUnit tests to verify that:
     - The ConfigurationManager class restricts the instantiation of the class to one instance.
     - The configuration settings can be set and retrieved correctly.
     - The Singleton implementation is thread-safe.
3. Guidelines:
   - Use the double-checked locking mechanism to implement the Singleton pattern.
   - Include comments in your code to explain the key parts of your implementation.
   - Use JUnit 5 for the unit tests.
4. Submission:
   - Provide the source code for the ConfigurationManager class.
   - Provide the source code for the JUnit test class.
5. Bonus:
   - Extend the functionality of the ConfigurationManager class to include additional configuration settings and test them accordingly.
   - This challenge should provide a compelling and realistic scenario for utilizing the Singleton Pattern while giving your graduate engineers practical experience with concurrent programming and unit testing in Java.

#### Hint:
If you want to see how it is done checkout the `solution` branch.
