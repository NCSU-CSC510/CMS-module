Scenario 1 : Editing  a post in Draft state

Given API call to the editPost method is made
When the post is in DRAFT state
Then post version content is replaced 

Scenario 2 : Editing  a post in Archive state

Given API call to the editPost method is made
When the post is in ARCHIVE state
Then new version is created 

Scenario 2 : Editing  a post in Published state

Given API call to the editPost method is made
When the post is in Published state
Then new version is created in DRAFT State
