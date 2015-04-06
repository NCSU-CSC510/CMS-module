# BDD vs TDD approach comparison

Aniket Lawande, Anisha Shetty, Prashant Trivedi, Ritwika Roychoudhury, Sohan Kollu

A software engineering project (CSC 510)
#Goals :
- Goal of our project is to develop a simple content management system using two different approaches: test driven development and behaviour driven development.
- Both the implementation will have same features.
- First version was developed using Test driven development approach and tested using JUnit framework.
- Second version developed using Behaviour driven development and was tested using JBehave.
- Our aim is to compare these two approaches on the basis of certain parameters.

# Background:
- Test Driven Development :
  - Technique of using automated unit tests to drive the design of software and force decoupling of dependencies.
  - “Get something working now and perfect it later “ - After each test, refactoring is done to the implementation. Then again the test is executed to verify if the test case pass or not.
  - Process iterated as many times as necessary until each unit reaches desired level of functioning as per specification.
- Behaviour Driven Development :
  - Testing style used to enforce the principle that software should be written to meet some requirement or specification
  - Prior to writing code, the required functionality is specified as tests. Then code is written to make the tests pass
  - Refactoring is done as required to reform code to account for reusability, maintainability and robustness but ensuring that tests continue to pass
