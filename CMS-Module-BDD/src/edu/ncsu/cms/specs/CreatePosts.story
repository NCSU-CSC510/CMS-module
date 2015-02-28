Scenario: I create a new post
Given API call to the create_post method is made
Then  I see a new post created

Scenario: PostManager is invoked
Given  API call to the create_post method is made
When  The PostManager is invoked
Then new post object is returned by PostManager

Scenario: Post Manager initializes a Post object
Given  API call to the create_post method is made
When  The PostManager is invoked by the create_post method
And PostManager creates a new Post object
Then version is assigned to 'Draft' 