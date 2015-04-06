# BDD vs TDD approach comparison

Aniket Lawande, Anisha Shetty, Prashant Trivedi, Ritwika Roychoudhury, Sohan Kollu

A software engineering project (CSC 510)
## Goals :
- Goal of our project is to develop a simple content management system using two different approaches: test driven development and behaviour driven development.
- Both the implementation will have same features.
- First version was developed using Test driven development approach and tested using JUnit framework.
- Second version developed using Behaviour driven development and was tested using JBehave.
- Our aim is to compare these two approaches on the basis of certain parameters.

## Background:
- Test Driven Development :
  - Technique of using automated unit tests to drive the design of software and force decoupling of dependencies.
  - “Get something working now and perfect it later “ - After each test, refactoring is done to the implementation. Then again the test is executed to verify if the test case pass or not.
  - Process iterated as many times as necessary until each unit reaches desired level of functioning as per specification.
- Behaviour Driven Development :
  - Testing style used to enforce the principle that software should be written to meet some requirement or specification
  - Prior to writing code, the required functionality is specified as tests. Then code is written to make the tests pass
  - Refactoring is done as required to reform code to account for reusability, maintainability and robustness but ensuring that tests continue to pass

## System Description:
A comparison between the BDD and TDD approach has been made by developing a Content Management System (CMS)API.
The functionalities implemented in this CMS system are
- Managing Posts:
  - Create new post
  - Edit post
  - Save post
  - Publish post
  - Delete post
  - Retrieve post
  - Retrieve post-version
  - Searching filtering and Sorting

- Versioning
  - Incorporated in Content Management
  - Version control
  - Each version is associated with a State

- Comments
  - Every Post is associated with a set of Comments.

- Likes 
  - A Post as well as Comments have this feature incorporated.
  - This feature is used to upvote a Post/Comment by the users.
 
- UML Diagrams:

  - Class Diagram
  - Sequence Diagram:
  - State Diagram: 

## Methods:
  - Test Driven Development:
  - We have used Junit and Mockito to test the different features.
  - We first wrote the different test cases based on the intended behaviour of the system.
  - We have used mocking to mock different objects like Database.
  - This is our “RED” phase.
  - After this we wrote the main implementation of the features.
  - Then we run our test cases again, and checked if they passed or not.
  - If testcases didn’t pass, we had to modify our implementation.
  - This is our “GREEN” phase.
  - Finally we refactored our code, to remove the duplications and pieces of code written just to pass our test case.
  - This is our REFACTOR phase
  - Below is some sample code and test snippet.
![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/EditPost.png "Edit Post Version Code")
![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/EditPostTest.png "Edit Post Version Test Code")
![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/LikeTest.png "Like Test Code")

