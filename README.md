Reflektion API testing project
This project contains test cases for all the scenarios mentioned in the email.
There are validations for GET,POST,PUT,DELETE request.
Technologies used are JAVA,Rest Assured,TestNG,Maven.
Eclipse is used to write the code.

Setup:
1.Install Adopt Open JDK version 12.
2.Maven should be installed (Java jdk should be pre installed)

Follow the instruction in https://www.tutorialspoint.com/maven/maven_environment_setup or any other sites for maven installation.

Note:
Please install the latest version of maven i.e. apache-maven-3.6.1


Running the test:
1.Using Eclipse:
You can import the suite to eclipse by selecting existing maven project under section.
Then run the pom.xml by selecting Run as -> maven test.
Note:
Maven and TestNG should also be installed for eclipse if you are running through eclipse.

2.Using command prompt:
move to the folder where project is present.
Run command:
mvn test

Test Report:
complete Report can be found in target/surefire-reports
emailable-report.html has all the details on test case logs and result status.

