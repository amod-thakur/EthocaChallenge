<h3>Test Coding Challenge for Ethoca on automationpractice.com 

The automation framework is developed using Selenium Web Driver. It uses Java as the scripting language and TestNG as the Test Runner. 

* The framework is designed using Page Object Design Pattern.
* Each page is created as a Java class and it contains the element locators and actions on that page.</br>
* The reporting is implemented using Extent Report Library.</br>
* Maven is used for dependency management using pom.xml. 
* Logging is implemented using log4j and the logs are generated by ITestNGListner implementation. The generated logs are stored at "Log4j/log4j-application.log".
* The testNG suite file is located under "src/test/testSuites/suite.xml".

* The test suite can be executed in one of the following ways.

  * Using IDE such as IntelliJ or Eclipse
  * Using maven surefire plugin,entering the below command in terminal
*       mvn clean test

*   On Test Execution the Extent report is generated and placed at ExtentReports/ExecutionReport.html
          