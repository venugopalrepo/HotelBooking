HotelBooking

This is Serenity Cucumber test automation framework to automate Hotel Booking application. This project is built on maven in Java, with tools Serenity and Cucumber.

To setup the project, follow below steps:

Clone the Git repository to your local machine.
Ensure you have Java 8 and IDE (Eclipse or IntelliJ) installed.
Import the project as maven project in IDE and wait until all dependancies downloaded.

To run the test:

Open command prompt or terminal window in IDE, then in the project root path run the below command:

mvn clean verify serenity:check -Dcucumber.options="--tags @Demo" -Denv=test

To view the test reports:

Go to target/serenity folder from project path and open index html file.

Note: Serenity is used in this project for reporting purpose only.