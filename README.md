# Junit_Automation

## About this project

This test automation project is designed to automate various test scenarios on the Digital Unite website. It utilizes the Selenium WebDriver framework to interact with web elements and perform actions on web pages. The project includes test cases for:
- Visiting the website.
- Verifying the page title.
- Checking the visibility of the title image.
- Filling out a web form and submitting it.

### Prerequisites

- Java Development Kit (JDK)
- Selenium WebDriver
- WebDriver executable 
- Maven 

### Installation

1.Download and install intellij.
2.Clone the repository to your local machine:

   ```shell
   git clone <repository_url>

### Configuration

1.Open the project in preferred Java IDE(e.g., IntelliJ IDEA,).
2.Configure the WebDriver executable path in the test script:
 In the browsersetup method of TestAutomation.java, set the path to WebDriver executable.
3.For using Maven, navigate to the project's root directory and install the required dependencies:
 mvn clean install'
4.In the TestAutomation.java file, configure the following:
 WebDriver Executable Path: Update the browsersetup method to set the path to WebDriver executable.
  
## Running the Tests
To run the automated tests use Java IDE or Maven. Ensure that the WebDriver executable is either in system's PATH or the path is set explicitly in the code.
For Using Maven:
  Open your terminal or command prompt.
  Navigate to the project's root directory.
  Run the following Maven command to execute the tests:
  -mvn test

 ## Test Report
![image](https://github.com/Fayrose96/Junit_Automation/assets/143695839/9bb61ee5-770d-4422-9aee-ceb9f1671f42)




