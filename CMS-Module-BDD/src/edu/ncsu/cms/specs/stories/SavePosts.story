Scenario: Save a post (DRAFT)

Given number of posts 1
When I try to save a post using postid=1, versionid=1
Then the post is updated