Scenario: Publish a post (DRAFT)

Given number of posts 1
Given a post with a draft version
When I try to publish a post using postid=1, versionid=1
Then the post is published
Then the currentVersion is updated

Given number of posts 1
Given a post with a published version
When I try to publish a post using postid=2, versionid=1
Then the post is not updated