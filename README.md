# CMS-module
This is a CSC 510 Project as a demonstration in TDD vs BDD practices in software engineering.

This project was done by 
* Aniket Lawande
* Anisha Shetty
* Prashant Trivedi
* Ritwika Roychoudhury
* Sohan Kollu

CMS-Module-BDD and CMS-Module-TDD are 2 parallel projects which develop a CMS (Content Management System). It is a simple Java application. The TDD version was developed using JUnit and TDD (Test Driven Development) practices. The BDD (Behavior driven Development) version was developed with JBhehave and using BDD practices.

### Installation
* TDD project is a self contained eclipse java project. All dependencies are included in /lib folder
* BDD project uses [Apache Ivy](http://ant.apache.org/ivy/) for dependency management. Ivy libraries will need to be resolved before the project can be compiled

### Execution
Both projects are JUnit runnable. TDD projects include JUnit tests. BDD project has a JUnitTestRunner(edu.ncsu.cms.specs.JBehave) which can be run as JUnit tests
