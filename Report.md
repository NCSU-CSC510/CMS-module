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

  - Class Diagram: Below is the class diagram for Content Management System
      - ![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/LikeSeqDiag.png "Like Sequence Diagram")

  - Sequence Diagram: Below is the sequence diagram for Like
      - ![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/LikeSeqDiag.png "Like Sequence Diagram")

  - State Diagram: Below is the Post state Diagram
      - ![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/PostStateDiag.png "Post State Diagram")


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
![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/Mantra.png "TDD Mantra")
Ref:http://otroblogmas.com/tdd-buenas-practicas/

- Behavior driven development

  - The BDD version of the application was developed using JBehave. JBehave is a Java framework for developing applications using BDD principles. 
  - The main components of a JBehave workflow are :
    1. Stories - Tests and data described in an understandable manner which are picked up by the test engine to drive the tests.
    2. Specs (Tests) - The java code that mirrors the stories by initializing and calling application code to change and check application state is expected.
    3. Engine (JBehaveRunner) - The JBehave engine which orchestrates the running of the the stories and specs to produce JUnit type tests which are run and the results are collated as a JUnit report.
  - The workflow of actually developing functionality in a BDD style of development that was followed was:
    1. Write a story and spec for the functionality
    2. For successful compilation of the spec, which calls application code, stubs may need to be created
    3. Tests will fail expectations when testing against stubs
    4. When enough tests are written to successfully the functionality being tested, the actual implementation code is written
    5. Failed tests are made to pass by writing enough code
    6. When all tests pass, code is refactored for maintainability, generality while ensuring all tests continue to pass





## Results:
- TDD : We have created a simple content management system with basic features like create post,edit post, add comment, like a post etc. In total we have added 16 test cases using JUnit and Mockito. Below is the JUnit run report of all the test cases. 
![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/JUnit_Report.png "JUnit Report")

## Discussion:
- Learning curve for the tools:
  - Jbehave: Since neither of the team members were familiar to the tool, the first few days of the project were spent in learning about using the tool, writing stories.
  - JUnit and Mockito : The team members were familiar with writing JUnit test cases so writing JUnit test cases wasn't that difficult. Mockito framework was something new. So it took some time to understand Mockito and how and where we can use Mockito framework in our project.
- Development time : With use of TDD, the initial development time increases which might overshadow the long term gain like software quality etc. With the use of BDD, we can develop test cases faster with users use cases as its main focus. This helps faster development and gives better clarity.
- Scope: BDD tests an entire functionality of the system. For example, Consider the save posts spec. The tests are written for the below functionality: Scenario: Save a post (DRAFT)
  Given number of posts 1
  Given a post with a draft version
  When I try to save a post using postid=1, versionid=1
  Then the post is updated
  Given number of posts 1
  Given a post with a published version
  When I try to save a post using postid=2, versionid=1
  Then the post is not updated.

  The scope if TDD is only testing a particular method. For example : We have method say editPostVersion() in PostManager class. So testEditPost() testcase just focuses on if the particular method is giving expected output or not.

- Granularity: BDD does not focus on how the method for the spec has been implemented. The main focus of BDD is on the user specification. TDD focuses on the specific implementation of the method. TDD is used to test the source code to check whether it returns the desired value or not. It is difficult to write TDD test cases, as it is not always true that the programmer will know the results correctly.
- Ease of understanding : On comparing the BDD and TDD tests, BDD stories give a clearer understanding on what the method is expected to do.TDD on the other hand gives more insight into how the method has been implemented. So to a user who doesn't know the internal implementation, understanding TDD test cases is tough.
- Interaction level with users: TDD is more developer centric whereas BDD is more user centric. So with BDD, user can better understand the test case and verify if the system is producing expected output or not.

## Conclusion:
- Behavior-driven development is “test-driven development done right”.
- Behavior driven development is set of best practices to develop software by centering your users.
- Test driven development focuses on making sure code is correct
- Behaviour driven development focuses on making sure requirements are satisfied
![alt text](https://github.com/NCSU-CSC510/CMS-module/blob/master/ConclusionMantra.png "Conclusion")
  Reference: http://www.radicalgeek.co.uk/Post/14/acceptance-test-driven-development-of-an-mvc-web-application-using-specflow-and-selenium-webdriver


## Future Work:
- Since our project did a comparison of two parallel projects working with TDD and BDD, another comparison could be made with a project which does TDD and BDD in tandem.
- Test correctness and coverage comparison - Does either TDD or BDD produce more correct or useful tests?

## References:
1. Solis, C., Xiaofeng Wang - [A Study of the Characteristics of Behaviour Driven Development](http://ieeexplore.ieee.org/xpls/abs_all.jsp?arnumber=6068372)
2. Kent Beck - [Test-driven Development: By Example](https://books.google.com/books?id=gFgnde_vwMAC&source=gbs_navlinks_s)
3. Jaelson Castro, Manuel Kolp, John Mylopoulos - [A Requirements-Driven Development Methodology](http://link.springer.com/chapter/10.1007/3-540-45341-5_8)
4. http://gaboesquivel.com/blog/2014/differences-between-tdd-atdd-and-bdd
5. https://joshldavis.com/2013/05/27/difference-between-tdd-and-bdd
6. http://www.ryangreenhall.com/articles/bdd-by-example.html
7. http://programmers.stackexchange.com/questions/234753/are-there-any-cases-when-one-should-not-use-test-driven-development
