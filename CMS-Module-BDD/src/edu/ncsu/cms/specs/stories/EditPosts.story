Scenario 1 : Manager editing a post

Given API call to the editPost method is made
When PostManager is invoked by editPost method
Then I see post is edited by Manager 

Scenario 2 : PostOwner editing a post

Given API call to the editPost method is made
When PostManager is invoked by editPost method
Then I see post is edited by PostOwner not others
