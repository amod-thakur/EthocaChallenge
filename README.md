<h3>Test Coding Challenge for Ethoca on automationpractice.com </h3>

* The automation framework is developed using Selenium Web Driver. It uses Java as the programming language and TestNG as the Test Runner. 

* The framework is designed using Page Object Design Pattern and Single Responsibility Principle.
* All the page object classes  are under "src/main/java/ in "com.ethoca.pages" package.
* All the test cases are under "src/test/java" in "com.ethoca.tests" package.
* Each page is created as a Java class and it contains the element locators and actions on that page.</br>
* The reporting is implemented using Extent Report Library. The reporting logic is implemented under "src/main/java" in package"com.ethoca.report" </br>
* Maven is used for dependency management using pom.xml. 
* Logging is implemented using log4j and the logs are generated by ITestNGListener implementation. The logs are generated on test execution and stored at "Log4j/log4j-application.log".
* The testNG suite file is located under "src/test/testSuites/suite.xml".

* The test suite can be executed in one of the following ways.

  * Using IDE such as IntelliJ or Eclipse
  * Using maven surefire plugin,entering the below command in terminal
*       mvn clean test

*   On Test Execution the Extent report is generated and placed at ExtentReports/ExecutionReport.html
          